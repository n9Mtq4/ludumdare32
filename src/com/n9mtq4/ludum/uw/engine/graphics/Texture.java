package com.n9mtq4.ludum.uw.engine.graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

/**
 * Created by will on 4/17/15.
 */
public class Texture {
	
	/**
	 * Takes a filePath and returns a Render with the pixels
	 * 
	 * @param filePath The file location inside the jar
	 * @return a Render with the image
	 * */
	private static Render loadBitmap(String filePath) {
		
		try {
			
			BufferedImage image = ImageIO.read(Texture.class.getResource(filePath));
			int width = image.getWidth();
			int height = image.getHeight();
			Render result = new Render(width, height);
			image.getRGB(0, 0, width, height, result.pixels, 0, width); // load the pixels into render
			return result;
			
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
	
}
