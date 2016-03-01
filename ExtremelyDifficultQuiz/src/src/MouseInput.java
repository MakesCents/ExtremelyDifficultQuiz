package src;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseInput implements MouseListener {
	
	private Menu menu;
	private Graphics g;
	private Graphics2D g2d;
	
	public MouseInput(Menu m){
		menu=m;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {


	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		/** 	
			 	public Rectangle startBtn = new Rectangle((Game.WIDTH-200)/2, 400,200,100);
				public Rectangle soundBtn = new Rectangle(Game.WIDTH-225, 825,100,50); 
		 */

		int mx = e.getX();
		int my=e.getY();
		if(mx>=(Game.WIDTH-200)/2 && mx <= (Game.WIDTH-200)/2+200){
			if(my >= 400 && my <= 500){
				//Click on Play Button
				System.out.println("CLICK");
				menu.setClick();
			}
		}
		
		if(mx>=(Game.WIDTH-225) && mx <= (Game.WIDTH-100)){
			if(my >= 825 && my <= 875){
				//Click on Play Button
				System.out.println("CLICK");
				menu.setSound();
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}



	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}


}
