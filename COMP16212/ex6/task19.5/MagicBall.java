import java.awt.Color;

public class MagicBall extends Ball
{

  private enum State {NORMAL,FLASHING,INVISIBLE,COUNTING};
  private State state;
  private int perceivedValue;

  public MagicBall(int requiredValue, Color c)
  {
    super(i,c);
    //set the state to normal to begin
    state = State.NORMAL;
    //set the perceived value for when counting to start at 0
    perceivedValue = 0;
  }



  public int getValue()
  {
    if(state==State.COUNTING)
    {
      //if in a counting state increase value till 100
      perceivedValue=(perceivedValue+1)%100;
      //getImage().update();
      return perceivedValue;
    }else
    {
      //if not in a cutning state act normally
      return super.getValue();

    }
  }

  //overried to use magicBallImage instead
  public BallImage makeImage()
  { 
    return new MagicBallImage(this);
  }

  public void doMagic(int spellNumber)
  {
    switch(spellNumber)
    {
      case 1:
      //if it is spell number one, go to the next state
        switch(state)
        {
          case NORMAL: state = State.FLASHING;break;
          case FLASHING: state = State.INVISIBLE;break;
          case INVISIBLE: state = State.COUNTING;break;
          case COUNTING: state = State.NORMAL;break;
        }
        break;

      //if it is spell number two, go to the normal state
      case 2: state = State.NORMAL;break;
      default:break;
    }

    getImage().update();
  
  }


  public boolean isVisible()
  {
    //return false only if its in the invisible state
    if(state == State.INVISIBLE)
    {
      return false;
    }else
    {
      return true;
    }   

  }
  

  public boolean isFlashing()
  {
    //return true onluy if its in the flashing state
    if(state == State.FLASHING)
    {
      return true;
    }else
    {
      return false;
    }
  } 

}
