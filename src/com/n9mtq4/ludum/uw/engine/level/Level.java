package com.n9mtq4.ludum.uw.engine.level;

import com.n9mtq4.ludum.uw.engine.graphics.Screen;

/**
 * Created by will on 4/17/15.
 */
public class Level {
	
	private int width;
	private int height;
	private int[] tiles;
	
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
	
	public void update() {
		
	}
	
	private void time() {
		
	}
	
	/**
	 * renders everything
	 * */
	public void render(int xScroll, int yScroll, Screen screen) {
		int x0 = xScroll >> Screen.TILE_SIZE;
		int x1 = (xScroll + screen.width) >> Screen.TILE_SIZE;
		int y0 = yScroll >> Screen.TILE_SIZE;
		int y1 = (yScroll + screen.height) >> Screen.TILE_SIZE;
	}
	
}
