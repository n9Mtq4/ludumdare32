package com.n9mtq4.ludum.uw.engine.entitiy.mob;

import com.n9mtq4.ludum.uw.engine.entitiy.Entity;
import com.n9mtq4.ludum.uw.engine.entitiy.Projectile;
import com.n9mtq4.ludum.uw.engine.graphics.Screen;
import com.n9mtq4.ludum.uw.engine.graphics.Sprite;
import com.n9mtq4.ludum.uw.game.entity.PillowProjectile;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by will on 4/18/15 at 3:06 PM.
 */
public abstract class Mob extends Entity {
	
	public Sprite sprite;
	public int dir = 0;
	public boolean moving = false;
	
	protected List<Projectile> projectiles = new ArrayList<Projectile>();
	
	public void tick() {
		
		level.getTile((x) >> Screen.TILE_SIZE, (y) >> Screen.TILE_SIZE).mobIn(this);
		
	}
	
	public void shoot(int x, int y, double dir) {
//		dir *= 180 / Math.PI;
		Projectile p = new PillowProjectile(x, y, dir);
		projectiles.add(p);
		level.add(p);
	}
	
	public void move(int xd, int yd) {
		
		if (xd != 0 && yd != 0) {
			move(xd, 0);
			move(0, yd);
			return;
		}
		
		if (xd > 0) dir = 1;
		if (xd < 0) dir = 3;
		if (yd > 0) dir = 2;
		if (yd < 0) dir = 0;
		
		if (!collision(xd, yd)) {
			x += xd;
			y += yd;
		}
		
	}
	
	public boolean collision(int xd, int yd) {
		
		boolean solid = false;
		for (int c = 0; c < 4; c++) {
			int xt = ((x + xd) + c % 2 * ((int) (Screen.TILE_SIZE * 5))) >> Screen.TILE_SIZE;
			int yt = ((y + yd) + c / 2 * ((int) (Screen.TILE_SIZE * 5))) >> Screen.TILE_SIZE;
			if (level.getTile(xt, yt).isSolid()) return true;
		}
		
		return false;
		
	}
	
}
