package game.Levels;

import game.Cake;
import game.Door;
import game.FinishingPost;
import game.Fire;
import game.Key;
import game.Level;
import game.Start;
import game.Wall;

public class No2 extends Level
{
	public No2()
    { 
        setImage("no2.jpg");
		setLevel(2);
        no2();
        setStandart(); 
        setPlayer(unit(30), unit(34));
    }
    
    public void no2()
    {
        addObject(new FinishingPost(), unit(35), unit(34));
        addObject(new FinishingPost(), unit(2), unit(25));
        addObject(new Wall(), unit(54), unit(28));
        Door t = new Door();
        addObject(t, unit(47), unit(34));
        t.open();
        addObject(new Start(), unit(51), unit(34));
        
        newWallRow(33,24,33,34);
        newWallRow(1,23,54,23);
        newWallRow(34,32,46,32);
        newWallRow(47,29,47,33);
        newWallRow(40,28,52,28);
        newWallRow(40,24,40,27);
        newLadderRow(53,28,53,34);
        newLadderRow(27,27,27,34);
        
        newWallRow(25, 28, 25, 34);
        newWallRow(22, 27, 26, 27);
        newWallRow(29, 27, 32, 32);
        addObject(new Wall(), unit(28), unit(27));
        addObject(new Wall(), unit(29), unit(24));
        addObject(new Wall(), unit(29), unit(25));
        addObject(new Door(), unit(29), unit(26));
        addObject(new Cake(), unit(31), unit(26));
        newLadderRow(21, 27, 21, 30);
        newWallRow(15, 32, 21, 32);
        newWallRow(15, 31, 16, 31);
        addObject(new Wall(), unit(18), unit(31));
        newWallRow(20, 31, 21, 31);
        newWallRow(19, 33, 19, 34);
        newLadderRow(14, 31, 14, 34);
        newWallRow(1, 26, 6, 26);
        newLadderRow(7, 26, 7, 33);
        newWallRow(6, 34, 8, 34);
        addObject(new Wall(), unit(4), unit(34));
        newWallRow(1, 34, 2, 34);
        addObject(new Wall(), unit(4), unit(24));
        addObject(new Door(), unit(4), unit(25));
        addObject(new Key(), unit(2), unit(33));
        addObject(new Key(), unit(15), unit(30));
        newFireRow(20, 34, 24, 34);
        addObject(new Fire(), unit(3), unit(34));
        addObject(new Fire(), unit(5), unit(34));
        addObject(new Fire(), unit(17), unit(31));
        addObject(new Fire(), unit(19), unit(31));
    }
}
