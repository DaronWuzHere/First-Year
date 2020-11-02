public class FahrenheitToCelsius
{  
  public static void main(String[] args)
  {
    double TempF = Double.parseDouble(args[0]);
    double TempC = (TempF - 32) * 5 / 9;
  
    System.out.println("The Temperature " + TempF + " Fahrenheit in Celsius is " + TempC);
  }
}
 
    
