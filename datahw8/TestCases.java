package hw8data;

import java.util.ArrayList;

public class TestCases implements Runnable {

    private  String FileName;
    private int X_SIZE;
    private int Y_SIZE;

    public TestCases(String FileName, int X_SIZE, int Y_SIZE) {
        this.FileName = FileName;
        this.X_SIZE = X_SIZE;
    	this.Y_SIZE = Y_SIZE;
    }



  
    
    public void test(){
    	
    	System.out.println("\n\n*******************\nMap is " + this.FileName + " with X_SIZE " + this.X_SIZE + " and Y_SIZE " + this.Y_SIZE + "\n********************\n");
    	 try {
    			cse222map map = new cse222map(this.FileName);
    			cse222graph graph = new cse222graph(map);
    			CSE222Dijkstra dij = new CSE222Dijkstra(graph);
    			ArrayList<String> path = dij.findpath();
    			map.convertpng();//original map with no lines
    			map.drawLinedij(path);
				System.out.println(FileName);
    			System.out.println("Dijkstra Path: "+( path.size()-1));
    			CSE222BFS BFS= new CSE222BFS (graph);
    			ArrayList<String> path1 = BFS.findpath();
    			System.out.println("BFS Path: " +( path1.size()-1))	;	
    			map.drawLinebfs(path1);
    			dij.writePath(path);
    			BFS.writePath(path1);
    	

    			
    		} catch (Exception e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}

    }

    @Override
    public void run() {
        test();
    }
}

