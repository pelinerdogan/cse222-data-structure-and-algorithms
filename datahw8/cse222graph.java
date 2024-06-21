package hw8data;

import java.util.ArrayList;

public class cse222graph {

	protected ArrayList<Vertex> vertexes;
	protected cse222map mapcse;

	public cse222graph(cse222map mapcse) {

		vertexes = new ArrayList<Vertex>();

		this.mapcse = mapcse;
		generatevertexes();
		generatedges();
	}

	/**
	 * generetes vertexes by searcing map and finds 0's
	 */
	private void generatevertexes() {

		int count = 0;
		for (int i = 0; i < mapcse.map.size(); i++) { // since map is a 2d arralist method has nested loop

			for (int k = 0; k < mapcse.map.get(i).size(); k++) {

				if (mapcse.map.get(i).get(k) == 0) {
					Vertex newvertex = new Vertex(i, k, count);
					count++;
					vertexes.add(newvertex);
				}
			}

		}

	}

	/**
	 * generetes edges of vertexes by looking at their coordinates
	 */
	private void generatedges() {

		for (int i = 0; i < vertexes.size(); i++) {// for every vertex it searcheas neighbor vertexes
			Vertex v = vertexes.get(i);
			int x = v.xcoor;
			int y = v.ycoor;
			for (int k = 0; k < vertexes.size(); k++) {
				Vertex v1 = vertexes.get(k);
				int x1 = vertexes.get(k).xcoor;
				int y1 = vertexes.get(k).ycoor;
				if (x1 == x - 1 && y1 == y) {
					v.edges.add(new edge(v1));
				}
				if (x1 == x + 1 && y1 == y) {
					v.edges.add(new edge(v1));
				}
				if (x1 == x && y1 == y - 1) {
					v.edges.add(new edge(v1));
				}
				if (x1 == x && y1 == y + 1) {
					v.edges.add(new edge(v1));
				}
				if (x1 == x - 1 && y1 == y - 1) {
					v.edges.add(new edge(v1));
				}
				if (x1 == x - 1 && y1 == y + 1) {
					v.edges.add(new edge(v1));
				}
				if (x1 == x + 1 && y1 == y - 1) {
					v.edges.add(new edge(v1));
				}
				if (x1 == x + 1 && y1 == y + 1) {
					v.edges.add(new edge(v1));
					break; // founded all neigbours
				}

			}

		}

	}

	/**
	 * searches and returns vertex with specific coordinates mostly used to find
	 * start and end points
	 * 
	 * @param x x coordinate of vertex
	 * @param y y coordinate of vertex
	 * @return
	 */
	protected Vertex findvertex(int x, int y) {
		for (int i = 0; i < vertexes.size(); i++) {
			if (vertexes.get(i).xcoor == x && vertexes.get(i).ycoor == y) {

				return vertexes.get(i);
			}
		}
		return null;
	}

}

/**
 * This class keeps coordinates of the vertex and its index inside so that i can
 * easily learn thir place in arraylist without doing search
 * 
 * @author pelin
 *
 */
class Vertex {
	int xcoor, ycoor;
	int index;
	ArrayList<edge> edges = new ArrayList<edge>();

	public Vertex(int xcoor, int ycoor, int index) {
		this.xcoor = xcoor;
		this.ycoor = ycoor;
		this.index = index;
	}

	@Override
	public String toString() {
		return "X coordinate " + xcoor + "Y coordinate " + ycoor;

	}

}

class edge {
	Vertex neighbor; // every vertex has edge list and edges on their list keep the neighbor vertex
						// of them

	public edge(Vertex v) {
		neighbor = v;

	}
}