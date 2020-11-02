import java.io.File;
import java.util.Scanner;
/* This is a program that outputs puzzle for the user to solve,
    he or she must put the lines in the correct order.
*/

// Class to make the puzzle
public class RandomOrderPuzzle
{

  //The lines of the puzzle that will be randomized
  private String[] test = new String[0];
  private String[] answer;

  //To initialize the puzzle
  public RandomOrderPuzzle(Scanner fScanner)
  {
    final int MAX_ARRAY_SIZE = 100;
    int arraySize = 0;
    test = new String[MAX_ARRAY_SIZE];

    //While there are next lines add, as long as it is less than maximum
    while(fScanner.hasNextLine()&&
          arraySize<MAX_ARRAY_SIZE)
    {
      test[arraySize] = fScanner.nextLine();
      arraySize++;
    }

    //create full array now
    String[] correctTest = new String[arraySize];
    for(int index = 0; index < arraySize; index++)
    {
      correctTest[index] = test[index];
    }

    // Set it to the global variable`
    test = correctTest;
    answer = test.clone();
    randomStringArrayOrder(test);
  }

  //given main to run puzzle
  public static void main(String[] args) throws Exception
  {

    Scanner fileScanner = new Scanner(new File(args[0]));
    RandomOrderPuzzle puzzle = new RandomOrderPuzzle(fileScanner);

    Scanner inputScanner = new Scanner(System.in);
    System.out.println(puzzle);
    int moves = 0;
    while(!puzzle.isSorted())
    {
      System.out.print("Enter a line number to swap with the last line: ");
      puzzle.swapLine(inputScanner.nextInt());
      System.out.println(puzzle);
      moves++;
    }//While

    System.out.println("Game over in "+ moves +" moves.");

  }//Main

  //To string method to output string
  public String toString()
  {
    String plain ="";
    //Make plain string
    
    //Loop adding each line and its index
    for(int index = 0;index<test.length;index++)
    {
      plain+=index + "\t" + test[index] + "\n";
    }
    return plain;
  }//To string

  
  //Method to swap the lines 
  public void swapLine(int index)
  {

    //Swap the index and final line
    String storedLine;
    storedLine = test[index];
    test[index] = test[test.length-1];
    test[test.length-1] = storedLine;

  }//Swap Line

  //Boolean function and while loop to sort the puzzle
  public boolean isSorted()
  {
    boolean sortedLine = true;
    int current = 0;

    while(sortedLine && current <  test.length)
    {
      if(test[current] != answer[current]) 
      {
        sortedLine = false;
        current++;
      }//If
    }//While
    return sortedLine;
 
  }//isSorted

  //String array randomiser
  private void randomStringArrayOrder(String[] anArray)
  {
    for(int itemThatRemain = anArray.length;
        itemThatRemain > 0; itemThatRemain--)
    {
      int anIndex = (int) (Math.random() * itemThatRemain);
      String itemAtAnIndex = anArray[anIndex];
      anArray[anIndex] = anArray[anArray.length - 1];
      anArray[anArray.length-1] = itemAtAnIndex;
    }//For

  }//Randomize String Array Order

}//RandomOrderPuzzle
