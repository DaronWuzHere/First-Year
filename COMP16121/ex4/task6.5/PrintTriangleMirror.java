//Program called PrintTriangleMirror used to print a mirrored image of a
//right angled triangle
public class PrintTriangleMirror
{
  public static void main(String args[])
  {
    //The height of the triangle
    int height = Integer.parseInt(args[0]);
    
    //Used to implement the rows of the triangle
    for (int row = 1; row <= height; row++)
    { 
      //Outputs the blank space
      for( int column = 1; column < row; column++)
      {
        System.out.print("   ");
      }//For 3
      //Outputs the box used to form the triangle
      for(int halfSquare = 0; halfSquare < height - row + 1  ; halfSquare++)
        {
          System.out.print("[_]");
        }//For 3

     
      System.out.println();
    }//For 1
  }//Main
}//Public Class   
