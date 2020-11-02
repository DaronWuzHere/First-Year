public class DegreeCatergory
{
  public static void main(String[] args)
  {  

    double mark = Double.parseDouble(args[0]);
    //Declares the variable mark as a double variable

    if (mark > 100 || mark < 0)
    {  
      System.out.println("Invalid Mark Entered!");
    }
    
    else if (mark >= 70)
    {
      System.out.println("Honours, first class");
    }

    else if (mark >= 60)
    {
      System.out.println("Honours. second class, division one");
    }

    else if (mark >= 50)
    {  
      System.out.println("Honors, second class, division two");
    }
   
    else if (mark >= 40)
    {   
      System.out.println("Honours, third class");
    }

    else if (mark >= 32)
    {
      System.out.println("Pass/Ordinary Degree");
    }

    else if (mark < 32)
    {
      System.out.println("Fail");
    }
   
   }
}
