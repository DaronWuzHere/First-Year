//The class Delivery House Details will store a hosue number and person details
import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

public class DeliveryHouseDetails 
{
  //Variable to store the house numbers
  public int houseNumber;
 
  //String to store the person's name
  public String personName;
  
  //Constructor method
  public DeliveryHouseDetails(String personName, int houseNumber) 
  {
    this.personName = personName;
    this.houseNumber = houseNumber;
  }//PersonDetails

  //Accessor method to obtain the string
  public String getName(String name)
  {
    return personName;
  }//getName

  //Sorts out the list
  public static <ListType extends Comparable<? super ListType>> 
                void sort (List<ListType> list)
  {
    Collections.sort(list);
  }//ListType

  //Converts the address to string
  public String toString()
  {
    return personName;
  }//toString
  
  //Method to compare the houseNumbers
  public int compareTo(Object other)
  {
    if ((houseNumber % 2 == 1) && (this.houseNumber % 2 == 1))
      return (this.houseNumber - houseNumber);
    else if ((houseNumber % 2 == 0) && (this.houseNumber % 2 == 0))
      return (houseNumber - this.houseNumber);
    else if (this.houseNumber % 2 == 1)
      return -1;
    else
      return 1;
  }//compareTo

  //Method to deal with house numbers that are equal with each other
  public boolean equals(Object other) 
  {
    if (other instanceof DeliveryHouseDetails)
      return houseNumber == ((DeliveryHouseDetails)other).houseNumber;
    else 
      return super.equals(other);
  }//equals
}//DeliveryHouseDetails
