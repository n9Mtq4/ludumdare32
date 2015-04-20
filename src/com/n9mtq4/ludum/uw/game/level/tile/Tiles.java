package com.n9mtq4.ludum.uw.game.level.tile;

import com.n9mtq4.ludum.uw.engine.graphics.Screen;
import com.n9mtq4.ludum.uw.engine.level.tile.Tile;
import com.n9mtq4.ludum.uw.engine.level.tile.VoidTile;
import com.n9mtq4.ludum.uw.game.Sprites;

/**
 * Created by will on 4/18/15 at 10:02 AM.
 */
public class Tiles {
	
	public static final int SIZE = (1 << Screen.TILE_SIZE);
	public static Tile voidTile = new VoidTile();
	public static Tile wood = new WoodTile();
	public static Tile wall = new WallTile();
	public static Tile tropheyTile = new TrophyTile();
	
	public static Tile spawnBed = new SpawnBedTile(Sprites.bedc);
	public static Tile pillow = new SpawnBedTile(Sprites.pillow);
//	public static Tile bed0 = new BedTile(Sprites.bed0);
//	public static Tile bed1 = new BedTile(Sprites.bed1);
//	public static Tile bed2 = new BedTile(Sprites.bed2);
//	public static Tile bed3 = new BedTile(Sprites.bed3);
//	public static Tile bed4 = new BedTile(Sprites.bed4);
//	public static Tile bed5 = new BedTile(Sprites.bed5);
//	public static Tile bed6 = new BedTile(Sprites.bed6);
//	public static Tile bed7 = new BedTile(Sprites.bed7);
	
}
