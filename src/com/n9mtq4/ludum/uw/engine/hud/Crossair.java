package com.n9mtq4.ludum.uw.engine.hud;

import com.n9mtq4.ludum.uw.engine.graphics.Screen;
import com.n9mtq4.ludum.uw.engine.graphics.Sprite;
import com.n9mtq4.ludum.uw.engine.input.Mouse;
import com.n9mtq4.ludum.uw.game.Sprites;

/**
 * Created by will on 4/19/15 at 4:12 PM.
 */
public class Crossair {
	
	public int mx = 0;
	public int my = 0;
	public Sprite sprite = Sprites.crossair;
	
	public void tick() {
		
	}
	
	public void render(Screen screen) {
//		screen.renderSpriteAbs(Mouse.mouseX - 16, Mouse.mouseY - 16, sprite);
	}
	
}
