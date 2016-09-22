package game;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class CreditCounter extends Actor
{
	public float münzen = 0;
    Joppa j;
    
	public CreditCounter(Joppa j)
	{
		this.j = j;
	}
	
	
	public void act() 
    {
        münzen = (float)j.credits;
        BufferedImage score = null;
        
        if(münzen < 1000)
        {
            score = new JoppaImage(String.format("%d", (int)münzen) , 18, Color.BLACK, Color.WHITE);
        }
        if(münzen >= 1000 && münzen < 1000000)
        {
            score = new JoppaImage(String.format("%.2f", münzen/1000) + " K", 18, Color.BLACK, Color.WHITE);
        }
        if(münzen >= 1000000)
        {
            score = new JoppaImage(String.format("%.2f", münzen/1000000) + " Mio.", 18, Color.BLACK, Color.WHITE);
        }
        
        JoppaImage background = new JoppaImage(80, 16);
        background.setColor(Color.WHITE);
        background.fillRect(0, 0, 80, 16);
        background.drawImage((JoppaImage) score, 60 - score.getWidth(), 0);
        background.drawImage(new JoppaImage("graphics/Münze.gif"), 64, 0);
        image = background;
    }
}
