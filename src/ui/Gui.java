package ui;


import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;

import io.KeyHandler;

public class Gui {

	public static int width = 320, height = 640;		// accessible everywhere outside the class
	public static JFrame jf;
	

	public void create() throws  IOException {

		jf = new JFrame("Tetris");
		jf.setSize(width + 17 + 200, height + 41); // 10 wide, 18 height ,  for the next block 
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setLocationRelativeTo(null);  // put the window in the middle of the screen
		jf.setResizable(false);
		jf.setLayout(null);
		jf.addKeyListener(new KeyHandler());
		jf.requestFocus();
		


		DrawMenu dm = new DrawMenu();
		setupDraw(dm, 0, 0, width +200, height);
		
		DrawGame dg = new DrawGame();						// draw the grid where there will be the game 
		setupDraw(dg, 0, 1, width + 1, height + 1);        // + 1 so that the last line and column is drawn

		DrawInterface di = new DrawInterface();			  // Draw the interface where there is the next block
		setupDraw(di, width + 1, 1, width, height);		  // We draw it from the right of the grid game
		

		jf.setVisible(true);
	

	}

	private void setupDraw(JLabel draw, int x, int y, int width, int height) {
		draw.setBounds(x, y, width, height);          // set the bounds of the draw component
		draw.setVisible(true);
		jf.add(draw);								  // add to the window the draw component
	}

}
