// By Iacon1
// Created 4/18/2021
// Make calls to this when logging; Can switch which logger is used w/ setLogger, all commands are then passed to that

package Logging;

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
}
