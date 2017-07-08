import java.awt.event.KeyEvent;
import java.util.*;
/**
 * Class that determines where the player is moving
 *
 * @author Melissa James
 * @version 5/10/13
 */

public class Explorer extends Occupant
{
   private String name;
   private Maze maze;

   public Explorer(Square location, Maze maze, String name)
   {
      super(location);
      this.maze = maze;
      this.name = name;

      maze.lookAround(location);
   }

   public String name()
   {
      return name;
   }

   public void move(int key)
   {
      Square location = location();
      int row = location.row();
      int col = location.col();

         if(key == KeyEvent.VK_KP_LEFT || key == KeyEvent.VK_LEFT) // LEFT
         {
            if(!location.wall(Square.LEFT))
            {
               Square newLocation = maze.getSquare(row, col - 1);
               moveTo(newLocation);
            }
         }
         
         else if(key == KeyEvent.VK_KP_RIGHT || key == KeyEvent.VK_RIGHT) // RIGHT
         {
            if(!location.wall(Square.RIGHT))
            {
               Square newLocation = maze.getSquare(row, col + 1);
               moveTo(newLocation);
            }
         }

         else if(key == KeyEvent.VK_KP_UP || key == KeyEvent.VK_UP) // UP
         {
            if(!location.wall(Square.UP))
            {
               Square newLocation = maze.getSquare(row - 1, col);
               moveTo(newLocation);
            }
         }

         else if(key == KeyEvent.VK_KP_DOWN || key == KeyEvent.VK_DOWN) // DOWN
         {
            if(!location.wall(Square.DOWN))
            {
               Square newLocation = maze.getSquare(row + 1, col);
               moveTo(newLocation);
            }
         }
   }

   public void moveTo(Square s)
   {
      super.moveTo(s);
      s.enter();
      maze.lookAround(s);
   }
} 