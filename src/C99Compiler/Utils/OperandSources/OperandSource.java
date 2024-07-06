// Created by Iacon1 on 10/22/2023.
// A way of accessing and operating on a value or region of memory.
package C99Compiler.Utils.OperandSources;

import java.io.Serializable;

import C99Compiler.Utils.AssemblyUtils.DetailsTicket;

public abstract class OperandSource implements Serializable
{
	private boolean isLiteral;
	protected int size, offset;
	
	public OperandSource(int size, int offset, boolean isLiteral)
	{
		this.size = size;
		this.offset = offset;
		this.isLiteral = isLiteral;
	}
	public OperandSource(int size, boolean isLiteral)
	{
		this.size = size;
		this.offset = 0;
		this.isLiteral = isLiteral;
	}
	public OperandSource()
	{
		this.size = 0;
		this.offset = 0;
		this.isLiteral = false;
	}
	public boolean isLiteral() {return isLiteral;}
	public int getSize() {return size;}
	public int getOffset() {return offset;}
	public abstract OperandSource getShifted(int offset, int size);
	public OperandSource getShifted(int offset) {return getShifted(offset, 0);}
	public abstract OperandSource getRespecified(int offset, int size);
	public OperandSource respec(int size) {return getRespecified(offset, size);}
	/** Returns the "base" value of the source, i. e. what would come after the operation if the byte offset is 0.
	 * 
	 * @return The "base" value of the source, e. g. a variable's address
	 */
	public abstract String getBase();
	
	/** Returns assembly to perform the specified operation on the value or region represented by the source.
	 * 
	 * @param whitespace The whitespace to place before each line
	 * @param operation The operation to perform
	 * @param i	The byte offset from the first byte of the source
	 * @param ticket The details on what registers must be preserved by the access
	 * @return The assembly to perform the specified operation on the value or region represented by the source
	 */
	public abstract String getInstruction(String whitespace, String operation, Integer i, DetailsTicket ticket);
	/** Returns assembly to perform the specified operation on the value or region represented by the source.
	 * 
	 * @param operation The operation to perform
	 * @param i	The byte offset from the first byte of the source
	 * @param ticket The details on what registers must be preserved by the access
	 * @return The assembly to perform the specified operation on the value or region represented by the source
	 */
	public String getInstruction(String operation, Integer i, DetailsTicket ticket)
	{
		return getInstruction("", operation, i, ticket);
	}
	
	/** Returns assembly to load the the value or region represented by the source into the A register.
	 * 
	 * @param whitespace The whitespace to place before each line
	 * @param i	The byte offset from the first byte of the source
	 * @param ticket The details on what registers must be preserved by the access
	 * @return The assembly to perform the specified operation on the value or region represented by the source
	 */
	public String getLDA(String whitespace, Integer i, DetailsTicket ticket)
	{
		assert (ticket.flags & DetailsTicket.saveA) == 0; // We can't do this if we need to save A
		return getInstruction(whitespace, "LDA", i, ticket);
	}
	/** Returns assembly to load the the value or region represented by the source into the A register.
	 * 
	 * @param whitespace The whitespace to place before each line
	 * @param i	The byte offset from the first byte of the source
	 * @param ticket The details on what registers must be preserved by the access
	 * @return The assembly to perform the specified operation on the value or region represented by the source
	 */
	public String getLDA(Integer i, DetailsTicket ticket)
	{
		return getLDA("", i, ticket);
	}
	
	/** Returns assembly to store the value of the A register into the region represented by the source.
	 * 
	 * @param whitespace The whitespace to place before each line
	 * @param i	The byte offset from the first byte of the source
	 * @param ticket The details on what registers must be preserved by the access
	 * @return The assembly to perform the specified operation on the value or region represented by the source
	 */
	public String getSTA(String whitespace, Integer i, DetailsTicket ticket)
	{
		assert !isLiteral; // Can't store into numbers
		return getInstruction(whitespace, "STA", i, ticket);
	}
	/** Returns assembly to store the value of the A register into the region represented by the source.
	 * 
	 * @param whitespace The whitespace to place before each line
	 * @param i	The byte offset from the first byte of the source
	 * @param ticket The details on what registers must be preserved by the access
	 * @return The assembly to perform the specified operation on the value or region represented by the source
	 */
	public String getSTA(Integer i, DetailsTicket ticket)
	{
		return getSTA("", i, ticket);
	}
	
	public boolean isStationary()
	{
		return false;
	}
}
