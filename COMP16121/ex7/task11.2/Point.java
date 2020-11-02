//This is where the point is basically processed for the other classes to use
public class Point
{
  //These are the points that will be used in the other class
  public double x, y;
  public Point(double x, double y)
  {
    this.x = x;
    this.y = y;
  }//Points X and Y


  //These two methods allow X and Y to be accesible
  public double getX()
  {
    return x;
  }// Get X
  
  public double getY()
  {
    return y;
  }//Get Y

  //This method is used to shift the point
  public Point shift(Point shift)
  {
    return new Point(x + shift.x, y + shift.y);
  }//Shift Point
}//Point
