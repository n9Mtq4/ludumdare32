package com.n9mtq4.ludum.uw.game;

import com.n9mtq4.ludum.uw.engine.graphics.Sprite;
import com.n9mtq4.ludum.uw.engine.graphics.SpriteSheet;
import com.n9mtq4.ludum.uw.game.level.tile.Tiles;

/**
 * Created by will on 4/18/15 at 2:39 AM.
 */
public class Sprites {
	
	private static SpriteSheet sheet = new SpriteSheet("/textures/spritesheet.png", 256);
	public static Sprite wood = new Sprite(Tiles.SIZE, 0, 0, sheet);
	public static Sprite voidSprite = new Sprite(Tiles.SIZE, 0x000000);
	public static Sprite wall = new Sprite(Tiles.SIZE, 0x000000);
	
	
	public static Sprite playerb = new Sprite(Tiles.SIZE, 1, 0, sheet);
	public static Sprite playerf = new Sprite(Tiles.SIZE, 1, 1, sheet);
	public static Sprite playerl = new Sprite(Tiles.SIZE, 1, 2, sheet);
	public static Sprite playerr = new Sprite(Tiles.SIZE, 1, 3, sheet);
	
}
