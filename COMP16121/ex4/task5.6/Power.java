public class Power
{
  public static void main(String[] args)
  {  
    double base = Double.parseDouble(args[0]); // The base
    double exponent = Double.parseDouble(args[1]); // The exponent
    double orignalBase = base;

    if(exponent == 0)
    {
      System.out.println(1);
    }

    else
    {
      if(exponent < 0)
      {
        for(int count = 1; count < (-exponent); count = count + 1)
          base = (1 / (base * orignalBase));

        System.out.println((1 / base));
      }

      else
      {
        for(int count = 1; count < exponent; count = count + 1)
          base = (base * orignalBase);
    
        System.out.println(base);
      }
     }
  }
} 
    
