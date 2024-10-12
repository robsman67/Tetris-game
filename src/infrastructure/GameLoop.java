package infrastructure;

import data.Collision;
import game.Block;
import game.Game;
import game.GameState;

public class GameLoop extends Thread {
	private boolean running = true;

	@Override
	public void run() {
		while (running) {
			try {
				if (Game.gamestate == GameState.ingame) {
					
					if (!Collision.collideWithWall(Game.currentBlock, 0)
							&& !Collision.collideWithBlock(Game.currentBlock, 0)) {
						Game.currentBlock.setY(Game.currentBlock.getY() + 1);
						Collision.collideWithWall(Game.currentBlock, 0);

					}

					if (Game.spawnNewBlock) {
						Collision.checkFullRow(1);
						Game.blocks.add(Game.nextBlock);
						Game.currentBlock = Game.nextBlock;
						Game.nextBlock = new Block();
						Game.spawnNewBlock = false;
					}
				}
				
				if(Game.level == 0) {
					if (!Game.speedup) {
						sleep(1000);     	// if we dont press down on the keyboard there is 1 seconde before the block move down for 1 step
						Game.timer += 1;
					} else {
						sleep(50);			// if we press down then the block go down by 1 step in 0.1 seconde
					}
				}
				else if(Game.level == 1) {
					if (!Game.speedup) {
						sleep(800); 
						Game.timer += 0.8;
					} else {
						sleep(50);			
					}
				}
				
				else if(Game.level == 2) {
					if (!Game.speedup) {
						sleep(500);     
						Game.timer += 0.5;
					} else {
						sleep(50);			
					}
				}
				
				else if(Game.level == 3) {
					if (!Game.speedup) {
						sleep(300);  
						Game.timer += 0.3;
					} else {
						sleep(50);			
					}
				}
				
				else if(Game.level == 4) {
					if (!Game.speedup) {
						sleep(100);  
						Game.timer += 0.1;
					} else {
						sleep(50);			
					}
				}

			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}

	}

}
