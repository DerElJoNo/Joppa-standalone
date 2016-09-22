package game;

public class Item extends Actor
{
	public boolean food;
    public JoppaImage itemPicture;
    public int foodpoints;
    
    public JoppaImage getItemPicture()
    {
        return itemPicture;
    }
    
    public void setItemPicture(String x)
    {
        itemPicture = new JoppaImage(x);
    }
}
