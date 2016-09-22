package game;

public class Inventory
{
	Item[] inventory;
    final int inventorysize = 9;
	public boolean full = full();
    
	
    public Inventory()
    {
        inventory = new Item[inventorysize];
    }
	
    
    public int size()
    {
        return inventorysize;
    }
	
    
    public boolean full()
    {
        if(inventory[inventorysize-1]==null)
        {
            return false;
        }
        return true;
    }
    


	public Item give(int i)
	{
		Item result = inventory[i];
        inventory[i]=null;
        return result;
	}

	
	public boolean insert(Item item)
	{
		for(int i=0; i<inventorysize; i++)
        {
            if(inventory[i]==null)
            {
            	inventory[i] = item;
                return true;
            }
        }
        return false;
		
	}

}
