package robot;

import java.util.*;
import java.lang.Math.*;

public class RobotBeliefState{

  /**
     This is the class representing the robot's belief state. Some of
     the methods contain dummy code, however. Functioning versions of
     these methods can be found in the final subclass
     SolutionRobotBeliefState

  */


  protected double[][][] beliefMatrix;
  protected double[][] positionBeliefMatrix;
  protected double[] orientationBeliefMatrix;

  protected double maxPositionProbability;
  protected double maxOrientationProbability;

  protected double[][][] workMatrix; 

  protected String statusString;    

  public WorldMap map;             // Accurate map of the world

  protected ProbActionToggler probActionToggler; 


  // Set up constants

    public RobotBeliefState(WorldMap m, ProbActionToggler probActionToggler1){

    // Set map
    map= m;
    statusString= "Student's code"; // string telling the demonstrator code is ok
    initializeMatrices();
    probActionToggler= probActionToggler1;
  }

  public void initializeMatrices(){

    // Initialize matrices    
    beliefMatrix= 
      new double[RunRobot.SIZE][RunRobot.SIZE][RunRobot.SIZE];
    workMatrix= 
      new double[RunRobot.SIZE][RunRobot.SIZE][RunRobot.SIZE];
    positionBeliefMatrix=
      new double[RunRobot.SIZE][RunRobot.SIZE];
    orientationBeliefMatrix=
      new double[RunRobot.SIZE];

    int count = 0; // This count records the occupied spaces
    int occupiedNo; // This is number of occupied squares
    //WorldMap space = new WorldMap();
    //For loop to set the probability of occupied spaces to 0.
    for(int i= 0;i < RunRobot.SIZE; i++)   
      for(int j= 0;j < RunRobot.SIZE; j++)
        if (map.isOccupied(i, j))
        {
          count++;
          for(int k= 0;k < RunRobot.SIZE; k++)
            beliefMatrix[i][j][k]= 0; 
        }// If 
        else
        { 
          //I not occupied, sets the real proability.
          //occupiedNo = RunRobot.SIZE - count;
          //for(int k= 0;k < RunRobot.SIZE; k++)
            //beliefMatrix[i][j][k]= (1 / occupiedNo);
        }// Else


    for(int i= 0;i < RunRobot.SIZE; i++)   
    {
      for(int j= 0;j < RunRobot.SIZE; j++)
      {
         for(int k=0;k<RunRobot.SIZE;k++)
         {occupiedNo = RunRobot.SIZE - count;
beliefMatrix[i][j][k]= (1 / (double)(100*occupiedNo));
}}}
       
    updateMaxProbabilities(); // Update member variables used by public access 
                              // functions. (Do not change this line.)
  }


  public double getPoseProbability(Pose pose){
    /** 
	Return the probability that the robot is currently in Pose pose
    */
    return beliefMatrix[pose.x][pose.y][pose.theta];
  }

  public double getPositionProbability(int x, int y){
    /** 
	Return the probability that the robot is currently in position (x,y)
    */

    return positionBeliefMatrix[x][y];   
  }

  public double getOrientationProbability(int t){
    /** 
	Return the probability that the robot currently has orientation theta
    */
    return orientationBeliefMatrix[t];
  }

  protected void fixWorkMatrix(Observation o){

  }

  public void updateProbabilityOnObservation(Observation o){
    //Objects of the classes WorldMap and Pose
    WorldMap prob = new WorldMap();
    Pose p = new Pose();
    for(int i= 0;i < RunRobot.SIZE; i++)
      for(int j= 0;j < RunRobot.SIZE; j++)
	for(int t= 0;t < RunRobot.SIZE; t++)
        {
          //Uses the pose constructor method.
          new Pose(i, j, t);
          workMatrix[i][j][t] = prob.getObservationProbability(p, o);
	  beliefMatrix[i][j][t] = workMatrix[i][j][t];
        }

    updateMaxProbabilities();  // Update member variables used by public access 
                               // functions. (Do not change this line.)
  }


  public void updateProbabilityOnAction(Action a){
    //Initialize workMatrix to zero.
    Arrays.fill(workMatrix, 0);
    WorldMap action = new WorldMap();
    Pose tempPose= new Pose(); // Work variable
    if (!probActionToggler.probActions())
    {
      for(int x= 0;x < RunRobot.SIZE; x++)
        for(int y= 0;y < RunRobot.SIZE; y++)
          for(int t= 0;t < RunRobot.SIZE; t++)
          {
            new Pose(x, y, t);
            action.fillPoseOnAction(tempPose, x, y, t, a);
            workMatrix[x][y][t] += beliefMatrix[x][y][t];
            map.fillPoseOnAction(tempPose, x, y, t, a);
          }
    }// If
    else
    {
       //Had to initialize u as an Action
       Action u = new Action();
      //For loop to calculate the parameter that has been subject to random
      //random variation.
      for(int x= 0;x < RunRobot.SIZE; x++)
        for(int y= 0;y < RunRobot.SIZE; y++)
          for(int t= 0;t < RunRobot.SIZE; t++)
            for(int i  = 0;i  <20;i++)
            {
              map.fillPoseOnAction(tempPose, x, y, t, u);
              WorldMap.probabilify(10, i);
              workMatrix[x][y][t] += beliefMatrix[x][y][t];  
            }            
     }// Else

     for(int x= 0;x < RunRobot.SIZE; x++)
        for(int y= 0;y < RunRobot.SIZE; y++)
          for(int t= 0;t < RunRobot.SIZE; t++)
          {
            beliefMatrix[x][y][t] = workMatrix[x][y][t];
          }        
    updateMaxProbabilities();  // Update member variables used by public access 
                               // functions. (Do not change this line.)
  }

  public double getMaxPositionProbability(){
    return maxPositionProbability;
  }

  public double getMaxOrientationProbability(){
    return maxOrientationProbability;
  }

  protected void updateMaxProbabilities(){

    double temp;
    maxPositionProbability= 0;
    for(int x= 0; x< RunRobot.SIZE; x++)
      for(int y= 0; y< RunRobot.SIZE; y++){
	temp= 0;
	for(int k= 0; k< RunRobot.SIZE; k++)
	  temp+=beliefMatrix[x][y][k];
	positionBeliefMatrix[x][y]= temp;
	if(positionBeliefMatrix[x][y]>maxPositionProbability)
	  maxPositionProbability= positionBeliefMatrix[x][y];
      }

    maxOrientationProbability= 0;
    for(int t= 0; t< RunRobot.SIZE; t++){
	temp= 0;
	for(int i= 0; i< RunRobot.SIZE; i++)
	  for(int j= 0; j< RunRobot.SIZE; j++)
	    temp+=beliefMatrix[i][j][t];
	orientationBeliefMatrix[t]= temp;
	if(orientationBeliefMatrix[t]>maxOrientationProbability)
	  maxOrientationProbability= orientationBeliefMatrix[t];
    }
  }

}
