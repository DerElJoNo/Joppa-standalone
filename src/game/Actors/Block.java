package game.Actors;

import java.util.ArrayList;
import java.util.List;

public class Block extends Actor
{

	public boolean permeable = false;
	public boolean gravitation;
    
    
    public boolean gravitation()
    {
        return gravitation;
    }
    
    
    public void gravitationOff()
    {
        gravitation = false;
    }
    
    
    public void gravitationOn()
    {
        gravitation = true;
    }
    
    
    
    public Actor getOneTouchingObject(String x, @SuppressWarnings("rawtypes") Class b, int offset)
    {
        Actor a = null;
        int XChange = 0;
        int YChange = 0;
        if(x == "u") {
            YChange = offset;
        } else if(x == "l") {
            XChange = -offset;
        } else if(x == "o") {
            YChange = -offset;
        } else if(x == "r") {
            XChange = offset;
        }
        
        setLocation(getX() + XChange, getY() + YChange);
        Actor iActor = getOneIntersectingObject(b);
        if(iActor!=null)
        {
            boolean correctDirection = false;
            
            if(x == "u") {
                correctDirection = iActor.getY() > getY();
            } else if(x == "l") {
                correctDirection = iActor.getX() < getX();
            } else if(x == "o") {
                correctDirection = iActor.getY() < getY();
            } else if(x == "r") {
                correctDirection = iActor.getX() > getX();
            }
            
            if(correctDirection) {
                a = iActor;
            }
        }
        setLocation(getX()-XChange,getY()-YChange);
        
        return a;
    }
    
    public List<Actor> getTouchingObjects(String x, @SuppressWarnings("rawtypes") Class b, int offset)
    {
        List<Actor> a = new ArrayList<Actor>();
        int XChange = 0;
        int YChange = 0;
        if(x == "u") {
            YChange = offset;
        } else if(x == "l") {
            XChange = -offset;
        } else if(x == "o") {
            YChange = -offset;
        } else if(x == "r") {
            XChange = offset;
        }

        setLocation(getX() + XChange, getY() + YChange);

        List<Actor> c = getIntersectingObjects(b);
        if(c!=null)
        {
            boolean correctDirection = false;
            for(int i=0; i< c.size(); i++)
            {
                Actor iActor = c.get(i);
                if(x == "u")
                {
                    correctDirection = iActor.getY() >= getY();
                }
                else if(x == "l")
                {
                    correctDirection = iActor.getX() <= getX();
                }
                else if(x == "o")
                {
                    correctDirection = iActor.getY() <= getY();
                }
                else if(x == "r")
                {
                    correctDirection = iActor.getX() >= getX();
                }
                if(correctDirection)
                {
                    a.add(iActor);
                }
            }
        }
        setLocation(getX()-XChange, getY()-YChange);
        return a;
    }

}
