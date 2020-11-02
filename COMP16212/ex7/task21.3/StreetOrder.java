import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

//This class Street Order will read in file containing addresses and print them
//out in delivery order
public class StreetOrder
{
  public static void main(String[] args) 
  {
    //Read the file using Buffered Reader
    BufferedReader input = null;

    //Print the file to a new output using Print writer
    PrintWriter output = null;

    try
    {
      //If the number of arguments are not equal to two 
      if (!(args.length == 2))
        throw new IllegalArgumentException
                  ("There must be exactly two arguments: infile, outfile");
 
      
      input = new BufferedReader(new FileReader(args[0]));
      output = new PrintWriter(new FileWriter(args[1]));
      
      //The list for storing the lines
      List<String> lineList = new ArrayList<String>();

      //Read the lines into lineList
      String currentLine;

      while ((currentLine = input.readLine()) != null)
        lineList.add(currentLine);

      //This outputs each odd line then each even line
      for (int i = 0; lineList.size() > i; i++)
      {
        if(i % 2 == 0)
        {
          DeliveryHouseDetails address = 
                     new DeliveryHouseDetails(lineList.get(i), i); 
          output.println(address);
        }//If
      }//For

      for(int i = 0; lineList.size() > i; i++) 
      {
        if(i % 2 == 1)
        { 
          DeliveryHouseDetails address = 
                     new DeliveryHouseDetails(lineList.get(i), i);
          output.println(address);
        } //If
      }//For

    } // Try
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
      }//if 
    }//Finally
  } // Main
} // StreetOrder
