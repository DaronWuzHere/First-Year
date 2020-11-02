public class TestRelativeDates
{
  public static void Main(String[] args)
  {
    int day = 1;
    int month = 1;
    int year = 2018;
    Date date1 = new Date(day, month, year);
    Date date2 = new Date(day, month, year);
    Date date3 = new Date(day, month, year);
    for (int i = 2020; i >= year; year++)
    {
      for (int j = 12; j >= month; month++)
      { 
        if (j == 2 && i == 2019) 
        {
          for (int k = 28; k >= day; day++)
          {
            System.out.println(date1);
          }// For
        } // If
        else
        {
          if (j == 2 && i == 2020)
          {
            for (int k = 29; k >= day; day++)
            {
              System.out.println(date2);
            }// For
          }// If
          for (int k = 31; k >= day; day++)
          {
            System.out.println(date3);
          }// For 
        }// Else
      }// For
    }// For
  }// Main       
}// Test Relative Dates 
