package game;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class Joppa extends Actor
{
	public int life=100;
    public int air=100;
    public Inventory inv;
    public Weapon weapon;
    public Boots boots;
    public Pants pants;
    public Top top;
    public Helmet helmet;
    public boolean left;
    private final int V = 8;
    public int credits;

    public Joppa()
    {
        inv = new Inventory();
    }
    
    public Dress[] getRüstung()
    {
        Dress[] dress = {boots, pants, top, helmet};
        return dress;
    }
    
    public Weapon getWeapon()
    {
        return weapon;
    }

    
    public void act() 
    {
        move();
        reset();
        burn();
        getShot();
        open();
        collect();
        fall();
        setItem();
        eat();
        flipSwitch();
    }

    public Inventory inv()
    {
        return inv;
    }

    /**
     * 
     */
    public void flipSwitch()
    {
        if (Keyboard.isKeyDown(KeyEvent.VK_F) && getOneIntersectingObject(Switch.class) != null)
        {
            Switch s = (Switch)getOneIntersectingObject(Switch.class);
            s.flip();
        }        
    }

    /**
     * 
     */
    public void eat()
    {
        if(getOneIntersectingObject(Item.class)!=null && Keyboard.isKeyDown(KeyEvent.VK_Q))
        {
            Item i = (Item)getOneIntersectingObject(Item.class);
            if( i instanceof Eatable ){
                Eatable food = (Eatable) i;
                if( 100 >= food.getFoodpoints() + life) 
                {
                    life = life + food.getFoodpoints();
                }
                else
                {
                    life = 100;
                }
                getWorld().removeObject(i);
            }
        }
    }

    /**
     * 
     */
    public void setItem()
    {
        for(int i=0; i<inv.size(); i++)
        {
            if(Keyboard.isKeyDown(i+48))
            {
                Item a = inv.give(i);
                if(a!=null)
                {
                    if(left==true)
                    {
                        getWorld().addObject(a,getX()-16,getY());
                    }
                    if(left!=true)
                    {
                        getWorld().addObject(a,getX()+16,getY());
                    }
                }
            }
        }
    }

    /**
     * 
     */
    public void collect()
    {
        if(getOneIntersectingObject(Item.class)!=null && Keyboard.isKeyDown(KeyEvent.VK_E) && inv.full==false)
        {
            Item i = (Item)getOneIntersectingObject(Item.class);
            inv.insert(i);
            getWorld().removeObject(i);
        }
        if(getOneIntersectingObject(Coin.class) != null)
        {
            Coin c = (Coin)getOneIntersectingObject(Coin.class);
            credits = credits + c.getValue();
            getWorld().removeObject(c);
        }
    }

    
    
    
    public void open()
    {
        if (Keyboard.isKeyDown(KeyEvent.VK_O))
        {
            Door door;
            if(getOneTouchingObject("l", Door.class,4) != null && left==true) 
            {
                door = (Door) getOneTouchingObject("l", Door.class,4);
            }
            else if(getOneTouchingObject("r", Door.class,4) != null && left==false) 
            {
                door = (Door) getOneTouchingObject("r", Door.class,4);
            }
            else 
            {
                return;
            }

            for(int i=0; i<inv.size(); i++)
            {
                Item a = inv.give(i);
                if(a != null)
                {
                    if(a.getClass()==Key.class && door.permeable==false)
                    {
                        door.open();
                    }
                    if(door.permeable)
                    {
                        return;
                    }
                    if(a.getClass()!=Key.class)
                    {
                        inv.insert(a);
                    }
                }
            }
        }        
    }

    
    public int getLife()
    {
        return life;
    }
    
    
    public void setLife(int l)
    {
       life = l;
    }

    
    public int getAir()
    {
        return air;
    }

    
    public void getShot()
    {
        if(getOneIntersectingObject(Ammunition.class)!=null)
        {
            life=life-5;
            Ammunition m = (Ammunition)getOneIntersectingObject(Ammunition.class);
            getWorld().removeObject(m);
        }
    }

    
    public void burn()
    {
        if(getOneIntersectingObject(Fire.class)!=null)
        {
            life= life-15;
        }
    }

    
    public void reset()
    {
        if(Keyboard.isKeyDown(KeyEvent.VK_R)||life<=0)
        {
            World world = getWorld();
            Level w = (Level)world;
            Start start = w.start;
            w.setPlayer(start.getX(), start.getY());
            setImage("Joppa_links.png");
            life = 100;
            air = 100;
        }
    }

    
    public void move()
    {

        if(Keyboard.isKeyDown(KeyEvent.VK_LEFT))
        {
            for(int i=V; i>0; i--)
            {
                Block l = null;
                List<Actor> m = getTouchingObjects("l", Block.class, i);
                for(int j = 0; j < m.size(); j++)
                {
                    Block b = (Block) m.get(j);
                    if(b.permeable == false)
                    {
                        l = b;
                    }
                }
                if(l == null)
                {
                    setLocation(getX()-i,getY());
                    break;
                }
            }
            left = true;
            setImage("graphics/Joppa_links.png");
        }

        if(Keyboard.isKeyDown(KeyEvent.VK_RIGHT))
        {
            for(int i=V; i>0; i--)
            {
                Block r = null;
                List<Actor> m = getTouchingObjects("r", Block.class, i);
                for(int j = 0; j < m.size(); j++)
                {
                    Block b = (Block) m.get(j);
                    if(b.permeable == false)
                    {
                        r = b;
                    }
                }
                if(r == null)
                {
                    setLocation(getX()+i,getY());
                    break;
                }
            }
            left = false;
            setImage("graphics/Joppa_rechts.png");
        }

        if(Keyboard.isKeyDown(KeyEvent.VK_UP))
        {
            for(int i=2*V; i>0; i--)
            {
                Block o = (Block)getOneTouchingObject("o", Block.class, i);
                if(getOneIntersectingObject(Ladder.class)!=null && (o == null || o.permeable==true))
                {
                    setLocation(getOneIntersectingObject(Ladder.class).getX(),getY()-i);
                    break;
                }
                if(getOneIntersectingObject(Water.class)!=null && o instanceof Water)
                {
                    setLocation(getX(),getY()-i);
                    break;
                }
            }
        }

        if(Keyboard.isKeyDown(KeyEvent.VK_DOWN))
        {
            for(int i=2*V; i>=0; i--)
            {
                if(getOneTouchingObject("u", Ladder.class, i)!=null)
                {
                    setLocation(getX(),getY()+i);
                    break;
                }
                Block u = (Block)getOneTouchingObject("u", Block.class, i);
                if(getOneIntersectingObject(Water.class)!=null && u instanceof Water)
                {
                    setLocation(getX(),getY()+i);
                    break;
                }
            }
        }

        if((Block)getOneTouchingObject("o", Block.class, V) instanceof Water)
        {
            air=air-2;
            if(air <= 1)
            {
                life=life-5;
            }
        }

        if(getOneTouchingObject("o",Water.class, V)==null)
        {
            air=100;
        }

        if((Block)getOneTouchingObject("o", Block.class, V)==null && Keyboard.isKeyDown(KeyEvent.VK_SPACE))
        {
            Block l = (Block)getOneTouchingObject("l", Block.class, V);
            Block r = (Block)getOneTouchingObject("r", Block.class, V);
            Block u = (Block)getOneTouchingObject("u", Unrushthroughable.class, 1);
            Block v = (Block)getOneTouchingObject("u", Ladder.class, 1);
            if(u !=null || v != null)
            {
                setLocation(getX(),getY()-3*V);
                setLocation(getX(),getY());
            }
            if(getOneIntersectingObject(Water.class)!=null && (l!=null || r!=null))
            {
                setLocation(getX(),getY()-3*V);
                setLocation(getX(),getY());
            }
        }
    }

    /**
     * 
     */
    public void fall()
    {
        if(getOneIntersectingObject(Ladder.class)!=null || getOneIntersectingObject(Water.class)!=null)
        {
            return;
        }

        for(int i = 0; i<=V; i++)
        {
            Actor u = getOneTouchingObject("u",Unrushthroughable.class, i);
            if(u == null)
            {
                int h = i+1;
                Actor v = getOneTouchingObject("u",Unrushthroughable.class, h);
                if(i == V || v != null)
                {
                    setLocation(getX(), getY()+i);
                    u = null;
                    v = null;
                    return;
                }
            }
        }
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
                correctDirection = iActor.getY() >= getY();
            } else if(x == "l") {
                correctDirection = iActor.getX() <= getX();
            } else if(x == "o") {
                correctDirection = iActor.getY() <= getY();
            } else if(x == "r") {
                correctDirection = iActor.getX() >= getX();
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
