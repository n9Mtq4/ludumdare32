package com.n9mtq4.ludum.uw.engine.level;

import com.n9mtq4.ludum.uw.engine.graphics.Screen;
import com.n9mtq4.ludum.uw.engine.level.tile.Tile;
import com.n9mtq4.ludum.uw.game.level.Tiles;

/**
 * Created by will on 4/17/15.
 */
public class Level {
	
	public int width;
	public int height;
	public int[] tiles;
	
	public Level(int width, int height) {
		this.width = width;
		this.height = height;
		generateLevel();
	}
	
	public void generateLevel() {
		
	}
	
	public Level(String path) {
		loadLevel(path);
	}
	
	private void loadLevel(String path) {
		
		
		
	}
	
	public void tick() {
		
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
		
	}
	
	public Tile getTile(int x, int y) {
		return Tiles.tiles[0]; //TODO: change
	}
	
	public boolean checkBounds(int x, int y) {
		return ( x < 0 || y < 0 || x >= width || y >= height);
	}
	
}
