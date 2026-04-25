// Created by Iacon1 on 04/22/2026.
// Map from strings to sources with "disqualifiers" that, when invoked via disqualify, produce 
// A new version of the map missing all sources that had those disqualifiers

package C99Compiler.ProgramState;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

class DisqualifyingMap<T>
{
	private final HashMap<String, T> itemMap;
	private final HashMap<String, HashSet<String>> disqualsMap;
	
	private DisqualifyingMap(HashMap<String, T> itemMap, HashMap<String, HashSet<String>> qualsMap)
	{
		this.itemMap = itemMap;
		this.disqualsMap = qualsMap;
	}
	
	public DisqualifyingMap()
	{
		this.itemMap = new HashMap<String, T>();
		this.disqualsMap = new HashMap<String, HashSet<String>>();
	}
	
	public T get(String name)
	{
		return itemMap.get(name);
	}
	public Collection<T> getAll()
	{
		return itemMap.values();
	}
	public Collection<T> getDisqualifiedItems(String... disqualifiers)
	{
		final List<T> list = new LinkedList<T>();
		disqualsMap.forEach((String name, HashSet<String> disqualsSet)->
		{
			for (String disqualifier : disqualifiers)
				if (disqualsSet.contains(disqualifier))
					list.add(get(name));
		});
		
		return list;
	}
	public List<String> getDisqualifiedItemNames(String... disqualifiers)
	{
		final List<String> list = new LinkedList<String>();
		disqualsMap.forEach((String name, HashSet<String> disqualsSet)->
		{
			for (String disqualifier : disqualifiers)
				if (disqualsSet.contains(disqualifier))
					list.add(name);
		});
		
		return list;
	}
	
	public DisqualifyingMap<T> register(T item, String name, String... disqualifiers)
	{
		HashMap<String, T> itemMap = new HashMap<String, T>(this.itemMap);
		HashMap<String, HashSet<String>> disqualsMap = new HashMap<String, HashSet<String>>(this.disqualsMap);
		HashSet<String> disqualsSet = new HashSet<String>(Arrays.asList(disqualifiers));
		disqualsSet.add(name); // So that if we disqualify by name we know it shows up
		
		itemMap.put(name, item);
		disqualsMap.put(name, disqualsSet);
		
		return new DisqualifyingMap<T>(itemMap, disqualsMap);
	}
	public DisqualifyingMap<T> disqualify(String... disqualifiers)
	{
		HashMap<String, T> itemMap = new HashMap<String, T>(this.itemMap);
		HashMap<String, HashSet<String>> disqualsMap = new HashMap<String, HashSet<String>>(this.disqualsMap);
		
		for (String name : getDisqualifiedItemNames(disqualifiers))
		{
			itemMap.remove(name);
			disqualsMap.remove(name);
		}
		
		return new DisqualifyingMap<T>(itemMap, disqualsMap);
	}
	public DisqualifyingMap<T> remove(T item)
	{
		HashMap<String, T> itemMap = new HashMap<String, T>(this.itemMap);
		HashMap<String, HashSet<String>> disqualsMap = new HashMap<String, HashSet<String>>(this.disqualsMap);

		for (Entry<String, T> entry : itemMap.entrySet())
			if (entry.getValue().equals(item))
			{
				itemMap.remove(entry.getKey());
				disqualsMap.remove(entry.getKey());
				break;
			}
		
		return new DisqualifyingMap<T>(itemMap, disqualsMap);
	}
	
	
}
