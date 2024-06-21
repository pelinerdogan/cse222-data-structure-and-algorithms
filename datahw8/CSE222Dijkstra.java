package hw8data;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CSE222Dijkstra {
    private cse222graph graph;

    public CSE222Dijkstra(cse222graph graph) {
        this.graph = graph;
    }

    /**
     * method sets inital values then set distance 0 for start vertex. if every
     * vertexs length to start is found while loop ends.if not it contiues and set
     * visited to true for current vertex
     * if distance of current index+1 is smaller than neigbors distance set distance
     * of neighbor to distance of current index+1 and set current vertrx to previous
     * vertex of neighbor
     * 
     * @return path
     * @throws Exception
     */
    public ArrayList<String> findpath() throws Exception {

        ArrayList<Integer> distances = new ArrayList<Integer>();
        ArrayList<Boolean> visited = new ArrayList<Boolean>();
        ArrayList<Vertex> predecessors = new ArrayList<Vertex>();

        for (int i = 0; i < graph.vertexes.size(); i++) { // set inital values
            distances.add(Integer.MAX_VALUE);
            predecessors.add(null);
            visited.add(false);
        }
        Vertex start = graph.findvertex(graph.mapcse.startx, graph.mapcse.starty); // start vertex find
        distances.set(start.index, 0); // set distance 0 for start vertex

        while (true) {

            Vertex currVertex = getMinDistanceVertex(distances, visited);

            if (currVertex == null) // if every vertexs length to start is found loop breaks
                break;

            visited.set(currVertex.index, true); // if not it contiues and set visited to true for current vertex

            ArrayList<edge> edgesofcurrent = currVertex.edges;

            for (edge edgeofcurr : edgesofcurrent) {// for every edge of vertex
                Vertex neighborVertex = edgeofcurr.neighbor;
                int ndistance = distances.get(currVertex.index) + 1; // distanceof current index+1

                if (ndistance < distances.get(neighborVertex.index)) { // if distance of current index+1 is smaller than
                                                                       // neigbors distance
                    distances.set(neighborVertex.index, ndistance); // set distance of neighbor to distance of current
                                                                    // index+1
                    predecessors.set(neighborVertex.index, currVertex);// and set current vertrx to previous vertex of
                                                                       // neighbor
                }
            }
        }

        return getPath(predecessors);

    }

    /**
     * creates path as string list while it finds previous node from end to start
     * 
     * @param predecessors
     * @return
     */
    private ArrayList<String> getPath(ArrayList<Vertex> predecessors) {
        Vertex before = graph.findvertex(graph.mapcse.finishx, graph.mapcse.finishy);
        ArrayList<String> path = new ArrayList<String>();

        while (before != null) {

            path.add(before.xcoor + "," + before.ycoor);

            before = predecessors.get(before.index);

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

            String workingDir = System.getProperty("user.dir");// gets current workin direction to create file in the
                                                               // same path as java files
            String relativePath = "/Outputdijkstira" + graph.mapcse.filename;// creates file name from file name of
                                                                             // original file
            FileWriter mywriter = new FileWriter(workingDir + relativePath);
            BufferedWriter output = new BufferedWriter(mywriter);

            for (int i = 0; i < path.size(); i++) {
                String s = path.get(i);
                int comma = s.indexOf(',');
                if (comma != -1) {
                    int xcoordinate = Integer.valueOf(s.substring(0, comma));// x is until comma
                    int ycoordinate = Integer.valueOf(s.substring(comma + 1)); // y is after comma
                    output.write(i + " ) X : " + xcoordinate + " Y: " + ycoordinate + "\n");
                }

            }

            mywriter.close();// prevents recsource leak
        } catch (IOException e1) {
            System.out.println(e1);
        }

    }

    /**
     * a vertexes neighbours get compared and find minumum distance vertex
     * 
     * @param distance
     * @param visited
     * @return
     */
    private Vertex getMinDistanceVertex(ArrayList<Integer> distance, ArrayList<Boolean> visited) {
        int minDistance = Integer.MAX_VALUE;
        Vertex minVertex = null;

        for (Vertex vertex : graph.vertexes) { // for every vertex if vertex is not visited and distance of it smaller
                                               // than min distance

            if (visited.get(vertex.index) == false && distance.get(vertex.index) < minDistance) { // if vertex is not
                                                                                                  // visited and has
                                                                                                  // smaller distance
                                                                                                  // then current vertex
                minDistance = distance.get(vertex.index);
                minVertex = vertex;
            }
        }

        return minVertex;
    }

}
