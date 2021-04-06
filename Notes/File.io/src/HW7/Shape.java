package HW7;

public class Shape {
	private double height = 0.0;
	private double length = 0.0;
	
	public Shape () {
		this.height = -1.0;
		this.length = -1.0;
	}
	public Shape (double aHeight, double aLength)
	{
		this.setHeight(aHeight);
		this.setLength(aLength);
	}
	public double getHeight() 
	{
		return this.height;
	}
	public double getLength()
	{
		return this.length;
	}
	public void setHeight(double aHeight)
	{
		if (aHeight>0.0)
			height = aHeight;
	}
	public void setLength(double aLength)
	{
		if (aLength>0.0)
			length = aLength;
	}
	public double getArea()
	{
		double aHeight = getHeight();
		double aLength = getLength();
		if (aHeight>0.0 && aLength>0.0)
			return aHeight*aLength;
		else if(aLength>0.0)//length being radius
			return (Math.PI*aLength*aLength);
		return 0.0;
	}
	public String toString()
	{
		return "Height: " + getHeight() + " Length: " + "Area: " + getArea();
	}
}
