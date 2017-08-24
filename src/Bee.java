
import java.awt.Color;
import java.awt.Graphics;

import Graphics.GameObject;

public class Bee extends GameObject {
	int x;
	int y;
	int width;
	int height;
	int speed;
	boolean up = false;
	boolean down = false;
	boolean left = false;
	boolean right = false;
	public Bee(int x, int y, int width, int height, int speed) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.speed = speed;
	}

	
	public void update() {
		y+=5;
		super.update();
		if(up){
			y-=15;
		}
		if(down){
			y+=speed;
		}
		if(left){
			x-=speed;
		}
		if(right){
			x+=speed;
		}
	}

	

	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(x, y, 75, 75);
	}

	public void up() {
		y-=25;
	}
}
