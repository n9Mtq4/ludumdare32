package com.n9mtq4.ludum.uw.game.level.tile;

import com.n9mtq4.ludum.uw.engine.entitiy.mob.Mob;
import com.n9mtq4.ludum.uw.engine.entitiy.mob.Player;
import com.n9mtq4.ludum.uw.engine.graphics.Sprite;
import com.n9mtq4.ludum.uw.engine.level.tile.Tile;

/**
 * Created by will on 4/18/15 at 5:19 PM.
 */
public class SpawnBedTile extends Tile {
	
	public SpawnBedTile(Sprite sprite) {
		super(sprite);
	}
	
	@Override
	public void mobIn(Mob mob) {
		if (mob instanceof Player) {
			((Player) mob).display.nextLevel();
		}
	}
}
