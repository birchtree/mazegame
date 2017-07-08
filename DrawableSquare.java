/**
 * Class that defines each square in the maze
 *
 * @author Melissa James
 * @version 5/10/13
 */
public class DrawableSquare extends Square implements Drawable
{
   public DrawableSquare(boolean up, boolean right, boolean down, boolean left, int row, int col)
   {
      super(up, right, down, left, row, col);
   }

   public void draw()
   {
      if(!this.seen())
      {

      }
      else if(this.seen())
      {
         int x = x();
         int y = y();
         if(this.inView())
         {
            fill(#4CBB08);
            rect(x, y, SQUARE_SIZE, SQUARE_SIZE);
            fill(#B07E3A);
            rect(x, y, SQUARE_SIZE, 2);
            rect(x, y, 2, SQUARE_SIZE);
            rect(x, SQUARE_SIZE + y, 2, SQUARE_SIZE);
            rect(SQUARE_SIZE + x, y, SQUARE_SIZE, 2);
         }
         else
         {
            fill(#79D217);
            rect(x, y, SQUARE_SIZE, SQUARE_SIZE);
            fill(#9A5D09);
            rect(x, y, SQUARE_SIZE, 2);
            rect(x, y, 2, SQUARE_SIZE);
            rect(x, SQUARE_SIZE + y, 2, SQUARE_SIZE);
            rect(SQUARE_SIZE + x, y, SQUARE_SIZE, 2);
         }
      }
   }
}