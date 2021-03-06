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

	public void changeState()
	{
		this.isSelected = !this.isSelected;
	}
	
	public Node copy()
	{
		Node n = new Node();
		n.setColumn(this.col);
		n.setRow(this.row);
		return n;
	}

}
