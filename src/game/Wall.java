package game;

public class Wall extends Block implements Unrushthroughable
{
	public Wall()
    {
		setImage("Wand.gif");
        permeable = false;
    } 
}
