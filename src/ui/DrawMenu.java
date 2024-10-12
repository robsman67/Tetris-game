package ui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLabel;

import game.Game;
import game.GameState;

public class DrawMenu extends JLabel {
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		if (Game.gamestate == GameState.start) {		// PRESS ENTER TO START LABEL 
			g.setColor(Color.BLUE);
			g.fillRect(0, Gui.height / 2 - 50, Gui.width+200, 100);
			g.setColor(Color.WHITE);
			
			g.drawString("PRESS ENTER TO START", Gui.width/2, Gui.height / 2 +10);
			
			
			g.setColor(Color.RED);
			g.fillRect(0, Gui.height / 2 - 320, Gui.width+25, 200);						//level MENU
			g.setColor(Color.WHITE);
			g.drawString("Press 0 for LEVEL 0 (EASY)", Gui.width/2 -100 , Gui.height / 2 -130);
			g.drawString("Press 1 for LEVEL 1 (NORMAL)", Gui.width/2 -100, Gui.height / 2 -170);
			g.drawString("Press 2 for LEVEL 2 (HARD)", Gui.width/2  -100, Gui.height / 2 -210);
			g.drawString("Press 3 for LEVEL 3 (EXPERT)", Gui.width/2  -100, Gui.height / 2 -250);
			g.drawString("Press 4 for LEVEL 4 (LEGEND)", Gui.width/2  -100, Gui.height / 2 -290);
			
			g.setColor(Color.GRAY);
			g.fillRect(0, Gui.height / 2 + 100, Gui.width+200, 200);						// keyboard MENU
			g.setColor(Color.WHITE);
			g.drawString("Press F to RESTART the Game", Gui.width/2 -80 , Gui.height / 2 +130);
			g.drawString("Press ESCAPE to PAUSE the Game", Gui.width/2 -80, Gui.height / 2 +170);
			g.drawString("Press ESPACE to ROTATE tetris blocks", Gui.width/2  -80, Gui.height / 2 +210);
			g.drawString("Press RIGHT/LEFT to MOVE tetris blocks", Gui.width/2  -80, Gui.height / 2 +250);
			g.drawString("Press DOWN to HARD DROP tetris blocks", Gui.width/2  -80, Gui.height / 2 +290);
			
		}else if(Game.gamestate == GameState.pause) { 	// PRESS ESC TO CONTINUE LABEL
			g.setColor(Color.GRAY);
			g.fillRect(0, Gui.height / 2 - 50, Gui.width+200, 100);
			g.setColor(Color.WHITE);
			g.drawString("PRESS ESC TO CONTINUE", Gui.width/2 -10, Gui.height / 2 +10);
		}else if(Game.gamestate == GameState.gameover){		// YOU LOST PRESS ENTRER TO PLAY AGAIN LABEL
			g.setColor(Color.RED);
			g.fillRect(0, Gui.height / 2 - 50, Gui.width+200, 100);
			g.setColor(Color.WHITE);
			
			g.drawString("YOU LOST. PRESS ENTER TO START AGAIN", 75, Gui.height / 2 +10);
			
			
			g.setColor(Color.GRAY);
			g.fillRect(0, Gui.height / 2 - 320, Gui.width+25, 200);						//level MENU
			g.setColor(Color.WHITE);
			g.drawString("Press 0 for LEVEL 0 (EASY)", Gui.width/2 -100 , Gui.height / 2 -130);
			g.drawString("Press 1 for LEVEL 1 (NORMAL)", Gui.width/2 -100, Gui.height / 2 -170);
			g.drawString("Press 2 for LEVEL 2 (HARD)", Gui.width/2  -100, Gui.height / 2 -210);
			g.drawString("Press 3 for LEVEL 3 (EXPERT)", Gui.width/2  -100, Gui.height / 2 -250);
			g.drawString("Press 4 for LEVEL 4 (LEGEND)", Gui.width/2  -100, Gui.height / 2 -290);
			
			
			g.setColor(Color.GRAY);
			g.fillRect(0, Gui.height / 2 + 100, Gui.width+200, 200);						// keyboard MENU
			g.setColor(Color.WHITE);
			g.drawString("Press F to RESTART the Game", Gui.width/2 -80 , Gui.height / 2 +130);
			g.drawString("Press ESCAPE to PAUSE the Game", Gui.width/2 -80, Gui.height / 2 +170);
			g.drawString("Press ESPACE to ROTATE tetris blocks", Gui.width/2  -80, Gui.height / 2 +210);
			g.drawString("Press RIGHT/LEFT to MOVE tetris blocks", Gui.width/2  -80, Gui.height / 2 +250);
			g.drawString("Press DOWN to HARD DROP tetris blocks", Gui.width/2  -80, Gui.height / 2 +290);
		}

		repaint();
		
	}
}
