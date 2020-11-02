//The class Delivery House Details will store a hosue number and person details
import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import java.util.Iterator;

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


  //Converts the address to string
  public String toString()
  {
    return personName;
  }//toString
  
  //These methods become obsolete becaue of the set interface iterator
  
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
