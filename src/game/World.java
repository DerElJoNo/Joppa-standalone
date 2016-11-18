package game;

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
public class World
{
	public World()
	{
		
	}

	final public int SIZE = 16;
	final public int HEIGHT = 36*SIZE;
	final public int WIDTH = 56*SIZE;
	
	public Image image;
	
	
	public Actor[] actors = new Actor[0];
	
	

	
	
	
	int getSize()
	{
		return SIZE;
	}
	
	int getHeight()
	{
		return HEIGHT;
	}
	
	int getWidth()
	{
		return WIDTH;
	}
	
	Actor[] getActors()
	{
		return actors;
	}

	
	
	
	public void addObject(Actor object, int xPos, int yPos)
	{
		
		Actor[] list = new Actor[actors.length +1];
		
		for(int i = 0; i<actors.length; i++)
		{
			list[i] = actors[i];
		}
			
		list[actors.length] = object;
		
		actors = list.clone();
		object.x = xPos;
		object.y = yPos;
		object.world = this;
	}

	
	
	public Actor[] getObjects(int x, int y)
	{
		Actor[] list = null;
		
		for(int i=0; i<actors.length; i++)
		{
			Actor a = actors[i];
			if(a.x == x && a.y == y)
			{
				Actor[] newList = new Actor[list.length+1];
				for(int j = 0; j<list.length; j++)
				{
					newList[j] = list[j];
				}
				
				newList[list.length] = a;
				
				list = newList.clone();
				actors[i] = a;
			}
		}
		
		return list;
	}

	
	
	public void removeObject(Actor o)
	{
		int pos = actors.length;
		
		for(int i=0; i<actors.length; i++)
		{
			if(actors[i].equals(o))
			{
				pos = i;
			}
		}
		
		Actor[] list = new Actor[actors.length-1];
		
		for(int i=0; i<pos; i++)
		{
			list[i]=actors[i];
		}
		
		for(int i=pos; i<actors.length-1; i++)
		{
			list[i]=actors[i+1];
		}
		
		actors=list;
	}
	
}
