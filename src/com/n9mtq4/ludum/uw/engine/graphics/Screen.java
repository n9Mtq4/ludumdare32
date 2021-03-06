package com.n9mtq4.ludum.uw.engine.graphics;

import com.n9mtq4.ludum.uw.engine.level.tile.Tile;
import com.n9mtq4.ludum.uw.game.Sprites;

/**
 * Created by will on 4/17/15.
 */
public class Screen {
	
	public static final int TILE_SIZE = 5; // 2^TILE_SIZE is the pixel equivalent
	private static final int LEVEL_WIDTH = 64;
	private static final int LEVEL_HEIGHT = 64;
	private static final int TRANSPARENT = 0xffff00ff;
	
	public int width;
	public int height;
	public int[] pixels;
	public int[] tiles;
	
	public int xOff;
	public int yOff;
	
	public Screen(int width, int height) {
		this.width = width;
		this.height = height;
		this.pixels = new int[width * height];
		this.tiles = new int[LEVEL_WIDTH * LEVEL_HEIGHT];
		
	}
	
	public void clear() {
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = 0; // black
		}
	}
	
	public void renderSpriteAbs(int xp, int yp, Sprite sprite) {
		
		for (int y = 0; y < sprite.SIZE; y++) {
			int ya = y + yp;
			for (int x = 0; x < sprite.SIZE; x++) {
				int xa = x + xp;
				if (xa < -sprite.SIZE || xa >= width || ya < 0 || ya >= height) break;
				if (xa < 0) xa = 0;
//				System.out.println((xa + ya * width) + " : (" + xa + " + " + ya + " * " + width + ")");
				int col = sprite.pixels[x + y * sprite.SIZE];
				if (col != TRANSPARENT) {
					pixels[xa + ya * width] = col;
				}
			}
		}
		
	}
	
	public void renderSprite(int xp, int yp, Sprite sprite) {
		
		yp -= yOff;
		xp -= xOff;
		for (int y = 0; y < sprite.SIZE; y++) {
			int ya = y + yp;
			for (int x = 0; x < sprite.SIZE; x++) {
				int xa = x + xp;
				if (xa < -sprite.SIZE || xa >= width || ya < 0 || ya >= height) break;
				if (xa < 0) xa = 0;
//				System.out.println((xa + ya * width) + " : (" + xa + " + " + ya + " * " + width + ")");
				int col = sprite.pixels[x + y * sprite.SIZE];
				if (col != TRANSPARENT) {
					pixels[xa + ya * width] = col;
				}
			}
		}
		
	}
	
	public void renderTile(int xp, int yp, Tile tile) {
		yp -= yOff;
		xp -= xOff;
		for (int y = 0; y < tile.sprite.SIZE; y++) {
			int ya = y + yp;
			for (int x = 0; x < tile.sprite.SIZE; x++) {
				int xa = x + xp;
				if (xa < -tile.sprite.SIZE || xa >= width || ya < 0 || ya >= height) break;
				if (xa < 0) xa = 0;
//				System.out.println((xa + ya * width) + " : (" + xa + " + " + ya + " * " + width + ")");
				if (tile.sprite.pixels[x + y * tile.sprite.SIZE] != TRANSPARENT) {
					pixels[xa + ya * width] = tile.sprite.pixels[x + y * tile.sprite.SIZE];
				}
			}
		}
		
	}
	
	public void setOffset(int xOff, int yOff) {
		this.xOff = xOff;
		this.yOff = yOff;
	}
	
}
