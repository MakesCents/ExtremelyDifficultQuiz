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
	private JPanel panel1;
	private JPanel panel2;
	private JLabel label1;
	private JFrame frame;
	private ActionListener listener;
	public Window(int w, int h, String title){
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//Close when the x is pressed
		frame.setPreferredSize(new Dimension(w,h));
		frame.setMaximumSize(new Dimension(w,h));
		frame.setMinimumSize(new Dimension(w,h));	//Dimensions
		frame.setLocationRelativeTo(null);	//put in middle of screen
		frame.setTitle(title);		//Title obviously
		frame.setResizable(false);	//Now you can't change the size
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		// panel setup
		panel1 = new JPanel();
		panel1.setBackground(Color.gray);
		panel1.setSize(w, h);
		panel2 = new JPanel();
		panel2.setBackground(Color.cyan);
		panel2.setSize(w, h);
		label1 = new JLabel("Next page is successful");
		label1.setBackground(Color.red);
		listener = new Listener();
		button1 = new JButton("START");
		button1.addActionListener(listener);
		button1.setLocation(w/2,h/2);
		panel1.add(button1);
		panel2.add(label1);
		frame.setContentPane(panel1);
	    frame.pack();
	    frame.setVisible(true);
	
	}
	
	private class Listener implements ActionListener{
			public void actionPerformed(ActionEvent e){
				if(e.getSource() == button1){
					System.out.println("Next page");
					frame.setContentPane(panel2);
					frame.pack();
					frame.setVisible(true);
				}
					
			}
	}
}
