/**
 * Students Calling Class
 * This is the main class, this is where the story happens. The students can buy credit and  
 * make phone calls. This method will contains mostly print line statements and use the other 
 * methods contained in the task 11.3 folder.
 * @author Daron Mauricette
 */
public class StudentsCalling
{
  /**
   * Outputs a story about Students and phones
   * 
   * @param name - The names that are used in the story
   */
  public static void main(String[] arg)
  {
    Student sam = new Student("Sam Edwards");
    Student harry = new Student("Harry Taylor");
    Student ally = new Student("Ally Warnerbro");
    Student verena = new Student("Verena Dittrich");
    Student diane = new Student("Diane Charles");
    Student zanaii = new Student("Zanaii Collin");
   //The names of the students
  
   System.out.println("All student love phones");
   System.out.println();
  
   System.out.println(sam.toString());
   System.out.println(harry.toString());
   System.out.println(ally.toString());
   System.out.println(verena.toString());
   System.out.println(diane.toString());
   System.out.println(zanaii.toString());
   System.out.println();

   System.out.println("All the girls decided to buy phones");
   System.out.println();

   diane.newPhone(new Phone ("iPhone", new Account("Diane's Account")));
   verena.newPhone(new Phone ("Samsung", new Account("Verena's Account")));
   zanaii.newPhone(new Phone ("iPhone", new Account("Zanaii's Account")));
   
   System.out.println("All girls topped their phones up");
   System.out.println();
  
   diane.toppedUp(10);
   verena.toppedUp(20);
   zanaii.toppedUp(10);

   System.out.println(diane.toString());
   System.out.println(zanaii.toString());
   System.out.println(verena.toString());
   
   System.out.println("The boys got jealous and wanted to buy phones aswell");
   System.out.println();
   
   ally.newPhone(new Phone ("iPhone", new Account("Ally's Account")));
   sam.newPhone(new Phone ("Samsung", new Account("Sam's Account")));
   harry.newPhone(new Phone ("iPhone", new Account("Harry's Account")));
 
   System.out.println(ally.toString());
   System.out.println(sam.toString());
   System.out.println(harry.toString());

   System.out.println("The boys topped up aswell");
   System.out.println();

   ally.toppedUp(5);
   harry.toppedUp(20);
   sam.toppedUp(3);
 
   System.out.println(ally.toString());
   System.out.println(sam.toString());
   System.out.println(harry.toString());

   

  }
}











