package com.n9mtq4.ludum.uw.game.level.tile;

import com.n9mtq4.ludum.uw.engine.entitiy.mob.Mob;
import com.n9mtq4.ludum.uw.engine.level.tile.Tile;
import com.n9mtq4.ludum.uw.game.Sprites;
import com.n9mtq4.ludum.uw.game.entity.player.MainPlayer;

/**
 * Created by will on 4/19/15 at 7:32 PM.
 */
public class TrophyTile extends Tile {
	
	public TrophyTile() {
		super(Sprites.trophy);
	}
	
	@Override
	public void mobIn(Mob mob) {
		
		if (mob instanceof MainPlayer) {
//			TODO: win condition
			System.out.println("WIN");
		}
		
	}
	
}
