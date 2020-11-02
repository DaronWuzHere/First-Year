import java.util.Scanner;

/* This is a program that displays an array of marks after 
   getting the average. Takes integers in the argument
*/
public class MarkAnalysis
{
  public static void main(String[] args)
  {
    //A scanner for getting data from the user.
    Scanner inputScanner = new Scanner(System.in);
    
  
    System.out.print("Enter the number of marks:  ");
    int noOfStudents = inputScanner.nextInt();
    if (noOfStudents <= 0)
    {
      System.out.println("This is an incorrect input");
    }// If
    else  
    {
      //Skip past the end of that line
      inputScanner.nextLine();

      //Names are stored in a different array
      Student[] students = new Student[noOfStudents];

      //Obtain the grades from the input
      for (int studentIndex = 0; studentIndex < noOfStudents; studentIndex++)
      {
        System.out.print("Enter Name of Student " + (studentIndex + 1)
                                                  + " :  ");
        String studentName =  inputScanner.nextLine();
        
        System.out.print("Enter mark #" + (studentIndex + 1) + " for "
                                        + studentName + ":  ");
        int studentGrade = inputScanner.nextInt();
        //Skip past that line
        inputScanner.nextLine();
        students[studentIndex] = new Student(studentName, studentGrade);
      }//For 

      //Now compute the sum of the grades
      int sumOfGrades = 0;
      for (Student names : students)
      {
        sumOfGrades += names.getGrade();
      }//For

      //Calculate the mean, then minimum and maximum using array sort
      double meanGrades = sumOfGrades / (double)noOfStudents;    
      sort(students);
    
      //Produce the results
      System.out.println();
      System.out.println("The mean mark is:         " + meanGrades);
      System.out.println("The minimum mark is:      " 
                         + students[0].getGrade());
      System.out.println("The maximum mark is:      "
                         + students[students.length-1].getGrade());
      System.out.println();
    
  
      //Prints above the For loop because we don't want it to repeat
      System.out.println("Person  and  Score | Difference From Mean");
  
      for (Student names : students)
      {
        double differenceMean = (double)names.getGrade() - meanGrades;
        System.out.printf(names.toString());
        System.out.println(" | " +  differenceMean);
      }// For
   }//Else
  }// Main
  private static Student[] sort(Student[] input)
  {

    int index = 0;

    while(index!=(input.length-1))
    {

      if(input[index].compareTo(input[index+1])<0)
      {
        index++;
      }else
      {
        Student store = input[index];
        input[index]=input[index+1];
        input[index+1]=store;
  
        index=0;
      }//if
    }//while

    return input;
  }// Sort
      

   
}// Mark Analysis
