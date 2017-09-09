package project1;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class World {
	
	
	/* The factors used to convert tile coordinates into 
	 * world coordinates, are not set to final because it
	 * depends on width and height that are read from the file */
    static int HEIGHT_EXCHANGE;
    static int WIDTH_EXCHANGE;
    
	private Sprite[] sprites;
	private Player newPlayer;
	
	
	/* Read the given file and create an array of sprite, use the height and the
	 * width of the world read from first line of the file to determine the position
	 * of the game world within the window. In the end, initialize a player */
	public World() throws SlickException {
		sprites = Loader.loadSprites("res/levels/0.lvl");
		newPlayer = Loader.getPlayer();
		WIDTH_EXCHANGE = (App.SCREEN_WIDTH - Loader.width * App.TILE_SIZE) / 2;
		HEIGHT_EXCHANGE = (App.SCREEN_HEIGHT - Loader.height * App.TILE_SIZE) / 2;

	}
    
	// Update the player coordinates
	public void update(Input input, int delta) {
		newPlayer.update(input, delta);
	}
	
	// Iterate through the array to draw each sprite and then the player
	public void render(Graphics g) throws SlickException {
		for (int spriteIndex = 0; spriteIndex < Loader.countSprite; spriteIndex ++) {
			sprites[spriteIndex].render(g);
		}
		newPlayer.render(g);
	}
}
