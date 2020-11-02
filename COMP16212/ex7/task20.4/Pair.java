// Two objects grouped as pair.
public class Pair<FirstType, SecondType>
{
  // The two objects.
  private final FirstType first;
  private final SecondType second;


  // Constructor is given the two objects.
  public Pair(FirstType requiredFirst, SecondType requiredSecond)
  {
    first = requiredFirst;
    second = requiredSecond;
  } // Pair
  
  
  // Return the first object.
  public FirstType getFirst()
  {
    return first;
  } // getFirst


  // Return the second object.
  public SecondType getSecond()
  {
    return second;
  } // getSecond

} // Class Pair
