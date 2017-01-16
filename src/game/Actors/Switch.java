package game.Actors;

import game.IngameBackgroundClasses.SwitchDependList;

public class Switch extends Block
{
    public void act() 
    {
        setPicture();
        setDependends();
    }

    SwitchDependList list;
    public boolean turnedOn;
    
    public void setPicture()
    {
        if(turnedOn == true)
        {
            setImage("Schalter(ein).png");
        }
        else
        {
            setImage("Schalter(aus).png");
        }
    }
    
    public Switch(SwitchDependList dependList)
    {
        list = dependList;
        permeable = true;
    }

    public void setDependends()
    {
        if(list != null)
        {
            for(int i = 0; i < list.size() ; i++)
            {
                Electronics e = list.give(i);
                if(e != null)
                {
                    getWorld().addObject(e, e.getX(), e.getY());
                }
                list.insert(e);
            }
        }
    }

    public void flip()
    {
        if(list != null)
        {
            for(int i = 0; i < list.size(); i++)
            {
                Electronics e = list.give(i);
                e.flipSwitch();
                list.insert(e);
            }
        }
        
        if(turnedOn == true)
        {
        	turnedOn = false;
        }
        else
        {
        	turnedOn = true;
        }
    }
	
}
