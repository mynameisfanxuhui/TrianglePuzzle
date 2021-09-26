package example;

import java.awt.event.WindowEvent;

import com.sun.jdi.event.EventQueue;

import example.boundary.PuzzleApp;
import example.entity.Model;
import example.entity.Puzzle;

public class Main {
	public static void main(String[] args) {
	Model m = new Model();
	Puzzle puzzle = new Puzzle(4, 4);
	m.setPuzzle(puzzle);
	// need to remain order. Since the edge use the node's postion to get node
	puzzle.add(1, 1);
	puzzle.add(2, 1);
	puzzle.add(2, 2);
	puzzle.add(3, 1);
	puzzle.add(3, 2);
	puzzle.add(3, 3);
	puzzle.add(4, 1);
	puzzle.add(4, 2);
	puzzle.add(4, 3);
	puzzle.add(4, 4);
	
	// red is 1, green is 2, blue is 3
	puzzle.addEdge(0, 1, 1);
	puzzle.addEdge(0, 2, 1);
	puzzle.addEdge(1, 3, 1);
	puzzle.addEdge(3, 6, 1);
	puzzle.addEdge(2, 5, 1);
	puzzle.addEdge(5, 9, 1);
	
	puzzle.addEdge(1, 2, 2);
	puzzle.addEdge(3, 4, 2);
	puzzle.addEdge(4, 5, 2);
	puzzle.addEdge(6, 7, 2);
	puzzle.addEdge(7, 8, 2);
	puzzle.addEdge(8, 9, 2);
	
	puzzle.addEdge(1, 4, 3);
	puzzle.addEdge(2, 4, 3);
	puzzle.addEdge(4, 7, 3);
	puzzle.addEdge(4, 8, 3);
	puzzle.addEdge(3, 7, 3);
	puzzle.addEdge(5, 8, 3);
	
	
	
	PuzzleApp window = new PuzzleApp(m);
	window.frame.setVisible(true);

	}
}
