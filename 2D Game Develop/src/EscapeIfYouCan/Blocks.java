package EscapeIfYouCan;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Blocks extends MasterEntity{
	
	private Rectangle collition;
	private int xd,yd;
	private boolean dead = false;
	private RunningObject instance;

	public Blocks(RunningObject instance, int x, int y) {
		super(x, y);
		this.instance = instance;
		collition = new Rectangle(x, y, 25, 25);
		
		xd = 0;
		yd = 1;
	}
	
	public void draw(Graphics g) {
		move();
		g.setColor(Color.BLUE);
		g.fillRect(collition.x, collition.y, collition.width, collition.height);
	}
	
	private void move(){
		if (instance.getBar().isCollided(collition)) {
			yd = 0;
			dead = true;
		}
		collition.x += xd;
		collition.y += yd;
	}
	public boolean isDead(){
		return dead;
	}
	public Rectangle getCollition() {
		return collition;
	}
}
