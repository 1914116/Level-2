package Graphics;

import java.awt.Graphics;

public class GameObject {
	int x;
	int y;
	int width;
	int height;
	int speed;

	public GameObject() {

	}

	public void update() {

	}

	public void draw(Graphics g) {
		g.fillRect(x, y, 75, 75);

	}
}