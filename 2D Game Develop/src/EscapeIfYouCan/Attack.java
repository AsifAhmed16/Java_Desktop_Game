package EscapeIfYouCan;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Attack {
	
	private int amount;
	private List<Blocks> blocks = new ArrayList<Blocks>();
	private RunningObject instance;

	public Attack(RunningObject instance, int x) {
		this.amount = x;
		this.instance = instance;
		spawn();
	}
	
	public void spawn() {
		Random random = new Random();
		int ss = blocks.size();
		if (ss < amount) {
			for (int i = 0; i < amount - ss; i++) {
				blocks.add(new Blocks(instance, random.nextInt(778), random.nextInt(100) + 1));
			}
		}else if (ss > amount) {
			for (int i = 0; i < ss-amount; i++) {
				blocks.remove(i);
			}
		}
	}
	
	public void draw(Graphics g) {
		update();
		for (Blocks e : blocks ) { e.draw(g); }
	}
	
	private void update(){
		boolean delete = false;
		for (int i = 0; i < blocks.size(); i++) {
			if (blocks.get(i).isDead()) { 
				blocks.remove(i);
				delete = true;
			}
		}
		if(delete) { spawn(); }
	}
	
	public boolean isColliding(Rectangle collition) {
		boolean c = false;
		for (int i = 0; i < blocks.size(); i++) {
			if (collition.intersects(blocks.get(i).getCollition())) 	c = true;
		}
		return c;
	}
	
}
