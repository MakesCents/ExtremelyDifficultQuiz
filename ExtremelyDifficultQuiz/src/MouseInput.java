package src;

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

		if (game.state == Game.STATE.MENU) {
			if (mx >= (Game.WIDTH - 200) / 2 && mx <= (Game.WIDTH - 200) / 2 + 200) {
				if (my >= 400 && my <= 500) {
					// Click on Play Button
					System.out.println("CLICK");
					menu.setClick();
					game.state = Game.STATE.valueOf("Q" + game.stack.pop());
					timer.setTime(9);
					timer.start();
//					game.state = Game.STATE.Q1;
//					q1.start();
				}
			}
			if (mx >= (Game.WIDTH - 225) && mx <= (Game.WIDTH - 100)) {
				if (my >= 825 && my <= 875) {
					menu.setSound();
				}
			}
		}

		else if (game.state == Game.STATE.Q1) {
			if (mx >= 100 && mx <= 900) {
				System.out.println("mx: "+mx + " my: "+ my);
				if (my >= 250 && my <= 350) {
					game.state = Game.STATE.LOSE;
				} else if (my >= 400 && my <= 500) {
					game.state = Game.STATE.LOSE;
				} else if (my >= 550 && my <= 650) {
					System.out.println("Right!!");
					if(!game.stack.isEmpty()){
						game.state = Game.STATE.CORRECT;
						correct.setPrevious(1);
					}
					else
						game.state = Game.STATE.WIN;
					if(menu.soundClick)
						game.PA.Blip();
				} else if (my >= 700 && my <= 800) {
					game.state = Game.STATE.LOSE;
					System.out.println("Why");
				}
			}
		}

		else if (game.state == Game.STATE.Q2) {
			if (mx >= 100 && mx <= 900) {
				if (my >= 250 && my <= 350) {
					game.state = Game.STATE.LOSE;
				} else if (my >= 400 && my <= 500) {
					game.state = Game.STATE.LOSE;
				} else if (my >= 550 && my <= 650) {
					System.out.println("Right!!");
					if(!game.stack.isEmpty()){
						game.state = Game.STATE.CORRECT;
						correct.setPrevious(2);
					}
					else
						game.state = Game.STATE.WIN;	
					if(menu.soundClick)
						game.PA.Blip();
				} else if (my >= 700 && my <= 800) {
					game.state = Game.STATE.LOSE;
				}
			}
		}

		else if (game.state == Game.STATE.Q3) {
			if (mx >= 100 && mx <= 900) {
				if (my >= 250 && my <= 350) {
					game.state = Game.STATE.LOSE;
				} else if (my >= 550 && my <= 650) {
					game.state = Game.STATE.LOSE;
				} else if (my >= 400 && my <= 500) {
					if(!game.stack.isEmpty()){
						game.state = Game.STATE.CORRECT;
						correct.setPrevious(3);
					}
					else
						game.state = Game.STATE.WIN;
					if(menu.soundClick)
						game.PA.Blip();
				} else if (my >= 700 && my <= 800) {
					game.state = Game.STATE.LOSE;
				}
			}
		}

		else if (game.state == Game.STATE.Q4) {
			if (mx >= 100 && mx <= 900) {
				if (my >= 250 && my <= 350) {
					if(!game.stack.isEmpty()){
						game.state = Game.STATE.CORRECT;
						correct.setPrevious(1);
					}
					else
						game.state = Game.STATE.WIN;
					if(menu.soundClick)
						game.PA.Blip();
				} else if (my >= 550 && my <= 650) {
					game.state = Game.STATE.LOSE;
				} else if (my >= 400 && my <= 500) {
					game.state = Game.STATE.LOSE;
				} else if (my >= 700 && my <= 800) {
					game.state = Game.STATE.LOSE;
				}
			}
		}

		else if (game.state == Game.STATE.Q5) {
			if (mx >= 100 && mx <= 900) {
				if (my >= 250 && my <= 350) {
					if(!game.stack.isEmpty()){
						game.state = Game.STATE.CORRECT;
						correct.setPrevious(5);
					}
					else
						game.state = Game.STATE.WIN;
					if(menu.soundClick)
						game.PA.Blip();
				} else if (my >= 550 && my <= 650) {
					game.state = Game.STATE.LOSE;
				} else if (my >= 400 && my <= 500) {
					game.state = Game.STATE.WIN;
					correct.setPrevious(50);
				} else if (my >= 700 && my <= 800) {
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
