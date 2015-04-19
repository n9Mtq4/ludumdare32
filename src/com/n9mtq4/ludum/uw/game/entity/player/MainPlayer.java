package com.n9mtq4.ludum.uw.game.entity.player;

import com.n9mtq4.ludum.uw.engine.Display;
import com.n9mtq4.ludum.uw.engine.entitiy.mob.Player;
import com.n9mtq4.ludum.uw.engine.graphics.Screen;
import com.n9mtq4.ludum.uw.engine.input.KeyBoard;
import com.n9mtq4.ludum.uw.engine.input.Mouse;
import com.n9mtq4.ludum.uw.game.Sprites;

/**
 * Created by will on 4/17/15.
 */
public class MainPlayer extends Player {
	
	public int pillows = 30;
	
	public MainPlayer(int x, int y, KeyBoard input, Display display) {
		super(x * (1 << Screen.TILE_SIZE), y * (1 << Screen.TILE_SIZE), input, display);
		this.backwards = Sprites.playerb;
		this.foward = Sprites.playerf;
		this.left = Sprites.playerl;
		this.right = Sprites.playerr;
	}
	
	@Override
	public void tick() {
		super.tick();
		if (Mouse.getButton() == 1) {
//			clicked so fire pillow
			int dx = Mouse.getMouseX() - Display.getWindowWidth() / 2;
			int dy = Mouse.getMouseY() - Display.getWindowHeight() / 2;
			double dir = Math.atan2(dy, dx);
			shoot(x, y, dir);
		}
	}
}
