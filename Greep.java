import greenfoot.*;

/**
 * A Greep is an alien creature that likes to collect tomatoes.
 * 
 * @author (your name here)
 * @version 0.2
 */
public class Greep extends Creature
{
    // Remember: you cannot extend the Greep's memory. So:
    // no additional fields (other than final fields) allowed in this class!
    
    /**
     * Default constructor for testing purposes.
     */
    public Greep()
    {
        this(null);
    }
    
    /**
     * Create a Greep with its home space ship.
     */
    public Greep(Ship ship)
    {
        super(ship);
    }

    /**
     * Do what a greep's gotta do.
     */
    public void act()
    {
        super.act();   // do not delete! leave as first statement in act().
        if (carryingTomato()) {
              spit("red");
            if (atWater ()) {        
                spit("purple");
                turn(80);
                move();
            }
              if (atShip()) {
                dropTomato();
                turn(180);
                move();
              }
              else {                
                turnHome();
                move(); 
                spit("Red");
              }
        }
        else 
        {
            checkFood();
            
        }
        if (atWater ()) {        
                spit("purple");
                turn(60);
                move();
        }
        if (isAtEdge() )
            {
             turn(80);   
            }
        if (isTouching (Paint.class)) 
        {            
            move();
        }
    }
    
    /**
     * Is there any food here where we are? If so, try to load some!
     */
    public void checkFood()
    {
        // check whether there's a tomato pile here
        TomatoPile tomatoes = (TomatoPile) getOneIntersectingObject(TomatoPile.class);
        if (tomatoes != null) {
            loadTomato();
            spit("red");       
        }
        else {
            move();
        }
    }

    /**
     * This method specifies the name of the author (for display on the result board).
     */
    public static String getAuthorName()
    {
        return "Micah B. Pace";  // write your name here!
    }
    
    /**
     * This method specifies the image we want displayed at any time. (No need 
     * to change this for the competition.)
     */
    public String getCurrentImage()
    {
        if (carryingTomato()) {
            return "greep-with-food.png";
            
        }
        else {
            return "greep.png";
        }
    }
}