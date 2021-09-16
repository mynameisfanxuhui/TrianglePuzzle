package example.controller;

import java.awt.Point;
import java.util.ArrayList;

import example.boundary.PuzzleApp;
import example.boundary.PuzzlePanel;
import example.entity.Model;
import example.entity.Node;
import example.entity.Puzzle;

public class ClickNodeController {

	
	Model model;
	PuzzleApp app;
	
	public ClickNodeController(Model m, PuzzleApp app) {
		this.model = m;
		this.app = app;
	}

	public void process(Point point) {
		PuzzlePanel puzzlePanel = app.getPuzzlePanel();
		Puzzle puzzle = model.getPuzzle();
		ArrayList<Node> nodes = puzzle.getNodes();
		for (int i = 0; i < nodes.size(); ++ i)
		{
			Node node = nodes.get(i);
			if (!this.contain(node, point, puzzlePanel))
			{
				continue;
			}
			
			if (model.canSelect(i))
			{
				model.changeAfterSelect(i);
			}
			
			app.frame.repaint();
			
		}
	}
	
	public boolean contain(Node n, Point point, PuzzlePanel puzzlePanel)
	{
		
		Point upperLeftCorner = puzzlePanel.transferIndex2Coordinate(n);
		if (point.x >= upperLeftCorner.x & point.x <= upperLeftCorner.x + puzzlePanel.boxSize
				& point.y >= upperLeftCorner.y & point.y <= upperLeftCorner.y + puzzlePanel.boxSize)
		{
			return true;
		}
		return false;
	}
}
