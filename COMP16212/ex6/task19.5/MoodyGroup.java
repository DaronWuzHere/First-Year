//Representation of a moody group of people from the notional lottery
public class MoodyGroup<MoodType extends MoodyPerson>
{
  //The initial array size
  private static final int INITIAL_ARRAY_SIZE = 2;

  //The array resize factor
  private static final int ARRAY_RESIZE_FACTOR = 2;

  //The array and the int to hold the number of people 
  private MoodyPerson[] persons = new MoodyPerson[INITIAL_ARRAY_SIZE];
  private int noOfPersons = 0;

  //The state of the persons happiness
  private boolean isHappyNow;

  //The empty constructor method, nothing needs to be done
  public MoodyGroup()
  {
  
  }//Constructor
  
  //Add a person to the moody group of people
  public void addPerson(MoodyType newPerson)
  {
    if(noOfPersons == persons.length)
    {
      MoodyPerson[] largerArray = MoodyPerson[(persons.length 
                                              * ARRAY_RESIZE_FACTOR)];
      for (int i = 0; i < persons.length;i++)
        largerArray[i] = persons[i];
      persons = largerArray;
    }//If
    persons[noOfPersons] = newPerson;
    noOfPersons++;
  }//Add Person

  //Used to keep track of the people in the group to become happy
  private int nextMoody = 0; 

  //Return the number of people in the conversation
  public int getSize()
  {
    return noOfPersons;
  }//Get Size

  //This method sets the persons mood to happy
  public void setHappy(boolean newHappiness)
  {
    newHappiness = isHappyNow;
    if (noOfPersons > 0)
    {
      persons[nextMoody].setHappy(newHappiness);
      nextMoody = (nextMoody + 1) % noOfPersons;
    }//If
  }//Set Happpy
  
  //To String method mainly for testing
  @Override
  public String toString()
  {
    String result = noOfPersons == 0 ? "" : "" + persons[0];
    for (int i = 0; i < noOfPersons; i++)
      result += String.format("%n%s", persons[i]);
    return result;
  }//To String

}//MoodyGroup
