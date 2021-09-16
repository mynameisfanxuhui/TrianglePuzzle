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
		if (this.model.swapEdge())
		{
			app.getMoveLabel().setText("" + model.getMoves());
			app.getScoreLabel().setText("" + model.getScore());
			this.model.unselectAll();
		}
			
		if (this.model.isWin())
		{
			this.app.showWinBoard();
		}
		
		this.app.frame.repaint();
		
	}
}
