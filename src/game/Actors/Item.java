package game.Actors;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Item extends Actor
{
	public boolean food;
    public BufferedImage itemPicture;
    public int foodpoints;
    
    public void setItemPicture(String s)
    {
    	try
		 {
			 itemPicture = ImageIO.read(getClass().getClassLoader().getResourceAsStream("graphics/"+s));
		 }
		 catch (IOException e)
		 {
			 e.printStackTrace();
		 }   
    }
}
