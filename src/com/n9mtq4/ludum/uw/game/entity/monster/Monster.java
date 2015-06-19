package com.n9mtq4.ludum.uw.game.entity.monster;

import com.n9mtq4.ludum.uw.engine.entitiy.mob.Mob;

/**
 * Created by will on 4/19/15 at 8:21 PM.
 */
public class Monster extends Mob {
	
	public int health;
	public int maxHealth;
	
	public Monster(int x, int y) {
		super(x, y);
	}
	
	public void initHealth(int hp) {
		this.health = hp;
		this.maxHealth = hp;
	}
	
	@Override
	public void tick() {
		super.tick();
		if (health <= 0) {
			level.remove(this);
			level.score++;
		}
		
	}
}
