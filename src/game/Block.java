package game;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import data.Collision;

public class Block {

	BlockType type;
	int x, y, size, rotation = 0;			
	int[][][] bounds;
	Color color;
	boolean movable = true;

	public Block() {

		type = BlockType.random();
		//type = BlockType.I;	// for test we comment the line 20 so that only I block spawn
		
		switch (type) {        // there is different size for blocks so we set a size for each block
		case I:
			size = 4;
			break;
		case O:
			size = 2;
			break;
		default:
			size = 3;

		}

		switch (type) {				// set a different color for each block
		case I:
			color = Color.CYAN;
			break;
		case O:
			color = Color.YELLOW;
			break;
		case T:
			color = Color.MAGENTA;
			break;
		case L:
			color = Color.ORANGE;
			break;
		case J:
			color = Color.BLUE;
			break;
		case Z:
			color = Color.RED;
			break;
		case S:
			color = Color.GREEN;
		}

		x = 4;					// block spawn in the middle of the widht of the grid game where we play
		y = -2;					// so that black appear a little bit higher than the grid game where we play

		try {
			bounds = blockBuilder(type);

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

	}

	public void rotate() {         // so that rotation stay between the value of 0 and 4 because 4 is the maximal number of rotations

		rotation++;

		if (rotation == 4) {
			rotation = 0;
		}

	}

	public int[][][] blockBuilder(BlockType type) throws FileNotFoundException {

		int[][][] bounds;

		switch (type) {
		case I:
			bounds = new int[4][4][4];          // 4 different rotations of a block which is in a 4x4 grid
			break;
		case O:
			bounds = new int[4][2][2];			// 4 rotations ( which are all equals since it's a square ) which is in a 2x2 grid
			break;
		default:
			bounds = new int[4][3][3];			// 4 different rotations for (T,L,J,Z,S) blocks which are is a 3x3 grid 
		}

		File file = new File("rsc/blocks/" + type + ".txt");      // We need to import the file text corresponding to the block we want
		Scanner sc = new Scanner(file);							  // We need a scanner that reads the contents of the text file	that we just have opened	

		for (int variant = 0; variant < 4; variant++) {
			for (int i = 0; i < bounds[0].length; i++) {

				if (sc.hasNext()) {
					String[] srow = sc.next().split("");
					int[] row = new int[bounds[0].length];

					for (int j = 0; j < row.length; j++) {
						row[j] = Integer.valueOf(srow[j]);
						bounds[variant][j][i] = row[j];

					}
				}
			}
		}

		return bounds;

	}

	public int getTypeValue() {
		switch (type) {
		case I:
			return 1;
			
		case O:
			return 2;
		
		case T:
			return 3;
			
		case L:
			return 4;
			
		case J:
			return 5;
			
		case Z:
			return 6;
			
		case S:
			return 7;
		}
		
		return 0;

	}

	public BlockType getType() {
		return type;
	}

	public void setType(BlockType type) {
		this.type = type;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getRotation() {
		return rotation;
	}

	public void setRotation(int rotation) {
		this.rotation = rotation;
	}

	public int[][][] getBounds() {
		return bounds;
	}

	public void setBounds(int[][][] bounds) {
		this.bounds = bounds;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public boolean isMovable() {
		return movable;
	}

	public void setMovable(boolean movable) {
		this.movable = movable;
	}


}
