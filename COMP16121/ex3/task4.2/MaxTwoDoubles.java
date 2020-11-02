public class MaxTwoDoubles
{
  public static void main(String[] args)
  {
    double num1 = Double.parseDouble(args[0]); 
    double num2 = Double.parseDouble(args[1]);
    // Declares both inputs as double values
    
    if (num1 > num2)
      System.out.println("Out of the two numbers," + num1 + " and "
                         + num2 + "," + num1 + " is greater.");
    else
      System.out.println("Out of the two numbers," + num1 + " and "
                         + num2 + "," + num2 + " is greater.");
   }
}
    
