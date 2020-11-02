//A program to display a truth table
//No arguments needed
public class TruthTable34
{
  //This is how the first condition is made
  private static boolean p1(boolean a, boolean b, boolean c, boolean d)
  {
    return (((a || b) && c) || ((b || c) && d)) && (a || d);
  }//P1

  //This is the second condition
  private static boolean p2(boolean a, boolean b, boolean c, boolean d)
  {
    return a && c || b && d || c && d;
  }//P2
 
  //This is the third condition
  private static boolean p3(boolean a, boolean b, boolean c, boolean d)
  {
    return (b || c) && (c || d) && (a || d);
  }//P3
 
  //This is how the top of the table is printed
  private static void PrintStraightLine()
  {
    System.out.println("__________________________________________________");
  }//Print straight line

  //This is how the column headings are made
  private static void PrintHeadings()
  {
    System.out.println("|   a  |   b  |   c  |   d" +
                       "  |   p1 |   p2 |   p3 |");
  }//Print headings

  //This is how the columns are made
  private static void PrintColumns()
  {
    System.out.println("|______|______|______|______|______|______|______|");
  }//Print columns
 
  //This is how the boolean variables are entered into the table
  private static void PrintValuesInTable(boolean a, boolean b, boolean c, boolean d)
  {
    System.out.println("|" + formatRowItem(a) + "|" + formatRowItem(b) +
                       "|" + formatRowItem(c) + "|" + formatRowItem(d) +
                       "|" + formatRowItem(p1(a, b, c, d)) +
                       "|" + formatRowItem(p2(a, b, c, d)) +
                       "|" + formatRowItem(p3(a, b, c, d)) + "|");
  }//Print values in tables
  

  //This is how we print the true or false into the table
  private static String formatRowItem(boolean rowItem)
  {
    return rowItem ? " true " : " false";
  }//Format row item 

  public static void main(String args[])
  {
    PrintStraightLine();
    PrintHeadings();
    PrintColumns();
    
    boolean a = true, b = true, c = true, d = true;

    for (int aCount = 1; aCount <= 2; aCount++, a = !a)
    {
      for (int bCount = 1; bCount <= 2; bCount++, b = !b)
      {
        for (int cCount = 1; cCount <= 2; cCount++, c = !c)
        {
          for (int dCount = 1; dCount <= 2; dCount++, d = !d)
          {
            //This prints each combination of a, b, c, and d 
            PrintValuesInTable(a, b, c, d);
          }//The last for loop
        }//The third for loop
      }//The second for loop
    }//The first for loop
    
    PrintColumns();
    
  }//Main

}//Class Table
  














  
 

