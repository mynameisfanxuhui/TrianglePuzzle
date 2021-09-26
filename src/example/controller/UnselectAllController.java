package example.controller;

import example.boundary.PuzzleApp;
import example.entity.Model;

public class UnselectAllController {

	Model model;
	PuzzleApp app;
	
	public UnselectAllController(Model m, PuzzleApp app) {
		this.model = m;
		this.app = app;
	}
	
	public void unselectAll()
	{
		if (model.haveWinned())
		{
			app.showAlreadyWinBoard();
			return;
		}
		this.model.unselectAll();
		this.app.frame.repaint();
	}
}
