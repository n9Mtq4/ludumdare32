package com.n9mtq4.ludum.uw.engine.entitiy.mob;

import com.n9mtq4.ludum.uw.engine.graphics.Screen;
import com.n9mtq4.ludum.uw.engine.graphics.Sprite;
import com.n9mtq4.ludum.uw.engine.input.KeyBoard;

/**
 * Created by will on 4/18/15 at 3:11 PM.
 */
public class Player extends Mob {
	
	private KeyBoard input;
	private int speed;
	
	protected Sprite foward;
	protected Sprite backwards;
	protected Sprite left;
	protected Sprite right;
	
	public Player(int x, int y, KeyBoard input) {
		
		this.x = x;
		this.y = y;
		this.input = input;
		this.speed = 2;
		
	}
	
	public Player(KeyBoard input) {
		this(0, 0, input); //TODO: change later
	}
	
	@Override
	public void render(Screen screen) {
		if (dir == 0) {
			screen.renderPlayer(x, y, foward);
		}else if (dir == 1) {
			screen.renderPlayer(x, y, right);
		}else if (dir == 2) {
			screen.renderPlayer(x, y, backwards);
		}else if (dir == 3) {
			screen.renderPlayer(x, y, left);
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
	
	@Override
	public boolean collision() {
		return super.collision();
	}
	
}
