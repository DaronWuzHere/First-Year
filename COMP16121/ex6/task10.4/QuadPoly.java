//This is used to store polynomials before they are added up
public class QuadPoly
{
     //These are the three variables
     public double coeffic1,coeffic2 ,coeffic3;
  
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
       return coeffic1 == other.coeffic1 && coeffic2 == other.coeffic2
              && coeffic3 == other.coeffic3;
     }//Equivalent

     //This is where thhe polynomials are checked to see if the first one is lower than the    
     //second
     public boolean lessThan (QuadPoly other)
     {
       return coeffic1 < other.coeffic1
                || coeffic1 == other.coeffic1
                  && (coeffic2 < other.coeffic2 
                    || coeffic2 == other.coeffic2 && coeffic3 < other.coeffic3);
     }//Less Than

     public String toString()
     {
       return coeffic1 + "x^2 +" +
              coeffic2 + "x +" +
              coeffic3 ;
     }//To String
}//Class Quad Poly
