import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import Graphics.ObjectManager;

public class GamePanel extends JPanel implements ActionListener, KeyListener {

	Timer timer;
	Bee Bee;
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	static BufferedImage GameBee;
	static BufferedImage EndBee;
	int currentState = MENU_STATE;
	Font titleFont;
	Font startFont;
	Color flower = new Color(255, 255, 204);
	ObjectManager manager;
	
	public GamePanel() {
		Bee = new Bee(100, 250, 75, 75, 5);
		timer = new Timer(1000 / 60, this);
		titleFont = new Font("Arial", Font.PLAIN, 56);
		startFont = new Font("Arial", Font.PLAIN, 36);
		manager = new ObjectManager();
		manager.addObject(Bee);
		try {
			GameBee = ImageIO.read(this.getClass().getResourceAsStream("download.png"));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void startGame() {
		timer.start();
	}

	public void updateMenuState() {

	}

	public void updateGameState() {
		Bee.update();
	}

	public void updateEndState() {

	}

	public void drawMenuState(Graphics g) {
		g.setColor(flower);
		g.fillRect(0, 0, 1000, 750);
		g.setColor(Color.BLACK);
		g.setFont(titleFont);
		g.drawString("BUZZING BEE", 500, 150);
		g.setFont(startFont);
		g.drawString("Press ENTER to Begin", 500, 300);
		g.drawString("Press SHIFT for Instructions", 460, 450);
		g.drawImage(GameBee, 40, 150, 360, 250, null);
	}

	public void drawGameState(Graphics g) {
		g.setColor(Color.CYAN);
		g.fillRect(0, 0, BuzzingBee.WIDTH, BuzzingBee.HEIGHT);
		Bee.draw(g);

	}

	public void drawEndState(Graphics g) {
		g.setColor(Color.ORANGE);
		g.fillRect(0, 0, BuzzingBee.WIDTH, BuzzingBee.HEIGHT);
		g.setColor(Color.BLACK);
		g.setFont(titleFont);
		g.drawString("GAME OVER", 450, 150);
		g.setFont(startFont);
		g.drawString("Press BACKSPACE to Return to Menu", 250, 300);
		g.drawString("You passed" + " (x) pipes...", 460, 450);

	}

	public void paintComponent(Graphics g) {
		if (currentState == MENU_STATE) {
			drawMenuState(g);
		} else if (currentState == GAME_STATE) {
			drawGameState(g);
		} else if (currentState == END_STATE) {
			drawEndState(g);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
		if (currentState == MENU_STATE) {
			updateMenuState();
		} else if (currentState == GAME_STATE) {
			updateGameState();
		} else if (currentState == END_STATE) {
			updateEndState();
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (currentState == MENU_STATE) {
				currentState = GAME_STATE;
			} else if (currentState == GAME_STATE) {
				currentState = END_STATE;
			}
			if (currentState > END_STATE) {
				currentState = MENU_STATE;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
			if (currentState == END_STATE) {
				currentState = MENU_STATE;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_SHIFT) {
			JOptionPane.showMessageDialog(null,
					"Press the SPACE key to fly your bee. Avoid flying into pipes and the ground.");
		}
		
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			Bee.up=true;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			Bee.down=true;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			Bee.right=true;
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			Bee.left=true;
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_SHIFT) {
			System.out.println("I work");
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			Bee.up=false;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			Bee.down=false;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			Bee.right=false;
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			Bee.left=false;
		}
	}

}
