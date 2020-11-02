/**
 * Class for Account
 * This is the class to keep track of the phone accounts of the students
 * This holds the account name, and the amount of credit on the phones
 * @author Daron Mauricette 
 */
public class Account
{ 

  //The Account of the student
  private final String accountName;
  
  //The amount of credit the student has to make phone calls
  private int credit;
 

 /**
   * Stores the account name in the story about Students and phones
   * 
   * @param accountName - The Account names that are used in the story
   */
  //Method to allow the account number to be visible
  public Account (String accountName)
  {
    this.accountName = accountName;
    credit = 0;
  }//Account Number

   /**
   * Stroes the top up value used in the story about Students and phones
   * 
   * @param value - The value fo the top up that are used in the story
   */
  //This method is used to make the credit visible
  public void toppedUp(int value)
  {
    credit += value * 100;
  }//Credit

   /**
   * Stores the value of time used in the call in the story about Students and phones
   * 
   * @param value - The value, call length that is used in the story
   */
  //This is a method to subtract call time from the credit
  public int call(int value)
  {
    credit -= value;

    if (credit < 0) 
    {
      value += credit;
    
      credit = 0;
    }//If
 
    return value;
    
  }//Call Time 
 
 /**
   * Outputs the string about account and credit
   * 
   * @param accountName - The Account names that are used in the story
   */
  //This is the output of this 
  public String toString()
  {
    return accountName + " has " + credit + "left";
  }//To String
}//Account 
