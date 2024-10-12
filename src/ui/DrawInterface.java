package ui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLabel;

import data.Conversion;
import game.Game;

public class DrawInterface extends JLabel{
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setColor(Game.nextBlock.getColor());
		for (int j = 0; j < Game.nextBlock.getBounds()[Game.nextBlock.getRotation()].length; j++) {
			for (int k = 0; k < Game.nextBlock.getBounds()[Game.nextBlock.getRotation()][j].length; k++) {

				if (Game.nextBlock.getBounds()[Game.nextBlock.getRotation()][j][k] == 1) {
					g.fillRect(Conversion.cellToCoord(1 + j),
							Conversion.cellToCoord(k), 32, 32);
				}
			}
		}
		
		
		g.setColor(Color.LIGHT_GRAY);
		for (int i = 0; i < 4; i++) {					// grid of the next block
			for (int j = 0; j < 4; j++) {				// same thing as the grid game but smaller 
				g.drawRect(i*32 +32, j*32, 32, 32);
			}
		}
	
		g.setColor(Color.BLACK);
		g.drawRect(32, 0,128, 128);
		
		g.drawString("SCORE: " + Game.score, 32, 200);
		
		g.drawString("BEST: " + Game.highscore, 32, 250);
		
		g.drawString("LINES: " + Game.lines_erased, 32, 300);
		
		g.drawString("LEVEL: " + Game.level, 32, 350);
		
		g.drawString("TIMER: " + Game.timer, 32, 400);
		
		g.drawString("seconds"   , 110 , 420);
		
		
		

		repaint();
	}
	
	
	
}
