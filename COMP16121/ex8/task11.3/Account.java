//This is the class to keep track of the phone accounts of the students
//This holds the account name, and the amount of credit on the phones
public class Account
{ 

  //The Account of the student
  private final String accountName;
  
  //The amount of credit the student has to make phone calls
  private int credit;
 
//  private final Student name;
 
  //Method to allow the account number to be visible
  public Account (String accountName)
  {
    this.accountName = accountName;
    credit = 0;
  }//Account Number

  //This method is used to make the credit visible
  public void toppedUp(int value)
  {
    credit += value * 100;
  }//Credit

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
 
  //This is the output of this 
  public String toString()
  {
    return accountName + " has " + credit + " left";
  }//To String
}//Account 
