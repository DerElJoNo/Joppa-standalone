package game;

public class Level extends World
{
	public int MIDDLE = SIZE / 2;
	int x;
	int y;
	int level;
	Joppa joppa;
	Start start = new Start();
	    
	   
	    
	public void newWallRow(int x1, int y1, int x2, int y2)
	{
        for(int i = x1; i<=x2; i++)
        {
            for(int j = y1; j<=y2; j++)
            {
                addObject(new Wall(), unit(i), unit(j));
            }
        }
    }
	
	public void newFireRow(int x1, int y1, int x2, int y2)
	{
        for(int i = x1; i<=x2; i++)
        {
            for(int j = y1; j<=y2; j++)
            {
                addObject(new Fire(), unit(i), unit(j));
            }
        }
    }
	
	public void newLadderRow(int x1, int y1, int x2, int y2)
	{
        for(int i = x1; i<=x2; i++)
        {
            for(int j = y1; j<=y2; j++)
            {
                addObject(new Ladder(), unit(i), unit(j));
            }
        }
    }
	
	
	
	public int unit(int x)
    {
        return x*SIZE + MIDDLE;
    }
	    
	public int getLevelType()
    {
        return level;
    }
    
    public void setLevel(int x)
    {
        level = x;
    }
	    
    public void setPlayer(int x, int y)
    {
        addObject(start, x, y);
        this.addObject(joppa, x, y);
        joppa.setLocation(x, y);
    }    
	    
    
    public void setStandart()
    {
        Lifebar lifebar = new Lifebar();
        addObject(lifebar, unit(5), unit(1));
        
        Airbar airbar = new Airbar();
        addObject(airbar, getWidth()-(unit(5)), unit(1));
        
        for(int a= MIDDLE; a<getWidth(); a = a + SIZE)
        {
            addObject(new Wall(), a, MIDDLE);
            addObject(new Wall(), a, getHeight() - MIDDLE);
        }
        
        for(int b= MIDDLE; b<getHeight(); b = b + SIZE)
        {
            addObject(new Wall(), MIDDLE, b);
            addObject(new Wall(), getWidth() - MIDDLE, b);
        }
        
        for(int i=0; i< joppa.inv.size(); i++)
        {
            addObject(new InventoryArea(i), (getWidth()/2) - (joppa.inv.size() * SIZE / 2) + unit(i), unit(1));
        }
        addObject(new CreditCounter(joppa), getWidth()/2 + 8*SIZE, unit(1));
    }
	    
    
    public Joppa getJoppa()
    {
        return joppa;
    }
}
