/**
 * Phone Class 
 * This is a class to record the model and brand of phones for students
 * It also records the length of the phone calls and the phone numbers of the students
 * @author Daron Mauricette
 */
public class Phone
{
  //This is the brand and model of the phone
  private final String phoneName;

  //This is time  student spends on a call
  private final Account account;

  private int timeCall;

  //End of variables


   /**
   * Stores the phone name and account name used in the story about Students and phones
   * 
   * @param phoneName - The name of the phone used
   * @param account - The name of the account used
   */
  //This is a method that allows the phone numbers to be used
  public Phone (String phoneName, Account account)
  {
    this.phoneName = phoneName;
    this.account = account;
    
  }//Phone Number
 
 
   /**
   * Stores the value of the top up used in the call in the story about Students and phones
   * 
   * @param value - The value of the top up that is used in the story
   */
  //This is a method that allows the phone name to used
  public void toppedUp(int value)
  {
    account.toppedUp(value);
  }//Top Up

   /**
   * Stores the value of time used in the call in the story about Students and phones
   * 
   * @param duration - The value, call length that is used in the story
   */
  public int call(int duration)
  {
    int call = account.call(duration);
    timeCall += duration;
    return call;

  }//Get Name

   /**
   * Stores the name of the phoneName in the story about Students and phones
   * 
   * @param phoneName - The phone name that is used in the story
   */
  //This is what gets output
  public String toString()
  {
    return phoneName + " used for " + timeCall + " seconds with the account " +
           account.toString();
  }//To String
    
}//Public Class Phone









