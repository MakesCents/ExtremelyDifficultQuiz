package src;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class Listener implements ActionListener{
	public void actionPerformed(ActionEvent e, Object source){
		if(e.getSource() == source){
			System.out.println("I dunno");
		}
			
	}
}