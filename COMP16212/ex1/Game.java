public class Game
{

// ----------------------------------------------------------------------
// Part a: the score message
  private String scoreMessage;
  //Variable to store the score message
  
  //The method to return the score message
  public String getScoreMessage()
  {
     return scoreMessage;
  } // getScoreMessage
  
  //The method to turn string into the message
  public void setScoreMessage(String message)
  { 
    scoreMessage = message;
  } // setScoreMessage

  //My name
  public String getAuthor()
  {
    return "Daron Mauricette";
  } // getAuthor


// ----------------------------------------------------------------------
// Part b: constructor and grid accessors
  private final int gridSize;
  //The variable to store the size of the grid

  private final Cell[][] grid;
  //The array of cells that the game operates on

  //The method that initializes the grid
  public Game(int requiredGridSize)
  {
    gridSize = requiredGridSize;
    grid = new Cell [requiredGridSize][requiredGridSize];
    //Sets the size of the array with the required size

    //For loop to make each tile a cell for the game
    for (int x = 0; x < requiredGridSize; x++)
      for (int y = 0; y < requiredGridSize; y++)
        grid[x][y] = new Cell();
  }

  //This method returns the size of the grid
  public int getGridSize()
  {
    return gridSize;
  } // getGridSize

  //This metho returns the cell 
  public Cell getGridCell(int x, int y)
  {
    return grid[x][y];
  } // getGridCell


// ----------------------------------------------------------------------
// Part c: initial game state

// Part c-1: setInitialGameState method

  private int score;
  // Variable to store the score


  //This method places the food and passes on the required variables to the rest
  //of the methods
  public void setInitialGameState(int requiredTailX, int requiredTailY,
                                  int requiredLength, int requiredDirection)
  {
    for (int x = 0; x < gridSize; x++)
      for(int y = 0; y < gridSize; y++)
        grid[x][y].setClear();
    placeSnake(requiredTailX, requiredTailY,
               requiredLength, requiredDirection);
    placeFood();
    setSnakeDirection(requiredDirection);
    score = 0;
    
  } // setInitialGameState
    
// ----------------------------------------------------------------------
// Part c-2 place food
  int x;
  //This is the x coordinate of the food image

  int y;
  //This is the y coordinate of the food image

  //This method places the food in cells that are not preoccupied
  public void placeFood()
  {
    do 
    {
      x = (int) (Math.random() * gridSize);
      y = (int) (Math.random() * gridSize);
    } // Do
    while (grid[x][y].getType() != Cell.CLEAR);
      grid[x][y].setFood();
  }// Place Food
  

// ----------------------------------------------------------------------
// Part c-3: place snake
  int headX;
  //Variable for the x coordinate of the snake's head
  int headY;
  //Variable for the y coordinate of the snake's head
  int tailX;
  //Variable for the x coordinate of the snake's tail
  int tailY;
  //Variable for the y coordinate of the snake's tail
  int snakeLength;
  //Variable for the length of the snake
  int snakeDirection;
  //Vairable  for the direction of the snake
  int nextCellX;
  //Variable for the next x coordinate of the snake's body
  int nextCellY;
  //Variab;e for the next y coordinate of the snake's body
  int nextHeadX;
  //Variable for the next x coordinate of the snake's head
  int nextHeadY;
  //Variable for the next y coordinate of the snake's head
  int nextBodyX;
  //Variable for the next x coordinate of the snake's moving body
  int nextBodyY;
  //Variable for the next y coordinate of the snake's moving body
     

  //This method places the snake
  public void placeSnake(int requiredTailX, int requiredTailY,
                         int requiredLength, int requiredDirection)
  { 
    snakeLength = requiredLength;
    headX = requiredLength - 1;
    headY = requiredLength - 1; 
    tailX = requiredTailX;
    tailY = requiredTailY;
    snakeDirection = requiredDirection;
  
    //This places the tail
    grid[tailX][tailY].setSnakeTail(Direction.opposite(snakeDirection),
                    	                               snakeDirection);
 
    //This for loop places the snake body
    for (int i = 1; snakeLength > i; i++)
    { 
      nextCellX = tailX + i * Direction.xDelta(snakeDirection);
      nextCellY = tailY + i * Direction.yDelta(snakeDirection);
      grid[nextCellX][nextCellY].setSnakeBody
      (Direction.opposite(snakeDirection), snakeDirection);
    }// For

     // This places the Head    
    nextHeadX = tailX + headX * Direction.xDelta(snakeDirection);
    nextHeadY = tailY + headY * Direction.yDelta(snakeDirection);  
    grid[nextHeadX][nextHeadY].setSnakeHead
    (Direction.opposite(snakeDirection), snakeDirection);
     
     
   } //placeSnake

// ----------------------------------------------------------------------
// Part d: set snake direction
  public void setSnakeDirection(int requiredDirection)
  {
    int direction = requiredDirection;
    int opposite = Direction.opposite(snakeDirection);

    //This if statement doesn't let you run into anything
    if (opposite == direction) 
    {
      setScoreMessage("That's suicide!");
      crash(true);
    } // If
    else
    {
      grid[nextHeadX][nextHeadY].setSnakeOutDirection(direction);
      snakeDirection=requiredDirection;
    } // Else
  } // setSnakeDirection


// ----------------------------------------------------------------------
// Part e: snake movement

// Part e-1: move method
  
  public void move(int moveValue)
  { 
    //If statement checks if the snake is bloody

    if (grid[nextHeadX][nextHeadY].isSnakeBloody() == false)
      nextHeadX = nextHeadX + 1 * Direction.xDelta(snakeDirection);
      nextHeadY = nextHeadY + 1 * Direction.yDelta(snakeDirection);
      

      if ((nextHeadX > gridSize) || (nextHeadY > gridSize) 
      || (nextHeadX < 0) || (nextHeadY < 0))
        crash(true);
      else
      {
       crash(false);
       moveSnakeHead(nextHeadX, nextHeadY);
       if (grid[nextHeadX][nextHeadY].getType() == Cell.FOOD)
       { 
       // Eat the food
          snakeFood();
       }else
       {moveSnakeTail();}
        //moveSnakeTail();
      } 
    
        
  } // move


// ----------------------------------------------------------------------
// Part e-2: move the snake head
  public void moveSnakeHead(int nextHeadX, int nextHeadY)
  {
    nextBodyX = nextHeadX;
    nextBodyY = nextHeadY;
 
    //Make the cells of the snake head, the body
    
    //Then add one to the snake head to allow movement
    grid[nextBodyX][nextBodyY].setSnakeHead(Direction.opposite(snakeDirection),
    snakeDirection);

    //Then move the body
    grid[nextBodyX-Direction.xDelta(snakeDirection)][nextBodyY-Direction.yDelta
    (snakeDirection)].
    setSnakeBody();
     
  } // Move Snake Head

// ----------------------------------------------------------------------
// Part e-3: move the snake tail
  public void moveSnakeTail()
  {
      int tailDirection = grid[tailX][tailY].getSnakeOutDirection();
      grid[tailX][tailY].setClear();
      tailX += Direction.xDelta(tailDirection);
      tailY += Direction.yDelta(tailDirection);
      grid[tailX][tailY].setSnakeTail();
     // (Direction.opposite(snakeDirection), snakeDirection);
  } // move snake tail

  
// ----------------------------------------------------------------------
// Part e-4: check for and deal with crashes
  public void crash(boolean crashed)
  {
    //grid[nextHeadX - 1][nextHeadY - 1].setSnakeBloody(true);
  }
// ----------------------------------------------------------------------
// Part e-5: eat the food
  public void snakeFood()
  {
      grid[nextBodyX][nextBodyY].
      setSnakeBody(Direction.opposite(snakeDirection), snakeDirection);
  }
  public int getScore()
  {
    return score;
  } // getScore

// ----------------------------------------------------------------------
// Part f: cheat


  public void cheat()
  {
  } // cheat


// ----------------------------------------------------------------------
// Part g: trees


  public void toggleTrees()
  {
  } // toggleTrees


// ----------------------------------------------------------------------
// Part h: crash countdown


// ----------------------------------------------------------------------
// Part i: optional extras


  public String optionalExtras()
  {
    return "  No optional extras defined\n";
  } // optionalExtras


  public void optionalExtraInterface(char c)
  {
    if (c > ' ' && c <= '~')
      setScoreMessage("Key " + new Character(c).toString()
                      + " is unrecognised (try h)");
  } // optionalExtraInterface

} // class Game
