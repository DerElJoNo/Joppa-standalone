package game;

import java.awt.Color;

public class Lifebar extends Actor
{
	public void act()
	{
		Level world =(Level) getWorld();
        Joppa joppa = world.getJoppa();
        int life = joppa.getAir();
    
    	setImage("graphics/Balken.png");
    	JoppaImage bar = (JoppaImage) image;
    	bar.setColor(Color.GRAY);
    	bar.fillRect(0,0,102,16);
    
    	if(life>=66)
    	{
    		bar.setColor(Color.GREEN);
    		bar.fillRect(1,1,life,14);
    	}
    	if(life>=34 && life <=65)
    	{
    		bar.setColor(Color.YELLOW);
    		bar.fillRect(1,1,life,14);
    	}
    	if(life <=33)
    	{
    		bar.setColor(Color.RED);
    		bar.fillRect(1,1,life,14);
    	}
	}
}
