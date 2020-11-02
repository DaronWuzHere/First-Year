//Class showing students' names and their grades
public class Student
{
  //The student name
  private final String studentName;
  
  //The grade of the student
  private final int studentGrade;
 
  //The constructor method
  public Student(String requiredName, int requiredGrade)
  {
    studentName = requiredName;
    studentGrade = requiredGrade;
  }//Student
  
  //Get the name of the student
  public String getStudent()
  {
    return studentName;
  }//Get Student

  //Get the grade of the student
  public int getGrade()
  {
    return studentGrade;
  }// Get Grade

  public int compareTo(Student other)
  {
    return other.studentGrade - studentGrade;
  }
  public String toString()
  {
    return String.format("%-10s got %3d", studentName, studentGrade);
  }// To string
}//Class Student
  
