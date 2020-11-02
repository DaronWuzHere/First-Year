import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JLabel;

//Program to display a Hello World program in French using a GUI
public class HelloWorld extends JFrame
{
  //Constructor
  public HelloWorld()
  {
    setTitle("Hello World");
    Container contents = getContentPane();
    contents.add(new JLabel("Salutations a ceux qui habitent sur la planete Terre!"));
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    pack();
  }//Hello World


  //Create a HelloWorld and make it appear on screen
  public static void main (String[] args)
  {
    HelloWorld theHelloWorld = new HelloWorld();
    theHelloWorld.setVisible(true);
  }//Main

}//Class Hello World
