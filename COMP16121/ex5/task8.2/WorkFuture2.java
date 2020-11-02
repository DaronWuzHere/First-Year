//Program that shows how many more years two people have to work
//Arguments = present year, first person's birth year and second person's birth year
public class WorkFuture2
{
  public static void main(String[] args)
  {
    //Current year
    int year1 = Integer.parseInt(args[0]);
    int year2 = year1;
    
    //The birth year of the first individual, cannot be the current
    //year
    int birthYear1 = Integer.parseInt(args[1]);
  
    //The birth year of the second individual, same rules apply
    int birthYear2 = Integer.parseInt(args[2]);

    //Age this person will retire, which is 68
    int retireAge = 68;

    //Used to calculate how many years they have left to work in 
    //current year
    int yearsLeft1 = retireAge - (year1 - birthYear1);
    int yearsLeft2 = retireAge - (year2 - birthYear2);

    //Inorder to keep track of the years
    int retireYear1 = year1 + yearsLeft1;
    int retireYear2 = year2 + yearsLeft2;



    //The first person
    if (birthYear1 > year1)
    {
      System.out.println("Invalid Birth Year");
    }//If
    else
    {
      System.out.println("Currently, the first person has " + yearsLeft1 + 
                       " years left to work.");

      //Initiating countdown
      while (year1 != retireYear1)
      {  
        year1++;
        yearsLeft1 = yearsLeft1 - 1;   
        System.out.println("In " + year1 + " you will have " 
                         + yearsLeft1  + " years left to" 
                         + " work.");
      }//While

      //Year the year they will retire
      System.out.println("You will retire in the year " + retireYear1);

    }//Else
    
    //To space out the two lists
    System.out.println();
    System.out.println("---------------------------------------------------------");
    System.out.println();

    //The second person
    if (birthYear2 > year2)
    {
      System.out.println("Invalid Birth Year");
    }//If
    else
    {
      System.out.println("Currently, the second person has " + yearsLeft2 + 
                       " years left to work.");

      //Initiating countdown
    
    
      while (year2 != retireYear2)
      {  
        year2++;
        yearsLeft2 = yearsLeft2 - 1;   
        System.out.println("In " + year2 + " you will have " 
                         + yearsLeft2  + " years left to" 
                         + " work.");
      }//While
    

    //Year the year they will retire
    System.out.println("You will retire in the year " + retireYear2);
    
    }//Else
  }//Main
}//Public CLass





    

