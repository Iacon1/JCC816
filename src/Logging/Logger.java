// By Iacon1
// Created 04/21/2021
// Logger interface

// How this works is that there's one main log, divided into several sublogs
// Sublogs:
//   message
//   error
//   exception

package Logging;

public interface Logger
{
	public void logRaw(String reason, String text); // Logs with a particular category
	public void logNotice(String text); // Adds a line of text to the "notice" sublog with no calling method and line
	public void logError(String error); // Adds a message to the "error" sublog along with the calling method and line
	public void logException(Exception exception); // Adds a message to the "exception" sublog along with the calling method and line
}
