package game;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class JoppaImage extends BufferedImage
{

	private static final int width = 0;
	private static final int height = 0;


	public JoppaImage(String x)
	{
		super(width, height, SCALE_DEFAULT);
		try
		{
			ImageIO.read(getClass().getClassLoader().getResourceAsStream("graphics/Joppa_links.png"));
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	
	public JoppaImage(int x, int y)
	{
		super(x, y, SCALE_DEFAULT);
	}
	
	
	
	public JoppaImage(String string, int size, Color foreground, Color background)
	{
		super(size, size, size);
	}
	
	
	
	
	
	
	
	public void drawImage(JoppaImage itemPicture, int i, int j)
	{
		
		
	}

	
	public void setColor(Color color)
	{
		// TODO Auto-generated method stub
		
	}

	
	public void fillRect(int i, int j, int k, int l)
	{
		// TODO Auto-generated method stub
		
	}

}
