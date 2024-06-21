package hw6;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class mymap{
	LinkedHashMap <Character, info> map;
	int mapSize ;
	String str;
	/**
	 * constructor that arranges string suitable for map and creates the map
	 * @param str
	 */
	public mymap(String str)throws Exception  {
		
		if(str.isBlank() == true)
			   throw new Exception("String empty");
			
		System.out.println("Original String: " + str);
		str=str.toLowerCase();
		str = str.replaceAll("[^A-Za-z]", " ");
		System.out.println("Preprocessed String: " + str + "\n");
		this.str = str;
		mapSize = 0;
		map = new LinkedHashMap<Character, info>();
		int space = str.indexOf(" ");
	    if(space != -1) {
		while(space != -1) {
		String str1 = str.substring(0,space);
	
		str = str.substring(space+1);
		for(int i= 0; i<str1.length();i++) {
			if(map.get(str1.charAt(i))==null) {
				info infonew = new info();
				infonew.push(str1);
				put(str1.charAt(i), infonew);
				   	
			}
			else {
				
				map.get(str1.charAt(i)).push(str1);
				
			}
		}
			space = str.indexOf(" ");
		}
	    }
	    
	    	for(int i= 0; i<str.length();i++) {
				if(map.get(str.charAt(i))==null) {
					info infonew = new info();
					infonew.push(str);
					put(str.charAt(i), infonew);
							
				}
				else {
					
					map.get(str.charAt(i)).push(str);
					
				}
	    }
	    
		
		
	}
	
	public mymap() {
		
		map = new LinkedHashMap<Character, info>();
		mapSize = 0;
	}
	/*
	 * returns size
	 */
	public int size() {
	
		return mapSize;
	}
	
	public boolean isEmpty() {
		if(mapSize!=0)
		return false;
		else 
		return true;
	}

	/**
	 * returns the info with given key
	 * @param key
	 * @return
	 */
	public info get(Character key) {

	    Iterator<Entry<Character, info>> iterator = map.entrySet().iterator();
	     while (iterator.hasNext()) {
	    Entry<Character, info> entry = iterator.next();
	    Character key1 = entry.getKey();
	    info value1 = entry.getValue();
	     if(key.equals(key1))
		   return value1 ;
	     }
		return null;
	}
	/**
	 * gets the key in given index
	 * @param index
	 * @return key in given index
	 */
	protected Character  getkeybyindex(int index) {
		   if(index<0||index>=mapSize) {
		
			   throw new IndexOutOfBoundsException();
		   }
	    Iterator<Entry<Character, info>> iterator = map.entrySet().iterator();
	    
	    Entry<Character, info> entry = iterator.next();
	    Character  key1 = entry.getKey();
	   for (int i = 0;i<index;i++) {

		    entry = iterator.next();
		    key1 = entry.getKey();
	    }
	   return key1 ;
	}
	/**
	 * puts new element to end of map and increase size
	 * @param key
	 * @param value
	 */
	public void put(Character key, info value) {
		
		map.put(key,value);
		mapSize++;
		
	}
	/**
	 * removes element with the key given in parameter
	 * @param key
	 */
	public void remove(Character key) {

	    Iterator<Entry<Character, info>> iterator = map.entrySet().iterator();
	     while (iterator.hasNext()) {
	    Entry<Character, info> entry = iterator.next();
	    Character key1 = entry.getKey();
	     if(key.equals(key1)) {
	    	 map.remove(key1);
	    	 mapSize--;
	    	
	    	 
	     }
	     }
		
	}
	/**
	 * deep copies the map
	 * @param m is map we want to copy this map to
	 */
	public void putAll(mymap m) {
		Iterator<Entry<Character,info>> it = map.entrySet().iterator();
		for(int i = 0;i<mapSize;i++) {
			Entry<Character,info> entry = it.next();
			Character newkey = entry.getKey();
			info newinfo = new info(entry.getValue());
			m.put(newkey,newinfo);
			
		}
		

	}
	/**
	 * this function adds new element to given index and 
	 * if an element with new key already exists in another index
	 *  swaps that one with the one in the index we want to add our new element to 
	 * @param index we want to put element to
	 * @param key new elements key
	 * @param value new elements value
	 */
	
	
	protected void addtoindex(int index,Character key, info value) {
		if(index>mapSize||index<0)
		   throw new IndexOutOfBoundsException();
		Iterator<Entry<Character,info>> it = map.entrySet().iterator();
        LinkedHashMap <Character, info> newmap = new LinkedHashMap <Character, info>();;
		
	
		for(int i = 0;i<index;i++) {
			Entry<Character,info> entry = it.next();
			Character newkey = entry.getKey();
			info newinfo = new info(entry.getValue());
	
			newmap.put(newkey, newinfo);
		}
		
		newmap.put(key, value);
		Entry<Character,info> entry = it.next();
		Character keywepassed = entry.getKey();
		info infowepassed = entry.getValue();
		
		
		for(int i = 0;i<mapSize-index-1    ;i++) {
			Entry<Character,info> entry1 = it.next();
			Character newkey = entry1.getKey();
			info newinfo = new info(entry1.getValue());
		
			if(newkey != key)
			newmap.put(newkey, newinfo);
			else
			newmap.put(keywepassed, infowepassed);
		}
		
		map = newmap;
        
	}
	/**
	 * clears the map
	 */
	public void clear() {
		map.clear();
		mapSize=0;
		
	}
	/**
	 * prints the map
	 */
	public void print() {

	    Iterator<Entry<Character, info>> iterator = map.entrySet().iterator();
	     while (iterator.hasNext()) {
	    Entry<Character, info> entry = iterator.next();
	    Character key1 = entry.getKey();
	    info value1 = entry.getValue();
	    System.out.print("\""+key1+"\"" + " Count: "+value1.count + " Words array: [ ");
	    value1.printarr();

	}
	}
	
	
	
}
