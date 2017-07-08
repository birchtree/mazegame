import java.awt.*;
import java.util.*;
/**
 * Class that determines where the player is moving
 *
 * @author Melissa James
 * @version 5/10/13
 */

public abstract class RandomOccupant extends Occupant
{
   private Random random;
   private Maze maze;

   public RandomOccupant(Maze maze)
   {
      super();
      this.maze = maze;
      int rows = maze.rows();
      int cols = maze.cols();
      random = new Random();
      int row = random.nextInt(rows);
      int col = random.nextInt(cols);

      Square location = maze.getSquare(row, col);
      moveTo(location);
   }

   public RandomOccupant(Maze maze, long seed)
   {
      super();
      this.maze = maze;
      int rows = maze.rows();
      int cols = maze.cols();
      random = new Random(seed);
      int row = random.nextInt(rows);
      int col = random.nextInt(cols);

      Square location = maze.getSquare(row, col);
      moveTo(location);
   }

   public RandomOccupant(Maze maze, Square location)
   {
      super(location);
      random = new Random();
      this.maze = maze;
   }

   public void move()
   {
      Square location = location();
      int row = location.row();
      int col = location.col();
      int rows = maze.rows();
      int cols = maze.cols();

      int randomNum = random.nextInt(4);
      while(location.wall(randomNum))
      {
         randomNum = random.nextInt(4);
      }
      if(!location.wall(randomNum) )
       //  && row - 1 >= 0 
        // && row + 1 < rows 
        // && col - 1 >= 0 
        // && col + 1 < cols)
      {
         if(randomNum == Square.UP)
         {
            Square newLocation = maze.getSquare(row - 1, col);
            moveTo(newLocation);
         }
         if(randomNum == Square.RIGHT)
         {
            Square newLocation = maze.getSquare(row, col + 1);
            moveTo(newLocation);
         }
         if(randomNum == Square.DOWN)
         {
            Square newLocation = maze.getSquare(row + 1, col);
            moveTo(newLocation);
         }
         else if(randomNum == Square.LEFT)
         {
            Square newLocation = maze.getSquare(row, col - 1);
            moveTo(newLocation);
         }
      }
   }
}