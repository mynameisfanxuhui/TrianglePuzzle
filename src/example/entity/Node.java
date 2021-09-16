package example.entity;

public class Node {
	int row;
	int col;
	boolean isSelected;
	
	public Node() {
		this.isSelected = false;
	}
	
	public void setRow(int r) { this.row = r; }
	public void setColumn(int c) { this.col = c; }

	public int getColumn() { return this.col; }
	public int getRow() { return this.row; }
	public boolean isSelected() 
	{
		return this.isSelected;
	}
	public Coordinate getLocation () { return new Coordinate(col, row); }

	public boolean contains(Coordinate c) {
		if (c.col >= col && c.col < col && c.row >= row && c.row < row) {
			return true;
		}
		
		return false;
	}

	public void changeState()
	{
		this.isSelected = !this.isSelected;
	}

}
