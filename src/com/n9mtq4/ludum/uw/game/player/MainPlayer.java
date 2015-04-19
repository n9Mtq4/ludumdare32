package com.n9mtq4.ludum.uw.game.player;

import com.n9mtq4.ludum.uw.engine.entitiy.mob.Player;
import com.n9mtq4.ludum.uw.engine.graphics.Screen;
import com.n9mtq4.ludum.uw.engine.input.KeyBoard;
import com.n9mtq4.ludum.uw.game.Sprites;

/**
 * Created by will on 4/17/15.
 */
public class MainPlayer extends Player {
	
	public int health = 100;
	public int maxHealth = 100;
	
	public MainPlayer(KeyBoard input) {
		super(input);
	}
	
	public MainPlayer(int x, int y, KeyBoard input) {
		super(x * (1 << Screen.TILE_SIZE), y * (1 << Screen.TILE_SIZE), input);
		this.backwards = Sprites.playerb;
		this.foward = Sprites.playerf;
		this.left = Sprites.playerl;
		this.right = Sprites.playerr;
	}
	
}
