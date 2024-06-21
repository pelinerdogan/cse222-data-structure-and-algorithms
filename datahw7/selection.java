package datahw7;

import java.util.Map;

public class selection {

	
	
	mymap originalmap;
	mymap sortedmap;
	private String [] aux;
	/**
	 *  constructor with  parameter  initilazes originalmap then copies the tosort map to originlmap . And fills aux with the keys of map
	 * @param tosort
	 */
	public selection(mymap tosort) {
		originalmap = new mymap();
		tosort.putAll(originalmap);
	    aux = new String[tosort.size()];
	    int count = 0;

		for (Map.Entry <String, info> entry : tosort.map.entrySet()) {
	        String key = entry.getKey();
	        aux[count] = key;
	        count++;
	    }
	}
	/**
	 * The sort method of class has nested for loops.Method finds the smallest
	 *  element in the searched area in map and swaps it with the element that was in its place. 
     *After sort of aux array is over method initializes sortedmap with mymap constructor 
     *that takes string array and original map to create my map object. 

. 
	 */
	protected void sort() {
		
		int indexsmallest =0;
		int smallestcount = 0;
		
		for(int i = 0; i<originalmap.mapSize;i++) {
			indexsmallest = i;
		
			smallestcount = originalmap.get(aux[i]).count;
			indexsmallest = i;
			for(int k = i+1 ; k<originalmap.size();k++) {
			
		
				if(smallestcount>originalmap.get(aux[k]).count) {
					smallestcount =originalmap.get(aux[k]).count;
					indexsmallest = k;
				}
				
			}
		    String temp = aux[indexsmallest];
		    aux[indexsmallest] =  aux[i] ;
            aux[i] =temp;;
		
		}
		sortedmap = new mymap(aux,originalmap);
	}
	
	
}
