package game.Actors;

import java.awt.event.KeyEvent;

import game.IngameBackgroundClasses.LevelManager;
import game.userInteraction.Keyboard;
import game.world.levels.Level;

public class FinishingPost extends Actor
{
	public FinishingPost()
	{
		setImage("Ziel.png");
	}
	
	public void act() 
    {
        if(getOneIntersectingObject(Joppa.class)!=null && Keyboard.isKeyDown(KeyEvent.VK_O))
        {
            Level level = (Level) getWorld();
            LevelManager.getInstance().setWorld(LevelManager.getInstance().getNextLevel(level));
        }
    }
}
