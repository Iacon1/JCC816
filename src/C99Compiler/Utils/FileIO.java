// Created by Iacon1 on 01/15/2024.
// File IO util methods
package C99Compiler.Utils;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

import C99Compiler.CompConfig;

public final class FileIO
{
	public static File getFileER(String filename) // Execution-relative, i. e. doesn't care about rootFolder
	{
		Path path = FileSystems.getDefault().getPath(filename);
		return path.toFile();
	}
	
	public static File getFile(String filename)
	{
		Path path = FileSystems.getDefault().getPath(filename);
		if (!path.startsWith(CompConfig.rootFolder))
			path = FileSystems.getDefault().getPath(CompConfig.rootFolder).resolve(path);
		return path.toFile();
	}
	
	public static final boolean hasResource(String filename)
	{
		return ClassLoader.getSystemResource(filename) != null;
	}
	public static boolean hasFile(String filename)
	{
		return getFile(filename).exists();
	}
	public static final String readResource(String filename) throws IOException
	{
		return new String(ClassLoader.getSystemResourceAsStream(filename).readAllBytes());
	}
	public static byte[] readResourceBytes(String filename) throws IOException
	{
		return ClassLoader.getSystemResourceAsStream(filename).readAllBytes();
	}
	public static final String readFile(File file) throws IOException
	{
		FileInputStream inStream = new FileInputStream(file);
		char[] chars = new char[(int) file.length()];
		BufferedReader reader = new BufferedReader(new InputStreamReader(inStream, "UTF-8"));
		reader.read(chars);
		reader.close();
		inStream.close();
		
		return new String(chars);
	}
	public static final byte[] readFileBytes(File file) throws IOException
	{
		FileInputStream inStream = new FileInputStream(file);
		byte[] bytes = new byte[(int) file.length()];
		inStream.read(bytes);
		inStream.close();
		
		return bytes;
	}
	
	public static final String readFile(String filename) throws IOException
	{
		return readFile(getFile(filename));
	}
	public static final byte[] readFileBytes(String filename) throws IOException
	{
		return readFileBytes(getFile(filename));
	}
	
	public static final void writeFile(String filename, byte[] bytes) throws IOException
	{
		File f = getFile(filename);
		f.createNewFile();
		FileOutputStream fo = new FileOutputStream(f);
		fo.write(bytes);
		fo.close();
	}
	
	public static byte[] serialize(Serializable s) throws IOException
	{
		ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
		ObjectOutputStream stream = new ObjectOutputStream(byteStream);
		stream.writeObject(s);
		stream.close();
		byte[] bytes = byteStream.toByteArray();
		byteStream.close();
		return bytes;
	}
	
	public static <T> T deserialize(byte[] bytes) throws IOException, ClassNotFoundException
	{
		ByteArrayInputStream byteStream = new ByteArrayInputStream(bytes);
		ObjectInputStream stream = new ObjectInputStream(byteStream);
		T t = (T) stream.readObject();
		stream.close();
		byteStream.close();
		return t;
	}
	
	public static Document readFileXML(String filename) throws Exception
	{
		File file = getFile(filename);
		DocumentBuilderFactory factory = DocumentBuilderFactory.newDefaultInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(file);
		return document;
	}
	
	private static List<String> findAll(File root)
	{
		List<String> filenames = new LinkedList<String>();
		File[] files = root.listFiles();
		for (File file : files)
		{
			if (file.isDirectory())
			{
				for (String filename : findAll(file))
					filenames.add(Path.of(file.getName(), filename).toString());
			}
			else filenames.add(file.getName());
		}
		
		return filenames;
	}
	public static List<String> matchingFiles(File root, String searchTerm)
	{
		List<String> filenames = findAll(root);
		List<String> matchingFilenames = new LinkedList<String>();
		for (String filename : filenames)
			if (filename.matches(searchTerm.replace(".", "\\.").replace("*", ".*")))
				matchingFilenames.add(filename);
		return matchingFilenames;
	}
	public static List<String> matchingFiles(String searchTerm)
	{
		return matchingFiles(getFile(""), searchTerm);
	}
}
