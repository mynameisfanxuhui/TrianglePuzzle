package example.boundary;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JPanel;

import example.entity.Model;
import example.entity.Point;
import example.entity.Puzzle;

public class PuzzlePanel extends JPanel {
	Model model;
	public static final int boxSize = 2;
	
	public static final int offset = 2;
	
	public PuzzlePanel(Model m) {
		this.model = m;
	}
	
	public Rectangle computePointRectangle (Point p) {
		int col = p.getColumn();
		int row = p.getRow();
		// the y postion can be directly get by row number
		int y = row * 40;
		// the x postion can be get by using the offset from mid line.
		// currentLine's total point number equals row number.
		int mid = this.getWidth() / 2;
		int linePointNum = row;
		int x = 0;
		Rectangle rect = new Rectangle(x, y, boxSize, boxSize);
		return rect;
	}
//	
//	public Coordinate pointToCoordinate(Point p) {
//		return new Coordinate(p.x/boxSize, p.y/boxSize);
//	}
//	
//	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		if (model == null) { return; } // nothing to draw. Only here for windowbuilder.
		Puzzle puzzle = model.getPuzzle();
		for (Point p : puzzle) {	
			g.setColor(Color.red);		
			Rectangle r = computePointRectangle(p);
			g.fillRect(r.x, r.y, r.width, r.height);
		}	
	}
}
