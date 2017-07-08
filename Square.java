/**
 * Class that defines each square in the maze
 *
 * @author Melissa James
 * @version 5/10/13
 */

public class Square
{
   public static final int SQUARE_SIZE = 50;
   public static final int UP = 0;
   public static final int RIGHT = 1;
   public static final int DOWN = 2;
   public static final int LEFT = 3;

   private boolean[] walls = new boolean[4];
   private boolean seen;
   private boolean vision;
   private int row, column;
   private Treasure treasure;

   public Square(boolean up, boolean right, boolean down, boolean left, int row, int col)
   {
      walls[0] = up;
      walls[1] = right;
      walls[2] = down;
      walls[3] = left;
      this.row = row;
      this.column = col;
   }

   public boolean wall(int direction)
   {
      boolean isThereAWall = walls[direction];

      return isThereAWall;
   }

   public boolean seen() 
   {
      return seen; // already seen
   }

   public boolean inView()
   {
      return vision; // in view now
   }

   public int row()
   {
      return row;
   }

   public int col()
   {
      return column;
   }

   public Treasure treasure()
   {
      return treasure;
   }

   public int x()
   {
      int col = col();
      int x = col * SQUARE_SIZE;
      return x;
   }

   public int y()
   {
      int row = row();
      int y = row * SQUARE_SIZE;
      return y;
   }

   public void setInView(boolean inView)
   {
      this.vision = inView;
      if(inView)
      {
         this.seen = true;
      }
   }

   public void setTreasure(Treasure t)
   {
      this.treasure = t;
   }

   public void enter()
   {
      if(treasure != null) 
      {
         treasure.setFound();
      }
   }
}