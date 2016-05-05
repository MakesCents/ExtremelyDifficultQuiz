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
	private Score score;

	public MouseInput(Menu m, Game game, Correct correct, Q1 q1, Timer timer, Score score) {
		menu = m;
		this.game = game;
		this.correct = correct;
		this.q1 = q1;
		this.timer = timer;
		this.score = score;
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
		System.out.println("mx:" + mx + " my:" + my);
		if (game.state == Game.STATE.MENU) {
			if (mx >= (500 * Game.widthRatio) && mx <= (Game.widthRatio * 700)) {
				if (my >= (400 * Game.heightRatio) && my <= (Game.heightRatio * 500)) {
					// Click on Play Button
					menu.setClick();
					Question question = game.stack.pop();
					game.state = question.getState();
					question.start();

				}
			}
			if (mx >= (Game.widthRatio * (Game.WIDTH - 225)) && mx <= (Game.widthRatio * (Game.WIDTH - 125))) {
				if (my >= (Game.heightRatio * 825) && my <= (Game.heightRatio * 875)) {
					menu.setSound();
				}
			}
		}

		else if (game.state == Game.STATE.Q1) {
			if (mx >= 100 * Game.widthRatio && mx <= 900 * Game.widthRatio) {
				if (my >= Game.heightRatio * 250 && my <= Game.heightRatio * 350) {
					incorrect();
				} else if (my >= Game.heightRatio * 400 && my <= Game.heightRatio * 500) {
					incorrect();
				} else if (my >= Game.heightRatio * 550 && my <= Game.heightRatio * 650) {
					correct();
				} else if (my >= Game.heightRatio * 700 && my <= Game.heightRatio * 800) {
					incorrect();
				}
			}
		}

		else if (game.state == Game.STATE.Q2) {
			if (mx >= 100 * Game.widthRatio && mx <= 900 * Game.widthRatio) {
				if (my >= Game.heightRatio * 250 && my <= Game.heightRatio * 350) {
					incorrect();
				} else if (my >= Game.heightRatio * 400 && my <= Game.heightRatio * 500) {
					incorrect();
				} else if (my >= Game.heightRatio * 550 && my <= Game.heightRatio * 650) {
					correct();
				} else if (my >= Game.heightRatio * 700 && my <= Game.heightRatio * 800) {
					incorrect();
				}
			}
		}

		else if (game.state == Game.STATE.Q3) {
			if (mx >= 100 * Game.widthRatio && mx <= 900 * Game.widthRatio) {
				if (my >= Game.heightRatio * 250 && my <= Game.heightRatio * 350) {
					incorrect();
				} else if (my >= Game.heightRatio * 400 && my <= Game.heightRatio * 500) {
					correct();
				} else if (my >= Game.heightRatio * 550 && my <= Game.heightRatio * 650) {
					incorrect();
				} else if (my >= Game.heightRatio * 700 && my <= Game.heightRatio * 800) {
					incorrect();
				}
			}
		}

		else if (game.state == Game.STATE.Q4) {
			if (mx >= 100 * Game.widthRatio && mx <= 900 * Game.widthRatio) {
				if (my >= Game.heightRatio * 250 && my <= Game.heightRatio * 350) {
					correct();
				} else if (my >= Game.heightRatio * 400 && my <= Game.heightRatio * 500) {
					incorrect();
				} else if (my >= Game.heightRatio * 550 && my <= Game.heightRatio * 650) {
					incorrect();
				} else if (my >= Game.heightRatio * 700 && my <= Game.heightRatio * 800) {
					incorrect();
				}
			}
		}

		else if (game.state == Game.STATE.Q5) {
			if (mx >= 100 * Game.widthRatio && mx <= 900 * Game.widthRatio) {
				if (my >= Game.heightRatio * 250 && my <= Game.heightRatio * 350) {
					incorrect();
				} else if (my >= Game.heightRatio * 400 && my <= Game.heightRatio * 500) {
					correct();
				} else if (my >= Game.heightRatio * 550 && my <= Game.heightRatio * 650) {
					incorrect();
				} else if (my >= Game.heightRatio * 700 && my <= Game.heightRatio * 800) {
					incorrect();
				}
			}
		} else if (game.state == Game.STATE.Q6) {
			if (mx >= 100 * Game.widthRatio && mx <= 900 * Game.widthRatio) {
				if (my >= Game.heightRatio * 250 && my <= Game.heightRatio * 350) {
					incorrect();
				} else if (my >= Game.heightRatio * 400 && my <= Game.heightRatio * 500) {
					incorrect();
				} else if (my >= Game.heightRatio * 550 && my <= Game.heightRatio * 650) {
					incorrect();
				} else if (my >= Game.heightRatio * 700 && my <= Game.heightRatio * 800) {
					correct();
				}
			}
		}

		else if (game.state == Game.STATE.Q7) {
			if (mx >= 100 * Game.widthRatio && mx <= 900 * Game.widthRatio) {
				if (my >= Game.heightRatio * 250 && my <= Game.heightRatio * 350) {
					incorrect();
				} else if (my >= Game.heightRatio * 400 && my <= Game.heightRatio * 500) {
					incorrect();
				} else if (my >= Game.heightRatio * 550 && my <= Game.heightRatio * 650) {
					correct();
				} else if (my >= Game.heightRatio * 700 && my <= Game.heightRatio * 800) {
					incorrect();
				}
			}
		}

		else if (game.state == Game.STATE.Q8) {
			if (mx >= 100 * Game.widthRatio && mx <= 900 * Game.widthRatio) {
				if (my >= Game.heightRatio * 250 && my <= Game.heightRatio * 350) {
					incorrect();
				} else if (my >= Game.heightRatio * 400 && my <= Game.heightRatio * 500) {
					incorrect();
				} else if (my >= Game.heightRatio * 550 && my <= Game.heightRatio * 650) {
					incorrect();
				} else if (my >= Game.heightRatio * 700 && my <= Game.heightRatio * 800) {
					correct();
				}
			}
		}

		else if (game.state == Game.STATE.Q9) {
			if (mx >= 100 * Game.widthRatio && mx <= 900 * Game.widthRatio) {
				if (my >= Game.heightRatio * 250 && my <= Game.heightRatio * 350) {
					incorrect();
				} else if (my >= Game.heightRatio * 400 && my <= Game.heightRatio * 500) {
					incorrect();
				} else if (my >= Game.heightRatio * 550 && my <= Game.heightRatio * 650) {
					correct();
				} else if (my >= Game.heightRatio * 700 && my <= Game.heightRatio * 800) {
					incorrect();
				}
			}
		}

		else if (game.state == Game.STATE.Q10) {
			if (mx >= 100 * Game.widthRatio && mx <= 900 * Game.widthRatio) {
				if (my >= Game.heightRatio * 250 && my <= Game.heightRatio * 350) {
					incorrect();
				} else if (my >= Game.heightRatio * 400 && my <= Game.heightRatio * 500) {
					correct();
				} else if (my >= Game.heightRatio * 550 && my <= Game.heightRatio * 650) {
					incorrect();
				} else if (my >= Game.heightRatio * 700 && my <= Game.heightRatio * 800) {
					incorrect();
				}
			}
		}

		else if (game.state == Game.STATE.Q11) {
			if (mx >= 100 * Game.widthRatio && mx <= 900 * Game.widthRatio) {
				if (my >= Game.heightRatio * 250 && my <= Game.heightRatio * 350) {
					incorrect();
				} else if (my >= Game.heightRatio * 400 && my <= Game.heightRatio * 500) {
					incorrect();
				} else if (my >= Game.heightRatio * 550 && my <= Game.heightRatio * 650) {
					incorrect();
				} else if (my >= Game.heightRatio * 700 && my <= Game.heightRatio * 800) {
					correct();
				}
			}
		}

		else if (game.state == Game.STATE.Q12) {
			if (mx >= 100 * Game.widthRatio && mx <= 900 * Game.widthRatio) {
				if (my >= Game.heightRatio * 250 && my <= Game.heightRatio * 350) {
					correct();
				} else if (my >= Game.heightRatio * 400 && my <= Game.heightRatio * 500) {
					incorrect();
				} else if (my >= Game.heightRatio * 550 && my <= Game.heightRatio * 650) {
					incorrect();
				} else if (my >= Game.heightRatio * 700 && my <= Game.heightRatio * 800) {
					incorrect();
				}
			}
		}

		else if (game.state == Game.STATE.Q13) {
			if (mx >= 100 * Game.widthRatio && mx <= 900 * Game.widthRatio) {
				incorrect();
			} else if (my >= Game.heightRatio * 400 && my <= Game.heightRatio * 500) {
				incorrect();
			} else if (my >= Game.heightRatio * 550 && my <= Game.heightRatio * 650) {
				correct();
			} else if (my >= Game.heightRatio * 700 && my <= Game.heightRatio * 800) {
				incorrect();
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

	public void incorrect() {
		game.state = Game.STATE.LOSE;
		score.updateScore();
		game.resetScore();
	}

	public void correct() {
		if (!game.stack.isEmpty()) {
			game.state = Game.STATE.CORRECT;
			correct.setPrevious(5);
			game.incrementScore();
		} else {
			game.state = Game.STATE.WIN;
			game.incrementScore();
			score.updateScore();
			game.resetScore();
		}
		if (menu.soundClick)
			game.PA.Blip();
	}

}
