package example.entity;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Model {
	Puzzle puzzle;
	ArrayList<Integer> selectedNodes;
	int numMoves = 0;
	int basicScore = 60;
	int score = 60;
	public boolean isWinning = false;
	
	/**
	 * (0,0) (1,0) (2,0) (0,1) (1,1) (2,1) (0,2) (1,2) (0,3) (1,3) (0,4) (1,4)
	 * 
	 */
	public Model() {

	}

	public void setPuzzle(Puzzle p) {
		this.puzzle = p;
		this.numMoves = 0;
		this.selectedNodes = new ArrayList<Integer>();
	}
	
	public Puzzle getPuzzle() {
		return puzzle;
	}
	
	public int getMoves()
	{
		return this.numMoves;
	}
	
	public int getScore()
	{
		return this.score;
	}
	
	public boolean haveWinned()
	{
		return this.isWinning;
	}
	
	public void resetPuzzle()
	{
		this.puzzle.reset();
		this.numMoves = 0;
		this.selectedNodes = new ArrayList<Integer>();
		this.isWinning = false;
		this.basicScore = 60;
		this.score = 60;
	}
	
	// Since we can choose any number of nodes. We just cannot swap if the node
	// number is larger than 3. So we can always select/ unselect.
	public boolean canSelect(int selectIndex) {
//		if (this.selectedNodes.contains(selectIndex))
//		{
//			return true;
//		}
//		if (this.selectedNodes.size() < 3)
//		{
//			return true;
//		}
//		return false;
		return true;
	}
	
	public void changeAfterSelect(int selectIndex)
	{
		Node node = this.puzzle.getNodeByIndex(selectIndex);
		node.changeState();
		if (this.selectedNodes.contains(selectIndex))
		{
			
			this.selectedNodes.remove(Integer.valueOf(selectIndex));
		}
		else {
			this.selectedNodes.add(Integer.valueOf(selectIndex));
		}
	}
	
	public void unselectAll()
	{
		for (int nodeIndex: this.selectedNodes)
		{
			Node node = this.puzzle.getNodeByIndex(nodeIndex);
			node.changeState();
		}
		
		this.selectedNodes.clear();
	}
	

	public boolean swapEdge()
	{
		
		ArrayList<Edge> swappedEdges = new ArrayList<Edge>();
		if (this.selectedNodes.size() != 3)
		{
			return false;
		}
		HashMap<Point, Edge> edges = this.puzzle.getEdges();
		Collections.sort(this.selectedNodes);
		Point topleftEdgeIndex = new Point(this.selectedNodes.get(0), this.selectedNodes.get(1));
		Point toprightEdgeIndex = new Point(this.selectedNodes.get(0), this.selectedNodes.get(2));
		Point bottomEdgeIndex = new Point(this.selectedNodes.get(1), this.selectedNodes.get(2));
		
		if (edges.containsKey(topleftEdgeIndex)) swappedEdges.add(edges.get(topleftEdgeIndex));
		if (edges.containsKey(toprightEdgeIndex)) swappedEdges.add(edges.get(toprightEdgeIndex));
		if (edges.containsKey(bottomEdgeIndex)) swappedEdges.add(edges.get(bottomEdgeIndex));
		
		if (swappedEdges.size() < 2)
		{
			return false;
		}
		this.numMoves += 1;
		this.basicScore  -= 1;
		ArrayList<Integer> colorList = new ArrayList<Integer>();
		// if form a triangle, we need to determine whether it is the indexed six,
		// or the other three like 1, 2, 4. And change the color changed order to ensure
		// both rotate clockwise.
		int isRegularTriangle = 0;
		for (Edge e : swappedEdges)
		{
			colorList.add(e.color);
		}
		
		if (swappedEdges.size() == 3)
		{
			if (bottomEdgeIndex.y - bottomEdgeIndex.x == 1) isRegularTriangle = 1;
		}
		
		if (isRegularTriangle == 1)
		{
			
			for (int i = 1; i < swappedEdges.size(); ++i)
			{
				Edge e = swappedEdges.get(i);
				e.color = colorList.get(i - 1);
			}
			swappedEdges.get(0).color = colorList.get(colorList.size() - 1);
		}
		else
		{
			for (int i = 0; i < swappedEdges.size() - 1; ++i)
			{
				Edge e = swappedEdges.get(i);
				
				e.color = colorList.get(i + 1);
			}
			swappedEdges.get(colorList.size() - 1).color = colorList.get(0);
			
		}		
		this.score = this.basicScore + this.getBounsScore();
		return true;
	}
	
	public int getBounsScore()
	{
		int bouns = 0;
		for(ArrayList<Point> triangle: this.puzzle.triangles)
		{
			HashMap<Point, Edge> edges = this.puzzle.getEdges();
			
			if (edges.get(triangle.get(0)).color == edges.get(triangle.get(1)).color & 
					edges.get(triangle.get(1)).color == edges.get(triangle.get(2)).color)
			{
				bouns += 10;
			}
		}
		
		return bouns;
	}
	
	public void calculateWin()
	{
		HashMap<Point, Edge> edges = this.puzzle.getEdges();
		for(int i = 0; i < this.puzzle.triangles.size(); ++ i)
		{
			ArrayList<Point> triangle = this.puzzle.triangles.get(i);
			for (Point edgeIndex: triangle)
			{
				if (i == 0 || i == 4)
				{
					if (edges.get(edgeIndex).color != 1) return;
				}
				else if (i == 1|| i == 5)
				{
					if (edges.get(edgeIndex).color != 3) return;
				}
				else
				{
					if (edges.get(edgeIndex).color != 2) return;
				}
			}
		}
		this.isWinning = true;
	}
	
}
