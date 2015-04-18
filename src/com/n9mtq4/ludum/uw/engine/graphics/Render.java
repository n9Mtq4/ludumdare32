package com.n9mtq4.ludum.uw.engine.graphics;

import com.n9mtq4.ludum.uw.engine.utils.RgbConverter;

/**
 * Created by will on 4/17/15.
 */
public class Render {
	
	public static final int TRANSPARENT_COLOR = RgbConverter.intoRGB(255, 0, 255);
	
	public int width;
	public int height;
	public int[] pixels;
	
	public Render(int width, int height) {
		this.width = width;
		this.height = height;
		this.pixels = new int[width * height];
	}
	
	public void draw(Render render, int xOff, int yOff) {
		
//		goes through every pixel and checks to make sure its in bounds
		for (int y = 0; y < render.height; y++) {
			int yPx = y + yOff;
			if ((yPx < 0) || (yPx >= height)) continue;
			
			for (int x = 0; x < render.width; x++) {
				int xPx = x + xOff;
				if ((xPx < 0) || (xPx >= width)) continue;
				
				int pixelColor = render.pixels[x + y * render.width];
				if (pixelColor > 0 || pixelColor == TRANSPARENT_COLOR) pixels[xPx + yPx * width] = pixelColor;
				
			}
			
		}
		
	}
	
}
