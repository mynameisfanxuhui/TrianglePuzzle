package example;

import java.awt.event.WindowEvent;

import com.sun.jdi.event.EventQueue;

import example.boundary.PuzzleApp;
import example.entity.Model;
import example.entity.Puzzle;

public class Main {
	public static void main(String[] args) {
	Model m = new Model();
	Puzzle puzzle = new Puzzle(4, 5);
	m.setPuzzle(puzzle);
	puzzle.add(1, 1);
	PuzzleApp window = new PuzzleApp(m);
	window.frame.setVisible(true);

	}
}
