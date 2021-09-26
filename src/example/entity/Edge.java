package example.entity;

public class Edge {
	int color;

	Edge(int color)
	{
		this.color = color;
	}

	public int getColor()
	{
		return this.color;
	}
	
	public Edge copy()
	{
		Edge e = new Edge(this.color);
		return e;
	}
}

