package hw8data;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CSE222BFS {
	private cse222graph graph;

	public CSE222BFS(cse222graph graph) {
		this.graph = graph;
	}

	/**
	 * finds path with bfs first set inital values. then finds start point. then
	 * puts start to queue adn after that it keeps adding neighbors and
	 * polling them from queue until it visits all. meanwhile it sets the parents of
	 * vertexes then after all returns getpath() method which returns a list
	 * 
	 * @return
	 * @throws Exception
	 */
	public ArrayList<String> findpath() throws Exception {
		ArrayList<Boolean> visited = new ArrayList<Boolean>();
		ArrayList<Vertex> parent = new ArrayList<Vertex>();

		Queue<Vertex> queue = new LinkedList<>();

		for (int i = 0; i < graph.vertexes.size(); i++) { // set inital values
			visited.add(false);
			parent.add(null);
		}
		Vertex start = graph.findvertex(graph.mapcse.startx, graph.mapcse.starty); // find start vertex
		visited.set(start.index, true); // set visited true for start vertex
		queue.add(start);
		while (queue.isEmpty() == false) { // until queue is empty poll from queue
			Vertex currentVertex = queue.poll();

			for (edge edgeofcurr : currentVertex.edges) { // for every edge of vertex if it is not visited set it to
															// visited and set the current vertex to its parent
				Vertex neighborVertex = edgeofcurr.neighbor;
				if (visited.get(neighborVertex.index) == false) {
					visited.set(neighborVertex.index, true);
					parent.set(neighborVertex.index, currentVertex);
					queue.add(neighborVertex);
				}
			}
		}

		return getpath(parent);// creates an arraylist with path written in it
	}

	/**
	 * creates path as string list while it finds parents of end to start vertexs
	 * 
	 * @param parent
	 * @return
	 */
	private ArrayList<String> getpath(ArrayList<Vertex> parent) {
		ArrayList<String> path = new ArrayList<>();
		Vertex before = graph.findvertex(graph.mapcse.finishx, graph.mapcse.finishy);

		while (before != null) {

			path.add(before.xcoor + "," + before.ycoor);
			before = parent.get(before.index);

		}

		return path;
	}

	/**
	 * writes path to file
	 * 
	 * @param path
	 */
	public void writePath(ArrayList<String> path) {

		try {

			String workingDir = System.getProperty("user.dir"); // gets current workin direction to create file in the
																// same path as java files
			String relativePath = "/Outputbfs" + graph.mapcse.filename; // creates file name from file name of original
																		// file
			FileWriter mywriter = new FileWriter(workingDir + relativePath);
			BufferedWriter output = new BufferedWriter(mywriter);

			for (int i = 0; i < path.size(); i++) {
				String s = path.get(i);
				int comma = s.indexOf(',');
				if (comma != -1) {
					int xcoordinate = Integer.valueOf(s.substring(0, comma)); // x is until comma
					int ycoordinate = Integer.valueOf(s.substring(comma + 1));// y is after comma
					output.write(i + " ) X : " + xcoordinate + " Y: " + ycoordinate + "\n");
				}

			}

			mywriter.close(); // prevents recsource leak
		} catch (IOException e1) {
			System.out.println(e1);
		}

	}

}
