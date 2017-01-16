package game.Actors;

import game.IngameBackgroundClasses.Unrushthroughable;

public class Ladder extends Block implements Unrushthroughable
{
	public Ladder()
    {
        permeable = true;
        gravitation = false;
        setImage("Leiter.png");
    } 
}
