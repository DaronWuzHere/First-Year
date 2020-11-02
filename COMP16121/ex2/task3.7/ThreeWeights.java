public class ThreeWeights
{
  public static void main(String[] args)
  {
    int w1 = Integer.parseInt(args[0]);
    int w2 = Integer.parseInt(args[1]);
    int w3 = Integer.parseInt(args[2]);
  
    System.out.println((w1 + w2 + w3));
    System.out.println((w1 - w2 + w3));
    System.out.println((w1 - w2 - w3));
    System.out.println((w1 + w2 - w3));
    System.out.println((w1 + w2));
    System.out.println((w1 - w2));
    System.out.println((w1 + w3));
    System.out.println((w1 - w3));
    System.out.println((w2 - w3));
    System.out.println((w2 + w3));
    System.out.println((w2 - w1 - w3));
    System.out.println((w2 - w1 + w3));
    System.out.println((w1));
    System.out.println((w2));
    System.out.println((w3));
    System.out.println((0));
    System.out.println((-w3));
    System.out.println((-w2 + w3));
    System.out.println((-w2));
    System.out.println((-w2 - w3));
    System.out.println((-w1 + w2));
    System.out.println((-w1 + w3));
    System.out.println((-w1));
    System.out.println((-w1 - w3));
    System.out.println((-w1 - w2 + w3));
    System.out.println((-w1 - w2));
    System.out.println((-w1 - w2 - w3));
  }
}
 
