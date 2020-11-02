/**
 * Class for Student
 * Class called Student to process the names of students
 * Takes string arguments
 * @author Daron Mauricette
 */

public class Student
{
  //The one variable is the name of the student
  private final String name;

  private int call;
  
  private Phone phoneName;
  //End of Variables

/**
 * This just assigns a phone name to a variable
 * @param phoneName The name of the phone
 */
  //This how the student gets a phone
  public void newPhone(Phone phone)
  {
    phoneName = phone;
  }//Phone Name
  
/**
 * This just tops up phones and checks first to see if there is a phone or not
 * @param value The value of the top up
 */
  //This is where students can top up there phones
  public void toppedUp(int value)
  {
    if(phoneName!=null)
    {
      phoneName.toppedUp(value);
    }//If 
  }//Topped Up 


/**
 * This just records the length of the call
 * @param length The length of the phone call between students
 */
  //This is where the length of the calls is recorded
  public int call(int length)
  {
    if(phoneName!=null)
    {
      return phoneName.call(length);
    }//If 
    else
    {
      return 0;
    }//Else
  }//If
  
  /**
 * This just assigns student name to a variable
 * @param name The name of a student
 */
  public Student(String name)
  {
    this.name = name;
  }//Student Constructor


/**
 * This just prints out the students name and the other class if there is a phone
 * But it only prints out the students name if there is no phone
 */
  //This is the string output of the class
  public String toString()
  {
    if(phoneName==null)
    { 
      return name + " has no phone.";
    }//If
    else
    {
      return name + " has the " + phoneName.toString();
    }//Else  
}//To String
}//Student
 
