package src;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StartMenu {
	private JButton startBtn= new JButton("START");;
	private JButton soundBtn = new JButton("Sound On");;
	private JLabel titleLabel = new JLabel("THE EXTREMELY DIFFICULT QUIZ");
	private JFrame frame = new JFrame();
	private JPanel panel = new JPanel();

	
	public StartMenu(int w, int h, String title) {
		frame.setPreferredSize(new Dimension(w,h));
		frame.setMaximumSize(new Dimension(w,h));
		frame.setMinimumSize(new Dimension(w,h));
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setTitle(title);
		frame.setResizable(false);
		panel.setBackground(Color.BLACK);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);


		startBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(startBtn.getBackground()==Color.BLUE)
					startBtn.setBackground(Color.YELLOW);
				else
					startBtn.setBackground(Color.BLUE);
			}
		});
		startBtn.setForeground(Color.MAGENTA);
		startBtn.setBackground(Color.BLUE);
		startBtn.setBounds(430, 423, 332, 126);
		panel.add(startBtn);

		titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 31));
		titleLabel.setForeground(Color.ORANGE);
		titleLabel.setBounds(351, 203, 469, 110);
		panel.add(titleLabel);


		soundBtn.setForeground(Color.WHITE);
		soundBtn.setBackground(Color.GREEN);
		soundBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(soundBtn.getBackground()==Color.GREEN){
					soundBtn.setText("Sound Off");
					soundBtn.setBackground(Color.RED);
				}
				else{
					soundBtn.setText("Sound On");
					soundBtn.setBackground(Color.GREEN);
				}
			}
		});
		soundBtn.setBounds(1045, 800, 111, 23);
		panel.add(soundBtn);
	}
}
