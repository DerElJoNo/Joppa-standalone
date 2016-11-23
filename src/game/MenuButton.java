package game;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class MenuButton
{
	public String s;
	public Graphics g;
	public static BufferedImage i;
	public boolean isSelected;
	
	
	public MenuButton(String s, Graphics g)
	{
		this.s = s;
		this.g = g;
	}
	
	public boolean isSelected()
	{
		return isSelected;
	}
	
	public void createImage()
	{
		
	}
}
