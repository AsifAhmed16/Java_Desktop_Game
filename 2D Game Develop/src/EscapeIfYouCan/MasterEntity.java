package EscapeIfYouCan;

import javax.swing.text.html.parser.Entity;
import java.awt.Graphics;

public abstract class MasterEntity {

	protected int x, y, w, h;
	protected boolean removed = false;
	
	public MasterEntity(int x, int y){
		this.x=x;
		this.y=y;
	}
	
	public void draw(Graphics g) {
		
	}
	public int getX() { return x; }
	public int getY() { return y; }
	public int getW() { return w; }
	public int getH() { return h; }
	
}
