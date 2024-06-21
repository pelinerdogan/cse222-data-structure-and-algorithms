package hw6;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class mergesort {
mymap originalmap;
mymap sortedmap;
/**
 *  constructor with  parameter  initilazes originalmap and copies the tosort map to originalmap. Then assigns sortedmap to tosort map.
 * @param tosort
 */
public mergesort(mymap tosort) {
	originalmap = new mymap();

	tosort.putAll(originalmap);
	sortedmap = tosort;
	
		
}
/**
 * recursive sort function divides map untill left is bigger or equal to right
 * @param left is 0 in beggining
 * @param right is size-1 of map
 */
protected void divideandmerge(int left,int right ) {

    if(left<right) {
	int mid = (left+right)/2;
	
	divideandmerge(left,mid);
	divideandmerge(mid+1,right);
	merge(left,mid,right);
    }
	
}

/**
 * creates 2 other maps for left and right sides to merge. Puts the elements we want to merge inside them and than compares 
 * left ones with right ones and whichever is smaller adds that one in to original map first. This is why I have addtoindex and getkeybyindex.
 * after comperisson if there are any elements in right or left map that is not putted in place in original map. Puts them after the ones added before
 * @param left
 * @param mid
 * @param right
 */

protected void merge(int left, int mid, int right) {
	int  map1s = mid - left + 1;
	int map2s = right - mid;
	
	mymap leftmap = new mymap();
	mymap rightmap = new mymap();
	
	for(int i = 0;i<map1s;i++) {	
		Character newkey = sortedmap.getkeybyindex(i+left);
	
		if(sortedmap.get(newkey)!=null)
    	   leftmap.put(newkey, sortedmap.get(newkey));			
	}
	for(int i = 0;i<map2s;i++) {	
		Character newkey = sortedmap.getkeybyindex(i+mid+1);
		
		if(sortedmap.get(newkey)!=null)
    	   rightmap.put(newkey, sortedmap.get(newkey));			
	}
	int indexleftmap= 0,indexrightmap = 0; // Initial index of first sub-array
    int indexOfMergedmap= left; 
	
    while (indexleftmap < map1s && indexrightmap < map2s) {
    	
    	Character keyleft = leftmap.getkeybyindex(indexleftmap);
    	Character keyright = rightmap.getkeybyindex(indexrightmap);
    	info valueleft = leftmap.get(keyleft);
    	info valueright = rightmap.get(keyright);
    	
         if (valueleft.count <= valueright.count)
         {
        	
             sortedmap.addtoindex(indexOfMergedmap,keyleft , valueleft);
                 
             indexleftmap++;
         }
         else {
        	 
             sortedmap.addtoindex(indexOfMergedmap,keyright , valueright);
                 
             indexrightmap++;
         }
         indexOfMergedmap++;
     }
     while (indexleftmap < map1s) {
    
    	 Character keyleft = leftmap.getkeybyindex(indexleftmap);
    	 info valueleft = leftmap.get(keyleft);
         sortedmap.addtoindex(indexOfMergedmap,keyleft , valueleft);
             
         indexleftmap++;
         indexOfMergedmap++;
     }
     
     while (indexrightmap < map2s) {
    	Character keyright = rightmap.getkeybyindex(indexrightmap);
     	info valueright = rightmap.get(keyright);
     	
     	sortedmap.addtoindex(indexOfMergedmap,keyright , valueright);
        
         indexrightmap++;
         indexOfMergedmap++;
     }
  
 }
	
	
	
	
	
}




