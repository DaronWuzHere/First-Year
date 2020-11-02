public class DramaticMachine extends Machine 
{
  public DramaticMachine(String machineName, int machineSize) 
  {
    super(machineName, machineSize);
  }

  public Ball ejectBall()
  {
    //choose random ball to eject
    int ballToEject = (int) (Math.random() * getNoOfBalls());

    //flash balls up to chose one
    for(int current = 0;current<=ballToEject;current++)
      getBall(current).flash(4,5);
    
    //get ball to eject
    Ball ejectedBall = getBall(ballToEject);

    swapBalls(ballToEject, getNoOfBalls() -1);
    removeBall();

    return ejectedBall;
    
  } // ejectBall
 
  public String getType()
  {
    return "Dramatic Machine";
  } // getType

}// DramaticMahcine
    
  
