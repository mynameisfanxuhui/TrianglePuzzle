package example.controller;

import example.boundary.PuzzleApp;
import example.entity.Model;

public class SwapController {

	Model model;
	PuzzleApp app;
	
	public SwapController(Model m, PuzzleApp app) {
		this.model = m;
		this.app = app;
	}
	
	public void swapEdge()
	{
		this.model.swapEdge();
		this.model.unselectAll();
		this.app.frame.repaint();
		
	}
}
