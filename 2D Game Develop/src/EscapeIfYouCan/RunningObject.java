package EscapeIfYouCan;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.*;

public class RunningObject extends JPanel implements KeyListener{
	
	private Player player;
	private Bar bar;
	private boolean isGameOver = false;
	private Attack allBlocks;
	
	public RunningObject(){
		setSize(800, 600);
		setPreferredSize(new Dimension(800, 600));
		setFocusable(true);
		addKeyListener(this);
		
		bar = new Bar();
		player = new Player(this, 200, 200);
		allBlocks = new Attack(this, 20);
	}
	
	@Override
	public void update(Graphics g){
		paint(g);
	}
	
	public void paint(Graphics g){
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		bar.draw(g);
		if (!isGameOver) {
			player.draw(g);
			allBlocks.draw(g);
		}else {
			g.setFont(new Font("Century Gothic", Font.BOLD, 48));
			g.drawString("!!! GAME OVER !!!", 200, 250);
		}
		g.dispose();
		repaint();	
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_W) {
//			player.setYD(-1);
		}
		if (key == KeyEvent.VK_A) {
			player.setXD(-1);
		}
		if (key == KeyEvent.VK_S) {
//			player.setYD(1);
		}
		if (key == KeyEvent.VK_D) {
			player.setXD(1);
		}
		
	}

	public void setGameOver(boolean flag) {
		isGameOver = flag;
	}
	@Override
	public void keyReleased(KeyEvent e) {
		player.setXD(0);
		player.setYD(0);		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	public Bar getBar(){
		return bar;
	}
	
	public Attack getAttack() {
		return allBlocks;
	}
	
	public static void main(String[] args) {	
		
		JFrame frame = new JFrame();
		frame.setTitle("!!! Escape If You Can !!!");
		frame.add(new RunningObject());
		frame.pack();
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(800, 600));
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
	}
}
