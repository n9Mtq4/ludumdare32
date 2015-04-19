package com.n9mtq4.ludum.uw.game.entity;

import com.n9mtq4.ludum.uw.engine.entitiy.Projectile;
import com.n9mtq4.ludum.uw.engine.graphics.Screen;
import com.n9mtq4.ludum.uw.game.Sprites;

/**
 * Created by will on 4/19/15 at 1:57 AM.
 */
public class PillowProjectile extends Projectile {
	
	public static int rateOfFire = 40; // delay between fire
	
	public PillowProjectile(int xOrigin, int yOrigin, double angle) {
		super(xOrigin, yOrigin, angle);
		range = 80;
		damage = 10;
		speed = 3;
		sprite = Sprites.thrownPillow;
		nx = speed * Math.cos(angle);
		ny = speed * Math.sin(angle);
	}
	
	@Override
	public void render(Screen screen) {
		super.render(screen);
	}
}
