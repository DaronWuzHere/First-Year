public class LotteryTestB
{
  public static void main(String args[])
  {
    SpeedController speedController
      = new SpeedController(SpeedController.HALF_SPEED);

    LotteryGUI gui = new LotteryGUI ("TV Studio", speedController);
   
    DramaticGame game1 = new DramaticGame("Lott O’Luck Barcelona", 49,
    "Where is the real Madrid?", 7);
    gui.addGame(game1);

    Worker worker1 = new TraineeWorker("Gareth", 0);
    worker1.fillMachine(game1);

    for (int count = 1; count <= game1.getRackSize(); count ++)
    {
      game1.ejectBall();
    } // for

    game1.rackSortBalls();
    speedController.delay(40);

  
  }// Main
}// Lottery Test A
    
