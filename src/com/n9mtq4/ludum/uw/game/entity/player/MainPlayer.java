package com.n9mtq4.ludum.uw.game.entity.player;

import com.n9mtq4.ludum.uw.engine.Display;
import com.n9mtq4.ludum.uw.engine.entitiy.Projectile;
import com.n9mtq4.ludum.uw.engine.entitiy.mob.Player;
import com.n9mtq4.ludum.uw.engine.graphics.Screen;
import com.n9mtq4.ludum.uw.engine.input.KeyBoard;
import com.n9mtq4.ludum.uw.engine.input.Mouse;
import com.n9mtq4.ludum.uw.game.Sprites;
import com.n9mtq4.ludum.uw.game.entity.projectiles.PillowProjectile;

/**
 * Created by will on 4/17/15.
 */
public class MainPlayer extends Player {
	
//	public int pillows = 30;
	
	public MainPlayer(int x, int y, KeyBoard input, Display display) {
		super(x * (1 << Screen.TILE_SIZE), y * (1 << Screen.TILE_SIZE), input, display);
		this.backwards = Sprites.playerb;
		this.forward = Sprites.playerf;
		this.left = Sprites.playerl;
		this.right = Sprites.playerr;
		this.fireRate = PillowProjectile.rateOfFire;
		this.sprite = Sprites.playerf;
	}
	
	@Override
	public Projectile getShooter(int x, int y, double angle) {
		return new PillowProjectile(x, y, angle);
	}
	
	@Override
	public void tick() {
		super.tick();
		if (Mouse.mouseB == 1 && fireRate <= 0) {
//			clicked so fire pillow
			int dx = Mouse.mouseX - Display.getWindowWidth() / 2;
			int dy = Mouse.mouseY - Display.getWindowHeight() / 2;
			double dir = Math.atan2(dy, dx);
			shoot(x, y, dir);
			fireRate = PillowProjectile.rateOfFire;
		}
	}
}
