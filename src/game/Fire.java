package game;

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
            setImage("graphics/Feuer(links begrenzt).png");
        }
        if(getOneObjectAtOffset(-16,0,Fire.class)!=null)
        {
            setImage("graphics/Feuer(rechts begrenzt).png");
        }
        if(getOneObjectAtOffset(16,0,Fire.class)!=null && getOneObjectAtOffset(-16,0,Fire.class)!=null)
        {
            setImage("graphics/Feuer(unbegrenzt).png");
        }
        else
        {
        	setImage("graphics/Feuer(liks+rechts begrenzt).png");
        }
    }
}
