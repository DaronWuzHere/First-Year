public class RoundPennies
{
  public static void main(String[] args)
  {
    int NPens = Integer.parseInt(args[0]);
    int Pds = (NPens + 50)/100;
    
    System.out.println("Her amount is " + Pds + " pounds");
  }
} 

