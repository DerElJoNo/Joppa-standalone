package game;

import java.awt.Color;
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
		setLifebar(w, g);
		setAirbar(w, g);
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
	
	public void setLifebar(World world, Graphics f)
	{
		Level l = (Level)world;
		Joppa joppa = l.getJoppa();
        int life = joppa.getLife();
        int x = transformX(world, 0);
        int y = transformY(world, 0);
        int unit = 16;
        
        f.setColor(Color.GRAY);
    	f.fillRect(x + unit* 4, y+ unit*1,102,16);
    
    	if(life>=66)
    	{
    		f.setColor(Color.GREEN);
    	}
    	if(life>=34 && life <=65)
    	{
    		f.setColor(Color.YELLOW);
    	}
    	if(life <=33)
    	{
    		f.setColor(Color.RED);
    	}

		f.fillRect(x + unit* 4+ 1, y+ unit*1+1, life, 14);
	}
	
	public void setAirbar(World world, Graphics f)
	{
		Level l = (Level)world;
		Joppa joppa = l.getJoppa();
        int air = joppa.getAir();
        int x = transformX(world, 0);
        int y = transformY(world, 0);
        int unit = 16;
        
        f.setColor(Color.GRAY);
    	f.fillRect(x + world.WIDTH - unit* 4 - 102, y+ unit*1,102,16);
    
    	if(air>=50)
    	{
    		f.setColor(Color.CYAN);
    	}
    	if(air<50)
    	{
    		f.setColor(Color.BLUE);
    	}
    	
		f.fillRect(x + world.WIDTH - unit* 4 - 101, y+ unit*1 + 1,air,14);
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
