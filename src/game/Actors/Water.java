package game.Actors;

import game.IngameBackgroundClasses.Unrushthroughable;

public class Water extends Block implements Unrushthroughable
{
    public int v;
    
    public Water(int volume)
    {
        v = volume;
        permeable = true;
    }
    
   
    public void act() 
    {
        flow();
        gravitationOff();
        addOn();
    }
    
    public int getVolume()
    {
        return v;
    }
    
    
    public void addOn()
    {
        if(getOneObjectAtOffset(0, 0, Water.class) != null)
        {
            Water w = (Water)getOneObjectAtOffset(0, 0, Water.class);
            v = v + w.getVolume();
            getWorld().removeObject(w);
        }
    }
    
    /**
     * 
     */
    public int leftDistanceTo(@SuppressWarnings("rawtypes") Class c)
    {
        int dl = 0;
        for(int i = getX(); i>0; i--)
        {
            int x = getX();
            setLocation(i, getY());
            if(getOneIntersectingObject(c)!=null)
            {
                dl = i;
                setLocation(x, getY());
                break;
            }
        }
        return dl;
    }
    
    /**
     * 
     */
    public int rightDistanceTo(@SuppressWarnings("rawtypes") Class c)
    {
        int dr = 0;
        for(int h = getX(); h < getWorld().getWidth()-1; h++)
        {
            int x = getX();
            setLocation(h, getY());
            if(getOneIntersectingObject(c)!=null)
            {
                dr = h;
                setLocation(x, getY());
                break;
            }
        }
        return dr;
    }
    
    /**
     * 
     */
    public void flow()
    {
        int dr = rightDistanceTo(Wall.class);
        int dl = leftDistanceTo(Wall.class);
        
        if(getOneObjectAtOffset(0,1,Wall.class)==null && getOneObjectAtOffset(0,1,Water.class)==null)
        {
            setLocation(getX(), getY()+1);
        }
        if(dr>=v)
        {
            for(int i = dr; i>=0; i--)
            {
                getWorld().addObject(new Water(1), getX()+i, getY());
                v = v - dr;
            }
        }
        if(dl>=v)
        {
            for(int h = dl; h>=0; h--)
            {
                getWorld().addObject(new Water(1), getX()-h, getY());
                v = v - dl;
            }
        }
        else
        {
            getWorld().addObject(new Water(v-1), getX(), getY()-1);
            v = 1;
        }
    }
}
