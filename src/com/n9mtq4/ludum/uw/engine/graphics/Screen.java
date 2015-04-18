package com.n9mtq4.ludum.uw.engine.graphics;

import com.n9mtq4.ludum.uw.engine.level.tile.Tile;

/**
 * Created by will on 4/17/15.
 */
public class Screen {
	
	public static final int TILE_SIZE = 5; // 2^TILE_SIZE is the pixel equivalent
	private static final int LEVEL_WIDTH = 64;
	private static final int LEVEL_HEIGHT = 64;
	private static final int LEVEL_WIDTH_MASK = LEVEL_WIDTH - 1;
	private static final int LEVEL_HEIGHT_MASK = LEVEL_HEIGHT - 1;
	
	public int width;
	public int height;
	public int[] pixels;
	public int[] tiles;
	
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
	
	public void render(int xOff, int yOff) {
		
		
		
		/*for (int y = 0; y < height; y++) {
			int yp = y + yOff;
			if (yp < 0 || yp >= height) continue;
			for (int x = 0; x < width; x++) {
				int xp = x + xOff;
				if (xp < 0 || xp >= width) continue;
				pixels[xp + yp * width] = Sprites.wood.pixels[(x & Sprites.wood.SIZE_MASK) + (y & Sprites.wood.SIZE_MASK) * Sprites.wood.SIZE];
			}
		}
		*/
	}
	
	public void renderTile(int xp, int yp, Tile tile) {
		
		for (int y = 0; y < tile.sprite.SIZE; y++) {
			int ya = y + yp;
			for (int x = 0; x < tile.sprite.SIZE; x++) {
				int xa = x + xp;
				if (xa < 0 || xa >= width || ya < 0 || ya >= width) break;
				pixels[xa + ya * width] = tile.sprite.pixels[x + y + tile.sprite.SIZE];
			}
		}
		
	}
	
}
