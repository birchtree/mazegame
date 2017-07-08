import java.util.*;
/**
 * Class that contains all the logic to model a Maze with Treasures, Monsters, and an Explorer.
 * 
 * @author Melissa James 
 * @version 5/10/13
 */
public class Maze
{
   // named constants
   public static final int ACTIVE = 0;
   public static final int EXPLORER_WIN = 1;
   public static final int MONSTER_WIN = 2;
    
    // instance variables
   private Square[][] maze;
   private ArrayList<RandomOccupant> randOccupants;
   private Explorer explorer;
   private int rows;
   private int cols;

   /**
    * Constructor for objects of class Maze
    */
   public Maze(Square[][] maze, int rows, int cols)
   {
      // initialize the maze, rows, and cols instance variables
		  this.maze = maze;
      this.rows = rows;
      this.cols = cols;
      //  - create the empty ArrayList of RandomOccupants
		  this.randOccupants = new ArrayList<RandomOccupant>();
   }
	
   // QUERIES
   public Square getSquare(int row, int col) { return maze[row][col]; }
   public int rows() {return rows;}
   public int cols() {return cols;}
   public String explorerName() {return explorer.name();}
   public Explorer getExplorer() {return explorer;}
    
   //  - Implement the following two methods.  I have them stubbed to return dummy values just so it will compile.
   //          Your getRandomOccupant should return the occupant from the ArrayList at the specified index.
   public RandomOccupant getRandomOccupant(int index) 
   {
      return this.randOccupants.get(index);
   }
   public int getNumRandOccupants() {return this.randOccupants.size();}
	
   // COMMANDS
   //  - implement the following method
   public void addRandomOccupant(RandomOccupant ro) {  this.randOccupants.add(ro);}
	
   public void setExplorer(Explorer e) {explorer = e;}
	
   public void explorerMove(int key)
   {
      explorer.move(key);
   }
	
   public void randMove()
   {
      for(int i = 0; i < getNumRandOccupants(); i++)
      {
        RandomOccupant thing = getRandomOccupant(i);
        thing.move();
      }
      //  - instruct each object in the RandomOccupant to move
   }
	
   /**
    * Returns the status of the game.
    *
    * If all treasures have been found, return EXPLORER_WIN.
    * If not, check each maze occupant, if it is a Monster and
    *   it is in the same location as the Explorer, return
    *   MONSTER_WIN.  Note that you can use == to check locations, do you know why?
    * Otherwise, return ACTIVE.
    */
   public int gameStatus()
   {
      int status = ACTIVE;
        
      if(foundAllTreasures())
      {
        status = EXPLORER_WIN;
      }
      // CHANGE - implement
      for(int i = 0; i < getNumRandOccupants(); i++)
      {
        if(getRandomOccupant(i).getClass() == Monster.class)
        {
           if(explorer.location() == getRandomOccupant(i).location())
           {
               return MONSTER_WIN;
           }
        }
      }
      return status;
   }
	
   private boolean foundAllTreasures()
   {
      boolean foundAll = true;
        
      //  - search through all the occupants to see if the Treasures have been found.  Return false if
      // there is a Treasure that hasn't been found.
      for(int i = 0; i < getNumRandOccupants(); i++)
      {
         if(getRandomOccupant(i).getClass() == Treasure.class)
         {
           Treasure treasure = (Treasure)getRandomOccupant(i);
           Boolean isItFound = treasure.found();
           if(!isItFound)
           {
               foundAll = false;
           }
         }
         
      }

      return foundAll;
   }
    
   public void lookAround(Square s)
   {
      int row = s.row();
      int col = s.col();

      // Clear what was previously in view
      resetInView();
          
      // Set the current square so that we are viewing it (obviously)
      s.setInView(true);

      //  - Check the adjacent squares.  If there isn't a wall in the way, set their inview to true.

      if(row - 1 >= 0)
      {
        Square upSquare = getSquare(row - 1, col);
        if(s.wall(Square.UP) == false){upSquare.setInView(true);}
      }
      if(col + 1 < cols())
      {
        Square rightSquare = getSquare(row, col + 1);
        if(s.wall(Square.RIGHT) == false){rightSquare.setInView(true);}
      }
      if(row + 1 < rows())
      {
        Square downSquare = getSquare(row + 1, col);  
        if(s.wall(Square.DOWN) == false){downSquare.setInView(true);}
      }
      if(col - 1 >= 0)
      {
        Square leftSquare = getSquare(row, col - 1);
        if(s.wall(Square.LEFT) == false){leftSquare.setInView(true);}
      }

      // - Check the diagonal squares.  If there isn't a wall in the way, set their inview to true.
      
      if(row - 1 >= 0 && col - 1 >= 0)
      {
        Square upLeftSquare = getSquare(row - 1, col - 1);
        if((s.wall(Square.UP) == false && 
           upLeftSquare.wall(Square.RIGHT) == false) || 
          (upLeftSquare.wall(Square.DOWN) == false && 
             s.wall(Square.LEFT) == false))
          {upLeftSquare.setInView(true);}
      }
      if(row - 1 >= 0 && col + 1 < cols())
      {
        Square upRightSquare = getSquare(row - 1, col + 1);
        if((upRightSquare.wall(Square.DOWN) == false && 
            s.wall(Square.RIGHT) == false) || 
          (upRightSquare.wall(Square.LEFT) == false && 
            s.wall(Square.UP) == false))
          {upRightSquare.setInView(true);}
      }
      if(row + 1 < rows() && col + 1 < cols())
      {
        Square downRightSquare = getSquare(row + 1, col + 1);
        if((downRightSquare.wall(Square.LEFT) == false && 
            s.wall(Square.DOWN) == false) || 
          (s.wall(Square.RIGHT) == false && 
            downRightSquare.wall(Square.UP) == false))
          {downRightSquare.setInView(true);}
      }
      if(row + 1 < rows() && col - 1 >= 0)
      {
        Square downLeftSquare = getSquare(row + 1, col - 1);
        if((downLeftSquare.wall(Square.UP) == false && 
             s.wall(Square.LEFT) == false) || 
          (downLeftSquare.wall(Square.RIGHT) == false && 
             s.wall(Square.DOWN) == false))
          {downLeftSquare.setInView(true);}
      }
   }
    
   private void resetInView()
   {
      for (int i = 0; i<rows; i++) {
         for (int j = 0; j<cols; j++) {
            maze[i][j].setInView(false);
         }
      }
   }
}
