//This is a program that adds two polynomials together
//It takes six aurguments
//These are the coefficients of x in a polynomial
public class AddQuadPoly
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
    System.out.println("Polynomial:      " + quadratic1.toString());

    System.out.println("Added to:        " + quadratic2.toString());

    System.out.println("Results in:      " + (quadratic1.AddQuad(quadratic2)).toString());
  }//Print Quad
}//Add Quad Poly




      
