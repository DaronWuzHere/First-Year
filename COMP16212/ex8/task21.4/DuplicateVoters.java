import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import java.io.InputStreamReader;

public class DuplicateVoters
{
  public static void main(String[] args)
  {
    //Handles the input and output files
    BufferedReader input = null;
    PrintWriter output = null;
    try
    {
      //If the number of files is not two, throw an exception 
      if (!(args.length == 2))
        throw new IllegalArgumentException
                  ("There must be exactly two arguments: infile, outfile");
      input = new BufferedReader(new FileReader(args[0]));
      output = new PrintWriter(new FileWriter(args[1]));
    
      //This is the Hash Set that stores the lines of voters
      Set <String> regularVoters = new HashSet<String>();

      //A count to keep track of the number of duplications
      int duplicationCount = 0;
 
      //String to store the current line
      String currentLine;

      //Line counter
      int oddLinesOnly = 1;

      //While loop to add each line of voters to the set
      while ((currentLine = input.readLine()) != null)
      {
        if(oddLinesOnly % 2 == 1)
        {
          if(regularVoters.contains(currentLine))
          {
            output.println(currentLine);
            duplicationCount++;
          }//If
          else
            regularVoters.add(currentLine);
        }//If
        oddLinesOnly++;
      }//While
      output.println("There were " + duplicationCount + " duplicated votes");
      
    }//Try 
    catch (Exception exception)
    {
      System.err.println(exception);
    } //Catch
    finally
    {   
      try { if (input != null) input.close(); }// Try
      catch (IOException exception)
        { System.err.println("Could not close input " + exception); } //Catch
      if (output != null)
      {
        output.close();
        if (output.checkError())
          System.err.println("Something went wrong with the output");
      }//If
    }//Finally
  }//Main
}//DuplicateVoters
