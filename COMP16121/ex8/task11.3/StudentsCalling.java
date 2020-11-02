/**
 * Class for StudentsCalling
 * This is the main class, this is where the story happens. The students can buy credit and   
 * make phone calls. This method will contains mostly print line statements and use the 
 * other methods
 * @author Daron Mauricette
 */
public class StudentsCalling
{
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
    System.out.println();

    System.out.println("The boys topped up aswell");
    System.out.println();

    ally.toppedUp(5);
    harry.toppedUp(20);
    sam.toppedUp(3);
 
    System.out.println(ally.toString());
    System.out.println(sam.toString());
    System.out.println(harry.toString());
    System.out.println();

    System.out.println("The girls all called each other");
    System.out.println();

    verena.call(700);
    diane.call(450);
    zanaii.call(600);

    System.out.println(diane.toString());
    System.out.println(zanaii.toString());
    System.out.println(verena.toString());
    System.out.println();

    System.out.println("The boys called the girls but during the call some ran");
    System.out.println("out of credit");
    System.out.println();

    ally.call(1000);
    sam.call(200);
    harry.call(990);   

    System.out.println(ally.toString());
    System.out.println(sam.toString());
    System.out.println(harry.toString());
    System.out.println();   

    System.out.println("Ally's call dropped");     
    System.out.println("He decided to top up on his own");   
    System.out.println();   

    ally.toppedUp(100);
    System.out.println("He asked his dad for money so now he's good for the month");   
    System.out.println(ally.toString());
    System.out.println();   

    System.out.println("The girls all ran out of credit before the end of the day aswell");   
    System.out.println();   
   
    verena.call(2000);
    diane.call(1000);
    zanaii.call(1600);     

    System.out.println(diane.toString());
    System.out.println(zanaii.toString());
    System.out.println(verena.toString());
    System.out.println();

   }
}











