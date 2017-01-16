package game.Actors;

public class Fire extends Block
{
	public Fire()
    {
        permeable = true;
    }
    
    
    public void act() 
    {
        ChangePicture();
    }
    
   
    public void ChangePicture()
    {
        if(getOneObjectAtOffset(16,0,Fire.class)!=null)
        {
            setImage("Feuer_links_begrenzt.png");
        }
        if(getOneObjectAtOffset(-16,0,Fire.class)!=null)
        {
            setImage("Feuer_rechts_begrenzt.png");
        }
        if(getOneObjectAtOffset(16,0,Fire.class)!=null && getOneObjectAtOffset(-16,0,Fire.class)!=null)
        {
            setImage("Feuer_unbegrenzt.png");
        }
        else
        {
        	setImage("Feuer_links_rechts_begrenzt.png");
        }
    }
}
