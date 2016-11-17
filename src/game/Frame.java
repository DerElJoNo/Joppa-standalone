package game;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

public class Frame extends JFrame
{
	
	private static final long serialVersionUID = -9213211594897249162L;
	private BufferStrategy bs;
	public static World w = new No1();
	
	
	public Frame()
	{
		addKeyListener(new Keyboard());
	}
	
	public void makeBS()
	{
		createBufferStrategy(2);
		bs = getBufferStrategy();
	}

	public void repaint()
	{
		Graphics g = bs.getDrawGraphics();
		draw(g);
		g.dispose();
		bs.show();
	}
	
	

	public void draw(Graphics g)
	{
		setBackground(w, g);
		setActors(w, g);
	}
	
	

	
	
	
	public void setBackground(World world, Graphics f)
	{
		f.drawImage(world.image, transformX(world, 0), transformY(world, 0), null);
	}
	
	public void setActors(World world, Graphics f)
	{
		Actor[] a = getActors(world);
		
		if(a==null)
		{
			return;
		}
		
		for(int i=0; i<a.length; i++)
		{
			Actor actor = a[i];
			f.drawImage(actor.image, transformX(world, actor.x) - actor.image.getWidth(null)/2,
			transformY(world, actor.y) - actor.image.getHeight(null)/2, null);
			
			a[i] = actor;
		}
	}
	
	public static Actor[] getActors(World w)
	{
		return w.getActors();
	}

	public static int transformX(World w, int x)
	{
		int screenWidth = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
		
		int transformedX = (screenWidth/2) - (w.WIDTH/2) + x;
		
		return transformedX;
	}
	
	public static int transformY(World w, int y)
	{
		int screenHeight = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
		
		int transformedY = (screenHeight/2) - (w.HEIGHT/2) + y;
		
		return transformedY;
	}
	
}
