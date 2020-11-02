//This is used to store polynomials before they are added up
public class QuadPoly
{
     //These are the three variables
     private double coeffic1,coeffic2 ,coeffic3;
  
     //This is used to construct the quadratic formula
     public QuadPoly(double variable1, double variable2, double variable3)
     {
       coeffic1 = variable1;
       coeffic2 = variable2;
       coeffic3 = variable3;

       
     }//QuadPoly

     //This is where the two polynomials are compared to see if they are equal
     public boolean isEquivalentTo (QuadPoly other)
     {
       return coeffic1 == other.getCoeffic1() && getCoeffic2() == other.getCoeffic2()
              && getCoeffic3() == other.getCoeffic3();
     }//Equivalent

     //This is where thhe polynomials are checked to see if the first one is lower than the    
     //second
     public boolean lessThan (QuadPoly other)
     {
       return getCoeffic1() < other.getCoeffic1()
                || getCoeffic1() == other.getCoeffic1()
                  && (getCoeffic2() < other.getCoeffic2() 
                    || getCoeffic2() == other.getCoeffic2() && getCoeffic3() < other.getCoeffic3());
     }//Less Than


     //These three methods get the variables 
     public double getCoeffic1()
     {
       return coeffic1;
     }//Get Coefficient 1

     public double getCoeffic2()
     {
       return coeffic2;
     }//Get Coefficient 2
  
     public double getCoeffic3()
     {
       return coeffic3;
     }// Get Coefficient 3


     //This private method adds up the coefficients
     public QuadPoly AddQuad(QuadPoly other)
     {
       return new QuadPoly(coeffic1 + other.getCoeffic1(), 
                           coeffic2 + other.getCoeffic2(), 
                           coeffic3 + other.getCoeffic3());
     }//Add Quad
                          
     public String toString()
     {
       return coeffic1 + "x^2 +" +
              coeffic2 + "x +" +
              coeffic3 ;
     }//To String
}//Class Quad Poly
