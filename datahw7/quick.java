package datahw7;

import java.util.Map;

public class quick {
	mymap originalmap;
	mymap sortedmap;
	private String [] aux;

	/**
	 *  	/**
    *constructor with  parameter  initilazes originalmap then copies the tosort map to originlmap .
     *And fills aux with the keys of map
     * @param tosort
	 
	 */
	public quick(mymap tosort) {
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
     *In this recursive method first we find the pivot using patriation method
     * and then call function again with dividing the map by pivot point. 
	 * 
	 * @param low
	 * @param high
	 */
	private void quicksort(int low,int high) {
	        
		if(low<high) {
	 
			int pivot = partitaion(low,high);
			quicksort(low,pivot-1);
			quicksort(pivot+1,high);
		}
	
	}
	
	protected void sort() {
	   
		quicksort(0,aux.length-1);
		sortedmap = new mymap(aux,originalmap);
	
	}
	/**
	 * Method is private because I wanted to be only called by sort method. 
	 * In the beginning of method program chooses the last element as pivot and
	 *  it has variable i which start as low-1.  Method has a for loop. 
	 *  In the for loop program compares the elements with the pivot 
	 *  if they are smaller than pivot program increases i and swaps the element 
	 *  smaller than pivot with the one in index i. 
	 *  After the for loop program swaps the pivot
	 *  with the element in index i + 1 and then returns i + 1. 
	 * @param low
	 * @param high
	 * @return
	 */
		private int  partitaion(int low,int high) {
			String pivotkey = aux[high];

			
			int pivot = originalmap.get(pivotkey).count;
			
			   int i = (low - 1);
			   
		        for (int j = low; j <= high - 1; j++) {
	
		           
		        	String ch  = aux[j];
		        	int countodvalue =  originalmap.get(ch).count;
		            
		        	if (countodvalue < pivot) {
		 
		                
		                i++;
		                String temp = aux[j];
		                aux[j] = aux[i];
		                aux[i] = temp;
		                
		                
		            }
		        }

                aux[high] =  aux[i+1];
                aux[i+1] = pivotkey;
                
		        return (i + 1);
			
			
		}
		

		
	
	
}
