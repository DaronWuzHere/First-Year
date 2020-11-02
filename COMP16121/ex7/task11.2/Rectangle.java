//This is the class that calculates a rectangle
public class Rectangle
{
  //These are the variables
  private Point point1;
  private Point point2;

  //This is the constructor method using this
  public Rectangle(Point point1, Point point2)
  {
    this.point1 = point1;
    this.point2 = point2;
  }//Rectangle

  //This is where the calculation of the displacement occurs
  public Rectangle shift(double x, double y)
  {
    return new Rectangle(point1.shift(new Point(x,y)),
                         point2.shift(new Point(x,y)));
  }//Shift


  //This is where the perimeter is calculated 
  public double perimeter()
  {
    return 2 * (Math.abs(point1.getX() - point2.getX())) +
           2 * (Math.abs(point1.getY() - point2.getY()));
  }//Perimeter

  //This is how the area is calculated
  public double area()
  {
     return (Math.abs(point1.getX() - point2.getX()) *
             Math.abs(point1.getY() - point2.getY()));
  
    
  }//Area
  
  //This is where the string is output
  public String toString()
  {
    return "Rectangle (" + point1.getX() + ", " + point1.getY() + ") " +
                     "(" + point1.getX() + ", " + point1.getY() + ") " +
                     "(" + point2.getX() + ", " + point2.getY() + ") " +
                     "(" + point2.getX() + ", " + point2.getY() + ") ";
  }//To String
}//Rectangle


                         
