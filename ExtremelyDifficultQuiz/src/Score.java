package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Score {

	private Scanner inFile;
	private PrintWriter outFile;
	private Game game;
	
	public Score(Game game){
		this.game = game;
	}
	
	public int[] getScore(){
		int[] scores = new int[5];
		
		try {
			inFile = new Scanner(new File("res/int_score.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		for (int i = 0; i < 5; i++){
			scores[i] = inFile.nextInt();
		}
		
		return scores;
	}
	
	public String[] getNames(){
		String[] names = new String[5];
		
		try{
			inFile = new Scanner(new File("res/String_score.txt"));
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}
		
		for (int i = 0; i < 5; i++){
			names[i] = inFile.next();
		}
			
		return names;
	}
	
	public void updateScore(){
		int[] scores = new int[5];
		int score = game.getPlayerScore();
		int temp = 0;
		
		try{
			inFile = new Scanner(new File("res/int_score.txt"));
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}
		
		for (int i = 0; i < 5; i++){
			scores[i] = inFile.nextInt();
		}
		
		for (int i = 0; i < 5; i++){
			if (score > scores[i]){
				temp = scores[i];
				scores[i] = score;
				score = temp;
			}
		}
		
		try {
			outFile = new PrintWriter("res/int_score.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		for (int i = 0; i < 5; i++){
			outFile.println(scores[i]);
		}
		
		outFile.close();
	}
	
	public void updateNames(){
		
	}
}
