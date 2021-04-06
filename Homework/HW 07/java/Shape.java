public class Shape implements Comparable<Shape>{
  //christopher walls
  private String name = null;
  private double side1 = 0.0;
  private double side2 = 0.0;
  private double radius = 0.0;
  private double area = 0.0;
  
  public Shape () {
    this.name = "Not set!";
    this.side1 = -1.0;
    this.side2 = -1.0;
    this.radius = -1.0;
    this.area = -1.0;
    
  }
  public Shape (String aName, double side1, double side2)//right triangle or rectangle
  {
    this.setName(aName);
    this.setSide1(side1);
    this.setSide2(side2);
    this.setArea(aName,side1,side2);
  }
  public Shape (String aName, double aRadius)
  {
    this.setName(aName);//has to be a circle
    this.setRadius(aRadius);
    this.setArea(aRadius);
    
  }
  public String getName()
  {
    return this.name;
  }
  public double getSide1() 
  {
    return this.side1;
  }
  public double getSide2()
  {
    return this.side2;
  }
  public double getRadius()
  {
    return this.radius;
  }
  public double getArea()
  {
    return this.area;
  }
  public void setName(String aName) 
  {
    if(aName.equals("Right Triangle") || aName.equals("Circle") || aName.equals("Rectangle"))
      name = aName;
    else
      name = "Invalid Shape Type";
  }
  public void setSide1(double aSide1)
  {
    if (aSide1>0.0)
      side1 = aSide1;
  }
  public void setSide2(double aSide2)
  {
    if (aSide2>0.0)
      side2 = aSide2;
  }
  public void setRadius(double aRadius)
  {
    if(aRadius>0.0)
      radius = aRadius;
  }
  public void setArea(String aName, double aSide1, double aSide2)
  {
    if (aName.equals("Rectangle") && aSide1>0.0 && aSide2>0.0)
      area = aSide1*aSide2;
    if (aName.equals("Right Triangle") && aSide1>0.0 && aSide2>0.0)
      area = (aSide1*aSide2)/2;
   
  }
  public void setArea(double aRadius)
  {
    if(aRadius>0.0)
      area = (Math.PI*aRadius*aRadius);
  }
  public String toString()
  {
    if(getRadius()<=0.0)
      return getName() + " Side 1: " + getSide1() + " Side 2: " + getSide2() + " Area: " + getArea();//not circle
    return getName() + " Radius: " + getRadius() + " Area: " + getArea();//circle
  }
    public int compareTo(Shape aShape)
  {
    if(this.area < aShape.getArea())
      return -1;
    else if(this.area > aShape.getArea())
      return 1;
    else
      return 0;
  }
}
