package GameState;

import Main.GamePanel;
import TileMap.Background;

import java.awt.*;
import java.awt.event.KeyEvent;

public class MenuState extends GameState {
	
	private Background bg;
	
	private int currentChoice = 0;
	private String[] options = {
			"Start",
			"Help",
			"Quit"
	};
	
	private Color titleColor;
	private Font titleFont;
	
	private Font font;
	
	public MenuState(GameStateManager gsm) {
		
		this.gsm = gsm;
		
		try { 
			
			bg = new Background("/Backgrounds/menubg.gif", 1);
			bg.setVector(-0.1, 0);
			
			titleColor = new Color(128, 0, 0);
			titleFont = new Font("Comic Sans MS", Font.PLAIN, 28);
			
			
			font = new Font("Arial", Font.PLAIN, 12);
			
		}
		catch (Exception e) {
			e.printStackTrace();
		} // end try
		
	} // end constructor

	public void init() {}
		
	public void update() {
		bg.update();
	}
	
	public void draw(Graphics2D g) {
		// draw background
		bg.draw(g);
		
		// draw titles
		g.setColor(titleColor);
		g.setFont(titleFont);
		g.drawString("OTA", 130, 80);
		
		// draw menu options
		g.setFont(font);
		for(int i = 0; i < options.length; i++) {
			if(i == currentChoice) {
				g.setColor(Color.BLACK);
			} 
			else {
				g.setColor(Color.RED);
			}
			g.drawString(options[i], 145, 140 + i * 15);
			
		} // end for
		
	} // end method 
	
	private void select() {
		if(currentChoice == 0) {
			gsm.setState(GameStateManager.LEVEL1STATE);
		} 
		
		if (currentChoice == 1) {
			// help
		}
		
		if (currentChoice == 2) {
			System.exit(0);
		}		
	} // end method
	
	public void keyPressed(int k){
		if (k == KeyEvent.VK_ENTER) {
			select();
		} // enter
		
		if (k == KeyEvent.VK_UP) {
			currentChoice--;
			if(currentChoice == -1) {
				currentChoice = options.length - 1;
			}
		} // up
		
		if (k == KeyEvent.VK_DOWN) {
			currentChoice++;
			if(currentChoice == options.length) {
				currentChoice = 0;
			}
			
		} // down
		
	} // end method 
	
	
	
	public void keyReleased(int k){}
	
	
	
} // end class
