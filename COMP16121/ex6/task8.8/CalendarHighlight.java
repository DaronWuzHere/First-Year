//A program to display a calendar with the date highlighted
//Three arguments needed, month, first day and the date you want
//highlighted
public class CalendarHighlight
{
  public static void main(String args[])
  {
    printTheMonth(Integer.parseInt(args[0]), Integer.parseInt(args[1]), 
                  Integer.parseInt(args[2]));
    
  }//Main

  private static void printTheMonth(int startOfMonth, int endOfMonth, int specialDay)
  {
    int nextDay = startOfMonth;
    int theSpecialDay = specialDay;
    printStraightLine();
    printNamesOfDay();
    
    int nextDayToPrint = 1;
   
    int noOfRows = 0;
  
    while (nextDayToPrint <= endOfMonth || noOfRows < 6)
    {
      System.out.print("|");
      
      for (int columnDay = 1; columnDay <= 7; columnDay++)
      {
        if (columnDay > 1)
        {
          System.out.print("   ");
        }//If
        if (columnDay != nextDay || nextDayToPrint > endOfMonth)
        {
          printDaySpace();
        }//If
        else
        {    
          if (nextDayToPrint == theSpecialDay)
          {
            printDay(nextDayToPrint,theSpecialDay);
            nextDay++;
            nextDayToPrint++;
          }//If
          else            
          {
            printDay(nextDayToPrint, theSpecialDay);
            nextDay++;
            nextDayToPrint++;
          }//Else 
        }//Else
      }//For  

      System.out.println("|");
      noOfRows++;
      nextDay = 1; 
      
    
    }//While
    printStraightLine();
  }//Print The Month
    

  //This is how th eline above and below the calendar is printed
  private static void printStraightLine()
  {
    System.out.print("   ");
      
    for (int columnDayNo = 1; columnDayNo <= 7; columnDayNo++)
    {
      if (columnDayNo > 1)
      {
        System.out.print("---");
        printDateLine();
      }//If
    }//For
      
    System.out.println(" ");
  }//Print Straight Line

  //This is how each day of the week is displayed on the top of the calendar
  private static void printNamesOfDay()
  {
    System.out.print("|");
    for (int columnDayNo= 1; columnDayNo <= 7; columnDayNo++)
    {
      if (columnDayNo > 1)
      {
        System.out.print("  ");
      }//If
      printNameOfDay(columnDayNo);
   
    }//For
 
    System.out.println("|");
  }//Print Names of Day

  private static void printNameOfDay(int dayNo)
  {
    //This is how the name of the day is displayed.
    switch (dayNo)
    {
      case 1: System.out.print(" Su  "); break;
      case 2: System.out.print(" Mo  "); break;
      case 3: System.out.print(" Tu  "); break;
      case 4: System.out.print(" We  "); break;
      case 5: System.out.print(" Th  "); break;
      case 6: System.out.print(" Fr  "); break;
      case 7: System.out.print(" Sa "); break;
    }//Switch
  }//Print Name of Day
   

  //This is what is entered in place of a date
  private static void printDaySpace()
  {
    System.out.print("    ");
  }//Print Day Space
  
  //This how the line at the top of the calendar is printed
  private static void printDateLine()
  {
    System.out.print("----");
  }//Print Date Line
  
  //This is the method used to print out te date, and select the highlighted one
  private static void printDay(int date, int highlight)
  { 
    if (highlight == date)
    {
      System.out.printf(">%02d", date);
      System.out.print("<");
    }//If
    else
    {
      System.out.printf(" %02d", date);
      System.out.print(" ");
    }//Else
  }//Print Day
}//Public  





































      














































































         
