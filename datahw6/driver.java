package hw6;

import java.util.Scanner;

public class driver {
	
public static void main(String[] args) {
	Scanner scan = new Scanner(System.in).useDelimiter("\n"); 
	Scanner scan1 = new Scanner(System.in);
	
	int choice;
	do {
		System.out.println("------------------------");
		System.out.println("Press 0 to exit");
		System.out.println("Press 1 to input string and sort the map");
		System.out.println("------------------------");
		choice = scan1.nextInt();
		
		switch(choice) {
		
		case 0:{
			System.out.println("Exiting");
			scan.close();
			scan1.close();
		}
		break;
        case 1:{
        	System.out.print("Enter String: ");
        	String s = scan.next();
        	mymap mapp;
			try {
				mapp = new mymap(s);

	        	mergesort sortingdevice = new mergesort(mapp);
	        	sortingdevice.divideandmerge(0, mapp.mapSize-1);
	        	System.out.println("Original map is");
	        	sortingdevice.originalmap.print();
	        	System.out.println("Sorted map is");
	        	sortingdevice.sortedmap.print();
			} catch (Exception e) {
				
				System.out.println(e + " please try again");
				break;
			}
		}
		break;
        default : 
        	System.out.println("You made invalid choice try again");
        	break;
		}
	}while(choice != 0);
	
}
}
