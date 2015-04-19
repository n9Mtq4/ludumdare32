package com.n9mtq4.ludum.uw.engine.graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by will on 4/18/15.
 */
public class SpriteSheet {
	
	private String path;
	public int size;
	public int width;
	public int pixels[];
	
	public SpriteSheet(String path, int width, int height) {
		this.path = path;
		this.width = width;
		this.size = width;
		pixels = new int[width * height];
		load();
	}
	
	public SpriteSheet(String path, int size) {
		this.path = path;
		this.size = size;
		this.width = this.size;
		pixels = new int[this.size * this.size];
		load();
	}
	
	private void load() {
		
		try {
			BufferedImage image = ImageIO.read(SpriteSheet.class.getResource(path));
			int w = image.getWidth();
			int h = image.getHeight();
			image.getRGB(0, 0, w, h, pixels, 0, w);
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
