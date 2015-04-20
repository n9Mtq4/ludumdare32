package com.n9mtq4.ludum.uw.game.entity.monster;

import com.n9mtq4.ludum.uw.engine.entitiy.mob.Mob;
import com.n9mtq4.ludum.uw.engine.graphics.Screen;
import com.n9mtq4.ludum.uw.game.Sprites;

/**
 * Created by will on 4/19/15 at 7:09 PM.
 */
public class Zombie extends Mob {
	
	public Zombie(int x, int y) {
		
		this.x = x << Screen.TILE_SIZE;
		this.y = y << Screen.TILE_SIZE;
		this.sprite = Sprites.ghost;
		
	}
	
	@Override
	public void render(Screen screen) {
		screen.renderSprite(x, y, sprite);
	}
	
	@Override
	public void tick() {
		
		
		
	}
	
}
