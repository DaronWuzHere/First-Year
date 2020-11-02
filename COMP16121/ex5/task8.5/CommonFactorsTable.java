//A program to create a common factors table
//No arguments
public class CommonFactorsTable
{
  //This is used to create the table itself in the main method
  public static void main(String args[])
  {
    //This is the top line
    printLine();
  
    //These are the column headings
    printColumnHeading();
  
    //This underlines the headings
    printLine();
  
    //This is how the rows are printed
    for (int row = 2; row <= 20; row++)
    {
      printRow(row);
    }//For
  
    //This prints the bottom line of the table
    printLine();
  }//That's all for main

  //Now this is to make the lines across the top of the table
  private static void printLine()
  {
     System.out.print("|-------|");
    
    //The line above the headings of the columns
    for (int column = 2; column <= 20; column++)
    {
      System.out.print("---");
    }//For 
   
    //This skips a line
    System.out.println("-|");

  }//PrintLine
  
  //This prints the column methods using a separate method
  private static void printColumnHeading()
  {
    //This is how the column headings are printed
    System.out.print("|       |");
    //Puts a number in each column
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
  }//PrintColumnHeadings

  //This prints the rows and GCD in a separate method aswell
  private static void printRow(int row)
  {  
    if (row >= 10)
    {
      System.out.print("|  ");
      System.out.print(row); 
      System.out.print("   |");
    } 
    else
    {
      System.out.print("|   ");
      System.out.print(row); 
      System.out.print("   |");
    }

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
    System.out.println(" |");
  }//PrintRow
  
}//Public class































