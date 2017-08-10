import javax.swing.JFrame;

public class BuzzingBee {
	JFrame game = new JFrame();
	static final int WIDTH = 1000;
	static final int HEIGHT = 700;
	GamePanel gamePanel = new GamePanel();

	public BuzzingBee() {
		setup();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BuzzingBee BB = new BuzzingBee();
	}

	public void setup() {
		game.add(gamePanel);
		game.setVisible(true);
		game.addKeyListener(gamePanel);
		game.setSize(WIDTH, HEIGHT);
		game.setTitle("Buzzing Bee");
		game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gamePanel.startGame();
	}

}
