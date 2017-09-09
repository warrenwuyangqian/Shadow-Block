package project1;

import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Graphics;


public class Player extends Sprite {
	
	
	public Player(String spriteType, float spriteX, float spriteY) throws SlickException {
		super(spriteType, spriteX, spriteY);
	}
	
	
	/* The method takes overrides the update method from Sprite class. It takes user input
	 * and determines the movement of the player and check whether the sprite which the
	 * player is on is blocked, if it is, the player will be moved back one sprite */
	@Override
	public void update(Input input, int delta) {
		if (input.isKeyPressed(Input.KEY_UP)) {
			spriteY --;
			if (Loader.isBlocked(spriteX, spriteY)) {
				spriteY ++;
			}
		}
		if (input.isKeyPressed(Input.KEY_DOWN)) {
			spriteY ++;
			if (Loader.isBlocked(spriteX, spriteY)) {
				spriteY --;
			}
		}
		if (input.isKeyPressed(Input.KEY_RIGHT)) {
			spriteX ++;
			if (Loader.isBlocked(spriteX, spriteY)) {
				spriteX --;
			}
		}
		if (input.isKeyPressed(Input.KEY_LEFT)) {
			spriteX --;
			if (Loader.isBlocked(spriteX, spriteY)) {
				spriteX ++;
			}
		}		
	}
	
	
	/* The method takes the tile coordinates of the player, change 
	 * them into world coordinates and draw the player on the map */
	public void render(Graphics g) throws SlickException {
		super.render(g);
	}
}