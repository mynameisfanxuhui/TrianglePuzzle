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
	
}
