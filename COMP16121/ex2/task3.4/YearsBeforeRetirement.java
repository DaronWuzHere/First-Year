public class YearsBeforeRetirement
{ 
  public static void main(String[] args)
  {
    int AgeNow;
    int RetirementAge;
    int YearsUntilRetirement;
    
    AgeNow = Integer.parseInt(args[0]);
    RetirementAge = 68;
    YearsUntilRetirement = RetirementAge - AgeNow;

    System.out.println("Your age now is " + AgeNow);
    System.out.println("You will retire at " +  RetirementAge);
    System.out.println("Years until you retire " + YearsUntilRetirement);
  }
} 
  
    
