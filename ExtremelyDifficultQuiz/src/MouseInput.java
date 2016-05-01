package src;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseInput implements MouseListener {

	private Menu menu;
	private Game game;
	private Correct correct;
	private Q1 q1;
	private Timer timer;

	public MouseInput(Menu m, Game game, Correct correct, Q1 q1, Timer timer) {
		menu = m;
		this.game = game;
		this.correct = correct;
		this.q1 = q1;
		this.timer = timer;
	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@SuppressWarnings("static-access")
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings("static-access")
	@Override
	public void mouseReleased(MouseEvent e) {

		int mx = e.getX();
		int my = e.getY();
		System.out.println("mx:" + mx+" my:"+my);
		if (game.state == Game.STATE.MENU) {
			if (mx >=(500*Game.widthRatio) && mx <= (Game.widthRatio*700)) {
				if (my >= (400*Game.heightRatio) && my <= (Game.heightRatio*500)) {
					// Click on Play Button
					menu.setClick();
					game.state = Game.STATE.valueOf("Q" + game.stack.pop());
					System.out.println(game.getState());
					timer.setTime(9);
					timer.start();
					
				}
			}
			if (mx >= (Game.widthRatio*(Game.WIDTH - 225)) && mx <= (Game.widthRatio*(Game.WIDTH - 125))) {
				if (my >= (Game.heightRatio*825) && my <= (Game.heightRatio*875)) {
					menu.setSound();
				}
			}
		}

		else if (game.state == Game.STATE.Q1) {
			if (mx >= Game.widthRatio*100 && mx <= Game.widthRatio*900) {
				System.out.println("mx: "+mx + " my: "+ my);
				if (my >= Game.heightRatio*250 && my <= Game.heightRatio*350) {
					game.state = Game.STATE.LOSE;
				} else if (my >= Game.heightRatio*400 && my <= Game.heightRatio*500) {
					game.state = Game.STATE.LOSE;
				} else if (my >= Game.heightRatio*550 && my <= Game.heightRatio*650) {
					System.out.println("Right!!");
					if(!game.stack.isEmpty()){
						game.state = Game.STATE.CORRECT;
						correct.setPrevious(1);
					}
					else
						game.state = Game.STATE.WIN;
					if(menu.soundClick)
						game.PA.Blip();
				} else if (my >= Game.heightRatio*700 && my <= Game.heightRatio*800) {
					game.state = Game.STATE.LOSE;
					System.out.println("Why");
				}
			}
		}

		else if (game.state == Game.STATE.Q2) {
			if (mx >= 100*Game.widthRatio && mx <= 900*Game.widthRatio) {
				if (my >= Game.heightRatio*250 && my <= Game.heightRatio*350) {
					game.state = Game.STATE.LOSE;
				} else if (my >= Game.heightRatio*400 && my <= Game.heightRatio*500) {
					game.state = Game.STATE.LOSE;
				} else if (my >= Game.heightRatio*550 && my <= Game.heightRatio*650) {
					System.out.println("Right!!");
					if(!game.stack.isEmpty()){
						game.state = Game.STATE.CORRECT;
						correct.setPrevious(2);
					}
					else
						game.state = Game.STATE.WIN;	
					if(menu.soundClick)
						game.PA.Blip();
				} else if (my >= Game.heightRatio*700 && my <= Game.heightRatio*800) {
					game.state = Game.STATE.LOSE;
				}
			}
		}

		else if (game.state == Game.STATE.Q3) {
			if (mx >= 100*Game.widthRatio && mx <= 900*Game.widthRatio) {
				if (my >= Game.heightRatio*250 && my <= Game.heightRatio*350) {
					game.state = Game.STATE.LOSE;
				} else if (my >= Game.heightRatio*550 && my <= Game.heightRatio*650) {
					game.state = Game.STATE.LOSE;
				} else if (my >= Game.heightRatio*400 && my <= Game.heightRatio*500) {
					if(!game.stack.isEmpty()){
						game.state = Game.STATE.CORRECT;
						correct.setPrevious(3);
					}
					else
						game.state = Game.STATE.WIN;
					if(menu.soundClick)
						game.PA.Blip();
				} else if (my >= Game.heightRatio*700 && my <= Game.heightRatio*800) {
					game.state = Game.STATE.LOSE;
				}
			}
		}

		else if (game.state == Game.STATE.Q4) {
			if (mx >= 100*Game.widthRatio && mx <= 900*Game.widthRatio) {
				if (my >= Game.heightRatio*250 && my <= Game.heightRatio*350) {
					if(!game.stack.isEmpty()){
						game.state = Game.STATE.CORRECT;
						correct.setPrevious(1);
					}
					else
						game.state = Game.STATE.WIN;
					if(menu.soundClick)
						game.PA.Blip();
				} else if (my >= Game.heightRatio*550 && my <= Game.heightRatio*650) {
					game.state = Game.STATE.LOSE;
				} else if (my >= Game.heightRatio*400 && my <= Game.heightRatio*500) {
					game.state = Game.STATE.LOSE;
				} else if (my >= Game.heightRatio*700 && my <= Game.heightRatio*800) {
					game.state = Game.STATE.LOSE;
				}
			}
		}

		else if (game.state == Game.STATE.Q5) {
			if (mx >= 100*Game.widthRatio && mx <= 900*Game.widthRatio) {
				if (my >= Game.heightRatio*250 && my <= Game.heightRatio*350) {
					if(!game.stack.isEmpty()){
						game.state = Game.STATE.CORRECT;
						correct.setPrevious(5);
					}
					else
						game.state = Game.STATE.WIN;
					if(menu.soundClick)
						game.PA.Blip();
				} else if (my >= Game.heightRatio*550 && my <= Game.heightRatio*650) {
					game.state = Game.STATE.LOSE;
				} else if (my >= Game.heightRatio*400 && my <= Game.heightRatio*500) {
					game.state = Game.STATE.LOSE;
					correct.setPrevious(50);
				} else if (my >= Game.heightRatio*700 && my <= Game.heightRatio*800) {
					game.state = Game.STATE.LOSE;
				}
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}