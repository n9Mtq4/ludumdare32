package com.n9mtq4.ludum.uw.game.entity.monster;

import com.n9mtq4.ludum.uw.engine.entitiy.Projectile;
import com.n9mtq4.ludum.uw.engine.graphics.Screen;
import com.n9mtq4.ludum.uw.game.Sprites;
import com.n9mtq4.ludum.uw.game.entity.projectiles.SlimeProjectile;

import java.util.ArrayList;

/**
 * Created by will on 4/19/15 at 4:18 PM.
 */
public class Ghost extends Monster {
	
	public Ghost(int x, int y) {
		
		this.x = x << Screen.TILE_SIZE;
		this.y = y << Screen.TILE_SIZE;
		this.sprite = Sprites.ghost;
		this.fireRate = SlimeProjectile.rateOfFire;
		initHealth(10);
		
	}
	
	@Override
	public void onProjectileHit(Projectile projectile) {
		if (!(projectile instanceof SlimeProjectile)) {
			health -= projectile.damage;
			projectile.remove();
		}
	}
	
	@Override
	public void render(Screen screen) {
		screen.renderSprite(x, y, sprite);
	}
	
	@Override
	public Projectile getShooter(int x, int y, double angle) {
		return new SlimeProjectile(x, y, angle);
	}
	
	@Override
	public void tick() {
		
		super.tick();
		chaserMovementAi();
		shootingAi(150, SlimeProjectile.rateOfFire);
		
	}
	
}
