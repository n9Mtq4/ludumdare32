package com.n9mtq4.ludum.uw.game.player;

import com.n9mtq4.ludum.uw.engine.entitiy.mob.Player;
import com.n9mtq4.ludum.uw.engine.input.KeyBoard;
import com.n9mtq4.ludum.uw.game.Sprites;

/**
 * Created by will on 4/17/15.
 */
public class MainPlayer extends Player {
	
	public MainPlayer(KeyBoard input) {
		super(input);
	}
	
	public MainPlayer(int x, int y, KeyBoard input) {
		super(x, y, input);
		this.backwards = Sprites.playerb;
		this.foward = Sprites.playerf;
		this.left = Sprites.playerl;
		this.right = Sprites.playerr;
	}
	
}
