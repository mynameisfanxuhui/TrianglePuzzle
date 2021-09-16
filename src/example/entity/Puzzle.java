package example.entity;

import java.util.ArrayList;
import java.util.Iterator;

public class Puzzle implements Iterable<Node> {
	ArrayList<Node> nodes = new ArrayList<>();
	ArrayList<Edge> edges = new ArrayList<>();
	public final int numRows;
	public final int numColumns;
	
	public Puzzle(int numColumns, int numRows) {
		this.numColumns = numColumns;
		this.numRows = numRows;
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
	}
	
	public void addEdge(int startPoint, int endPoint, int color)
	{
		Edge e = new Edge(color);
		e.setStart(startPoint);
		e.setEnd(endPoint);
		edges.add(e);
	}
	
	
	
	public ArrayList<Edge> getEdges()
	{
		return edges;
	}
	
	public boolean isCovered(Coordinate coord) {
		for (Node p : nodes) {
			if (p.contains(coord)) {
				return true;
			}
		}
		
		return false;
	}

	@Override
	public Iterator<Node> iterator() {
		return nodes.iterator();
	}


	
}
