public class FieldPerimeter
{
  public static void main(String[] args)
  {
    int Length;
    int Width;
    int Perimeter;
 
    Length = Integer.parseInt(args[0]);
    Width = Integer.parseInt(args[1]);
    Perimeter = Length + Length + Width + Width;
    
    System.out.println("You will need " + Perimeter + " meters of fence");
   }
}
 
