package game;

public class Level extends World
{
	public int MIDDLE = SIZE / 2;
	int x;
	int y;
	int level;
	Joppa joppa;
	Start start = new Start();
	    
	public Level() 
	{
		joppa = new Joppa();
	}
	    
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
        
        
    }
	    
    
    public Joppa getJoppa()
    {
        return joppa;
    }
}