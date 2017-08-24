package Graphics;

import java.awt.Graphics;

public class Barrier extends GameObject{
	
	public Barrier(int x, int y, int height, int width, int speed){
		this.x=x;
		this.y=y;
		this.height=height;
		this.width=width;
		this.speed=speed;
	}
	public void update(){
		x-=5;	
	}
	public void draw(Graphics g){
		
	}
}
