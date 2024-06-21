package hw8data;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class pngimage {

    private  BufferedImage img ;
    private File f;
    //create random image pixel by pixel
  
    /**
     * creates empty map png with no lines
     * sets 0s to white 1s and negative 1 to gray
     * 
     * @param width
     * @param height
     * @param mapcse
     */
    public pngimage(int width,int height,cse222map mapcse) {
    	
    	
    	img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
    	f = null;
    	
    	  for(int y = 0; y < mapcse.map.size(); y++){
    	      for(int x = 0; x < mapcse.map.get(y).size(); x++){
    	      
                 if(mapcse.map.get(y).get(x)==0) {
                	 
                	 img.setRGB(y, x, Color.white.getRGB());//if map is 0 set color of that pixel to white
                 }

                 if(mapcse.map.get(y).get(x)==1 ) {
                	 
                	 img.setRGB(y, x, Color.GRAY.getRGB());//if map is 1 set color of that pixel to black
                 }
                   if(mapcse.map.get(y).get(x)==-1 ) {
                	 
                	 img.setRGB(y, x, Color.GRAY.getRGB());//if map is -1 set color of that pixel to black
                 }
                  
                 
                	 
    	      }
    	    }
    	  
    	    try{
				String workingDir = System.getProperty("user.dir");//gets current directory to create a file
				String topng = mapcse.filename.replace("txt", "png"); //changes filename extension txt to png
				String relativePath = "/Output" + topng  ; // adds word output
    	        f = new File(workingDir+relativePath); //creates file
    	        ImageIO.write(img, "png", f); //writes the image to file
    	    }catch(IOException e){
    	      System.out.println("Error: " + e);
    	    }
    }
    /**
     * draws line
     * if name is not bfs or dij line is blue if it is bfs it is green and if it is dij it is red
     * @param width
     * @param height
     * @param mapcse 
     * @param path is the path we will draw
     * @param name is the algorithm name we want to draw for for bfs name should be bfs for Dijkstra it should be  dij
     */
  public pngimage(int width,int height,cse222map mapcse,ArrayList<String> path,String name) {
    	
    	img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
    	f = null;
    	
    	  for(int y = 0; y < mapcse.map.size(); y++){
    	      for(int x = 0; x < mapcse.map.get(y).size(); x++){
    	      
                 if(mapcse.map.get(y).get(x)==0) {
                	 
                	 img.setRGB(y, x, Color.white.getRGB());
                 }

                 if(mapcse.map.get(y).get(x)==1 ) {
                	 
                	 img.setRGB(y, x, Color.GRAY.getRGB());
                 }
                   if(mapcse.map.get(y).get(x)==-1 ) {
                	 
                	 img.setRGB(y, x, Color.GRAY.getRGB());
                 }
                  
                 
                	 
    	      }
    	    }
    	  int color;
    	  if(name.compareTo("bfs")==0)//line color decide
    		  color = Color.green.getRGB();
    	  else if (name.compareTo("dij")==0)
    		  color = Color.red.getRGB();
    	  else
    		  color = Color.blue.getRGB();
    		  
    	  for(int i = 0; i<path.size();i++) {
    		  String s = path.get(i);
    		  int comma = s.indexOf(',');
    		  int xcoordinate =  Integer.valueOf(s.substring(0,comma)) ;//getting coordinates
    		  int ycoordinate =  Integer.valueOf(s.substring(comma+1)) ;
    		  
    			 img.setRGB(xcoordinate, ycoordinate, color);
    		  
    		  
    	  }
    	  
    	    try{
				String workingDir = System.getProperty("user.dir");
				String topng = mapcse.filename.replace("txt", "png");//changing txt to png 
				String relativePath = "/" +name + topng  ;
    	      f = new File(workingDir+relativePath);
    	      ImageIO.write(img, "png", f);
    	    }catch(IOException e){
    	      System.out.println("Error: " + e);
    	    }
    }
}
