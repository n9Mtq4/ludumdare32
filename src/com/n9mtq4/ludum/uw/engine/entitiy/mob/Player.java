package com.n9mtq4.ludum.uw.engine.entitiy.mob;

import com.n9mtq4.ludum.uw.engine.Display;
import com.n9mtq4.ludum.uw.engine.entitiy.Projectile;
import com.n9mtq4.ludum.uw.engine.graphics.Screen;
import com.n9mtq4.ludum.uw.engine.graphics.Sprite;
import com.n9mtq4.ludum.uw.engine.input.KeyBoard;
import com.n9mtq4.ludum.uw.game.entity.projectiles.PillowProjectile;

/**
 * Created by will on 4/18/15 at 3:11 PM.
 */
public class Player extends Mob {
	
	public static boolean invincible = false;
	
	private KeyBoard input;
	private int speed;
	public Display display;
	
	public int health = 100;
	public int maxHealth = 100;
	public boolean hasWon = false;
	
	protected Sprite forward;
	protected Sprite backwards;
	protected Sprite left;
	protected Sprite right;
	
	public Player(int x, int y, KeyBoard input, Display display) {
		
		super(x, y);
		this.x = x;
		this.y = y;
		this.input = input;
		this.speed = 2;
		this.display = display;
		
	}
	
	@Override
	public void onProjectileHit(Projectile projectile) {
		if (!(projectile instanceof PillowProjectile)) {
			if (!invincible) health -= projectile.damage;
			projectile.remove();
		}
	}
	
	@Override
	public void render(Screen screen) {
		if (dir == 0) {
			screen.renderSprite(x, y, forward);
		}else if (dir == 1) {
			screen.renderSprite(x, y, right);
		}else if (dir == 2) {
			screen.renderSprite(x, y, backwards);
		}else if (dir == 3) {
			screen.renderSprite(x, y, left);
		}
	}
	 
	@Override
	public void tick() {
		super.tick();
		if (input.up) move(0, -speed);
		if (input.down) move(0, speed);
		if (input.left) move(-speed, 0);
		if (input.right) move(speed, 0);
	}
	
}
