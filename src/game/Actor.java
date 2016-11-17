package game;


import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
public class Actor
{
	int x;
	int y;
	World world;

	public BufferedImage image;
	
	public Actor()
	{
		setImage("graphics/Joppa_links.png");
	}
	
	
	public void setImage(String path)
	{
		try
		{
			image = ImageIO.read(getClass().getClassLoader().getResourceAsStream(path));
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public int getHeight()
	{
		return image.getHeight();
	}
	
	public int getWidth()
	{
		return image.getWidth();
	}
	
	public void setLocation(int xPos, int yPos)
	{
		x = xPos;
		y = yPos;
		checkWorldRims();
	}

	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	public World getWorld()
	{
		return world;
	}
	
	
	
	public void checkWorldRims()
	{
		if(x > world.WIDTH)
		{
			x = world.WIDTH;
		}	
		if(y > world.HEIGHT)
		{
			y = world.HEIGHT;
		}
		if(x <0)
		{
			x = 0;
		}	
		if(y < 0)
		{
			y = 0;
		}
	}
	
	
	public void act()
	{}
	
	
	public Actor getOneIntersectingObject(@SuppressWarnings("rawtypes") Class cls)
	{
		Actor c = null;
		
		for(int a=0; a<world.actors.length; a++)
		{
			
			if(world.actors[a]!=this && cls.isInstance(world.actors[a]))
			{
				Actor b = world.actors[a];
				
				boolean h = b.x < x+image.getWidth();
				boolean i = b.x > x-b.image.getWidth();
				boolean j = b.y < y+image.getHeight();
				boolean k = b.y > y-b.image.getHeight();
				
				if(h && i && j&& k)
				{
					c = b;
					world.actors[a] = b;
					return c;
				}
				
				world.actors[a] = b;
			}
		}

		return c;
	}
	
	
	public List<Actor> getIntersectingObjects(@SuppressWarnings("rawtypes") Class cls)
	{
		List<Actor> c = new ArrayList<Actor>();
		
		for(int a=0; a<world.actors.length; a++)
		{
			
			if(world.actors[a]!=this && world.actors[a].getClass()==cls)
			{
				Actor b = world.actors[a];
				
				boolean h = b.x < x+image.getWidth();
				boolean i = b.x > x-b.image.getWidth();
				boolean j = b.y < y+image.getHeight();
				boolean k = b.y > y-b.image.getHeight();
				
				if(h && i && j&& k)
				{
					c.add(b);
				}
				
				world.actors[a] = b;
			}
		}

		return c;
	}
	
	public Actor getOneObjectAtOffset(int x, int y, @SuppressWarnings("rawtypes") Class cls)
	{
		return null;
		
	}
}
