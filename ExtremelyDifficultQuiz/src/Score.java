package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Score {

	private Scanner inFile;
	
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
}
