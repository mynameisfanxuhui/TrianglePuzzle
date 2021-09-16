package example.entity;

import java.util.ArrayList;

public class Model {
	Puzzle puzzle;
	boolean gameOver;
	ArrayList<Integer> selectedNodes;
	int numMoves = 0;
	int score = 60;
	
	/**
	 * (0,0) (1,0) (2,0) (0,1) (1,1) (2,1) (0,2) (1,2) (0,3) (1,3) (0,4) (1,4)
	 * 
	 */
	public Model() {

	}

	public void setPuzzle(Puzzle p) {
		this.puzzle = p;
		this.numMoves = 0;
		this.gameOver = false;
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
	
	public boolean canSelect(int selectIndex) {
		if (this.selectedNodes.contains(selectIndex))
		{
			return true;
		}
		if (this.selectedNodes.size() < 3)
		{
			return true;
		}
		return false;
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
	
	
	public ArrayList<Edge> getSwappedEdge()
	{
		if (this.selectedNodes.size() < 3)
		{
			return null;
		}
		for (int mutualNode: this.selectedNodes)
		{
			ArrayList<Edge> neededEdges = new ArrayList<Edge>();
			for (Edge edge : puzzle.edges)
			{
				if (mutualNode == edge.startPoint)
				{
					if (this.selectedNodes.contains(edge.endPoint))
					{
						neededEdges.add(edge);
					}
				}
				
				else if (mutualNode == edge.endPoint)
				{
					if (this.selectedNodes.contains(edge.startPoint))
					{
						neededEdges.add(edge);
					}
				}
				
			}
			if (neededEdges.size() == 2)
			{
				return neededEdges;
			}
		}
		return null;	
	}
	
	public void swapEdge()
	{
		ArrayList<Edge> swappedEdge = this.getSwappedEdge();
		if (swappedEdge != null)
		{
			Edge firstEdge = swappedEdge.get(0);
			Edge secondEdge = swappedEdge.get(1);
			int tempStart = firstEdge.startPoint;
			int tempEnd = firstEdge.endPoint;
			firstEdge.startPoint = secondEdge.startPoint;
			firstEdge.endPoint = secondEdge.endPoint;
			secondEdge.startPoint = tempStart;
			secondEdge.endPoint = tempEnd;
		}
	}
	
}
