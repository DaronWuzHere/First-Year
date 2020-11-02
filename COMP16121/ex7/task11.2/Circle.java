//This is the class for the Circle
public class Circle
{
  //These are the variables
  private Point centre;
  private double radius;
 
  //This is the constructor method using this
  public Circle(Point centre, double radius)
  {
    this.centre = centre;
    this.radius = radius;
  }// Constructor method


  //This is where the displacement of the circle occurs
  public Circle shift(double x, double y)
  {
    return new Circle(centre.shift(new Point(x,y)),radius);
  }//Shift

  //This is where the perimeter or circumfrence is calculated 
  public double perimeter()
  {
    return (2 * Math.PI * radius);
  }//Perimeter

  //This is where the area is calculated
  public double area()
  {
    return Math.PI * Math.pow((radius), 2);
  }//Area

  //This is where the string gets output
  public String toString()
  {
    return "Circle (" + centre.getX() + ", " + centre.getY() + "), " + radius + ") ";
                     
  }//To String
}//Circle
