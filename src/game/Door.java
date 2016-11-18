package game;

public class Door extends Block implements Unrushthroughable
{
	public Door()
	{
		setImage("Tür(geschlossen).png");
		permeable = false;
	}
	
	public void open()
    {
        permeable = true;
        setImage("Tür(geöffnet).png");
    }
    
    
    public void close()
    {
        permeable = false;
        setImage("Tür(geschlossen).png");
    }

}
