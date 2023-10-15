// By Iacon1
// Created 04/25/2021
// Debug logger

package Logging;

public class DebugLogger implements Logger
{

	@Override
	public void logRaw(String reason, String text)
	{
		System.out.println(reason + ": " + text);
	}

	@Override
	public void logNotice(String text)
	{
		logRaw("Note", text);
	}

	@Override
	public void logError(String error)
	{
		logRaw("Error", error);
	}

	@Override
	public void logException(Exception exception)
	{
		exception.printStackTrace();
	}

}
