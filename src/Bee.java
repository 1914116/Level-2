
import java.awt.Color;
import java.awt.Graphics;

import Graphics.GameObject;

public class Bee extends GameObject {
	int x;
	int y;
	int width;
	int height;
	int speed;

	public Bee(int x, int y, int width, int height, int speed) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.speed = speed;
	}

	public void update() {
		x = +speed;
	}

	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(x, y, 75, 75);
	}

	public void up() {
		y = +25;
	}
}
