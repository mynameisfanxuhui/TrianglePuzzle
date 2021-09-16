package example.entity;

import java.util.ArrayList;
import java.util.Iterator;

public class Puzzle implements Iterable<Point> {
	ArrayList<Point> points = new ArrayList<>();
	public final int numRows;
	public final int numColumns;
	
	public Puzzle(int numColumns, int numRows) {
		this.numColumns = numColumns;
		this.numRows = numRows;
	}
	
	public void add(int col, int row) {
		Point p = new Point();
		p.setColumn(col);
		p.setRow(row);
		
		// check overlapping....
		
		points.add(p);
	}
	
	public boolean isCovered(Coordinate coord) {
		for (Point p : points) {
			if (p.contains(coord)) {
				return true;
			}
		}
		
		return false;
	}

	@Override
	public Iterator<Point> iterator() {
		return points.iterator();
	}


	
}
