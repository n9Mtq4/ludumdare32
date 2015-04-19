package com.n9mtq4.ludum.uw.game.level;

import com.n9mtq4.ludum.uw.engine.level.Level;
import com.n9mtq4.ludum.uw.engine.level.tile.Tile;
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
		
	/*	tiles = new int[width * height];
		for (int i = 0; i < tiles.length; i++) {
			tiles[i] = 1;
		}
		*/
	}
	
	@Override
	public Tile getTile(int x, int y) {
		if (checkBounds(x, y)) return Tiles.voidTile;
		if (tiles[x + y * width] == 0xff2f2f2f) return Tiles.wall;
		if (tiles[x + y * width] == 0xfffffffe) return Tiles.wood;
		if (tiles[x + y * width] == 0xffff0000) return Tiles.spawnBed;
		if (tiles[x + y * width] == 0xffffff00) return Tiles.pillow;
//		if (tiles[x + y * width] == 0xff00000f) return Tiles.bed0;
//		if (tiles[x + y * width] == 0xff0000f0) return Tiles.bed1;
//		if (tiles[x + y * width] == 0xff000f00) return Tiles.bed2;
//		if (tiles[x + y * width] == 0xff00f000) return Tiles.bed3;
//		if (tiles[x + y * width] == 0xffff0f00) return Tiles.bed4;
//		if (tiles[x + y * width] == 0xfff00000) return Tiles.bed5;
//		if (tiles[x + y * width] == 0xff0000ff) return Tiles.bed6;
//		if (tiles[x + y * width] == 0xff000f0f) return Tiles.bed7;
		return Tiles.voidTile;
	}
	
}
