package game.Levels;

import game.Door;
import game.FinishingPost;
import game.Key;
import game.Level;
import game.Wall;

public class No1 extends Level
{
    public No1()
    {
        setImage("no1.jpg");
    	setLevel(1);  
        setStandart();
        no1();
        setPlayer(unit(51), unit(34));
    }
    
    public void no1()
    {
        addObject(new FinishingPost(), unit(35), unit(34));
        addObject(new Wall(), unit(54), unit(28));
        addObject(new Door(), unit(47), unit(34));
        addObject(new Key(), unit(44), unit(27));
        
        newWallRow(33,24,33,34);
        newWallRow(33,23,54,23);
        newWallRow(34,32,46,32);
        newWallRow(47,29,47,33);
        newWallRow(40,28,52,28);
        newWallRow(40,24,40,27);
        newLadderRow(53,28,53,34);
    }
}
