//This is a program that adds two polynomials together
//It takes six aurguments
//These are the coefficients of x in a polynomial
public class CompareQuadPoly
{  

    private static QuadPoly quadratic1;
    private static QuadPoly quadratic2;

    //Retrieves the stored input from the QuadPoly class
    public static void main(String[] args)
    {
      quadratic1 = new QuadPoly(Double.parseDouble(args[0]),
                                Double.parseDouble(args[1]),
                                Double.parseDouble(args[2]));

      quadratic2 = new QuadPoly(Double.parseDouble(args[3]),
                                Double.parseDouble(args[4]),
                                Double.parseDouble(args[5]));

     printQuad(quadratic1, quadratic2);
    }//Main
  //This adds and prints the polynomials
  private static void printQuad(QuadPoly quadratic1, QuadPoly quadratic2)
  {
   

    if (quadratic1.isEquivalentTo(quadratic2))
    {
      System.out.println("The polynomial:     " + quadratic1.coeffic1 + "x^2 +" 
                         + quadratic1.coeffic2 + "x + " + quadratic1.coeffic3);
      System.out.println("Is equal to:        " + quadratic2.coeffic1 + "x^2 +" 
                         + quadratic2.coeffic2 + "x + " + quadratic2.coeffic3);
    }//If
    else
    {
      if (quadratic1.lessThan(quadratic2))
      {
        System.out.println("The polynomial:     " + quadratic1.coeffic1 + "x^2 +" 
                           + quadratic1.coeffic2 + "x + " + quadratic1.coeffic3);
        System.out.println("Is less than:       " + quadratic2.coeffic1 + "x^2 +" 
                           + quadratic2.coeffic2 + "x + " + quadratic2.coeffic3);
      }//If
      else 
      {
        System.out.println("The polynomial:       " + quadratic1.coeffic1 + "x^2 +" 
                           + quadratic1.coeffic2 + "x + " + quadratic1.coeffic3);
        System.out.println("Is greater than:      " + quadratic2.coeffic1 + "x^2 +" 
                           + quadratic2.coeffic2 + "x + " + quadratic2.coeffic3);
      }//Else
    }//Print Quad          

  }//Print Quad 11:28
}//Add Quad Poly




      
