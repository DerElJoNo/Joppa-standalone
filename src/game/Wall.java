package game;

public class Wall extends Block implements Unrushthroughable
{
	public Wall()
    {
		setImage("graphics/Wand.gif");
        permeable = false;
    } 
}
