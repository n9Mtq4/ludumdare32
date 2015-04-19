package com.n9mtq4.ludum.uw.engine.level;

import com.n9mtq4.ludum.uw.engine.entitiy.Entity;
import com.n9mtq4.ludum.uw.engine.graphics.Screen;
import com.n9mtq4.ludum.uw.engine.level.tile.Tile;
import com.n9mtq4.ludum.uw.game.level.tile.Tiles;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by will on 4/17/15.
 */
public class Level {
	
	public int width;
	public int height;
	public int[] tiles;
	public int[] tilesInt;
	
	private List<Entity> entities = new ArrayList<Entity>();
	
	public Level(int width, int height) {
		this.width = width;
		this.height = height;
		this.tilesInt = new int[width * height];
		generateLevel();
	}
	
	public Level(String path) {
		loadLevel(path);
		generateLevel();
	}
	
	public void add(Entity entity) {
		entities.add(entity);
	}
	
	public void generateLevel() {
		
	}
	
	public void loadLevel(String path) {
		
		try {
			
			BufferedImage i = ImageIO.read(Level.class.getResource(path));
			this.width = i.getWidth();
			this.height = i.getHeight();
			tiles = new int[width * height];
			i.getRGB(0, 0, width, height, tiles, 0, width);
			generateLevel();
			
		}catch (Exception e) {
			
		}
		
	}
	
	public void tick() {
		for (Entity e : entities) {
			e.tick();
		}
	}
	
	private void time() {
		
	}
	
	/**
	 * renders everything
	 * */
	public void render(int xScroll, int yScroll, Screen screen) {
		screen.setOffset(xScroll, yScroll);
		int x0 = xScroll >> Screen.TILE_SIZE;
		int x1 = (xScroll + screen.width + (1 << Screen.TILE_SIZE)) >> Screen.TILE_SIZE;
		int y0 = yScroll >> Screen.TILE_SIZE;
		int y1 = (yScroll + screen.height + (1 << Screen.TILE_SIZE)) >> Screen.TILE_SIZE;
		
		for (int y = y0; y < y1; y++) {
			for (int x = x0; x < x1; x++) {
				getTile(x, y).render(x, y, screen);
			}
		}
		for (Entity e : entities) {
			e.render(screen);
		}
	}
	
	public Tile getTile(int x, int y) {
		return Tiles.voidTile; //TODO: not engine
	}
	
	public boolean checkBounds(int x, int y) {
		return x < 0 || y < 0 || x >= width || y >= height;
	}
	
}
