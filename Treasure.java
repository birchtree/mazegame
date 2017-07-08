/**
 * Class that handles the treasure's behavior
 *
 * @author Melissa James
 * @version 5/10/13
 */

public class Treasure extends RandomOccupant
{
   private boolean found;

   public Treasure(Maze maze)
   {
      super(maze);
      found = false;
      super.location().setTreasure(this);
   }

   public Treasure(Maze maze, long seed)
   {
      super(maze, seed);
      found = false;
      super.location().setTreasure(this);
   }

   public Treasure(Maze maze, Square location)
   {
      super(maze, location);
      found = false;
      super.location().setTreasure(this);
   }

   public boolean found()
   {
      return found;
   }

   public void setFound()
   {
      this.found = true;
   }

   public void move()
   {
      //make it not move
   }
}