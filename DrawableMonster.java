import java.awt.event.KeyEvent;
import java.util.*;
/**
 * Class that determines how the Monster looks
 *
 * @author Melissa James
 * @version 5/10/13
 */

public class DrawableMonster extends Monster implements Drawable
{
   public DrawableMonster(Maze maze)
   {
      super(maze);
   }
   public DrawableMonster(Maze maze, long seed)
   {
      super(maze, seed);
   }
   public DrawableMonster(Maze maze, Square location)
   {
      super(maze, location);
   }

   public void draw()
   {

   }
}