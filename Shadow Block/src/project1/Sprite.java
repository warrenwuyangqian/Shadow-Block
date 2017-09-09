package project1;

import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;


public class Sprite {
	
	
    String spriteType;
	float spriteX;
	float spriteY;
	private Image spriteImage;
	
	
	/* The constructor assigns values into relevant fields and
	 * determines the the type of the sprite to be drew */
	public Sprite(String image_src, float x, float y) throws SlickException {
		spriteType = image_src;
		spriteX = x;
		spriteY = y;
		if (spriteType.equals("floor")) {
			spriteImage = new Image("res/floor.png");
		} else if (spriteType.equals("stone")) {
			spriteImage = new Image("res/stone.png");
		} else if (spriteType.equals("target")) {
			spriteImage = new Image("res/target.png");
		} else if (spriteType.equals("wall")) {
			spriteImage = new Image("res/wall.png");
		} else {
			spriteImage = new Image("res/player_left.png");
		}
	}
	
	
	public void update(Input input, int delta) {}
	
	
	/* The method converts the tile coordinates of each sprite
	 * into world coordinates and draw the sprite onto the map */
	public void render(Graphics g) throws SlickException {
		spriteImage.drawCentered(World.WIDTH_EXCHANGE + App.TILE_SIZE * spriteX,
				World.HEIGHT_EXCHANGE + App.TILE_SIZE * spriteY);
	}
}
