package src;

import java.awt.Graphics;

public class Handler {
	
	private Game g;
	
	public Handler(Game g){
		this.g=g;
	}
	
	@SuppressWarnings("static-access")
	public void tick(){
		if(g.state==g.getState()){
		
		}
	}
	
	@SuppressWarnings("static-access")
	public void render(Graphics g){
		if(this.g.state==this.g.getState()){
			
		}
		
	}

}
