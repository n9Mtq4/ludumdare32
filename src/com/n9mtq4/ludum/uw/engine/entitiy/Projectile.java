package com.n9mtq4.ludum.uw.engine.entitiy;

import com.n9mtq4.ludum.uw.engine.graphics.Screen;
import com.n9mtq4.ludum.uw.engine.graphics.Sprite;

/**
 * Created by will on 4/19/15 at 1:55 AM.
 */
public class Projectile extends Entity {
	
	public static int rateOfFire;
	
	public double x;
	public double y;
	protected final int xOrigin;
	protected final int yOrigin;
	protected double angle;
	protected Sprite sprite;
	protected double nx;
	protected double ny;
	protected double speed;
	protected double range;
	protected double damage;
	
	public Projectile(int xOrigin, int yOrigin, double angle) {
		this.xOrigin = xOrigin;
		this.yOrigin = yOrigin;
		this.angle = angle;
		this.x = xOrigin;
		this.y = yOrigin;
	}
	
	protected void calcAngle() {
		nx = speed * Math.cos(angle);
		ny = speed * Math.sin(angle);
	}
	
	@Override
	public void render(Screen screen) {
		screen.renderSprite((int) x - sprite.SIZE, (int) y - sprite.SIZE, sprite);
	}
	
	@Override
	public void tick() {
		
		move();
		checkDistance();
		if (level.tileCollision(x, y, nx, ny, 16, 16, -20, -24)) {
			remove();
		}
	}
	
	protected void move() {
		x += nx;
		y += ny;
	}
	
	protected void checkDistance() {
		double dist = Math.sqrt((xOrigin - x) * (xOrigin - x) + (yOrigin - y) * (yOrigin - y));
		if (dist > range) remove();
	}
	
}
