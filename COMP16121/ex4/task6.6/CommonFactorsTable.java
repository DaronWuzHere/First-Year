//Program that displays the common factors of integers from 2 to 20
public class CommonFactorsTable
{
  public static void main(String args[])
  {
    //Top of the table to the left
    System.out.print("|-------|");
    
    //The line above the headings of the columns
    for (int column = 2; column <= 20; column++)
    {
      System.out.print("---");
    }//For 
   
    //the right side of the table
    System.out.println("-|");
    
    //This is the how to column headings are output
    System.out.print("|       |");
    
    for (int column = 2; column <= 20; column++)
    {
      if (column < 10)
      {
        System.out.print("  " + column);
      }//If
      if (column >= 10)
      {
        System.out.print(" " + column);
      }//If
    }//For
    
    System.out.println(" |");
    //Now to underline the heading
    System.out.print("|-------|");
    for (int column = 2; column <= 20 ; column++)
    {
      System.out.print("---");
    }//For
    System.out.println("-|");


    //The columns are complete, it's time to make the rows
    for (int row = 2; row <= 20; row++)
    {
      //The rows are modified accordingly when a number is two digits or one digit
      if(row < 10)
      {
        System.out.print("|   " + row + "   |");
      }//If
      else 
      {
        System.out.print("|  " + row + "   |");
      }//Else
   
      //Now the columns the have to be made
      for (int column = 2; column <= 20; column++)
      { 
        //Now the greatest common divisor has to be found for two numbers
        int columnGCD = column;
        int rowGCD = row;
        while (columnGCD != rowGCD)
        {
          if (columnGCD > rowGCD)
          {
            columnGCD-=rowGCD;
          }//If
          else
          {
            rowGCD-=columnGCD;
          }//Else
        }//While
          //Now we must  to determine whether the GCD is equal to or greater than 1
          if (rowGCD > 1)
          {
            System.out.print("--#");
          }//If
          else
          {
            System.out.print("--|");
          }//Else
       }//For
    
      //To close of the column
      System.out.println(" |");
    }//For
    
    //The bottom of the table
    System.out.print("|-------|");
    for (int column = 2; column <= 20; column++)
    {
      System.out.print("---");
    }
    System.out.println("-|");
  }//Main
}//Public Class
        


















         
    

































      
      
     
    
