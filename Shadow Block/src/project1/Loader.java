package project1;

import java.io.BufferedReader;
import java.io.FileReader;


public class Loader {
	
	
	private static String spriteType;
	private static float x;
	private static float y;
	private static final int NUM_SPRITES = 129;    // Number of the sprite in the file excluding player sprite
	private static Sprite[] sprites = new Sprite[NUM_SPRITES];
	private static Player player;
	// Variables that are available to all classes in the package 
	static int countSprite;
	static int width;
	static int height;
	
	
	// A getter that returns player of type Player
	public static Player getPlayer() {
		return player;
	}
	
	
	/* The method iterates through the array of sprite with coordinates of the
	 * players given to check whether the tile which player is currently on is
	 * of type wall, returns true if it is, in representation of being blocked */
	public static boolean isBlocked(float x, float y) {
		for (int eachSprite = 0; eachSprite < countSprite; eachSprite ++) {
			if (sprites[eachSprite].spriteType.equals("wall")) {
				if (x == sprites[eachSprite].spriteX && y == sprites[eachSprite].spriteY) {
					return true;	
				}
			}
		}
		return false;
	}
	
	
	/**
	 * Loads the sprites from a given file.
	 * @param filename
	 * @return
	 */
	/* The method reads a file line by line and assigns values separated
	 * by commas to relevant variables and store them into an array, at 
	 * the same time, counts the number of sprite in the file excluding
	 * the player sprite which is created separately as an object of type
	 * Player. In the end, it returns the array of sprite */
	public static Sprite[] loadSprites(String filename) {
		
		// Load data from the level file
		try (BufferedReader br = new BufferedReader (new FileReader(filename))) {
			String text;
			
			// Read the first line to determine the position of the world in the window
			String firstLine = br.readLine();
			String size[] = firstLine.split(",");
			width = Integer.parseInt(size[0]);
			height = Integer.parseInt(size[1]);
			
			countSprite = 0;
			while ((text = br.readLine()) != null) {
				String components[] = text.split(",");
				spriteType = components[0];
				x = Float.parseFloat(components[1]);
				y = Float.parseFloat(components[2]);
				if (spriteType.equals("player")) {
					player = new Player(spriteType, x, y);
				} else {
					sprites[countSprite] = new Sprite(spriteType, x, y);
					countSprite ++;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (sprites == null) {
			return null;
		}
		else {
			return sprites;
		}
	}
}
