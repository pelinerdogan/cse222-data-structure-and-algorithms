package datahw7;


import java.util.ArrayList;

public class info {
	
	int count;
	ArrayList<String> words;
	/**
	 * constructor with no parameters just initilazes arraylist and count
	 */
	public info() {
		words = new  ArrayList<String>();
		count=0;
		
	}
	/**
	 *  constructor with parameters just initilazes arraylist and count and copies given info to this info
	 * @param value
	 */
	public info(info value) {
		words = new  ArrayList<String>();

	  for(int i = 0; i<value.count ; i++)
		  words.add(value.words.get(i));
	  
	  count = value.count;
	}
/**
 * pushes string to arraylist
 * @param s
 */
protected void push(String s) {
		
		words.add(s);
		count++;
	}
	/**
	 * prints arraylist
	 */
	
	 protected void printarr() {
		
		for(int i = 0; i<count;i++) {
			if(i==0)
			System.out.print(  words.get(i) + " ");
			else
			System.out.print("," + words.get(i) + " ");
			
		}
		
		System.out.println("]");
			
	}
	
	

}
