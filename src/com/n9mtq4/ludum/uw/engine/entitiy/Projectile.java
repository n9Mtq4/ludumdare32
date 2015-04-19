package com.n9mtq4.ludum.uw.engine.entitiy;

import com.n9mtq4.ludum.uw.engine.graphics.Sprite;

/**
 * Created by will on 4/19/15 at 1:55 AM.
 */
public class Projectile extends Entity {
	
	protected final int xOrigin;
	protected final int yOrigin;
	protected double angle;
	protected Sprite sprite;
	protected double nx;
	protected double ny;
	protected double speed;
	protected double rateOfFire;
	protected double range;
	protected double damage;
	
	public Projectile(int xOrigin, int yOrigin, double angle) {
		this.xOrigin = xOrigin;
		this.yOrigin = yOrigin;
		this.angle = angle;
		this.x = xOrigin;
		this.y = yOrigin;
	}
	
	@Override
	public void tick() {
		
		move();
		
	}
	
	protected void move() {
		x += nx;
		y += ny;
	}
	
}
