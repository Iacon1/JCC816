// By Iacon1
// Created 4/18/2021
// Make calls to this when logging; Can switch which logger is used w/ setLogger, all commands are then passed to that

package Logging;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
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
		panel.addMouseMotionListener(new MouseMotionListener()
		{
			Point lastPos = new Point();
			Point oldPoint = new Point();
			@Override
			public void mouseDragged(MouseEvent e)
			{
				viewer.setLocation(lastPos.x + e.getX() - oldPoint.x, lastPos.y + e.getY() - oldPoint.y);
				
			}

			@Override
			public void mouseMoved(MouseEvent e)
			{
				lastPos = viewer.getLocation();
				oldPoint = e.getPoint();
				
			}	
		});
		panel.addMouseWheelListener(new MouseWheelListener()
		{

			@Override
			public void mouseWheelMoved(MouseWheelEvent e)
			{
				if (e.getScrollType() == MouseWheelEvent.WHEEL_UNIT_SCROLL)
					viewer.setScale(viewer.getScale() + e.getScrollAmount());
			}
			
		});
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}
