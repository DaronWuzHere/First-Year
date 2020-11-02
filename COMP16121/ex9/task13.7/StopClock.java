import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JFrame;

//A Stop Clock with a button that starts, stops and splits the clock.
//This clock shows the start time, stop time, elasped time and split time.

public class StopClock extends JFrame implements ActionListener
{
  //True only if clock is running
  private boolean clockRunning = false;

  //The time when the clock started in milliseconds
  private long startTime = 0;
 
  //The time from when the clock is split
  private long splitTime = 0;

  //The time when the clock stops
  private long stopTime = 0;

  //The time of the clock while running
  private long runningClock = 0;

  //The start time label
  private final JLabel startTimeJLabel = new JLabel("Not Started");
 
  //The stop time label
  private final JLabel stopTimeJLabel = new JLabel("Not Started");

  //The split time label
  private final JLabel splitTimeJLabel = new JLabel("Not Started");

  //The elasped time label
  private final JLabel runningClockJLabel = new JLabel("Not Started");

  //The button to start or stop
  private final JButton startStopJButton = new JButton("Start / Stop");

  //The button to split
  private final JButton splitJButton = new JButton("Split");

  //The Constructor
  public StopClock()
  {
    setTitle("Stop Clock");
 
    Container contents = getContentPane();
    //This grid layout used one column
    contents.setLayout(new GridLayout(0,1));

    contents.add(new JLabel("Started At:"));
    contents.add(startTimeJLabel);

    contents.add(new JLabel("Stopped At:"));
    contents.add(stopTimeJLabel);

    contents.add(new JLabel("Split:"));
    contents.add(splitTimeJLabel);

    contents.add(new JLabel("Elasped time (seconds):"));
    contents.add(runningClockJLabel);

    //This is the start stop button
   
    startStopJButton.addActionListener(this);
    contents.add(startStopJButton);

    //This is the split button
   
    splitJButton.addActionListener(this);
    contents.add(splitJButton);

    setDefaultCloseOperation(EXIT_ON_CLOSE);
    pack();
  }//Stop Clock

    //Perform an action if clock is running
    public void actionPerformed(ActionEvent event)
    {
      if (event.getSource() == startStopJButton)
      { 

        if(!clockRunning)
        {
          //Start the clock
          startTime = System.currentTimeMillis();
          startTimeJLabel.setText("" + startTime);
          stopTimeJLabel.setText("Running...");
          runningClockJLabel.setText("Running..");
          clockRunning = true;
        }//If 
        else 
        {
          //Stop the clock and show the updated times
          stopTime = System.currentTimeMillis();
          stopTimeJLabel.setText("" + stopTime);         
          long runningTime = stopTime - startTime;
          runningClockJLabel.setText("" + runningTime / 1000.0);
          clockRunning = false;

        pack();
        }//Else
      }//If

      if (event.getSource() == splitJButton)
      {        
        //Split the clock
        splitTime = System.currentTimeMillis();
        long split = splitTime - startTime;
        splitTimeJLabel.setText("" + split / 1000.0);
      }//If

      pack();
    }//Action Performed


  public static void main(String[] args)
  {
    StopClock theStopClock = new StopClock();
    theStopClock.setVisible(true);
  }//Main

}// class Stop Clock
          
        
   

    




















