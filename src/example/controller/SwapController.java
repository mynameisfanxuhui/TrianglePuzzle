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
		if (model.haveWinned())
		{
			app.showAlreadyWinBoard();
			return;
		}
		if (this.model.swapEdge())
		{
			app.getMoveLabel().setText("" + model.getMoves());
			app.getScoreLabel().setText("" + model.getScore());
			this.model.unselectAll();
		}
		
		this.app.frame.repaint();
		this.model.calculateWin();
		if (this.model.haveWinned())
		{
			this.app.showWinBoard();
		}
		
	}
}
