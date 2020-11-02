public class WorkFuture
{
  public static void main(String[] args)
  {
    //Current year
    int year = Integer.parseInt(args[0]);
    
    //The birth year of the individual, cannot be the current
    //year
    int birthYear = Integer.parseInt(args[1]);

    //Age this person will retire, which is 68
    int retireAge = 68;

    //Used to calculate how many years they have left to work in 
    //current year
    int yearsLeft = retireAge - (year - birthYear);

    //Inorder to keep track of the years
    int retireYear = year + yearsLeft;
    

    if (birthYear > year)
    {
      System.out.println("Invalid Birth Year");
    }
    else
    {
    
    
      System.out.println("Currently, you have " + yearsLeft + 
                       " years left to work.");

      //Initiating countdown
    
    
      while (year != retireYear)
      {  
        year = year + 1;
        yearsLeft = yearsLeft - 1;   
        System.out.println("In " + year + " you will have " 
                         + yearsLeft  + " years left to" 
                         + " work.");
      }

    //Year the year they will retire
    System.out.println("You will retire in the year " + retireYear);
    }  
  }
}





    

