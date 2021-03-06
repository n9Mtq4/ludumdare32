package com.n9mtq4.ludum.uw.engine.entitiy;

import com.n9mtq4.ludum.uw.engine.graphics.Screen;
import com.n9mtq4.ludum.uw.engine.graphics.Sprite;
import com.n9mtq4.ludum.uw.engine.level.Level;

/**
 * Created by will on 4/18/15 at 2:58 PM.
 */
public abstract class Entity {
	
	public int x;
	public int y;
	public boolean removed = false;
	public Level level;
	protected Sprite sprite;
//	a random for AI?
	
	public void init(Level level) {
		this.level = level;
	}
	
	public void render(Screen screen) {
		
	}
	
	public void tick() {
		
	}
	
	public void remove() {
		removed = true;
	}
	
	public boolean isRemoved() {
		return removed;
	}
	
	public void onProjectileHit(Projectile projectile) {
		
	}
	
}
