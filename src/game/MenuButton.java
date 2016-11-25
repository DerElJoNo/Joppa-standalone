package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class MenuButton
{
	public String s;
	public static BufferedImage i;
	public boolean isSelected = false;
	int x;
	int y;
	int width = 400;
	int height = 80;
	
	public MenuButton(int xPos, int yPos, String s)
	{
		this.s = s;
		this.x = xPos;
		this.y = yPos;
	}
	
	public boolean isSelected()
	{
		return isSelected;
	}
	
	public void createImage(Graphics g)
	{
		Font font = new Font("MONOSPACED",Font.BOLD,30);
		
		g.setColor(Color.DARK_GRAY);
		if(isSelected)
		{
			g.setColor(Color.GRAY);
		}
		g.fillRoundRect(x, y - height/2, width, height, 20, 20);
		
		g.setColor(Color.WHITE);
		g.setFont(font);
		g.drawString(s, x + 40, y + font.getSize()/2);
	}
}
