package com.n9mtq4.ludum.uw.game.entity;

import com.n9mtq4.ludum.uw.engine.entitiy.Projectile;

/**
 * Created by will on 4/19/15 at 1:57 AM.
 */
public class PillowProjectile extends Projectile {
	
	public PillowProjectile(int xOrigin, int yOrigin, double angle) {
		super(xOrigin, yOrigin, angle);
		range = 200;
		damage = 10;
		rateOfFire = 10;
		nx = Math.cos(angle);
		ny = Math.sin(angle);
	}
	
}
