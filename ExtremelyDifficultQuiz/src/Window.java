/*
 * Author: Timothy Beunte
 * Date: 2/18/2016
 * 
 * All of the code to make the window appear.
 */

package src;

import java.awt.*;
import javax.swing.*;

public class Window extends Canvas{

	private JFrame frame;
	
	public Window(int w, int h, String title){
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//Close when the x is pressed
		frame.setPreferredSize(new Dimension(w,h));
		frame.setMaximumSize(new Dimension(w,h));
		frame.setMinimumSize(new Dimension(w,h));	//Dimensions
		frame.setLocationRelativeTo(null);	//put in middle of screen
		frame.setTitle(title);		//Title obviously
		frame.setResizable(false);	//No you can't change the size
		
		
		
		frame.pack();				//not completely sure what this means
		frame.setVisible(true);		//I want to be able to see the window
	}
}
