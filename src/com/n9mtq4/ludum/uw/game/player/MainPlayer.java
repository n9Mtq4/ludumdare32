package com.n9mtq4.ludum.uw.game.player;

import com.n9mtq4.ludum.uw.engine.Display;
import com.n9mtq4.ludum.uw.engine.entitiy.mob.Player;
import com.n9mtq4.ludum.uw.engine.graphics.Screen;
import com.n9mtq4.ludum.uw.engine.input.KeyBoard;
import com.n9mtq4.ludum.uw.game.Sprites;

/**
 * Created by will on 4/17/15.
 */
public class MainPlayer extends Player {
	
	
	public MainPlayer(int x, int y, KeyBoard input, Display display) {
		super(x * (1 << Screen.TILE_SIZE), y * (1 << Screen.TILE_SIZE), input, display);
		this.backwards = Sprites.playerb;
		this.foward = Sprites.playerf;
		this.left = Sprites.playerl;
		this.right = Sprites.playerr;
	}
	
}
