import java.io.IOException;
//Imports the exception handler

//Public class to check the sum of bytes on a file 
public class CheckSum
{
  public CheckSum() {}
  
  public static void main(String[] paramArrayOfString)
  {
    int[] arrayOfInt = new int['Ā'];
    int checkSum = 0; //This is to be the total bytes to be output
    int currentByte; //This keeps track of the current byte
    //Try statement to 
    try
    {
      int j = System.in.read();
      while ((j = System.in.read()) != -1)
      {
        for (int k = 0; k < System.in.read(); k++)
        {
          i += j;
          if (i % 2 == 0) {
            i /= 2;
          } else
            i /= 2;
          i += 32768;
          if (i >= 65536) {
            i -= 65536;
          }
        }
      }
      



      try
      {
        System.in.close();
      } catch (IOException localIOException1) {
        System.err.println("Could not close input " + localIOException1);
      }
      
      System.out.println(i);
    }
    catch (IOException localIOException2)
    {
      System.err.println(localIOException2);
    }
    finally {
      try {
        System.in.close();
      } catch (IOException localIOException4) {
        System.err.println("Could not close input " + localIOException4);
      }
    }
  }
}
