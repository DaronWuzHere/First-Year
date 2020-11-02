public class PassFailDistinction
//Program that determines whether a mark of a student 
//is above the pass mark and whether it is worthy of a 
//distinction
{
  public static void main(String[] args)
  {  
    double mark = Double.parseDouble(args[0]);
//Declaring the mark as a double variable   
    if (mark >= 50)
    {
      System.out.println("Pass");
    }    
    else 
    {
      System.out.println("Fail");
    }
    if (mark >= 70)
    {
      System.out.println("Distinction");
    }
  }
}
