public class MinimumTankSize
{ 
  public static void main(String[] args)
  {
    double volumeTank = Double.parseDouble(args[0]);
    double side = 0.1;
    
    while((side * side * side) < volumeTank)
    {
      side = side + 0.1;
    }
    
    System.out.println("Your tank will need sides of " 
                       + side + " metre(s) inorder to " 
                       + " hold " + volumeTank 
                       + " litres");
   }
}
