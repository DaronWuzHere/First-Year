//Program taking a string of words and outoputs the amount
import java.io.InputStreamReader;
import java.io.IOException; 

public class WordCount
{
  public static void main(String[] args)
  { 
    int[] wordCount = new int[65536];
    //The number of total number bytes mentinoed in the textbook 
    InputStreamReader input = new InputStreamReader(System.in);
    //Counts the number of words
    int allWordsSoFar = 0;
    //Counts the number of white spaces
    int whiteSpace = 0;   
    //Try statement
    try 
    {
      int currentWord;
      //Stores the current word
     
      //While loop to count the words
      while ((currentWord = input.read()) != -1)
      {        
        if (Character.isWhitespace(currentWord))
        {
          wordCount[currentWord]++;
          allWordsSoFar++;
          
        }//If
        else
          if (!(Character.isWhitespace(currentWord)))
          {
            currentWord++;
          }//If

      }//While
    }//Try
  
    //Catch the IOException
    catch(IOException exception)
    {
      System.err.println(exception);
    }//Catch
   
    //Close the input stream
    finally
    {
      try{ input.close(); }
      catch( IOException exception )
      { System.err.println("Could not close input " + exception); }

    }//Finally
    
    //Print the number of words read
    System.out.println("The number of words read was " + allWordsSoFar);
    for(int wordValue = 0; wordValue <= 65535; wordValue++)
    {
      if(wordCount[wordValue] != 0)
      {
        System.out.println("Word value " + wordValue + " occured " +
                           wordCount[wordValue] + " times");
      }//If
    }//FOr    
  }// Main
}//Class WordCount
