package example.boundary;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.JPanel;

import example.entity.Edge;
import example.entity.Model;
import example.entity.Node;
import example.entity.Puzzle;
import java.awt.Point;

public class PuzzlePanel extends JPanel {
	Model model;
	public static final int boxSize = 10;
	
	public static final int topOffSet = 30;
	public static final int leftOffSet = 30;
	
	public PuzzlePanel(Model m) {
		this.model = m;
	}
	
	public Rectangle computePointRectangle (Node n) {
		Point coordinate = this.transferIndex2Coordinate(n);
		Rectangle rect = new Rectangle(coordinate.x, coordinate.y, boxSize, boxSize);
		return rect;
	}
	
	public Point transferIndex2Coordinate(Node n) {
		// the y postion can be directly get by row number
		// the x postion can be get by using the offset from mid line.
		// currentLine's total point number equals row number.
		// the bottom line's point number equals to col or row number
		int col = n.getColumn();
		int row = n.getRow();
		int x = 0;
		int y = 0;
		int mid = this.getWidth() / 2;
		int perFloorHeight = (this.getHeight() - 2 * topOffSet) / this.model.getPuzzle().getRow();
		int perRowLength = (this.getWidth() - 2 * leftOffSet) / this.model.getPuzzle().getRow();
		y = perFloorHeight * (row - 1) + topOffSet;
		if (row % 2 == 0)
		{
			int currentOffSet = 0;
			currentOffSet = perRowLength * (col - (row / 2)) - perRowLength / 2;
			x = mid + currentOffSet;
		}
		else
		{
			int currentOffSet = 0;
			currentOffSet = perRowLength * (col - 1 - (row / 2));
			x = mid + currentOffSet;
		}
		Point coordinate = new Point(x, y);
		return coordinate;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		if (model == null) { return; } // nothing to draw. Only here for windowbuilder.
		Puzzle puzzle = model.getPuzzle();
		for (Node p : puzzle) {	
			if (p.isSelected())
			{
				g.setColor(Color.black);
			}
			else
			{
				g.setColor(Color.white);
			}
					
			Rectangle r = computePointRectangle(p);
			g.fillRect(r.x, r.y, r.width, r.height);
		}
		
		for (Edge e: puzzle.getEdges())
		{	
			int startNodeIndex = e.getStart();
			int endNodeIndex = e.getEnd();
			Point startCoordinate = this.transferIndex2Coordinate(puzzle.getNodeByIndex(startNodeIndex));
			Point endCoordinate = this.transferIndex2Coordinate(puzzle.getNodeByIndex(endNodeIndex));
			int colorNum = e.getColor();
			if (colorNum == 1) g.setColor(Color.red);
			else if (colorNum == 2) g.setColor(Color.green);
			else if (colorNum == 3) g.setColor(Color.blue);
			g.drawLine(startCoordinate.x + boxSize / 2, startCoordinate.y + boxSize / 2, endCoordinate.x + boxSize / 2, endCoordinate.y + boxSize / 2);
		}
		
	}
}
