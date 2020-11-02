public class SinTable
{
  public static void main(String[] args)
  {
    double fromAngle = Double.parseDouble(args[0]);
    double increment = Double.parseDouble(args[1]);
    double toAngle = Double.parseDouble(args[2]);
    double sinAngle = 0;
    double differenceAngle = 0;


    differenceAngle = (differenceAngle + (toAngle - fromAngle));

    System.out.println(" ------------------------------------------------------------------------- ");
    System.out.println(" | Sin table from " + fromAngle + " to " + toAngle + " in steps of " + increment );
    System.out.println(" ------------------------------------------------------------------------- ");

    for (double count = 0; count <= (differenceAngle); count = count + increment)
    {
      sinAngle = (Math.sin(Math.toRadians(fromAngle)));
      System.out.println("| sin(" + fromAngle + ") = " + sinAngle);
     
      fromAngle = (fromAngle + increment);
    }
    

    System.out.println(" ------------------------------------------------------------------------- ");
  }
}

