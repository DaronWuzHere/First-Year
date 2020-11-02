import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

//Stopclock class
public class StopClock extends JFrame implements ActionListener
{
  //if the clock is running
  private boolean isRunning = false;

  //times since 1st jan 1970 in ms
  private long startTime = 0;
  private long stopTime = 0;

  //Labels
  private final JTextField startTimeField = new JTextField("Not Started");
  private final JTextField stopTimeField = new JTextField("Not Started");
  private final JTextField elapsedTimeField = new JTextField("Not Started");
  private final JTextField splitTimeField = new JTextField("Not Started");

  //Buttons
  private final JButton startStopButton = new JButton("Start / Stop");
  private final JButton splitButton = new JButton("Split");

  //constructor
  public StopClock()
  {

    setTitle("Stop Clock");

    Container contents = getContentPane();
    //set layout
    contents.setLayout(new GridLayout(0, 1));
    //add Labels and inactive fields
    contents.add(new JLabel("Started at:"));
    contents.add(startTimeField);
    startTimeField.setEnabled(false);

    contents.add(new JLabel("Finished at:"));
    contents.add(stopTimeField);
    stopTimeField.setEnabled(false);

    contents.add(new JLabel("Split time:"));
    contents.add(splitTimeField);
    splitTimeField.setEnabled(false);

    contents.add(new JLabel("Elapsed time (seconds):"));
    contents.add(elapsedTimeField);
    elapsedTimeField.setEnabled(false);

    startStopButton.addActionListener(this);
    splitButton.addActionListener(this);
    splitButton.setEnabled(false);

    contents.add(startStopButton);
    contents.add(splitButton);

    setDefaultCloseOperation(EXIT_ON_CLOSE);
    pack();
  }//constructor

  //button pressed listener
  public void actionPerformed(ActionEvent event)
  {
    //for startstopbutton
    if(event.getSource()==startStopButton)
    {
      if(isRunning)
      {//if its running stop the timer
        stopTime=System.currentTimeMillis();
        stopTimeField.setText(""+stopTime);
        long elapsedTime = stopTime-startTime;
        elapsedTimeField.setText(""+((elapsedTime)/1000.0));
        isRunning=false;

        startStopButton.setText("Start");
        splitButton.setEnabled(false);
      }else
      {//start the timer

        startTime=System.currentTimeMillis();
        startTimeField.setText(""+startTime);
        stopTimeField.setText("Running...");
        elapsedTimeField.setText("Running...");
        isRunning=true;

        startStopButton.setText("Stop");
        splitButton.setEnabled(true);
      }

    //for splitbutton
    }else if(event.getSource()==splitButton)
    {
      if(isRunning)
      {
        stopTime=System.currentTimeMillis();
        long elapsedTime=stopTime-startTime;
        splitTimeField.setText(""+((elapsedTime)/1000.0));
      }
    }
  }//actionPerformed

  //main
  public static void main(String[] args)
  {

    StopClock sc = new StopClock();
    sc.setVisible(true);
  }//main

}//StopClock


