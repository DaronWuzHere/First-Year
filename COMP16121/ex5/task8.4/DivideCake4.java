//Program used to divide a cake amoung four daughters
//Arguments are the ages of four girls
public class DivideCake4
{
  //This is used to get the GCD inorder to divide the cake into portions
  private static int getGCD(int multiple1GCD, int multiple2GCD,
                            int multiple3GCD, int multiple4GCD)
  {
    //These four while loops are used to calculate the GCD of the four ages
    while (multiple1GCD != multiple2GCD)
    {
      //If statement to determine which multiple is larger
      if (multiple1GCD > multiple2GCD)
      {
        multiple1GCD-=multiple2GCD;
      }//If
      else 
      {
        multiple2GCD-=multiple1GCD;
      }//Else
    }//While
    
    while (multiple3GCD != multiple4GCD)
    {
      //If statement to determine which multiple is larger
      if (multiple3GCD > multiple4GCD)
      {
        multiple3GCD-=multiple4GCD;
      }//If
      else 
      {
        multiple4GCD-=multiple3GCD;
      }//Else      
    }//While
 
     while (multiple1GCD != multiple3GCD)
    {
      //If statement to determine which multiple is larger
      if (multiple1GCD > multiple3GCD)
      {
        multiple1GCD-=multiple3GCD;
      }//If
      else 
      {
        multiple3GCD-=multiple1GCD;
      }//Else      
    }//While
    
    return multiple1GCD;
  }//Private
  
  //Now this code is what retrieves the ages of the 
  //girls and computes the portions of the cake
  public static void main(String args[])
  {
    //This is how the ages of the four girls are retrieved
    int age1 = Integer.parseInt(args[0]);
    int age2 = Integer.parseInt(args[1]);
    int age3 = Integer.parseInt(args[2]);
    int age4 = Integer.parseInt(args[3]);

    //This is how the GCD gets processed using the private 
    //method
    int ageGCD = getGCD(age1, age2, age3, age4);
  
    //This outputs the results from the line of code above
    System.out.println("The GCD of " + age1 + ", " + age2 +  ", " 
                       + age3 +  ", " + age4 + " is " + ageGCD + ".");
    
    //This is how we can determine how many portions each girl
    //gets based on their age
    int portions1 = (age1 / ageGCD);
    int portions2 = (age2 / ageGCD);
    int portions3 = (age3 / ageGCD);
    int portions4 = (age4 / ageGCD);
   

    //Now the final output
    System.out.println("The cake should be divided into " + (portions1 + portions2 
                        + portions3 + portions4) + " portions.");
    System.out.println("The " + age1 + " year old gets " + portions1
                       + " portions, the " + age2 + " year old gets "
                       + portions2 + " portions, the " + age3 
                       + " year old gets " + portions3 + " portions and"
                       + " the " + age4 + " year old gets " + portions4
                       + " portions."); 
  }//Main
}//Public  

    






                         











 
                                      
                                                               
                                                                                     

                                                                               
                                                                                  
                                                                                
