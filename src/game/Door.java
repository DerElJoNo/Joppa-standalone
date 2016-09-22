package game;

public class Door extends Block implements Unrushthroughable
{

	public boolean permeable = false;

	public void open()
    {
        permeable = true;
        setImage("graphics/T�r(ge�ffnet).png");
    }
    
    
    public void close()
    {
        permeable = false;
        setImage("graphics/T�r(geschlossen).png");
    }

}
