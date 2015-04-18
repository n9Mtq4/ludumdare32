package com.n9mtq4.ludum.uw.engine.graphics;

import java.util.Random;

/**
 * Created by will on 4/17/15.
 */
public class Screen {
	
	private static final int TILE_SIZE = 4; // 2^TILE_SIZE is the pixel equivalent
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
		
		Random random = new Random();
		for (int i = 0; i < tiles.length; i++) {
			tiles[i] = random.nextInt(0xfffffff);
		}
		
	}
	
	public void clear() {
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = 0x000000; // black
		}
	}
	
	public void render(int xOff, int yOff) {
		
		for (int y = 0; y < height; y++) {
			int yy = y;
//			if (yy < 0 || yy >= height) break;
			for (int x = 0; x < width; x++) {
				int xx = x - 3;
//				if (xx < 0 || xx >= width) break;
				int tileIndex = ((xx >> TILE_SIZE) & LEVEL_WIDTH_MASK) + ((yy  >> TILE_SIZE) & LEVEL_HEIGHT_MASK) * LEVEL_WIDTH;
				pixels[x + y * width] = tiles[tileIndex];
			}
		}
		
	}
	
}
