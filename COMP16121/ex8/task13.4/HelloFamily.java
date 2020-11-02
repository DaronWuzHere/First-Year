import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;


//Program to display a greeting to 11 family members, in a window
public class HelloFamily extends JFrame
{
  //Constructor
  public HelloFamily()
  {
    setTitle("Hello Family");

    Container contents = getContentPane();
    //Set layout to be a grid of 4 columns
    //This will also give 3 rows, as there are 12 items
    contents.setLayout(new GridLayout(0 , 3, 20, 10));
    contents.add(new JLabel("Hello Christopher aka my uncle!"));
    contents.add(new JLabel("Hello Cynthia aka my aunt!"));
    contents.add(new JLabel("Hello Daron aka myself!"));
    contents.add(new JLabel("Hello Diana aka grandma!"));
    contents.add(new JLabel("Hello Diane aka my mom!"));
    contents.add(new JLabel("Hello Dylan aka my brother!"));
    contents.add(new JLabel("Hello Hilary aka my uncle!"));
    contents.add(new JLabel("Hello Imani aka my cousin!"));
    contents.add(new JLabel("Hello Olive aka my aunt!"));
    contents.add(new JLabel("Hello Oliver aka my grandad!"));
    contents.add(new JLabel("Hello Stanley aka my uncle!"));
    contents.add(new JLabel("Hello Victoria aka my aunt!"));

    setDefaultCloseOperation(EXIT_ON_CLOSE);
    pack();
  }// Hello Family
  
  //Creat a Hello Family and make it appear on screen
  public static void main(String[] args)
  {
    HelloFamily theHelloFamily = new HelloFamily();
    theHelloFamily.setVisible(true);
  }//Main

}// Class Hello Family
