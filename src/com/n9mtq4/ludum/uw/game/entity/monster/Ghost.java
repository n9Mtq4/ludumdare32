package com.n9mtq4.ludum.uw.game.entity.monster;

import com.n9mtq4.ludum.uw.engine.entitiy.Projectile;
import com.n9mtq4.ludum.uw.engine.entitiy.mob.Mob;
import com.n9mtq4.ludum.uw.engine.graphics.Screen;
import com.n9mtq4.ludum.uw.game.Sprites;

/**
 * Created by will on 4/19/15 at 4:18 PM.
 */
public class Ghost extends Mob {
	
	public Ghost(int x, int y) {
		
		this.x = x << Screen.TILE_SIZE;
		this.y = y << Screen.TILE_SIZE;
		this.sprite = Sprites.bedc;
		
	}
	
	@Override
	public void render(Screen screen) {
		screen.renderSprite(x, y, sprite);
	}
	
	@Override
	public Projectile getShooter(int x, int y, double angle) {
		return super.getShooter(x, y, angle);
	}
	
	@Override
	public void tick() {
		super.tick();
	}
	
}
