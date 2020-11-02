import java.util.Arrays;
import java.io.IOException;
public class MinMaxArray
{
  public MinMaxArray()
  {
  }//Empty Constructor
  
  //This compares the arrays and returns the largest and smallest numbers
  //according to the index
  public static <ArrayType extends Comparable<ArrayType>> 
                Pair getMinMax(ArrayType[] anArray)
                throws IllegalArgumentException
  {
    if (anArray == null || anArray.length == 0)
      throw new IllegalArgumentException("Array must exist or must not be " + 
                                         "empty");
    Arrays.sort(anArray);

    return new Pair<ArrayType, ArrayType>(anArray[0], 
                                          anArray[anArray.length-1]); 
  } // 
} // Class MinMaxArray 
