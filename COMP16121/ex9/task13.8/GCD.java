import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

//Calc GCD of 3 ints
public class GCD extends JFrame implements ActionListener
{

  private final JTextField number1field = new JTextField(20);
  private final JTextField number2field = new JTextField(20);
  private final JTextField number3field = new JTextField(20);
  private final JTextField answerField = new JTextField(20);

  //Constructor
  public GCD()
  {
    //add GUI stuff
    setTitle("GCD");

    Container contents = getContentPane();
    contents.setLayout(new GridLayout(0,1));

    contents.add(new JLabel("Number 1"));
    contents.add(number1field);

    contents.add(new JLabel("Number 2"));
    contents.add(number2field);

    contents.add(new JLabel("Number 3"));
    contents.add(number3field);

    JButton compute = new JButton("Compute");
    compute.addActionListener(this);

    contents.add(compute);
    contents.add(new JLabel("GCD of numbers"));
    contents.add(answerField);


    setDefaultCloseOperation(EXIT_ON_CLOSE);
    pack();
  }

  //compute on button press
  public void actionPerformed(ActionEvent event)
  {


    //get int from input
    int num1=Integer.parseInt(number1field.getText());
    int num2=Integer.parseInt(number2field.getText());
    int num3=Integer.parseInt(number3field.getText());

    //compute and display GDC
    int gcd=MyMath.greatestCommonDivisor(num1,
            MyMath.greatestCommonDivisor(num2,num3));
    answerField.setText(""+gcd);

 }//actionPerformed

  //main
  public static void main(String[] args)
  {
    //show window
    GCD g = new GCD();
    g.setVisible(true);

  }//main

}//GCD
