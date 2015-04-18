package com.n9mtq4.ludum.uw.engine.entitiy.mob;

/**
 * Created by will on 4/18/15 at 3:11 PM.
 */
public class Player extends Mob {
	
	public Player(int x, int y) {
		
		this.x = x;
		this.y = y;
		
	}
	
	public Player() {
		this(0, 0); //TODO: change later
	}
	
	@Override
	public void render() {
		super.render();
	}
	 
	@Override
	public void tick() {
		super.tick();
	}
	
	@Override
	public void move() {
		super.move(0, 0);
	}
	
	@Override
	public boolean collision() {
		return super.collision();
	}
	
}
