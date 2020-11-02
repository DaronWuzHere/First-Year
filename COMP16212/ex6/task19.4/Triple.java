//Three objects grouped in a triplet
public class Triple<FirstType, SecondType, ThirdType>
{
  //The first object
  private final FirstType first;

  //The second object
  private final SecondType second;
 
  //The third object
  private final ThirdType third;

  //Constructor method 
  public Triple(FirstType requiredFirst, SecondType requiredSecond, 
                ThirdType requiredThird)
  {
    first = requiredFirst;
    second = requiredSecond;
    third = requiredThird;
  }//Contructor

  //Return the first object
  public FirstType getFirst()
  {
    return first;
  }//First

  //Return the second object
  public SecondType getSecond()
  {
    return second;
  }//Second
  
  //Return the third object
  public ThirdType getThird()
  {
    return third;
  }//Third

}//Triple
