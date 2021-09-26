package example.entity;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;


public class Puzzle implements Iterable<Node> {
	ArrayList<Node> nodes = new ArrayList<>();
	HashMap<Point, Edge> edges = new HashMap<Point, Edge>();
	ArrayList<Node> originalNodes = new ArrayList<>();
	HashMap<Point, Edge> originalEdges = new HashMap<Point, Edge>();
	
	//triangles: (firstPoint(Pair(smallPoint, largePoint), secondPoint, thirdPoint))
	ArrayList<ArrayList<Point>> triangles;
	public final int numRows;
	public final int numColumns;
	
	public Puzzle(int numColumns, int numRows) {
		this.numColumns = numColumns;
		this.numRows = numRows;
		this.initTriangle();
	}
	
	public int getColumn() {return this.numColumns;}
	public int getRow() {return this.numRows;}
	public Node getNodeByIndex(int index)
	{
		return nodes.get(index);
	}
	
	public void add(int row, int col) {
		Node n = new Node();
		n.setColumn(col);
		n.setRow(row);
		
		// check overlapping....
		nodes.add(n);
		this.originalNodes.add(n.copy());
	}
	
	public void addEdge(int smallNode, int largeNode, int color)
	{
		Point coordinate = new Point(smallNode, largeNode);
		Edge e = new Edge(color);
		edges.put(coordinate, e);
		this.originalEdges.put(coordinate, e.copy());
	}
	
	public void initTriangle()
	{
		this.triangles = new ArrayList<>();
		// T1: (0,1) (0, 2), (1,2)
		ArrayList<Point> t1 = new ArrayList<Point>();
		t1.add(new Point(0, 1));
		t1.add(new Point(0, 2));
		t1.add(new Point(1, 2));
		this.triangles.add(t1);
		
		// T2: (1, 3) (1, 4), (3, 4)
		ArrayList<Point> t2 = new ArrayList<Point>();
		t2.add(new Point(1, 3));
		t2.add(new Point(1, 4));
		t2.add(new Point(3, 4));
		this.triangles.add(t2);
		
		ArrayList<Point> t3 = new ArrayList<Point>();
		t3.add(new Point(2, 4));
		t3.add(new Point(2, 5));
		t3.add(new Point(4, 5));
		this.triangles.add(t3);
		
		ArrayList<Point> t4 = new ArrayList<Point>();
		t4.add(new Point(3, 6));
		t4.add(new Point(3, 7));
		t4.add(new Point(6, 7));
		this.triangles.add(t4);
		
		
		ArrayList<Point> t5 = new ArrayList<Point>();
		t5.add(new Point(4, 7));
		t5.add(new Point(4, 8));
		t5.add(new Point(7, 8));
		this.triangles.add(t5);
		
		
		ArrayList<Point> t6 = new ArrayList<Point>();
		t6.add(new Point(5, 8));
		t6.add(new Point(5, 9));
		t6.add(new Point(8, 9));
		this.triangles.add(t6);
	}
	
	
	
	public HashMap<Point, Edge> getEdges()
	{
		return edges;
	}
	
	public ArrayList<Node> getNodes()
	{
		return nodes;
	}
	

	public void reset()
	{
		nodes.clear();
		for (Node n: this.originalNodes) {
			nodes.add(n.copy());
		}
		
		edges.clear();
		for (HashMap.Entry<Point, Edge> entry : this.originalEdges.entrySet()) {
			Point key = entry.getKey();
			Edge value = entry.getValue();
			this.edges.put(key, value.copy());
		}
		
	}
	
	
	@Override
	public Iterator<Node> iterator() {
		return nodes.iterator();
	}


	
}
