package hw5;

import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class tree {

	ArrayList<ArrayList<String>> treearr = new ArrayList<ArrayList<String>>();
	DefaultMutableTreeNode root;
	JTree jt;
	JFrame fr = new JFrame();
/*
 * Constructor
 */
	public tree() {   
		root = new DefaultMutableTreeNode("root");
		jt = new JTree(root);
		fr.setSize(400, 500);
		fr.add(jt);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.setTitle("Tree");
		fr.setVisible(false);
	}
/**
 * reads file and calls function to add elements into array
 * @param textname file name
 */
	protected void readfile(String textname) {

		try {
			File myObj = new File(textname);
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();

				addelementtoarr(data);
			}
			myReader.close();
		} catch (Exception e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
/**
 * 
 * @param line is one line from file
 * @throws Exception if line is empty throws exception
 */
	private void addelementtoarr(String line) throws Exception {
		if (line.length() == 0)
			throw new Exception("Line is empty");

		int end = 0;
		ArrayList<String> temp = new ArrayList<String>();
		while (end != -1) {

			end = line.indexOf(";");

			if (end > 0) {

				temp.add(line.substring(0, end));
				line = line.substring(end + 1);

			} else {
				temp.add(line.substring(0));

			}

		}
		treearr.add(temp);

	}
/*
 * prints array
 */
	protected void printing() {

		for (int i = 0; i < treearr.size(); i++) {
			for (int k = 0; k < treearr.get(i).size(); k++) {
				System.out.print(treearr.get(i).get(k) + " ");
			}
			System.out.println();
		}

	}
/**
 * adds elements from array yo tree
 */
	protected void addelementstotree() {

		for (int i = 0; i < treearr.size(); i++) {

			DefaultMutableTreeNode nod = root;

			for (int l = 0; l < treearr.get(i).size(); l++) {

				boolean bool1 = false;
				for (int k = 0; k < nod.getChildCount(); k++) {

					if (nod.getChildAt(k).toString().compareTo(treearr.get(i).get(l)) == 0) {
						nod = (DefaultMutableTreeNode) nod.getChildAt(k);
						bool1 = true;

					}

				}

				if (bool1 == false) {

					DefaultMutableTreeNode nodnew = new DefaultMutableTreeNode(treearr.get(i).get(l));
					nod.add(nodnew);
					nod = nodnew;

				}
			}

		}
         fr.setVisible(true);
	}
   /**
    * fills tree
    * since it is bfs variable childs's type  is queue
    * @param tree is a queue that fill keep nodes
    * @param nod should be root in search but you can send another node to see only that node and it's childs
    */
	private void bfshelp(Queue<DefaultMutableTreeNode> tree, DefaultMutableTreeNode nod) {

		Queue<DefaultMutableTreeNode> childs = new LinkedList<DefaultMutableTreeNode>();

		childs.add(nod);
		tree.add(nod);
		while (childs.size() > 0) {

			nod = childs.poll();

			for (int i = 0; i < nod.getChildCount(); i++) {
				tree.add((DefaultMutableTreeNode) nod.getChildAt(i));
				childs.add((DefaultMutableTreeNode) nod.getChildAt(i));

			}
		}

	}
	
	/**
	 * searches three we filled in help function
	 * 
	 * @param search is the string we are searching
	 * @return true if element is found else returns false
	 */

	protected boolean bfs(String search) {

		Queue<DefaultMutableTreeNode> tree = new LinkedList<DefaultMutableTreeNode>();
		bfshelp(tree, root);

		int m = tree.size();
		System.out.println("\n\nUsing BFS to find \" " + search + "\" in tree");
		for (int i = 0; i < m; i++) {
			String s = tree.poll().toString();
			System.out.println("Step " + +(i + 1) + "-> " + s);
			if (s.compareTo(search) == 0) {
				System.out.println("Found!\n\n");
				return true;
			}
		}
		System.out.println("Not Found!\n\n");
		return false;
	}

	   /**
	    * fills tree
	    * since it is dfs variable childs's type  is stack
	    * @param tree is a queue that fill keep nodes
	    * @param nod should be root in search but you can send another node to see only that node and it's childs
	    */
	private void dfshelp(Queue<DefaultMutableTreeNode> tree, DefaultMutableTreeNode nod) {

		Stack<DefaultMutableTreeNode> childs = new Stack<DefaultMutableTreeNode>();

		childs.add(nod);

		while (childs.size() > 0) {

			nod = childs.pop();
			tree.add(nod);

			for (int i = 0; i < nod.getChildCount(); i++) {
				childs.add((DefaultMutableTreeNode) nod.getChildAt(i));

			}
		}

	}
	/**
	 * searches three we filled in help function
	 * 
	 * @param search is the string we are searching
	 * @return true if element is found else returns false
	 */

	protected boolean dfs(String search) {

		Queue<DefaultMutableTreeNode> tree = new LinkedList<DefaultMutableTreeNode>();
		dfshelp(tree, root);

		int m = tree.size();
		System.out.println("\n\nUsing DFS to find \" " + search + "\" in tree");
		for (int i = 0; i < m; i++) {
			String s = tree.poll().toString();
			System.out.println("Step " + +(i + 1) + "-> " + s);
			if (s.compareTo(search) == 0) {
				System.out.println("Found!\n\n");
				return true;
			}
		}
		System.out.println("Not Found!\n\n");
		return false;
	}

	   /**
	    * fills tree
	    * since it is dfs variable childs's type  is stack
	    * @param tree is a stack that fill keep nodes
	    * @param nod should be root in search but you can send another node to see only that node and it's childs
	    */
	private void posthelp(Stack<DefaultMutableTreeNode> tree, DefaultMutableTreeNode nod) {

		Stack<DefaultMutableTreeNode> childs = new Stack<DefaultMutableTreeNode>();

		childs.add(nod);

		while (childs.size() > 0) {

			nod = childs.pop();
			tree.add(nod);

			for (int i = 0; i < nod.getChildCount(); i++) {
				childs.add((DefaultMutableTreeNode) nod.getChildAt(i));

			}
		}

	}
	/**
	 * searches three we filled in help function
	 * 
	 * @param search is the string we are searching
	 * @return true if element is found else returns false
	 */

	protected boolean posttraversal(String search) {

		Stack<DefaultMutableTreeNode> tree = new Stack<DefaultMutableTreeNode>();
		posthelp(tree, root);

		int m = tree.size();
		System.out.println("\n\nUsing Post-Order Traversal to find \" " + search + "\" in tree");
		for (int i = 0; i < m; i++) {
			String s = tree.pop().toString();
			System.out.println("Step " + +(i + 1) + "-> " + s);
			if (s.compareTo(search) == 0) {
				System.out.println("Found!\n\n");
				return true;
			}
		}
		System.out.println("Not Found!\n\n");
		return false;
	}

	/**
	 * this functiıon first calls copytree function to create a copy of tree to show difference in a different jtree
	 * then it calls findnode function with s and to strings and assigns returned value of function to empty nodes 
	 * if nodes are null this means nodes we search for are not existing. if the one we want to move is null we print node doesnt exists
	 * if node we want to move other node to is null we create a node.
	 * İf we try to move root and child of a root it throws exception 
	 * then function calls find path which finds the node we should add this node but after getting this node we should check the 
	 * return node to being root childs sibling if so we should add the node with its parents. When we do that we have to be carefull about child number 
	 * if the node we want to move has a sibling we cant move parent with it so we create copy of parent and move sibling to copied parent
	 * And we create another jframe to show old tree
	 * @param s is the path to node we wanna move
	 * @param to is the node name we want to move the node to
	 * @throws Exception
	 */
	 protected void movenode(String s, String to) throws Exception {

		DefaultMutableTreeNode nod = new DefaultMutableTreeNode();
		DefaultMutableTreeNode nod1 = new DefaultMutableTreeNode();
		DefaultMutableTreeNode nod2 = new DefaultMutableTreeNode();
		DefaultMutableTreeNode nod3 = new DefaultMutableTreeNode();
		DefaultMutableTreeNode nod4 = new DefaultMutableTreeNode();

		DefaultMutableTreeNode cop = new DefaultMutableTreeNode();

		copytree(root, cop);

		nod = findnode(s);
		nod1 = findnode(to);

		if (nod == null) {
			System.out.println("Can't move " + s + " node doesn't exist");
		}
		
		else { //if node exists
				if (nod.getParent().equals(root) == true || nod == root) {  // if its a year
					throw new Exception("Can't move root or child of root");
				}
				
	
				if (nod1 == null) { // if to year doesnt exist add  
					root.add(nod1 = new DefaultMutableTreeNode(to));
					nod2=(DefaultMutableTreeNode) nod.getParent();
					if(nod2.getChildCount()==1)
						nod2.removeFromParent();
					
					nod1.add(nod);
					System.out.println("Moved " + s + " to " + to);
				} 
				
				else {// if to exists search in path
						nod3 = searchinpath(s, nod1);
						 
						if (nod3 == null) { // add straight
			              
							nod2 = (DefaultMutableTreeNode) nod.getParent();
							
							if(nod2.getChildCount()==1)
								nod2.removeFromParent();
							
							nod1.add(nod);
							
							System.out.println("Moved " + s + " to " + to);
		
						} 
						else {
                          
						if(nod3.toString().compareTo(nod.toString()) == 0) {
							
							System.out.println(s + "has been overwritten");
							if(nod.getParent().getChildCount() == 1)
								((DefaultMutableTreeNode )nod.getParent()).removeFromParent();
						}
						else {
							System.out.println("Moved " + s + " to " + to);
							  nod4 = nod;
							 
							 if(((DefaultMutableTreeNode) nod3.getParent()).isRoot() == false) {
							
							while (nod3.toString().compareTo(nod.toString()) !=0 ) {
								nod2 = nod;
								nod = (DefaultMutableTreeNode) nod.getParent();
						        
							   }	
							 }

							 
							nod1 = (DefaultMutableTreeNode) nod.getParent();
							
							if(nod1.getChildCount()==1)
								nod1.removeFromParent();
							
							
							 
							if (nod.getChildCount() == 1) {
								nod3.add(nod);
								
							} 
							else {
								DefaultMutableTreeNode nod5 = nod;
								nod2 = nod;
								 nod4 = new DefaultMutableTreeNode(nod.toString());
								 nod=(DefaultMutableTreeNode) nod.getParent();
								
								while(root.isNodeChild(nod)==false) {
									
								
									nod5 = new DefaultMutableTreeNode(nod.toString());
									nod5.add(nod4);
									nod4 = nod5;
									nod=(DefaultMutableTreeNode) nod.getParent();
								}
								
								nod3.add(nod5);
								nod2.removeFromParent();
                                
		
							}
						}
						}
				}
		}

		JTree jt1 = new JTree(cop);
		JFrame fr1 = new JFrame();
		fr1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr1.setSize(400, 500);
		fr1.add(jt1);
		fr1.setTitle("Tree before move operation");
		fr.setTitle("Tree after move operation");
		fr1.setVisible(true);

	}
    /**
     * 
     * @param s is path to node we want to move 
     * function creates string arraylist and adds the path to it 
     * then uses bfshelp function to create a tree to search  
     * 
     * @return returns true if node exists
     */
	private DefaultMutableTreeNode findnode(String s) {

		int end = s.indexOf('-');
		DefaultMutableTreeNode nod = new DefaultMutableTreeNode();
		ArrayList<String> temp = new ArrayList<String>();

		if (end == -1)
			temp.add(s);
		
			while (end != -1) {
	
				end = s.indexOf("-");
	
				if (end > 0) {
					temp.add(s.substring(0, end));
					s = s.substring(end + 2);
	            } else 
					temp.add(s.substring(0));
		
			}

		Queue<DefaultMutableTreeNode> tree = new LinkedList<DefaultMutableTreeNode>();
		bfshelp(tree, root);
		boolean all = false;
		for (int k = 0; k < temp.size(); k++) {
				boolean bool = false;
				int size = tree.size();
	
				for (int i = 0; i < size; i++) {
					nod = tree.poll();
	
					if (nod.toString().compareTo(temp.get(k)) == 0) {
						bool = true;
						i = size + 1;
	
					}
				}
	
				if (bool == false) {
					k = temp.size();
	
				} else {
					tree.clear();
					bfshelp(tree, nod);
				}
				all = bool;
		}

		if (all == true)
			return nod;

		else
			return null;

	}
	
	/**
	 * 
	 * @param s path of node we move
	 * @param nod1 the node we will move to
	 * @return node if nod1 has a child with the name of  the node null if it doesn't
	 */

 private DefaultMutableTreeNode searchinpath(String s, DefaultMutableTreeNode nod1) {

		int end = s.indexOf('-');
		DefaultMutableTreeNode nod = new DefaultMutableTreeNode();
		DefaultMutableTreeNode nod2 = new DefaultMutableTreeNode();
		
		ArrayList<String> temp = new ArrayList<String>();

		if (end == -1)
			temp.add(s);
		while (end != -1) {
			end = s.indexOf("-");
			if (end > 0) {
				temp.add(s.substring(0, end));
				s = s.substring(end + 2);
			} else
				temp.add(s.substring(0));

		}
		
		
		

		Queue<DefaultMutableTreeNode> tree = new LinkedList<DefaultMutableTreeNode>();
        
		bfshelp(tree, nod1);
		boolean all = false;
		int count = 0;
         tree.poll();
		for (int k = 1; k < temp.size(); k++) {
	      
			boolean bool = false;
			int size = tree.size();
            
			for (int i = 0; i < size; i++) {
				
				nod = tree.poll();

				if (nod.toString().compareTo(temp.get(k)) != 0) {
					bool = true;
					   
				        count++;
					i = size + 1;
				}
			}

			if (bool == true) {
				   
				k = temp.size()+10;

			} else {
				   
				tree.clear();
				bfshelp(tree, nod);
			}
			all = bool;
        
		}
		
		if (all == true) {
			if (count !=1)
			return nod;
			
			else return nod1;
		}
		else
			return null;

	}
/**
 * copies tree recursively
 * 
 * @param nodfromrealtree
 * @param nodfromcopy
 */
	private void copytree(DefaultMutableTreeNode nodfromrealtree, DefaultMutableTreeNode nodfromcopy) {

		DefaultMutableTreeNode nod2 = new DefaultMutableTreeNode();

		for (int i = 0; i < nodfromrealtree.getChildCount(); i++) {

			nodfromcopy.add(nod2 = new DefaultMutableTreeNode(nodfromrealtree.getChildAt(i).toString()));
			copytree((DefaultMutableTreeNode) nodfromrealtree.getChildAt(i), nod2);
		}

	}

}
