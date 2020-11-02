import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;

//Program to convert files to binary to avoid corruption
public class Uuencode
{
  
  //Write a single result byte as a printable character
  //Each byte is 6 bit, i.e range 0 - 63
  //Thus adding 32 makes it printable, except for 0 which become space and 
  //so we add 96 instead -- a left single quote. (')
  private static void writeByteAsChar(int thisByte)
  {
    System.out.print((char) (thisByte == 0 ? 96 : thisByte + 32)); 
  }//WriteByteAsChar
    

  public static void main(String args[])
  {
    PrintWriter output = null;
    BufferedReader input = null;
    try
    {
      //These if statements determine how many arguments are used with the 
      //program
      /*if(args.length > 2) 
        throw new UuencodeException("Too many arguments");
       
      if(args.length < 1 || args[0].equals("-"))
        input = new BufferedReader(new InputStreamReader(System.in));
      else
        input = new BufferedReader(new FileReader(args[0]));

      if(args.length < 2 || args[1].equals("-"))
        output = new PrintWriter(System.out, true);
      else
      {
        if (new File (args[1].exists()))
          throw new UuencodeException("Output file " + args[1]
                                     + "already exists");
      }//Else   
      output = new PrintWriter(new FileWriter(args[1]));
       */
      //Print out the header
      System.out.println("begin + 600" + args[1]); 

 
      //Keeps track fo the current byte
      int currentByte;
      
      //While loop to go through the bytes
      while ((currentByte = input.read()) != -1)
      {
        for (int x = 0; x < lineBytes.length; x++)
        {
          if (x == lineBytes.length - 1)
            throw new UuencodeException("Unexpected error");
          else 
          {        
            while((numberOfBytesOnThisLine < lineBytes.length - 1))
            {
              lineBytes[currentByte]++;
            }//While
          }//Else
        }//For
      }//While
      //This prints out the s
      while (numberOfBytes < lineBytes.length)
      {
        writeByteAsChar(lineBytes[currentByte]);
      }//While 
      
      for(int byteGroupIndex = 0; byteGroupIndex < lineBytes.length; 
          byteGroupIndex++)
      {
        if (byteGroupIndex % 3 == 0)
        {
          //Calculate 4 result bytes from the 3 input bytes
           int byte1 = lineBytes[byteGroupIndex] >> 2;
           int byte2 = (lineBytes[byteGroupIndex] & 0x3) >> 4 |
                     (lineBytes[byteGroupIndex + 1] >> 4);
           int byte3 = (lines[byteGroupIndex + 1] & 0xf) << 2
                     | lineBytes[byteGroupIndex + 2] >> 6;
           int byte4 = lineBytes[byteGroupIndex + 2] & 0x3f;
  
           //Now write those result bytes.
           writeByteAsChar(byte1);
           writeByteAsChar(byte2);
           writeByteAsChar(byte3);
           writeByteAsChar(byte4);
          
        }//If
      }//For
      System.out.println("end");
    
    }//Try
 
    catch(UuencodeException exception)
    {
      //Line number exceptions go to standard output
      System.out.println(exception.getMessage());
    }//Catch

    catch (IOException exception)
    {
      //All other exceptions go to standard error
      System.err.println(exception);
    }//Catch
  
    catch (IllegalArgumentException exception)
    {
      System.err.println("Please input only one file: "
                        + exception.getMessage());
    }//Catch
    finally
    {
      try 
      {
        //Close the input stream when finished
        if (input != null)
        {
          input.close();
        }//If
      }//Try
      catch(IOException exception)
      {
        System.err.println("Could not close input " + exception); 
      }//Catch

      //Check for errors surrounding the output if it cannot close
      if(output != null)
      {
        output.close();
        if (output.checkError())
        {
          System.err.println("Something went wrong with the output");
        }//If
      }//If
      
    }//Finally
  }//Main
}//Uuencode
