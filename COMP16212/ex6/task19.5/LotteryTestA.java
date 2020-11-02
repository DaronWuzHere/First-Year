public class LotteryTestA
{
  public static void main(String args[])
  {
    SpeedController speedController
      = new SpeedController(SpeedController.HALF_SPEED);

    LotteryGUI gui = new LotteryGUI ("TV Studio", speedController);
   
    TVHost tvHost1 = new TVHost("Will Sam Smith");
    gui.addPerson(tvHost1);

    AudienceMember audienceMember1 = new AudienceMember("Finn Mertens");
    gui.addPerson(audienceMember1);

    Punter punter1 = new Punter("Jake Thedog");
    gui.addPerson(punter1);

    Psychic psychic = new Psychic("Bee Moow");
    gui.addPerson(psychic);

    Director director1 = new Director("Party Patricia");
    gui.addPerson(director1);

    CleverPunter cleverPunter1 = new CleverPunter("Wendy McDonald");
    gui.addPerson(cleverPunter1);

    Worker worker1 = new TraineeWorker("Mister Worldwide", 0);
    gui.addPerson(worker1);

    Teenager teenager1 = new Teenager("Daron Mauricette");
    gui.addPerson(teenager1);

  
  }// Main
}// Lottery Test A
    
