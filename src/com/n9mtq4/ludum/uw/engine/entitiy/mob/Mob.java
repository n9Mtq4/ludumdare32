package com.n9mtq4.ludum.uw.engine.entitiy.mob;

import com.n9mtq4.ludum.uw.engine.entitiy.Entity;
import com.n9mtq4.ludum.uw.engine.entitiy.Projectile;
import com.n9mtq4.ludum.uw.engine.graphics.Screen;
import com.n9mtq4.ludum.uw.engine.graphics.Sprite;
import com.n9mtq4.ludum.uw.engine.level.Level;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by will on 4/18/15 at 3:06 PM.
 */
public abstract class Mob extends Entity {
	
//	public Sprite sprite;
	public int dir = 0;
	public boolean moving = false;
	
	protected Random random;
	private Player player;
	protected int fireRate = 0;
	protected List<Projectile> projectiles = new ArrayList<Projectile>();
	protected int xd;
	protected int yd;
	
	protected int time;
	
	@Override
	public void init(Level level) {
		super.init(level);
		this.random = new Random();
	}
	
	public void tick() {
		
		time++;
		if (fireRate > 0) fireRate--;
		level.getTile((x) >> Screen.TILE_SIZE, (y) >> Screen.TILE_SIZE).mobIn(this);
		clear();
		
	}
	
	public void shoot(int x, int y, double dir) {
//		dir *= 180 / Math.PI;
		Projectile p = getShooter(x + 32, y + 32, dir); //TODO: no var!
		projectiles.add(p);
		level.add(p);
	}
	
	public Projectile getShooter(int x, int y, double angle) {
		return null;
	}
	
	public void clear() {
		for (int i = 0; i < projectiles.size(); i++) {
			Projectile p = projectiles.get(i);
			if (p.isRemoved()) {
				projectiles.remove(i);
				level.remove(p);
			}
		}
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
	
	public void randomMovementAi() {
		if (time % (random.nextInt(50) + 30) == 0) {
			xd = random.nextInt(3) - 1;
			yd = random.nextInt(3) - 1;
			if (random.nextInt(5) == 0) {
				xd = 0;
				yd = 0;
			}
		}
		move(xd, yd);
	}
	
	public int getDistance(int x1, int y1, int x2, int y2) {
		return (int) Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
	}
	
	public void tryToShoot(int x, int y, double dir, int rate) {
		if (fireRate <= 0) {
			shoot(x, y, dir);
			fireRate = rate;
		}
	}
	
	public void shootingAi(int range, int rate) {
		Player p = level.getPlayer();
		if (getDistance(x, y, p.x, p.y) < range) {
			double dx = p.x - x;
			double dy = p.y - y;
			double dir = Math.atan2(dy, dx);
			tryToShoot(x, y, dir, rate);
		}
	}
	
	public void chaserMovementAi() {
		
		if (player == null) player = level.getPlayer();
		if (getDistance(x, y, player.x, player.y) < 150) {
			if (time % 4 == 0) {
				if (x > player.x) xd--;
				if (x < player.x) xd++;
				if (y > player.y) yd--;
				if (y < player.y) yd++;
				move(xd, yd);
			}
		}else {
			randomMovementAi();
		}
		
	}
	
}
