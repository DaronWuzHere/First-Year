/**
 * Student Class
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

  //This how the student gets a phone
  public void newPhone(Phone phone)
  {
    phoneName = phone;
  }//Phone Name
  

  //This is where students can top up there phones
  public void toppedUp(int value)
  {
    if(phoneName!=null)
    {
      phoneName.toppedUp(value);
    }//If 
  }//Topped Up 

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
    
  public Student(String name)
  {
    this.name = name;
  }//Student Constructor

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
 
