package com.n9mtq4.ludum.uw.engine.graphics;

/**
 * Created by will on 4/18/15.
 */
public class Sprite {
	
	public final int SIZE;
	public final int SIZE_MASK;
	public int x;
	public int y;
	public int[] pixels;
	private SpriteSheet sheet;
	
	public Sprite(int size, int x, int y, SpriteSheet sheet) {
		this.SIZE = size;
		this.SIZE_MASK = SIZE - 1;
		this.x = x * SIZE;
		this.y = y * SIZE;
		this.sheet = sheet;
		this.pixels = new int[SIZE * SIZE];
	}
	
	private void load() {
		
		for (int y = 0; y < SIZE; y++) {
			for (int x = 0; x < SIZE; x++) {
				pixels[x + y * SIZE] = sheet.pixels[(x + this.x) + (y + this.y) * sheet.SIZE];
			}
		}
		
	}
	
}
