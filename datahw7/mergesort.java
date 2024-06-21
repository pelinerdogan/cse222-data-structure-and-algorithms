package datahw7;

import java.util.Map;

public class mergesort {
mymap originalmap;
mymap sortedmap;
private String [] aux;

/**	/**
    *constructor with  parameter  initilazes originalmap then copies the tosort map to originlmap .
     *And fills aux with the keys of map
     * @param tosort

 */
public mergesort(mymap tosort) {

	originalmap = new mymap();
    aux = new String[tosort.size()];
    int count = 0;
	
    for (Map.Entry <String, info> entry : tosort.map.entrySet()) {
        String key = entry.getKey();
        aux[count] = key;
        count++;
        
    }
	
	tosort.putAll(originalmap);

	
	
		
}
/**
 *  calls divideandmerge method in a proper way and initializes sortedmap with mymap constructor 
 *  that takes string array and an another map to create my map object.  
 */
protected void sort( ) {

	divideandmerge(0,originalmap.size()-1);

	 sortedmap = new mymap(aux,originalmap);
	 
}

/**
 * recursive sort function divides map untill left is bigger or equal to right
 * @param left is 0 in beggining
 * @param right is size-1 of map
 */
private void divideandmerge(int left,int right ) {

    if(left<right) {
	int mid = (left+right)/2;
	
	divideandmerge(left,mid);
	divideandmerge(mid+1,right);
	merge(left,mid,right);
    }
	
}

/**
 * Method is private because I wanted to be only called by divideandmerge method. creates 4 other array for left and right sides to merge.
 *  2 integer arrays 2 string arrays. Puts the elements we want to merge inside them
 *   and then compares left ones with right ones and whichever is smaller assigns that one 
 *   into aux and increases necessary variables.after comparison 
 *   if there are any elements in right or left map that is not putted in place in original aux array. 
 *   Puts them after the ones added before.
 * @param left
 * @param mid
 * @param right
 */

private void merge(int left, int mid, int right) {
	int  map1s = mid - left + 1;
	int map2s = right - mid;
	

    int Lint[] = new int[map1s];
    String Left[] = new String[map1s];
    int Rint[] = new int[map2s];
    String Right[] = new String[map2s];

	for(int i = 0;i<map1s;i++) {	
		Left[i] = aux[i+left];
		Lint[i] = originalmap.get(Left[i]).count;			
			
		
	}
	for(int i = 0;i<map2s;i++) {		
		Right[i] = aux[i+mid+1];
		Rint[i] = originalmap.get(Right[i]).count;
	}
	int indexleft= 0,indexright = 0; // Initial index of first sub-array
    int indexOfMerged= left; 
	
    while (indexleft < map1s && indexright < map2s) {
    	
    	
         if (Lint[indexleft] <= Rint[indexright])
         {
        	
             aux[indexOfMerged] = Left[indexleft];
                 
             indexleft++;
         }
         else {

             aux[indexOfMerged] = Right[indexright];
                 
             indexright++;
         }
         indexOfMerged++;
     }
     while (indexleft < map1s) {
        
    	 aux[indexOfMerged] = Left[indexleft];
         indexleft++;
         indexOfMerged++;
     }
     
     while (indexright< map2s) {
    	   aux[indexOfMerged] = Right[indexright];
           
         indexright++;
         indexOfMerged++;
     }
  
 }
	
	
	
	
	
}




