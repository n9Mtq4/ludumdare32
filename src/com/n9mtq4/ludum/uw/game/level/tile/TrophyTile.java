package com.n9mtq4.ludum.uw.game.level.tile;

import com.n9mtq4.ludum.uw.engine.entitiy.Entity;
import com.n9mtq4.ludum.uw.engine.entitiy.mob.Mob;
import com.n9mtq4.ludum.uw.engine.level.tile.Tile;
import com.n9mtq4.ludum.uw.game.Sprites;
import com.n9mtq4.ludum.uw.game.entity.monster.Monster;
import com.n9mtq4.ludum.uw.game.entity.player.MainPlayer;

/**
 * Created by will on 4/19/15 at 7:32 PM.
 */
public class TrophyTile extends Tile {
	
	public TrophyTile() {
		super(Sprites.trophy);
	}
	
	@Override
	public boolean isSolid(Entity entity) {
//		monsters can't enter this tile
		return entity instanceof Monster;
	}
	
	@Override
	public void mobIn(Mob mob) {
		
		if (mob instanceof MainPlayer) {
			((MainPlayer) mob).hasWon = true;
		}
		
	}
	
}
