package example.controller;

import example.boundary.PuzzleApp;
import example.entity.Model;

public class ResetController {

	Model model;
	PuzzleApp app;
	
	public ResetController(Model m, PuzzleApp app) {
		this.model = m;
		this.app = app;
	}
	
	public void reset() {
		this.model.resetPuzzle();	
		app.getMoveLabel().setText("" + model.getMoves());
		app.getScoreLabel().setText("" + model.getScore());
		this.app.frame.repaint();
	}
	
}
