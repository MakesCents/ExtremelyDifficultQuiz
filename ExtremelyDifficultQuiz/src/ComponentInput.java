package src;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class ComponentInput implements ComponentListener{
	private Game game;
	public ComponentInput(Game g){
		game = g; 
	}
	@Override
	public void componentHidden(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentMoved(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentResized(ComponentEvent e) {
		game.setRatio(e.getComponent().getWidth(), e.getComponent().getHeight());
	}

	@Override
	public void componentShown(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	
}