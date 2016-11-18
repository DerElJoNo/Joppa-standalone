package game;

public class Door extends Block implements Unrushthroughable
{
	public Door()
	{
		setImage("T�r(geschlossen).png");
		permeable = false;
	}
	
	public void open()
    {
        permeable = true;
        setImage("T�r(ge�ffnet).png");
    }
    
    
    public void close()
    {
        permeable = false;
        setImage("T�r(geschlossen).png");
    }

}
