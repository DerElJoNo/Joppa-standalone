package game.userInteraction;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import game.Main;
import game.Actors.Actor;
import game.Actors.Item;
import game.Actors.Joppa;
import game.IngameBackgroundClasses.LevelManager;
import game.Main.GameState;
import game.world.World;
import game.world.levels.Level;

public class Frame extends JFrame
{
	
	private static final long serialVersionUID = -9213211594897249162L;
	private BufferStrategy bs;
	Graphics g;
	MenuButton[] buttons = new MenuButton[5];
	
	
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
		switch(Main.gs)
		{	
			case INGAME:
				setIngame(g);
				break;
			case LEVELCREATION:
				setLevelCreation(g);
				
			default:
				setMenu(g);
				break;
		}
	}
	
	
	
	public void setIngame(Graphics g)
	{
		World w = LevelManager.getInstance().world;
		
		setBackground(w, g);
		setActors(w, g);
		setLifebar(w, g);
		setAirbar(w, g);
		setCreditcounter(w, g);
		setInventory(w, g);
	}

	public void setMenu(Graphics g)
	{
		drawButtons(g);
	}

	public void setLevelCreation(Graphics g)
	{
		World w = LevelManager.getInstance().world;
		
		try
		{
			g.drawImage(ImageIO.read(getClass().getClassLoader().getResourceAsStream("graphics/no2.jpg")), transformX(w, 0), transformY(w, 0), null);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		setLifebar(w, g);
		setAirbar(w, g);
		setCreditcounter(w, g);
		setInventory(w, g);
	}


	public void calculate()
	{
		World w = LevelManager.getInstance().world;
		
		switch(Main.gs)
		{
			case INGAME:
				Actor[] a = w.actors;
				for(int i=0; i<a.length; i++)
				{
					a[i].act();
				}
				break;
				
			default:
				checkButtons();
				loginButtons();
		}
	}

	public void loginButtons()
	{
		if(Keyboard.isKeyDown(KeyEvent.VK_ENTER))
		{
			int selected = 0;
			if(buttons != null)
			{
				for(int i = 0; i < buttons.length; i++)
				{
					if(buttons[i].isSelected)
					{
						selected = i;
						
						break;
					}
				}
			}
			
			if(selected == 0)
				{
					Main.gs = GameState.INGAME;
				}
			else if(selected == 1)
				{
					
				}
			else if(selected == 2)
				{
					
				}
			else if(selected == 3)
				{
					Main.gs = GameState.LEVELCREATION;
				}
			else if(selected == 4)
				{
					System.exit(0);
				}
		}
	}
	
	
	public void setButtons()
	{
		buttons[0]= createButton("Play",1);
		buttons[1]= createButton("Options",2);
		buttons[2]= createButton("Select Level",3);
		buttons[3]= createButton("Create Levels",4);
		buttons[4]= createButton("Quit Game",5);
		buttons[0].isSelected = true;
	}
	
	public void drawButtons(Graphics g)
	{
		for(int i = 0; i<buttons.length; i++)
		{
			buttons[i].createImage(g);
		}
	}
	
	private MenuButton createButton(String s, int pos)
	{
		return new MenuButton(40, pos*120, s);
	}

	public void checkButtons()
	{
		int selected = 0;
		if(buttons != null)
		{
			for(int i = 0; i < buttons.length; i++)
			{
				if(buttons[i].isSelected)
				{
					selected = i;
					
					break;
				}
			}
		}
		
		int oldSelected = selected;
		if(Keyboard.isKeyDown(KeyEvent.VK_DOWN))
			{
				selected++;
				if(selected == buttons.length)
					selected = 0;
			}
		else if(Keyboard.isKeyDown(KeyEvent.VK_UP))
			{
				selected--;
				if(selected <0)
					selected = buttons.length-1;
			}
		
		buttons[oldSelected].isSelected = false;
		buttons[selected].isSelected = true;
	}
	
	public void setInventory(World world, Graphics f)
	{
	     BufferedImage image = null;
	     int size = 16;
	     try
		 {
			 image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("graphics/Inventar.png"));
		 }
		 catch (IOException e)
		 {
			 e.printStackTrace();
		 }   
	     
	     for(int i=0; i< Joppa.getInstance().inv.size(); i++)
	     {
	    	 Item item = Joppa.getInstance().inv.inventory[i];
	    	 f.drawImage(image, transformX(world, 0) + world.getWidth()/2 - (Joppa.getInstance().inv.size() * size / 2) + size * i,
	    	 transformY(world, 0) + size, null);
	    	 if(item!=null)
	    	 {
	    		 f.drawImage(item.itemPicture, transformX(world, 0) + world.getWidth()/2 - (Joppa.getInstance().inv.size() * size / 2) + size * i,
	    		 transformY(world, 0) + size, null);
	    	 }
	     }
	}
	
	public void setBackground(World world, Graphics f)
	{
		Level l = (Level)world;
		f.drawImage(l.image, transformX(world, 0), transformY(world, 0), null);
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
        int life = Joppa.getInstance().getLife();
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
        int air = Joppa.getInstance().getAir();
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
	
	public void setCreditcounter(World world, Graphics f)
	{
		float credits = Joppa.getInstance().credits;
        int unit = 16;
		int x = transformX(world, 0) + unit*43;
        int y = transformY(world, 0) + unit*1;
        Font font = new Font("MONOSPACED", Font.PLAIN, 16);
		
        BufferedImage i = null;
		try
		{
			i = ImageIO.read(getClass().getClassLoader().getResourceAsStream("graphics/M�nze.gif"));
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
        
		f.setColor(Color.WHITE);
        f.fillRect(x - 80 + i.getWidth(),y , 80, 16);
        f.drawImage(i, x, y , null);
        
        f.setColor(Color.BLACK);
        f.setFont(font);
        if(credits < 1000)
        {
            String s = ""+(int)credits;
        	f.drawString(s, x - 80 + i.getWidth(), y + font.getSize()-2);
        }
        if(credits >= 1000 && credits < 1000000)
        {
        	String s = ""+credits/1000 + " K";
        	f.drawString(s, x - 80 + i.getWidth(), y + font.getSize()-2);
        }
        if(credits >= 1000000)
        {
        	String s = ""+credits/1000000 + " Mio.";
        	f.drawString(s, x - 80 + i.getWidth(), y + font.getSize()-2);
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
