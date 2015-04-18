package com.n9mtq4.ludum.uw.engine.graphics;

/**
 * Created by will on 4/17/15.
 */
public class Screen {
	
	private int width;
	private int height;
	public int[] pixels;
	
	public Screen(int width, int height) {
		this.width = width;
		this.height = height;
		pixels = new int[width * height];
	}
	
	public void clear() {
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = 0x000000; // black
		}
	}
	
	public void render() {
		
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
			}
		}
		
	}
	
}