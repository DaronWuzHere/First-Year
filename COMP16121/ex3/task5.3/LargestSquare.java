public class LargestSquare
{
  public static void main(String[] args)
  {
    int firstNumber = Integer.parseInt(args[0]);
    int largestSquare = firstNumber;
    
    while (Math.pow(largestSquare, 2)> firstNumber)
    {
      largestSquare = largestSquare - 1;
    }
    
    System.out.println(largestSquare);
  }
}  
