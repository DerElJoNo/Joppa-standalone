package game.Actors;

public class Coin extends Actor
{

	public int getValue() 
	{
		return 0;
	}
	
	int value;
	
    public Coin(int value)
    {
        this.value = value;
        setImage("Münze.gif");
    }
    
}
