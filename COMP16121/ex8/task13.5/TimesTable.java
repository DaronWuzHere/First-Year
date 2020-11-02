import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

//Program to display a greeting to 11 family members, in a window
public class TimesTable extends JFrame
{ 
  //Constructor
  public TimesTable(int multiplier, int rows)
  {
    setTitle("Times Table");
    Container contents = getContentPane();
    //Set layout to be a grid of as many columns as entered
    contents.setLayout(new GridLayout(0 , 5));

    for(int row = 1; row <= rows; row++)
    {
      contents.add(new JLabel("" + row));
      contents.add(new JLabel("    x"));
      contents.add(new JLabel("   " + multiplier)) ;
      contents.add(new JLabel("    ="));
      contents.add(new JLabel("   " + row * multiplier));
    }//For

   setDefaultCloseOperation(EXIT_ON_CLOSE);
   pack();

  }//Constructor

  //Main method to collect the arguments
  public static void main(String[] args)
  {
    TimesTable table = new TimesTable(Integer.parseInt(args[0]),
                                      Integer.parseInt(args[1]));

    table.setVisible(true);
  }//Main
}//Times Table Class

