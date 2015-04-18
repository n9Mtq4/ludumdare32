package com.n9mtq4.ludum.uw.game;

import com.n9mtq4.ludum.uw.engine.graphics.Sprite;
import com.n9mtq4.ludum.uw.engine.graphics.SpriteSheet;

/**
 * Created by will on 4/18/15 at 2:39 AM.
 */
public class Sprites {
	
	private static SpriteSheet sheet = new SpriteSheet("/textures/spritesheet.png", 256);
	public static Sprite wood = new Sprite(32, 0, 0, sheet);
	
}
