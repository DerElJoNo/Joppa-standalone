package game;

public class InventoryArea extends Actor
{

	public void act() 
    {
        World world = getWorld();
        Level welt = (Level)world;
        Joppa joppa1 = welt.getJoppa();
        inv = joppa1.inv();
        Item i = inv.give(position);
        inv.insert(i);
        setImage("graphics/Inventar.png");
        JoppaImage a = (JoppaImage) image;
        if(i!=null)
        {
            a.drawImage(i.getItemPicture(),0,0);
        }
    }
    
	
	public Inventory inv;
    public int position;
    
    public InventoryArea(int x)
    {
        position = x;
    }
}
