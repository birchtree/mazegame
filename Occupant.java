import java.awt.*;
import java.util.*;
/**
 * Abstract class that provides basic methods for maze occupants
 *
 * @author Melissa James
 * @version 5/10/13
 */

public abstract class Occupant
{
   private Square location;

   public Occupant()
   {

   }

   public Occupant(Square start)
   {
      location = start;
   }

   public Square location()
   {
      return location;
   }

   public void moveTo(Square newLoc)
   {
      location = newLoc;
   }
}