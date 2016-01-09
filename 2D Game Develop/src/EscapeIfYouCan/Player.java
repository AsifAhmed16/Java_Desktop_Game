package EscapeIfYouCan;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Player extends MasterEntity {
	
	private int xDirection, yDirection;
	private RunningObject instance;
	private Rectangle collition;
	private int life = 3;

	public Player(RunningObject instance, int x, int y) {
		super(x, y);
		this.instance = instance;
		w = 16;
		h= 16;
		collition = new Rectangle(x, y, w, h);
	}
	
	public void draw(Graphics g){
		move();
		g.setColor(Color.CYAN);
		g.fillOval(collition.x, collition.y, collition.width, collition.height);
		g.setColor(Color.WHITE);
		g.drawString("Life / Lives : " + life, 20, 20);
	}
	private void move(){
		if(!instance.getBar().isCollided(collition)){
			yDirection = 1;
		} else { 
			yDirection = 0;
		}
		collition.x += xDirection;
		collition.y += yDirection;
		
		if (instance.getAttack().isColliding(collition)) {
			if (life > 0) {
				life= life-1;
				collition.x = 800 / 2 - w / 2;
				y = 390;
			}else {
				instance.setGameOver(true);
			}
		}
	}
	public void setXD(int value) {
		xDirection = value;
	}
	public void setYD(int value) {
		yDirection = value;
	}
}
