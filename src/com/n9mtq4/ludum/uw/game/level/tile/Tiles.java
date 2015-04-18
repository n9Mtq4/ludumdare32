package com.n9mtq4.ludum.uw.game.level.tile;

import com.n9mtq4.ludum.uw.engine.level.tile.Tile;
import com.n9mtq4.ludum.uw.engine.level.tile.VoidTile;

/**
 * Created by will on 4/18/15 at 10:02 AM.
 */
public class Tiles {
	
	public static final int SIZE = 32;
	public static Tile voidTile = new VoidTile();
	public static Tile wood = new WoodTile();
	public static Tile wall = new WallTile();
	public static Tile bed = new BedTile();
	public static Tile pillow = new PillowTile();
	
}
