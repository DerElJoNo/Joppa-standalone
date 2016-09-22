package game;

public class Door extends Block implements Unrushthroughable
{

	public boolean permeable = false;

	public void open()
    {
        permeable = true;
        setImage("graphics/Tür(geöffnet).png");
    }
    
    
    public void close()
    {
        permeable = false;
        setImage("graphics/Tür(geschlossen).png");
    }

}
