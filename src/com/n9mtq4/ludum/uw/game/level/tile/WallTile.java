package com.n9mtq4.ludum.uw.game.level.tile;

import com.n9mtq4.ludum.uw.engine.entitiy.Entity;
import com.n9mtq4.ludum.uw.engine.level.tile.Tile;
import com.n9mtq4.ludum.uw.game.Sprites;

/**
 * Created by will on 4/18/15 at 4:50 PM.
 */
public class WallTile extends Tile {
	
	public WallTile() {
		super(Sprites.wall);
	}
	
	@Override
	public boolean isSolid(Entity entity) {
		return true;
	}
	
}
