//Program called PrintHoledRectangle to pritn a rectangle with a hole in the middle
public class PrintHoledRectangle
{
  public static void main(String args[])
  {
    //The width of the rectangle
    int width = Integer.parseInt(args[0]);
    
    //The height of the rectangle
    int height = Integer.parseInt(args[1]);
    
    //This is to make sure the height and width are odd numbers
    height /=2;
    height *=2;
    height +=1;
    
    width /=2;
    width *=2;
    width +=1;
    
    //The loop to print the rectangle
    for (int row = 0; row < height; row++)
    { 
      // This implements the columns and rows
      for (int column = 0; column < width; column++)
      { 
        if (row == ((height / 2)) && column == ((width / 2)))
        {
          
          //This prints a blank spcae when the "if" statement is true
          System.out.print("   ");
        }//If
        else
        {
          System.out.print("[_]");
        }//Else
      }//For
      
      
      System.out.println();

     }//For
   
  }//Main
}//Public


