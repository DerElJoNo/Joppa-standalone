package game;

public class Cake extends Item implements Eatable
{
    public void act() 
    {
        setImage("Kuchen.png");
    	setItemPicture("Kuchen(Item).png");
    }

	public int getFoodpoints()
	{
		return 15;
	}
}
