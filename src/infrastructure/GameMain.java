package infrastructure;

import java.io.IOException;

import game.Block;
import game.Game;
import io.DataHandler;
import ui.Gui;

public class GameMain {
	


	public static void main(String[] args) {
		
		DataHandler.load();
	
		Game.currentBlock = new Block();			// generate the first block
		Game.blocks.add(Game.currentBlock);
		Game.nextBlock = new Block();
		
		try {
			Gui g = new Gui();
			g.create();					// create the window of the game
		} catch (IOException e) {
			System.out.println("Failed to create GUI.");
			e.printStackTrace();
		}
		
		startLoop();
		
	}
	
	public static void startLoop() {
		GameLoop loop = new GameLoop();
		loop.start();
	}

}
