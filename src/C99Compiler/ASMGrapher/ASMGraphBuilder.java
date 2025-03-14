// Created by Iacon1 on 12/01/2023.
//
package C99Compiler.ASMGrapher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.antlr.v4.gui.TreeViewer;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.InputMismatchException;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.tree.ParseTree;

import C99Compiler.ASMGrapher.Nodes.ASMNode;
import C99Compiler.ASMGrapher.Nodes.ASMNode.ASMType;
import C99Compiler.ASMGrapher.Nodes.InstructionNode;
import C99Compiler.CompilerNodes.LValues.VariableNode;
import Grammar.C816.C816Lexer;
import Grammar.C816.C816Parser;
import Grammar.C816.C816Parser.ProgramContext;
import Logging.Logging;
import Shared.ErrorCollector;
import C99Compiler.ASMGrapher.Nodes.LabelNode;
import C99Compiler.ASMGrapher.Nodes.Operation;
import C99Compiler.ASMGrapher.Nodes.PreprocNode;

public class ASMGraphBuilder
{
	private static ErrorCollector e = new ErrorCollector();
	private List<ASMNode<?>> lines;
	private List<String> textLines;
	private Set<Integer> busyLines; // To keep infinite recursion from happening
	
	private List<Integer> jumpsTo(String label, int index)
	{
		List<Integer> jumpsTo = new LinkedList<Integer>();
		
		if (label.equals(":")) // Unnamed label
		{
			label = ":-";
			for (int i = index; i < lines.size(); ++i)
			{
				ASMNode<?> line = lines.get(i);
				if (line.getType() == ASMType.label)
					label += "-";
				else if ((line.getType() == ASMType.jump || line.getType() == ASMType.branch))
					jumpsTo.add(i);
			}
			
			label = ":+";
			for (int i = index; i >= 0; --i)
			{
				ASMNode<?> line = lines.get(i);
				if (line.getType() == ASMType.label)
					label += "+";
				else if ((line.getType() == ASMType.jump || line.getType() == ASMType.branch))
					jumpsTo.add(i);
			}
		}
		else // Normal label
			for (int i = 0; i < lines.size(); ++i)
			{
				ASMNode<?> line = lines.get(i);
				if ((line.getType() == ASMType.jump || line.getType() == ASMType.branch) && line.getValue().toString().equals(label))
					jumpsTo.add(i);
			}
				
		return jumpsTo;
	}

	private void buildGraph(int i, List<Value> internalAddresses, Set<Value> importantAddresses, byte importantRegisters, byte importantFlags)
	{
		ASMNode<?> line = lines.get(i);
		busyLines.add(i);
		
		importantRegisters |= line.affectingRegisters();
		importantFlags |= line.affectingFlags();
		if (line.affectedByParameter()) importantAddresses.add(line.getValue());
		
		if (line.affectsParameter() && !internalAddresses.contains(line.getValue()))
			line.setExport();
		int j = i - 1;
		while (j >= 0) // For each line before this one
		{
			ASMNode<?> prevLine = lines.get(j);

			boolean required = false;
			
			switch (prevLine.getType())
			{
			case branch:
				required = true;
			case other: case jump: case REPSEP: case load: case store:
				if ((prevLine.affectedRegisters() & importantRegisters) != 0)
					required = true;
				if ((prevLine.affectedFlags() & importantFlags) != 0)
					required = true;
				if (prevLine.affectsParameter() && importantAddresses.contains(prevLine.getValue()))
				{
					required = true;
					importantAddresses.remove(prevLine.getValue());
				}
				
				if (required)
				{
					importantRegisters &= ~prevLine.affectedRegisters();
					importantRegisters |= prevLine.affectingFlags();
					
					importantFlags &= ~prevLine.affectedFlags();
					importantFlags |= prevLine.affectingFlags();
					
					if (prevLine.affectedByParameter())
					{
						importantAddresses.add(prevLine.getValue());
						if ((prevLine.affectedRegisters() & InstructionNode.registerA) != 0 && prevLine.is16A())
							importantAddresses.add(prevLine.getValue().increment());
						if ((prevLine.affectedRegisters() & (InstructionNode.registerX | InstructionNode.registerY)) != 0 && prevLine.is16XY())
							importantAddresses.add(prevLine.getValue().increment());
					}
				}
				break;
			case label:
				line.setExport(); // Hack
				for (Integer k : jumpsTo(prevLine.getValue().toString(), j))
				{
					prevLine.require(lines.get(k));
					if (!busyLines.contains(k)) buildGraph(k, internalAddresses, importantAddresses, importantRegisters, importantFlags);
				}
			case preproc:
				required = true;
				break;
			case jumpSub:
				// Who knows what's important in the sub, so assume it all is
				importantRegisters = (byte) 0xFF;
				importantFlags = (byte) 0xFF;
				required = true;
				break;
			}
			if (required)
				line.require(prevLine);
			
			
			j -= 1; // Subtract from j
		}
		busyLines.remove(i);
	}
	private void buildGraph(List<Value> internalAddresses)
	{
		for (int i = lines.size() - 1; i >= 0; --i)
			buildGraph(i, internalAddresses, new HashSet<Value>(), (byte) 0, (byte) 0);
	}
	
	private static String capitalize(String assembly) // capitalize all operations.
	{
		for (Operation operation : Operation.values())
			assembly = assembly.replaceAll("(?<=[\s\n\t])(?i)" + operation.name() + "(?=[\s\n\t])", operation.name());
		return assembly;
	}
	public ASMGraphBuilder(String assembly) throws Exception
	{
		lines = new ArrayList<ASMNode<?>>();
		textLines = new ArrayList<String>();
		busyLines = new HashSet<Integer>();
		assembly = capitalize(assembly);
		assembly = assembly.replaceAll("\n+", "\n");
		for (String line : assembly.split("\n"))
			textLines.add(line);

		e.reset();
		C816Lexer lexer = new C816Lexer(CharStreams.fromString(assembly));
		lexer.addErrorListener(e);
		C816Parser parser = new C816Parser(new CommonTokenStream(lexer));
		parser.addErrorListener(e);
		ProgramContext context = parser.program();
		if (e.hasFailed())
;//			Logging.logError(assembly);
		
//		Logging.viewParseTree(parser, context);
		int labels = 0, instrs = 0, preprocs = 0;
		for (int i = 0; i < context.getChildCount(); ++i)
		{
			ASMNode<?> node = null;

			if (context.label().size() > 0 && context.label(labels) == context.getChild(i))
				node = new LabelNode(i).interpret(context.label(labels++));
			else if (context.instruction().size() > 0 && context.instruction(instrs) == context.getChild(i))
				node = new InstructionNode(i).interpret(context.instruction(instrs++));
			else if (context.preprocInstruction().size() > 0 &&context.preprocInstruction(preprocs) == context.getChild(i))
				node = new PreprocNode(i).interpret(context.preprocInstruction(preprocs++));
			if (node != null)
				lines.add(node);
		}
		
	}
	
	/** Creates an assembly-level call graph and uses it to remove dead code
	 * 
	 * @param internalVariables All variables only accessible within the function
	 * @return The function's assembly, free of (at least most) dead code
	 */
	public String clearDeadCode(LinkedHashMap<String, VariableNode> internalVariables)
	{
		List<Value> internalAddresses = new ArrayList<Value>();
		String functionAssembly;
		
		// List internal addresses
		for (VariableNode internalVar : internalVariables.values())
			for (int i = 0; i < internalVar.getSize(); ++i)
				internalAddresses.add(new Value(internalVar.getFullName(), i));
		
		// Tell each line whether it's 16 bit or not
		boolean is16A = false, is16XY = false;
		for (int i = 0; i < lines.size(); ++i)
		{
			if (lines.get(i).getType() == ASMType.REPSEP)
			{
				if ((lines.get(i).getImmediate() & InstructionNode.flagM) != 0)
					lines.get(i).set16XY();
				if ((lines.get(i).getImmediate() & InstructionNode.flagX) != 0)
					lines.get(i).set16A();
			}
			if (lines.get(i).getType() == ASMType.label)
			{
				is16A = false;
				is16XY = false;
			}
		}
				
		// Remove redundancies
		Value addrA = null, addrX = null, addrY = null;
		for (int i = 0; i < lines.size(); ++i)
		{
			ASMNode<?> line = lines.get(i);
			switch (line.getType())
			{
			case load:
				if ((line.affectedRegisters() & InstructionNode.registerA) != 0)
					if (line.getValue().equals(addrA)) line.hide();
					else addrA = line.getValue();
				if ((line.affectedRegisters() & InstructionNode.registerX) != 0)
					if (line.getValue().equals(addrX)) line.hide();
					else addrX = line.getValue();
				if ((line.affectedRegisters() & InstructionNode.registerY) != 0)
					if (line.getValue().equals(addrY)) line.hide();
					else addrY = line.getValue();
				break;
			case store:
				if ((line.affectingRegisters() & InstructionNode.registerA) != 0)
					if (line.getValue().equals(addrA)) line.hide();
					else addrA = line.getValue();
				if ((line.affectingRegisters() & InstructionNode.registerX) != 0)
					if (line.getValue().equals(addrX)) line.hide();
					else addrX = line.getValue();
				if ((line.affectingRegisters() & InstructionNode.registerY) != 0)
					if (line.getValue().equals(addrY)) line.hide();
					else addrY = line.getValue();
				break;				
			case other:
				if ((line.affectedRegisters() & InstructionNode.registerA) != 0)
					addrA = null;
				if ((line.affectedRegisters() & InstructionNode.registerX) != 0)
					addrX = null;
				if ((line.affectedRegisters() & InstructionNode.registerY) != 0)
					addrY = null;
				break;
			case label:
				addrA = null;
				addrX = null;
				addrY = null;
				break;
			default:
				break;
			}
		}
				
		// Build the graph
		buildGraph(internalAddresses);
		
		// Re-assembly assembly from list
		functionAssembly = "";
		for (int i = 0; i < lines.size(); ++i)
			if (lines.get(i).isRequiredForExports())
				functionAssembly += textLines.get(lines.get(i).lineNo() - 1) + "\n";
		
		functionAssembly = functionAssembly.replace("\n:\n ", "\n:");
		return functionAssembly;
	}
	
	/** Finds the size of the graph's assembled form.
	 * 
	 * @return The function's assembly, free of (at least most) dead code
	 */
	public int getSize()
	{
		int size = 0;
		for (ASMNode<?> line : lines)
			size += line.getSize();
			
		return size;
	}
}
