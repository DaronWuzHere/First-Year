import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JScrollPane;

//program to show possible compinations of 3 weights
public class ThreeWeights extends JFrame implements ActionListener
{

  //input fields
  private final JTextField weight1field = new JTextField(5);
  private final JTextField weight2field = new JTextField(5);
  private final JTextField weight3field = new JTextField(5);

  //output field
  private final JTextArea resultArea = new JTextArea(15,20);

  //constructor
  public ThreeWeights()
  {
  
    setTitle("Three Weights");
   
    Container contents = getContentPane();
    contents.setLayout(new BorderLayout());
    
    JPanel numbersPanel = new JPanel(new GridLayout(3,0));
    contents.add(numbersPanel, BorderLayout.NORTH);
    //add input fields

    numbersPanel.add(new JLabel("Weight 1:"));
    numbersPanel.add(weight1field);

    numbersPanel.add(new JLabel("Weight 2:"));
    numbersPanel.add(weight2field);
    
    numbersPanel.add(new JLabel("Weight 3:"));
    numbersPanel.add(weight3field);

    //add center output field
    contents.add(new JScrollPane(resultArea), BorderLayout.CENTER);

    //add lower 
    JButton calculateButton = new JButton("Calculate");
    contents.add(calculateButton,BorderLayout.SOUTH);
    calculateButton.addActionListener(this);

    setDefaultCloseOperation(EXIT_ON_CLOSE);
    pack();
  }//Constructor

  //compute and output on click
  public void actionPerformed(ActionEvent event)
  {

    //clear output
    resultArea.setText("");
  
    //get weights
    int firstWeight = Integer.parseInt(weight1field.getText());
    int secondWeight = Integer.parseInt(weight2field.getText());
    int thirdWeight = Integer.parseInt(weight3field.getText());
   
    //multipliers
    for(int w1mult = -1;w1mult<2;w1mult++)
    {
      for(int w2mult = -1;w2mult<2;w2mult++)
      {
        for(int w3mult = -1;w3mult<2;w3mult++)
        {
          resultArea.append(""+(firstWeight*w1mult +
                                secondWeight*w2mult + 
                                thirdWeight*w3mult)
                            +"\n");
        }//for
      }//for
    }//for
  }//action performed 

  //create and display window
  public static void main(String[] args)
  {
    ThreeWeights w3 = new ThreeWeights();
    w3.setVisible(true);
  }
}//Three Weights





























