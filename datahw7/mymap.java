package datahw7;

import java.util.LinkedHashMap;
import java.util.Map;

public class mymap {
	LinkedHashMap<String, info> map;
	int mapSize;
	String str;

	/**
	 * constructor that arranges string suitable for map and creates the map
	 * 
	 * @param str
	 * @throws Exception
	 */
	public mymap(String str) throws Exception {
		if (str.isBlank())
			throw new Exception("Blink string");
		// System.out.println("Original String: " + str);
		str = str.toLowerCase();
		str = str.replaceAll("[^A-Za-z]", " ");
		// System.out.println("Preprocessed String: " + str + "\n");
		this.str = str;
		mapSize = 0;
		map = new LinkedHashMap<String, info>();
		int space = str.indexOf(" ");
		if (space != -1) {
			while (space != -1) {
				String str1 = str.substring(0, space);

				str = str.substring(space + 1);

				for (int i = 0; i < str1.length(); i++) {
					if (map.get(String.valueOf(str1.charAt(i))) == null) {

						info infonew = new info();
						infonew.push(str1);
						put(String.valueOf(str1.charAt(i)), infonew);

					} else {

						map.get(String.valueOf(str1.charAt(i))).push(str1);

					}
				}
				space = str.indexOf(" ");
			}
		}

		for (int i = 0; i < str.length(); i++) {
			if (map.get(String.valueOf(str.charAt(i))) == null) {
				info infonew = new info();
				infonew.push(str);
				put(String.valueOf(str.charAt(i)), infonew);

			} else {

				map.get(String.valueOf(str.charAt(i))).push(str);

			}
		}

	}

	public mymap() {

		map = new LinkedHashMap<String, info>();
		mapSize = 0;
	}

	/**
	 * initilazes map and fills with the map other with the same order of array
	 * 
	 * @param arr
	 * @param other
	 */
	public mymap(String[] arr, mymap other) {

		map = new LinkedHashMap<String, info>();
		for (int i = 0; i < arr.length; i++) {
			map.put(arr[i], other.get(arr[i]));
		}
	}

	/*
	 * returns size
	 */
	public int size() {

		return mapSize;
	}

	public boolean isEmpty() {
		if (mapSize != 0)
			return false;
		else
			return true;
	}

	/**
	 * returns the info with given key
	 * 
	 * @param key
	 * @return
	 */
	public info get(String key) {

		return map.get(key);
	}

	/**
	 * puts new element to end of map and increase size
	 * 
	 * @param key
	 * @param value
	 */
	public void put(String key, info value) {

		map.put(key, value);
		mapSize++;

	}

	/**
	 * removes element with the key given in parameter
	 * 
	 * @param key
	 */
	public void remove(String key) {

		map.remove(key);

	}

	/**
	 * deep copies the map
	 * 
	 * @param m is map we want to copy this map to
	 */
	public void putAll(mymap m) {

		for (Map.Entry<String, info> entry : map.entrySet()) {
			String key = entry.getKey();
			info value = new info(entry.getValue());
			m.put(key, value);
		}

	}

	/**
	 * clears the map
	 */
	public void clear() {
		map.clear();
		mapSize = 0;

	}

	/**
	 * prints the map
	 */
	public void print() {
		for (Map.Entry<String, info> entry : map.entrySet()) {
			String key1 = entry.getKey();
			info value1 = entry.getValue();
			System.out.print("\"" + key1 + "\"" + " Count: " + value1.count + " Words array: [ ");
			value1.printarr();
		}

		System.out.println();
	}

}
