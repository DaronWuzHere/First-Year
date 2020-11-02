public class FishTankVolume
{
  public static void main(String[] args)
  {
    try
    {
      int width = Integer.parseInt(args[0]);
      int depth = Integer.parseInt(args[1]);
      int height = Integer.parseInt(args[2]);
      if (args.length > 3)
        throw new ArrayIndexOutOfBoundsException
                    ("You have supplied " + args.length + " arguments!");
      if (width < 0) 
        throw new NumberFormatException
                    ("Your width of " + width + " is negative!");
      if (depth < 0) 
        throw new NumberFormatException
                    ("Your depth of " + depth + " is negative!");
      if (height < 0) 
        throw new NumberFormatException
                    ("Your height of " + height + " is negative!");

      int volume = width * height * depth;
      System.out.println("The volume of a tank with dimensions " + "(" + width 
                         + ", " + depth + ", " + height + ") is " + volume);
    } // Try
    catch (NumberFormatException exception)
    {
      System.out.println("Please input correct measurements for the tank!");
      System.out.println("The exception message was: '" + 
      exception.getMessage() + "'");
      System.err.println(exception);
    }// Catch
   
     catch (ArrayIndexOutOfBoundsException exception)
    {
      System.out.println("Please input the right amount of measurements for the"
      + " tank!");
      System.out.println("The exception message was: '" + 
      exception.getMessage() + "'");
      System.err.println(exception);
    }// Catch
   
    //Incase something unforseen occurs
    catch (Exception exception)
    {
      System.out.println("Something unexpected went wrong.");
      System.out.println("The exception message was: '" + 
      exception.getMessage() + "'");
      System.err.println(exception);
    }// Catch 
                       
  } // Main
} // Fish Tank Volume
