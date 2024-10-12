package game;

import java.util.ArrayList;

public class Game {
	
	public static int score = 0, highscore = 0, scoreToAdd = 0 , lines_erased = 0 , level ;   // we can access to these variables everywhere in the project
	public static float timer = 0;
	public static boolean spawnNewBlock = false, speedup = false;
	
	public static ArrayList<Block> blocks = new ArrayList<Block>();
	public static Block currentBlock, nextBlock;						 // variable next block for the small part in the top right which tell which block is coming
	
	public static int[][] map = new int[10][20];						 // grid game 
	
	public static GameState gamestate = GameState.start;
	
	public static void clear() {										// reset the grid game 
		for (int x = 0; x < map.length; x++) {
			for (int y = 0; y < map[x].length; y++) {
				map[x][y] = 0;
			}
		}
		score = 0;
	}
	

}
