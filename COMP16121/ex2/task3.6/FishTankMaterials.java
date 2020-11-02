public class FishTankMaterials
{
  public static void main(String[] args)
  {
    int width = Integer.parseInt(args[0]);
    int length = Integer.parseInt(args[1]);
    int height = Integer.parseInt(args[2]);
    
    int surfaceArea = length * width + 2 * width * height + 2 * length * height;

    int edgesLength = 4 * length + 4 * width + 4 * height;
  
    System.out.println("The surface area of a tank with dimensions "
                       + "(" + width + "," + height + "," + length + ") "
                       + "is " + surfaceArea);

    System.out.println("The length of the egdes of a tank with dimensions "
                       + "(" + width + "," + length + "," + height + ") " 
                       + "is " + edgesLength);
   }
}
