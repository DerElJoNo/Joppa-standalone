package game;

public class SetStandart extends Level
{
	public void setStandart()
    {
    	Lifebar lifebar = new Lifebar();
        addObject(lifebar, unit(5), unit(1));
        
        Airbar airbar = new Airbar();
        addObject(airbar, getWidth()-(unit(5)), unit(1));
        
        for(int a= MIDDLE; a<getWidth(); a = a + SIZE)
        {
            addObject(new Wall(), a, MIDDLE);
            addObject(new Wall(), a, getHeight() - MIDDLE);
        }
        
        for(int b= MIDDLE; b<getHeight(); b = b + SIZE)
        {
            addObject(new Wall(), MIDDLE, b);
            addObject(new Wall(), getWidth() - MIDDLE, b);
        }
        
        for(int i=0; i< joppa.inv.size(); i++)
        {
            addObject(new InventoryArea(i), (getWidth()/2) - (joppa.inv.size() * SIZE / 2) + unit(i), unit(1));
        }
        addObject(new CreditCounter(joppa), getWidth()/2 + 8*SIZE, unit(1));
    }
}
