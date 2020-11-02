//Class containing the method to access stats stored in an array
public class IntArrayStats
{
  //This static method parameterizes the three variables and throws an
  //exception if there is no array
  public static Triple<Integer, Integer, Double> getStats(int[] array)
                                                throws IllegalArgumentException
  {
    if(array == null || array.length == 0)
      throw new IllegalArgumentException("Array must exist and be non-empty");
    //The maximum integer
    int maximumInt = array[0];

    //The minimum integer
    int minimumInt = array[0];
  
    //The sum of the array
    int sumArray = 0;

    //For loop that calculates the maximum integer
    for (int i = 0; i < array.length; i++)
    {
      sumArray += array[i];
      if(array[i] > maximumInt)
      {
        maximumInt = array[i];
      }//If
    }//For
    
    //For loop that calculates the minimum integer
    for (int i = 0; i < array.length; i++)
    {
      if(array[i] < minimumInt)
      {
        minimumInt = array[i];
      }//If
    }//For
    
    //The mean of all the numbers in the array
    double mean = (sumArray / array.length); 

    //return the variables as objects
    return new Triple<Integer, Integer, Double>(maximumInt, minimumInt, mean); 
  }//getStats
    
}//IntArrayStats
