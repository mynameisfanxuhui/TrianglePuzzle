package example.entity;

public class Edge {
	int startPoint;
	int endPoint;
	int color;

	Edge(int color)
	{
		this.color = color;
	}
	void setStart(int startPoint)
	{
		this.startPoint = startPoint;
	}
	void setEnd(int endPoint)
	{
		this.endPoint = endPoint;
	}
	public int getStart()
	{
		return this.startPoint;
	}
	public int getEnd()
	{
		return this.endPoint;
	}
	public int getColor()
	{
		return this.color;
	}
}

