//Program with hard code to test the MinMaxArray Class
public class TestMinMaxArray
{
  public static void main(String[] args)
  {
    Integer[] array1 = {33, 56, 7, 9, 90};
    Integer[] array2 = {87, 74, 67, 3, 2, 1};

    System.out.println("This is the first test array");
    //This is the first array
    Pair firstArray = MinMaxArray.getMinMax(array1);
    int min = (Integer)firstArray.getFirst();
    int max = (Integer)firstArray.getSecond();
    System.out.println("Minimum number in the array: " + min); 
    System.out.println("Maximum number in the array: " + max); 
    
    System.out.println();
    //Skip a line
    System.out.println("This is the second test array");

    //Then the second array
    Pair secondArray = MinMaxArray.getMinMax(array2);
    min = (Integer)secondArray.getFirst();
    max = (Integer)secondArray.getSecond();
    System.out.println("Minimum number in the array: " + min); 
    System.out.println("Maximum number in the array: " + max); 
  }//Main
}//TestMinMaxArray
