public class Variance
{
  public static void main(String[] args)
  {

    double number = Double.parseDouble(args[0]);

    double numberOne = Double.parseDouble(args[0]);

    double average;
 
    double deviance = 0;

    double variance = 0;

    for (int index = 1;index < args.length; index = index + 1)
    {

      number = (number + Double.parseDouble(args[index]));

    }
     
     average = (number / args.length);

   
    System.out.println("The mean average is " + average);

    for (int index = 0; index < args.length; index = index + 1)
    {
      
      deviance = (deviance + Math.pow((Double.parseDouble(args[index]) - average), 2));
      
    }  
    
    variance = (deviance / args.length);

    System.out.println("The variance is " + variance);
     
  }
}
