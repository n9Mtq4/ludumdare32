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
		if (tiles[x + y * width] == 0xff0f0f0f) return Tiles.voidTile;
		if (tiles[x + y * width] == 0xfffffffe) return Tiles.wood;
		if (tiles[x + y * width] == 0xfff00000) return Tiles.bed0;
		if (tiles[x + y * width] == 0xfff00001) return Tiles.bed1;
		if (tiles[x + y * width] == 0xfff00002) return Tiles.bed2;
		if (tiles[x + y * width] == 0xfff00003) return Tiles.bed3;
		if (tiles[x + y * width] == 0xfff00004) return Tiles.bed4;
		if (tiles[x + y * width] == 0xfff00005) return Tiles.bed5;
		if (tiles[x + y * width] == 0xfff00006) return Tiles.bed6;
		if (tiles[x + y * width] == 0xfff00007) return Tiles.bed7;
		return Tiles.voidTile;
	}
	
}
