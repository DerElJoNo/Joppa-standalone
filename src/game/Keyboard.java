package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener
{
	public static boolean[] keys = new boolean[1024];
	
	public static boolean isKeyDown(int keycode)
	{
		return keys[keycode];
	}
	
	
	
	@Override
	public void keyPressed(KeyEvent e)
	{
		keys[e.getKeyCode()]= true;
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		keys[e.getKeyCode()]= false;
	}

	@Override
	public void keyTyped(KeyEvent e)
	{
	}

}
