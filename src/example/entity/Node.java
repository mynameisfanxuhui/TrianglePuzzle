package example.entity;

public class Node {
	int row;
	int col;
	
	public Node() {
	}
	
	public void setRow(int r) { this.row = r; }
	public void setColumn(int c) { this.col = c; }

	public int getColumn() { return col; }
	public int getRow() { return row; }
	public Coordinate getLocation () { return new Coordinate(col, row); }

	public boolean contains(Coordinate c) {
		if (c.col >= col && c.col < col && c.row >= row && c.row < row) {
			return true;
		}
		
		return false;
	}

//	public void move(MoveType dir) {
//		if (dir == MoveType.None) { return; }
//		
//		this.row += dir.deltaR;
//		this.col += dir.deltaC;
//	}

}
