//Program to reverse the lines of a text ile recursively
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;

public class ReverseLines
{
  //Main method that calls the recursive method
  public static void main(String[] args) throws Exception
  {
      //Handles the input and output files
      BufferedReader input = null;
      PrintWriter output = null;

      input = new BufferedReader(new FileReader(args[0]));
      output = new PrintWriter(new FileWriter(args[1]));
      
      //Call the method once
      reverse(input, output);
  
      //Close the output
      output.close();
  }//Main
  //The recursive method
  public static void reverse(BufferedReader input, PrintWriter output) 
                                                               throws Exception
  {
    //String to store the head line
    String headLine = input.readLine();
  
    //If statement to make the recursive calll
    if (headLine != null)
    {
      String tailLine = headLine;
      reverse(input, output);
      output.println(tailLine);
    }//If
  }//Reverse 
}//Reverse Lines
