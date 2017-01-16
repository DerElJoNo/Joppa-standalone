package game.IngameBackgroundClasses;

import game.Actors.Electronics;

public class SwitchDependList
{

    Electronics[] dependList;
    public int size;
    public SwitchDependList(int i)
    {
        size = i;
        dependList = new Electronics[size];
    }
    
    public boolean insert(Electronics e)
    {
        for(int i = 0; i < size; i++)
        {
            if(dependList[i]==null)
            {
                dependList[i] = e;
                return true;
            }
        }
        return false;
    }
    
    public int size()
    {
        return size;
    }
    
    public Electronics give(int i) 
    {
    	Electronics result = dependList[i];
        dependList[i] = null;
        return result;
    }

}
