package com.n9mtq4.ludum.uw.engine.hud;

import com.n9mtq4.ludum.uw.engine.entitiy.mob.Player;
import com.n9mtq4.ludum.uw.engine.graphics.Screen;

/**
 * Created by will on 4/18/15 at 10:44 PM.
 */
public class Hud {
	
	public HealthBar hb = new HealthBar();
	
	public void tick(Player p) {
		
		hb.health = p.health;
		hb.maxHealth = p.maxHealth;
		
	}
	
	public void render(Screen screen) {
		
		hb.render(screen);
		
	}
	
}
