/**
 * Class that handles the treasure's behavior
 *
 * @author Melissa James
 * @version 5/10/13
 */

 public class DrawableTreasure extends Treasure implements Drawable
 {
   public DrawableTreasure(Maze maze)
   {
      super(maze);
   }
   public DrawableTreasure(Maze maze, long seed)
   {
      super(maze, seed);
   }
   public DrawableTreasure(Maze maze, Square location)
   {
      super(maze, location);
   }

   public void draw()
   {

   }
 }