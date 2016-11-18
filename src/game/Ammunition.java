package game;

public class Ammunition extends Block
{
	public int R;
    public final double V=8;
    
    public Ammunition(int Rotation)
    {
        R= Rotation;
        permeable = true;
        setImage("Munition.gif");
    }
    
   
    public void act() 
    {
        fly();
        setRotation(R);
        dematrialise();
    }
    
    
    public void dematrialise()
    {
        if(getOneIntersectingObject(Wall.class) != null)
        {
            getWorld().removeObject(this);
        }
    }
    
    
    public void setRotation(int i)
    {
    	
    }
    
    
    public void fly()
    {
        double direction = Math.toRadians(R);
        double dx = Math.cos(direction) * V;
        double dy = Math.sin(direction) * V;
        setLocation((double)getX() + dx, (double)getY() + dy);
    }
    
    
    public void setLocation(double x, double y) 
    {
        setLocation((int) (x + 0.5), (int) (y + 0.5));
    }
}
