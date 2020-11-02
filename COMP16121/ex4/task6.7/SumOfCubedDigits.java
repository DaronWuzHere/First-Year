//Program to determine which cubed three digits have an added total larger than the 
//thre digit number they make
public class SumOfCubedDigits
{
  public static void main(String args[])
  { 
    //Loop tofind the first digit
    for(double specialNum1 = 1; specialNum1 < 10; specialNum1++)
    {
      //Loop to find the second digit
      for(double specialNum2 = 0; specialNum2 < 10; specialNum2++)
      {
        for (double specialNum3 = 0; specialNum3 <10; specialNum3++)
        {
          //The number the three digits make when put together
          double specialNumber = (specialNum1 * 100 + specialNum2 * 10 + specialNum3);
          
          //The sum of the cubes
          double total = (Math.pow(specialNum1, 3) + Math.pow(specialNum2, 3)
                          + Math.pow(specialNum3, 3));
          
          //Output if the sum is greater or equal than the three digits
          if (total == specialNumber)
          {
            System.out.println("The sum of the cubed digits of the number " + specialNumber);
            System.out.println("is equal to it.");  
          }//If
        }//For
      }//For
    }//For
  }//Main
}//Public Class
