import java.util.Scanner;

/* This is a program that displays an array of marks after 
   getting the average. Takes integers in the argument
*/
public class MarkAnalysis
{
  public static void main(String[] args)
  {
    //A scanner for getting data from the user.
    Scanner gradesScanner = new Scanner(System.in);
  
    System.out.print("Enter the number of marks:  ");
    int numberOfGrades = gradesScanner.nextInt();
    if (numberOfGrades < 0)
    {
      System.out.println("This is an incorrect input");
    }// If
    else  
    {
      //Grades are stored as integers in an array
      int [] grades = new int[numberOfGrades];

      //Obtain the grades from the input
      for (int index = 0; index < numberOfGrades; index ++)
      {
        System.out.print("Enter mark #" + (index + 1) + ":  ");
        grades[index] = gradesScanner.nextInt();
      }//For 

      //Now compute the sum of the grades
      int sumOfGrades = 0;
      for (int grade : grades)
      {
        sumOfGrades += grade;
      }//For

      //Calculate the mean, then minimum and maximum using array sort
      double meanGrades = sumOfGrades / (double)numberOfGrades;    
      sort(grades);
    
      //Produce the results
      System.out.println();
      System.out.println("The mean mark is:         " + meanGrades);
      System.out.println("The minimum mark is:      " + grades[0]);
      System.out.println("The maximum mark is:      "
                         + grades[grades.length-1]);
      System.out.println();
    
  
      //Prints above the For loop because we don't want it to repeat
      System.out.println("Person | Score | Difference From Mean");
 
      for (int index = 0; index < numberOfGrades; index++)
      {
        double differenceMean = (double)grades[index] - meanGrades;
        System.out.printf("%6d | %5d | %6.2f%n", (index + 1), grades[index],
                          differenceMean);
      }// For
   }//Else
  }// Main
  private static void sort (int[] anArray)
  {
    int unsortedLength = anArray.length;
    
    boolean changedOnThisPass;
    do 
    {
      changedOnThisPass = false;
      for (int pairLeftIndex = 0; pairLeftIndex < unsortedLength - 1; pairLeftIndex++)
      {
        if (anArray[pairLeftIndex] > anArray[pairLeftIndex + 1])
        {
          int thatWasPairLeftIndex = anArray[pairLeftIndex];
          anArray[pairLeftIndex] = anArray[pairLeftIndex];
          anArray[pairLeftIndex + 1] = thatWasPairLeftIndex;
          changedOnThisPass = true;
        }//If
      }//For
      unsortedLength--;
    }//Do
    while (changedOnThisPass);
  }//Sort
      

   
}// Mark Analysis
