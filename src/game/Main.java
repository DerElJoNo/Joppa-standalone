package game;



import java.awt.Color;

import javax.swing.JFrame;


public class Main
{
	public static void main(String[] args)
	{
		
		Frame frame = new Frame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setUndecorated(true);
		frame.setVisible(true);
		
		frame.makeBS();
		
		
		while(true)
		{
			calculate();
			
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


	private static void calculate()
	{
		Actor[] a = Frame.w.actors;
		for(int i=0; i<a.length; i++)
		{
			a[i].act();
		}
		
	}




	
	
	
	
	

	
}
