//Progran to print out all the permutations of a word entered as a command line
//argument. Only accepts string.

public class Anagrams
{ 
  public static void main(String[] args) throws RuntimeException
  {
    theWordToChars = args[0].toCharArray();
    permutations = new char[theWordToChars.length];
    hasItBeenUsed = new boolean[theWordToChars.length];
    printPermutations(0);

  }//Main

  private static char[] theWordToChars;
  private static char[] permutations;
  private static boolean[] hasItBeenUsed;
  
  public static void printPermutations(int currentIndex)
  {
    if (currentIndex >= theWordToChars.length)
    {
      for (char i : permutations)
      {
        System.out.print(i);
      }
      System.out.println();
    }//If
    else
    {
      for(int i = 0; i < theWordToChars.length; i++)
      {
        if(!hasItBeenUsed[i])
        {
          hasItBeenUsed[i] = true;
          permutations[currentIndex] = theWordToChars[i];
          printPermutations(currentIndex+1);
          hasItBeenUsed[i] = false;
        }//If
      }//For
    }//Else 
  }//Print Permutation
}//Anagrams
