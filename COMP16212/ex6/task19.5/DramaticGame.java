public class DramaticGame extends Game
{
  public DramaticGame(String machineName, int machineSize, 
              String rackName, int rackSize)
  {
    super(machineName, machineSize, rackName, rackSize);
  }

  public Machine makeMachine(String machineName, int machineSize) 
  {
    return new DramaticMachine(machineName, machineSize);
  } //Game
 
}


//return (super.Machine.makeMachine(machineName, machineSize));
