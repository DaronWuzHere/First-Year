public class MinimumBitWidth
{ 
  public static void main(String[] args)
  {
    int number = Integer.parseInt(args[0]);
    int noOfBits = 1;
     
    while (noOfBits < (Math.pow(2, number)))
    {
      noOfBits = (noOfBits * 2);
    }
    
    System.out.println("You need " + noOfBits + " bits to represent "
                       + number);
  }
}
