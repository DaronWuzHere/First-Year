import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
//Program to read a file or standard input and delete a field
public class DeleteField
{
  public static void main(String[] args)
  {
    BufferedReader input = null;
    PrintWriter output = null;
    try
    {
      //If there are more than three argumemts, don't allow it
      if (args.length > 3)
        throw new DeleteFieldException("Too many arguments");
      //This If/Else statement reads the file or the arguments if its less than
      // 3
      if(args.length < 3 || args[1].equals("-") )
        input = new BufferedReader(new InputStreamReader(System.in));
      else
        input = new BufferedReader(new FileReader(args[1]));
   
      //This If/Else statement checks whether argument 1 is a file
      if(args.length < 3 || args[1].equals("-"))
        output = new PrintWriter(System.out, true);
      else
      {
        //If the file already exists, throw an exception
        if (new File(args[2]).exists())
        {
          throw new DeleteFieldException("Output file " + args[1] + " already " 
                                        + "exists");
        }//If
        output = new PrintWriter(new FileWriter(args[1]));
      }//Else
      //Divide the lines into fields using tab as the delimiter
      int fieldToDelete = Integer.parseInt(args[0]);
      String currentLine = input.readLine();
      String[] fields = currentLine.split("\t");
      String editedLine = "";
      System.out.println(fields[0]);
      if (fields.length < fieldToDelete)
        editedLine = currentLine;
      else
      {
        //Build the new line back
        for (int i = 0; i < fieldToDelete - 1; i++)
        {
          if(editedLine.equals(""))
            editedLine = fields[i];
          else  
            editedLine += "\t" + fields[i];
          //Add the fields back
        }//For
        for (int i = fieldToDelete; i < fields.length; i++)
        {
          if (editedLine.equals(""))
            editedLine = fields[i];
          else 
            editedLine += "\t" + fields[i];
        }//For
      }//Else
    }//Try
    catch(DeleteFieldException exception)
    {
      //Line number exceptions go to standard output
      System.out.println(exception.getMessage());
    }//Catch

    catch (IOException exception)
    {
      //All other exceptions go to standard error
      System.err.println(exception);
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
}//DeleteField














