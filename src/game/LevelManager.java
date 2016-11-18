package game;

import java.util.ArrayList;
import java.util.List;

import game.Levels.*;

public class LevelManager
{

	List<Level> levelList;
    private static final LevelManager INSTANCE = new LevelManager();
    
    
    public Level getLevel(int i)
    {
        return levelList.get(i - 1);
    }
    
    
    public Level getNextLevel(Level level)
    {
        int index = levelList.indexOf(level);
        return levelList.get(index + 1);
    }
    
    private LevelManager()
    {
        levelList = new ArrayList<Level>();
        levelList.add(0, new No1()); // Level 1
        levelList.add(1, new No2()); // Level 2
        levelList.add(1, new No3()); // Level 3
    }
    
    
    public static LevelManager getInstance()
    {
        return INSTANCE;
    }


	public void setWorld(Level level)
	{
		Frame.w = level;
	}

}
