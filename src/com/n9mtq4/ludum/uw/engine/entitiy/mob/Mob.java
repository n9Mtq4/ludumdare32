package com.n9mtq4.ludum.uw.engine.entitiy.mob;

import com.n9mtq4.ludum.uw.engine.entitiy.Entitiy;
import com.n9mtq4.ludum.uw.engine.graphics.Screen;
import com.n9mtq4.ludum.uw.engine.graphics.Sprite;
import com.n9mtq4.ludum.uw.game.level.tile.Tiles;

/**
 * Created by will on 4/18/15 at 3:06 PM.
 */
public abstract class Mob extends Entitiy {
	
	public Sprite sprite;
	public int dir = 0;
	public boolean moving = false;
	
	public void tick() {
		
		level.getTile((x) >> Screen.TILE_SIZE, (y) >> Screen.TILE_SIZE).mobIn(this);
		
	}
	
	public void move(int xd, int yd) {
		
		if (xd > 0) dir = 1;
		if (xd < 0) dir = 3;
		if (yd > 0) dir = 2;
		if (yd < 0) dir = 0;
		
		if (!collision(xd, yd)) {
			x += xd;
			y += yd;
		}
		
	}
	
	public boolean collision(int xd, int yd) {
		
		return level.getTile((x + xd) >> Screen.TILE_SIZE, (y + yd + Tiles.SIZE) >> Screen.TILE_SIZE).isSolid();
		
	}
	
}
