//The class where the triangle is created
public class Triangle
{
  //These are the variables and points of the triangle
  private Point point1;
  private Point point2;
  private Point point3;
 
  //This is the constructor method
  public Triangle(Point point1, Point point2, Point point3)
  {
    this.point1 = point1;
    this.point2 = point2;
    this.point3 = point3;
  }//Triangle
  
  //This is where the displacement is calculated for the triangle
  public Triangle shift(double x, double y)
  {
    return new Triangle(point1.shift(new Point(x,y)),
                        point2.shift(new Point(x,y)),
                        point3.shift(new Point(x,y)));
  }//Shift
  

  //This is where the distance between the point are calculated,
  //inorder to obtain side lenght
  private double distanceBetween(Point point1, Point point2)
  {
    return Math.sqrt((point1.getX() - point2.getX()) *
                     (point1.getX() - point2.getX()) +
                     (point1.getY() - point2.getY()) *
                     (point1.getY() - point2.getY()));
  }//Distance Between

  //This is how the perimeter is calculated
  public double perimeter() 
  {
    return distanceBetween(point1, point2) + 
           distanceBetween(point2, point3) +
           distanceBetween(point3, point1);
  }//Perimeter
  
  //This is where the area is calculated
  public double area()
  {
     //These are the sides of the triangle
    double sideA = distanceBetween(point1, point2);
    double sideB = distanceBetween(point2, point3);
    double sideC = distanceBetween(point3, point1);

    //This is the semi perimeter
    double semiPerim = ((sideA + sideB + sideC) / 2);
      
    //This returns the area using Hero's Formula
    return (Math.sqrt((semiPerim * (semiPerim - sideA) 
                                 * (semiPerim - sideB)
                                 * (semiPerim - sideC))));
  }//Area


  //This is where the string is output into the main class
  public String toString()
  {
    return "Triangle (" + point1.getX() + ", " + point1.getY() + ") " + 
                    "(" + point2.getX() + ", " + point2.getY() + ") " +
                    "(" + point3.getX() + ", " + point3.getY() + ") ";
  }//To String
}//Triangle





















