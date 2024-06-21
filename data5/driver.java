package hw5;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class driver {
	
public static void main(String [] args) {
	 Scanner scan = new Scanner(System.in);
	 tree t = new tree();
	 boolean exit = false; 
	
	 while(exit == false) {
		 int choice ;
		 System.out.println("-------------------");
		
		 System.out.println("exit : 0");
		 System.out.println("read file : 1");
		 System.out.println("print 2d arraylist : 2");
		 System.out.println("Create the tree : 3");
		 System.out.println("Search with BFS : 4");
		 System.out.println("Search with DFS : 5");
		 System.out.println("Search with Post Traversal : 6");
		 System.out.println("Move node : 7");
		 System.out.println("Please enter the operation you want to do"); 
		
		 System.out.println("-------------------");
		 
		 choice = scan.nextInt() ;
		 switch(choice) {
		 case 0:
			 System.out.println("You need to close window");
			
			 exit = true;
			 scan.close();
		     
		 break; 

          case 1:{
        	  System.out.println("Enter file name");
			  String file = scan.next();
        	  t.readfile(file);
		 }
		 break;
		 case 2:{
			 
			 t.printing();
			 
		 }
		 break;
		 case 3:{
			 t.addelementstotree();
			 
		 }
		 break;
		 case 4:{

       	  System.out.println("Enter node");
			  String node = scan.next();
			 t.bfs(node);
		 }
		 break;
		 case 5:{

       	  System.out.println("Enter node");
			  String node = scan.next();
			  t.dfs(node);
		 }
		 break;
         case 6:{

       	  System.out.println("Enter node");
			  String node = scan.next();
        	 t.posttraversal(node);
		 }
		 break;
         case 7:{
			 
        	 try {
        		  System.out.println("Enter path with -> between nodes like 2022->CSE102->LECTURE1: ");
            	 String s = scan.next();
            	  System.out.println("Enter the node we want to move to ");
            	 String to = scan.next();
            	 
        		t.movenode(s,to);
        	} catch (Exception e) {
        		// TODO Auto-generated catch block
        		e.printStackTrace();
        	}
		 }
		 break;
		 }
		 
	 }
    
	 
}


}
