public class LotteryTestC
{
  public static void main(String args[])
  {
    SpeedController speedController
      = new SpeedController(SpeedController.HALF_SPEED);

    LotteryGUI gui = new LotteryGUI ("TV Studio", speedController);
   
    Game game1 = new Game("Lott O’Luck Barcelona", 10,
    "Where is the real Madrid?", 7);
    gui.addGame(game1);

    System.out.println("syso working in test");

    Worker worker1 = new TraineeWorker("Gareth", 0);
    worker1.fillMachine(game1);

    for (int count = 1; count <= game1.getRackSize(); count ++)
    {
     // game1.ejectBall();
    } // for

    game1.rackSortBalls();
    speedController.delay(40);

  
  }// Main
}// Lottery Test A
    
