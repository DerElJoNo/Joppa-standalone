package game;



import java.awt.Color;

import javax.swing.JFrame;

import game.userInteraction.Frame;


public class Main
{


	public static enum GameState {MENU, INGAME, LEVELCREATION, OPTIONS, LEVELSELECT}
	public static GameState gs = GameState.MENU;
	public static void main(String[] args)
	{
		
		Frame frame = new Frame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setUndecorated(true);
		frame.setVisible(true);
		
		frame.makeBS();
		frame.setButtons();
		
		
		while(true)
		{
			frame.calculate();
			
			frame.repaint();
	    
			pause();
		}
	}

	
	private static void pause()
	{
		try
		{
			Thread.sleep(100);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		
	}
}
