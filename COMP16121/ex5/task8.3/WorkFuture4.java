//A program used to show how long 4 people have left to work
//Arguments are the present year and four birth years
public class WorkFuture4
{


  //The private method used to calculate the retirement years and ages of a person
  private static void printWorkFuture(int year, int personNumber, int birthYear)
  {
    //The preset retirement age
    int retireAge = 68;
   
    //The year the person will retire
    int retireYear = (birthYear + retireAge);

    //The initial amout of years left before it goes thorugh the while loop
    int yearsLeft = (retireYear - year);
   
    //This is to ensure the correct birth date has been entered
    if (birthYear > year)
    {
      System.out.println("Invalid Birth Year");
    }//If
   
    else
    {
      //This displays how long the person has left to work
      System.out.println("Person number " + personNumber + " has " + yearsLeft + " years left"
                       + " to work.");
       
      //This is how we output the years the peron has left
      while (year != retireYear)
      { 
        //This makes the year increase and the years left decrease in the output
        year++;
        yearsLeft = yearsLeft - 1;

        System.out.println("In the year " + year + " person number " + personNumber
                           + " will have " + yearsLeft + " to work!");
      }//While
      
      //Outputs the year the person will retire
      System.out.println("Person number " + personNumber + " will retire in the year "
                         + retireYear);

      //This separates the lists
      System.out.println();
      System.out.println("---------------------------------------------------------");  
      System.out.println();  

    }//Else
  }//Private
  
  //This is the main program where the input is processed
  public static void main(String args[])
  {
    //This is the present year
    int year = Integer.parseInt(args[0]);
    
    //These are the four birth years of the four people
    int birthYear1 = Integer.parseInt(args[1]);
    int birthYear2 = Integer.parseInt(args[2]);
    int birthYear3 = Integer.parseInt(args[3]);
    int birthYear4 = Integer.parseInt(args[4]);  
 
    //This outputs the string we made in the private method
    printWorkFuture(year, 1, birthYear1);
    printWorkFuture(year, 2, birthYear2);
    printWorkFuture(year, 3, birthYear3);
    printWorkFuture(year, 4, birthYear4);
  }//Main
}//Public             
       
      
   














    
