package com.n9mtq4.ludum.uw.engine.graphics;

import com.n9mtq4.ludum.uw.game.Sprites;

/**
 * Created by will on 4/17/15.
 */
public class Screen {
	
	private static final int TILE_SIZE = 5; // 2^TILE_SIZE is the pixel equivalent
	private static final int LEVEL_WIDTH = 64;
	private static final int LEVEL_HEIGHT = 64;
	private static final int LEVEL_WIDTH_MASK = LEVEL_WIDTH - 1;
	private static final int LEVEL_HEIGHT_MASK = LEVEL_HEIGHT - 1;
	
	private int width;
	private int height;
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
		
		for (int y = 0; y < height; y++) {
			int yp = y + yOff;
			if (yp < 0 || yp >= height) continue;
			for (int x = 0; x < width; x++) {
				int xp = x + xOff;
				if (xp < 0 || xp >= width) continue;
				pixels[xp + yp * width] = Sprites.wood.pixels[(x & Sprites.wood.SIZE_MASK) + (y & Sprites.wood.SIZE_MASK) * Sprites.wood.SIZE];
			}
		}
		
	}
	
}
