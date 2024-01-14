// By Iacon1
// Created 4/18/2021
// Make calls to this when logging; Can switch which logger is used w/ setLogger, all commands are then passed to that

package Logging;

import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.antlr.v4.gui.TreeViewer;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.tree.ParseTree;

public final class Logging
{
	private static volatile Logger logger;
	
	public static void setLogger(Logger logger)
	{
		Logging.logger = logger;
	}
	public static final Logger getLogger()
	{
		return logger;
	}
	
	public static void logRaw(String reason, String text)
	{
		if (logger == null)
			return;
		else
			logger.logRaw(reason, text);
	}
	public static void logNotice(String text)
	{
		if (logger == null)
			return;
		else
			logger.logNotice(text);
	}
	public static void logError(String error)
	{
		if (logger == null)
			return;
		else
			logger.logError(error);
	}
	public static void logException(Exception exception)
	{
		if (logger == null)
			return;
		else
			logger.logException(exception);
	}
	
	public static void viewParseTree(Parser parser, ParseTree tree)
	{
		JFrame frame = new JFrame("Antlr");
		JPanel panel = new JPanel();
		TreeViewer viewer = new TreeViewer(Arrays.asList(parser.getRuleNames()), tree);
		viewer.setScale(1);
		panel.add(viewer);
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}
