package com.n9mtq4.ludum.uw.game.level;

import com.n9mtq4.ludum.uw.engine.level.tile.Tile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

/**
 * Created by will on 4/18/15 at 4:55 PM.
 */
public class Bedroom extends Floor {
	
	private Tile[] tiles;
	private int[] levelPixels;
	
	public Bedroom() {
		super("/levels/bedroom1.png");
	}
	
	@Override
	public void generateLevel() {
		
		
		
	}
	
	@Override
	public void loadLevel(String path) {
		
		try {
			
			BufferedImage i = ImageIO.read(Bedroom.class.getResource(path));
			int w = i.getWidth();
			int h = i.getHeight();
			i.getRGB(0, 0, w, h, levelPixels, 0, w);
			generateLevel();
			
		}catch (Exception e) {
			
		}
		
	}
	
}
