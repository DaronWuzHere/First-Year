import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

//A program to identify the duplicate voters and output the time and place of
//the occurences

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

      //Have a string to store the current voter
      String voterID;

      //Have a string to store the location and the duplicate location
      String location;
      String duplicateLocation;
   
      //Boolean variable to check if there has been a duplication
      boolean duplicate = false;

      //Duplication counter
      int lineCount = 0;

      //Use a hash map to effectively store the duplicate voters
      Map<String, String>votersAndLocations = new HashMap<String, String>();

      //This is the current line
      String currentLine;
      
      //While loop to read the line of the file
      while ((currentLine = input.readLine()) != null)
      {
        voterID = currentLine;
   
        //If statement to print out the duplicated voter's name, address and 
        //duplicate address
        if (votersAndLocations.get(voterID) != null)
        { 
          output.println(voterID);
          duplicateLocation = input.readLine();

          output.println("  Duplicate: " + duplicateLocation);
          output.println("  First occurence:  "
                         + votersAndLocations.get(voterID));
          lineCount++;
        }//If
        else
        {
          location = input.readLine();
          votersAndLocations.put(voterID, location);
        }//Else
      }//While
      output.println("There were " + lineCount + " duplicated votes");
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
