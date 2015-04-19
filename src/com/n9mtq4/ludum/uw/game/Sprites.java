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
	public static Sprite wall = new Sprite(Tiles.SIZE, 0x2f2f2f);
	
	public static Sprite playerb = new Sprite(Tiles.SIZE, 1, 0, sheet);
	public static Sprite playerf = new Sprite(Tiles.SIZE, 1, 1, sheet);
	public static Sprite playerl = new Sprite(Tiles.SIZE, 1, 2, sheet);
	public static Sprite playerr = new Sprite(Tiles.SIZE, 1, 3, sheet);
	
	private static SpriteSheet bed = new SpriteSheet("/textures/bed.png", 128);
	
	public static Sprite bedc = new Sprite(Tiles.SIZE, 0xff0000);
	public static Sprite pillow = new Sprite(Tiles.SIZE, 0xf0f0f0);
//	public static Sprite bed0 = new Sprite(Tiles.SIZE, 0, 0, bed);
//	public static Sprite bed1 = new Sprite(Tiles.SIZE, 1, 0, bed);
//	public static Sprite bed2 = new Sprite(Tiles.SIZE, 2, 0, bed);
//	public static Sprite bed3 = new Sprite(Tiles.SIZE, 3, 0, bed);
//	public static Sprite bed4 = new Sprite(Tiles.SIZE, 1, 0, bed);
//	public static Sprite bed5 = new Sprite(Tiles.SIZE, 1, 1, bed);
//	public static Sprite bed6 = new Sprite(Tiles.SIZE, 1, 2, bed);
//	public static Sprite bed7 = new Sprite(Tiles.SIZE, 1, 3, bed);
	
	private static SpriteSheet hudSheet = new SpriteSheet("/textures/hud.png", 32);
	public static Sprite healthStartFull = new Sprite(8, 0, 0, hudSheet);
	public static Sprite healthMidFull = new Sprite(8, 0, 1, hudSheet);
	public static Sprite healthEndFull = new Sprite(8, 0, 2, hudSheet);
	public static Sprite healthStartEmpty = new Sprite(8, 1, 0, hudSheet);
	public static Sprite healthMidEmpty = new Sprite(8, 1, 1, hudSheet);
	public static Sprite healthEndEmpty = new Sprite(8, 1, 2, hudSheet);
	
}
