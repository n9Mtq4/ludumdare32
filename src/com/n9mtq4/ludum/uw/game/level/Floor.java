package com.n9mtq4.ludum.uw.game.level;

import com.n9mtq4.ludum.uw.engine.level.Level;
import com.n9mtq4.ludum.uw.engine.level.tile.Tile;
import com.n9mtq4.ludum.uw.game.entity.monster.Ghost;
import com.n9mtq4.ludum.uw.game.level.tile.Tiles;

/**
 * Created by will on 4/18/15 at 11:06 AM.
 */
public class Floor extends Level {
	
	public Floor(String path) {
		super(path);
	}
	
	public Floor(int width, int height) {
		super(width, height);
	}
	
	@Override
	public void generateLevel() {
		
		add(new Ghost(7, 7));
		
	}
	
	@Override
	public Tile getTile(int x, int y) {
		if (checkBounds(x, y)) return Tiles.voidTile;
		if (tiles[x + y * width] == 0xff2f2f2f) return Tiles.wall;
		if (tiles[x + y * width] == 0xfffffffe) return Tiles.wood;
		if (tiles[x + y * width] == 0xffff0000) return Tiles.spawnBed;
		if (tiles[x + y * width] == 0xffffff00) return Tiles.pillow;
		if (tiles[x + y * width] == 0xfff0000f) return Tiles.tropheyTile; 
		return Tiles.voidTile;
	}
	
}
