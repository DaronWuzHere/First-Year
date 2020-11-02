public class MaxList
//Code for a program that collects the maximum of numbers in ascendening order
{
  public static void main(String[] args)
  {
    
  
    double firstNum = Double.parseDouble(args[0]);
    //The first number used to compare the rest
     
    double maxSoFar = firstNum;
    //The maximum number recorded so far

    double maxSoFarIndex = 0;
    //The index of the number
    
    

    for (int index = 0; index < args.length; index++)
    {
      
      int numberBeingCompared = Integer.parseInt(args[index]);
      //Saves number being compared

      //If current number is larger than the number compared
      if  (maxSoFar < numberBeingCompared)
      { 
        maxSoFar = numberBeingCompared;
        //Make the number being compared the new maximum recorded so far
        maxSoFarIndex = index;
        //Record the new index

      }//If
     
          
    }//For
    
     System.out.println("The maximum number in the list has the index number " + maxSoFarIndex 
                          + " the maximum number is " + maxSoFar);

     
  }//Main
} //Public claas
    
