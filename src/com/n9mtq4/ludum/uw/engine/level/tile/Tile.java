package com.n9mtq4.ludum.uw.engine.level.tile;

import com.n9mtq4.ludum.uw.engine.graphics.Screen;
import com.n9mtq4.ludum.uw.engine.graphics.Sprite;

/**
 * Created by will on 4/18/15.
 */
public class Tile {
	
	public int x;
	public int y;
	public Sprite sprite;
	
	public Tile(Sprite sprite) {
		this.sprite = sprite;
	}
	
	public void render(int x, int y, Screen screen) {
		
	}
	
	public boolean isSolid() {
		return false;
	}
	
}
