package game;

import java.awt.Color;

public class Airbar extends Actor
{
	public int air;
    Airbar a = new Airbar();
	
public void act() 
    {
		Level world =(Level) getWorld();
        Joppa joppa = world.getJoppa();
        air = joppa.getAir();
        
        setImage("graphics/Balken.png");
        JoppaImage bar = (JoppaImage) image;
    	bar.setColor(Color.GRAY);
    	bar.fillRect(0,0,102,16);
    
    	if(air>=66)
    	{
    		bar.setColor(Color.GREEN);
    		bar.fillRect(1,1,air,14);
    	}
    	if(air>=34 && air <=65)
    	{
    		bar.setColor(Color.YELLOW);
    		bar.fillRect(1,1,air,14);
    	}
    	if(air <=33)
    	{
    		bar.setColor(Color.RED);
    		bar.fillRect(1,1,air,14);
    	}
	}
	
}
