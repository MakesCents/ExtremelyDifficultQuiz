/*
 * Author: Timothy Beunte NOT REALLY HE STOLE THIS OFF THE INTERWEBBLOGSPHERENET
 * Date: 2/18/2016
 * 
 * All of the code to make the window appear.
 */

package src;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Window extends Canvas{

	private JButton button1;
	private ActionListener listener;
	public Window(int w, int h, String title){
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//Close when the x is pressed
		frame.setPreferredSize(new Dimension(w,h));
		frame.setMaximumSize(new Dimension(w,h));
		frame.setMinimumSize(new Dimension(w,h));	//Dimensions
		frame.setLocationRelativeTo(null);	//put in middle of screen
		frame.setTitle(title);		//Title obviously
		frame.setResizable(false);	//Now you can't change the size
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		listener = new Listener();
		button1 = new JButton("YOU");
		button1.addActionListener(listener);
		button1.setAlignmentX(Component.CENTER_ALIGNMENT);
		frame.getContentPane().add(button1);
	    frame.pack();
	    frame.setVisible(true);
	
	}
	
	private class Listener implements ActionListener{
			public void actionPerformed(ActionEvent e){
				if(e.getSource() == button1){
					System.out.println("I dunno");
				}
					
			}
	}
}
