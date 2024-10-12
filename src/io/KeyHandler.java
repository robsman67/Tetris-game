package io;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import data.Collision;
import game.Game;
import game.GameState;
import infrastructure.GameLoop;
import infrastructure.GameMain;

public class KeyHandler implements KeyListener {

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (Game.gamestate == GameState.start) {
			
			
			
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {				// if the game is at the state start and we press enter on the keyboard then the state game become ingame
				Game.gamestate = GameState.ingame;							

			}
			
			if (e.getKeyCode() == KeyEvent.VK_NUMPAD0 ||  e.getKeyCode() == KeyEvent.VK_0) {			
				Game.gamestate = GameState.ingame;							
				Game.level = 0;
			}
			
			if (e.getKeyCode() == KeyEvent.VK_NUMPAD1 ||  e.getKeyCode() == KeyEvent.VK_1) {			
				Game.gamestate = GameState.ingame;							
				Game.level = 1;
			}
			
			if (e.getKeyCode() == KeyEvent.VK_NUMPAD2 ||  e.getKeyCode() == KeyEvent.VK_2) {			
				Game.gamestate = GameState.ingame;							
				Game.level = 2;
			}
			
			if (e.getKeyCode() == KeyEvent.VK_NUMPAD3 ||  e.getKeyCode() == KeyEvent.VK_3) {			
				Game.gamestate = GameState.ingame;							
				Game.level = 3;
			}
			
			if (e.getKeyCode() == KeyEvent.VK_NUMPAD4 ||  e.getKeyCode() == KeyEvent.VK_4) {			
				Game.gamestate = GameState.ingame;							
				Game.level = 4;
			}
		}

		if (Game.gamestate == GameState.ingame) {
			if (e.getKeyCode() == KeyEvent.VK_SPACE) {
				try {
					if (!Collision.collideInRotation(Game.currentBlock)) {
						Game.currentBlock.rotate();
					}
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}

			}

			if (e.getKeyCode() == KeyEvent.VK_DOWN) {				// if we press down on the keyboard then the block fall quicker
				Game.speedup = true;
			}

			if (e.getKeyCode() == KeyEvent.VK_RIGHT) {

				try {
					if (!Collision.collideWithWall(Game.currentBlock, 1)
							&& !Collision.collideWithBlock(Game.currentBlock, 1)) {
						Game.currentBlock.setX(Game.currentBlock.getX() + 1);
					} 
				} catch (Exception e2) {
					e2.printStackTrace();
					
				}
			} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				try {
					if (!Collision.collideWithWall(Game.currentBlock, -1)
							&& !Collision.collideWithBlock(Game.currentBlock, -1)) {
						Game.currentBlock.setX(Game.currentBlock.getX() - 1);
					} 
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}

			if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {							// pause if we press escape
				Game.gamestate = GameState.pause;

			}
			
			if (e.getKeyCode() == KeyEvent.VK_F) {
				Game.gamestate = GameState.gameover;
				Game.clear();
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {							// restart a new game if we are gameover
					Game.gamestate = GameState.ingame;
					Game.clear();													// reset the grid game 
				}
			}
						
			
		} else if (Game.gamestate == GameState.pause) {							// go back to the game if we press escape a second time
			if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
				Game.gamestate = GameState.ingame;
			}

		} else if (Game.gamestate == GameState.gameover) {
			Game.gamestate = GameState.start;
			Game.clear();
			
		} 

	}

	@Override
	public void keyReleased(KeyEvent e) {			
		if (Game.gamestate == GameState.ingame) {
			if (e.getKeyCode() == KeyEvent.VK_DOWN) {							// if we no long press the down touch then the block no longer go down faster
				Game.speedup = false;
			}
		}

	}

}
