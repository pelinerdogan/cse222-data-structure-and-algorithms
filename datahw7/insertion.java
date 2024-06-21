package datahw7;

import java.util.Map;

public class insertion {
	mymap originalmap;
	mymap sortedmap;
	private String [] aux;
	
	/**
    *constructor with  parameter  initilazes originalmap then copies the tosort map to originlmap .
     *And fills aux with the keys of map
     * @param tosort
	 */
	public insertion(mymap tosort) {
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
	 *The sort method of class has a while loop inside of a for loop.
	 * In the for loop I store current key in variable current and then
	 *  I find the value of that key from map and store count (info object’s property ) in currentcount. 
	 *  In while loop I move the current element untill I find a smaller one. 
	 *  After sort of aux array is over method initializes sortedmap with mymap constructor 
	 *  that takes string array and original map to create my map object. 

 
	 */

	protected void sort() {
		
		int currentcount = 0;
		int beforecount = 0;
		String current;
		for(int i = 1; i<originalmap.mapSize;i++) {
	

		    int k = i-1;
		    current = aux[i];
		    currentcount = originalmap.get(aux[i]).count;
		    beforecount=originalmap.get(aux[k]).count;
		    while(k>=0&& beforecount>currentcount) {
		  
	        aux[k+1] =  aux[k];
	    
		    k--;
		    if(k>=0)
		    beforecount=originalmap.get(aux[k]).count;
		    }
		    
		    aux[k+1] = current;
		    
		  
		}
		
		sortedmap = new mymap(aux,originalmap);
	}
	
}
