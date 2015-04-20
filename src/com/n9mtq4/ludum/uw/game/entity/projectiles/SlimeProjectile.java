package com.n9mtq4.ludum.uw.game.entity.projectiles;

import com.n9mtq4.ludum.uw.engine.entitiy.Projectile;
import com.n9mtq4.ludum.uw.game.Sprites;

/**
 * Created by will on 4/19/15 at 6:10 PM.
 */
public class SlimeProjectile extends Projectile {
	
	public static int rateOfFire = 50;
	
	public SlimeProjectile(int xOrigin, int yOrigin, double angle) {
		super(xOrigin, yOrigin, angle);
		range = 100;
		damage = 3;
		speed = 3;
		sprite = Sprites.slimeProjectile;
		calcAngle();
	}
	
	@Override
	public void onProjectileHit(Projectile projectile) {
		if (projectile instanceof PillowProjectile) {
			this.remove();
		}
	}
	
}
