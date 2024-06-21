package hw8data;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class cse222map {
	int startx,finishx,starty,finishy;
   protected ArrayList<ArrayList<Integer>> map ;
	protected String filename;
    
    public cse222map(String textname) throws Exception {
    	filename = textname;
    	map = new ArrayList<ArrayList<Integer>>();
    	readfile(textname);
    	if(map.get(startx).get(starty) != 0)
    		throw new Exception("Start point wrong");

    	if(map.get(finishx).get(finishy) != 0)
    		throw new Exception("End point wrong");
    	
    }
    
    protected void readfile(String textname) {
 
		try {
			File myObj = new File(textname);
			Scanner myReader = new Scanner(myObj);
				String data = myReader.nextLine(); //get line
                 
				
				if( data.indexOf(',') != -1) {  
				String sub = data.substring(0, data.indexOf(',')); //getting start points
				data = data.substring( data.indexOf(',')+1);
				startx = Integer.valueOf(sub);
		
				starty = Integer.valueOf( data);
				
				}
				else {
					myReader.close();
					throw new Exception("Couldn't find coordinates");
				}
				
				 data = myReader.nextLine();
                
				
				if( data.indexOf(',') != -1) {
				String sub = data.substring(0, data.indexOf(','));
				data = data.substring( data.indexOf(',')+1);
				finishx = Integer.valueOf(sub);
				
				finishy = Integer.valueOf( data); //get finish point 
				
				}
				else {
					myReader.close();
					throw new Exception("Couldn't find coordinates");
				}
				 
				while (myReader.hasNextLine()) { // while file has next line 
				ArrayList<Integer> temp = new ArrayList<Integer>();
				String line = myReader.nextLine();
				
				while(line.indexOf(',')!=-1) { // while line has comma
					String sub = line.substring(0, line.indexOf(',')); 
					line = line.substring( line.indexOf(',')+1);
					temp.add(Integer.valueOf(sub));     
					
				}
				temp.add(Integer.valueOf(line)); //add element after last comma
				map.add(temp);
				
			    }
				
				
			myReader.close();
		} catch (Exception e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
/**
 * creates emptymap
 */
	public void convertpng() {
		pngimage deneme = new pngimage(map.size(),map.get(0).size(),this);
		
	}
/*
 * draws line for Dijkstra
 */
	public void drawLinedij(ArrayList<String> path) {
		
		pngimage deneme = new pngimage(map.size(),map.get(0).size(),this,path,"dij" );
		
	}
	/*
	 * draws line for bfs
	 */
   public void drawLinebfs(ArrayList<String> path) {
		
		pngimage deneme = new pngimage(map.size(),map.get(0).size(),this,path,"bfs" );
		
	}
   
   
}
