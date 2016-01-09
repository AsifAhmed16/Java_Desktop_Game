package EscapeIfYouCan;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Bar {

	private Rectangle platformBar = new Rectangle(0, 540, 800, 100);
	
	public Bar() {
		
	}
	public boolean isCollided(Rectangle entity) {
		return platformBar.intersects(entity);
	}
	public void draw(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(platformBar.x, platformBar.y, platformBar.width, platformBar.height);
	}
}
