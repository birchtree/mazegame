/**
 * Class that determines how the Monster behaves
 *
 * @author Melissa James
 * @version 5/10/13
 */

public class Monster extends RandomOccupant
{
   public Monster(Maze maze)
   {
      super(maze);
   }

   public Monster(Maze maze, long seed)
   {
      super(maze, seed);
   }

   public Monster(Maze maze, Square location)
   {
      super(maze, location);
   }
}