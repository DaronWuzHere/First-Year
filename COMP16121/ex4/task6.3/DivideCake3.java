//Program called DivideCake3 to divide cake using the GCD between three daughters.
public class DivideCake3
{
  public static void main(String args[])
  {
    //The first daughter's age
    int age1 = Integer.parseInt(args[0]);
   
    //The second daughter's age
    int age2 = Integer.parseInt(args[1]);
   
    //The thrid daughter's age
    int age3 = Integer.parseInt(args[2]);
    
    //These are multiples of the GCD
    int multiple1 = age1;
    int multiple2 = age2;
    int multiple3 = age3;

    //The GCD of the first two ages needs to be calculated
    while (multiple1 != multiple2)
    {
      if(multiple1 > multiple2)
      {
        multiple1 -= multiple2;
      }//If
      
      else
      {
        multiple2 -= multiple1;
      }//Else
    }//First While
   
    while (multiple1 != multiple3)
    {
      if(multiple1 > multiple3)
      {
        multiple1 -= multiple3;
      }//If
      else
      {
        multiple3 -= multiple1;
      }//Else
    }//Second While 
    
    //Now to determine how many portions each daughter gets
    int portions1 = (age1 / multiple1);
    int portions2 = (age2 / multiple2);
    int portions3 = (age3 / multiple3); 
  
    System.out.println("The " + age1 + " year old gets " + portions1 + ", the " 
                       + age2 + " year old gets " + portions2 + " and the " + age3 
                       + " year old gets " + portions3 + "." );
    


  }//Main
}//Public Class
        
