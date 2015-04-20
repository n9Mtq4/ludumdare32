package com.n9mtq4.ludum.uw.engine.level;

import com.n9mtq4.ludum.uw.engine.entitiy.Entity;
import com.n9mtq4.ludum.uw.engine.entitiy.Projectile;
import com.n9mtq4.ludum.uw.engine.entitiy.mob.Player;
import com.n9mtq4.ludum.uw.engine.graphics.Screen;
import com.n9mtq4.ludum.uw.engine.level.tile.Tile;
import com.n9mtq4.ludum.uw.game.level.tile.Tiles;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by will on 4/17/15.
 */
public class Level {
	
	public int width;
	public int height;
	public int[] tiles;
	public int[] tilesInt;
	public int score = 0;
	
	public List<Entity> entities = new ArrayList<Entity>(); //TODO: private
	public List<Projectile> projectiles = new ArrayList<Projectile>(); //TODO: private?
	
	public Level(int width, int height) {
		this.width = width;
		this.height = height;
		this.tilesInt = new int[width * height];
		generateLevel();
	}
	
	public Level(String path) {
		loadLevel(path);
		generateLevel();
	}
	
	public void add(Entity entity) {
		if (entity instanceof Projectile) System.out.println("THIS IS NOT CORRECT YET");
		entity.init(this);
		entities.add(entity);
	}
	
	public void addProjectile(Projectile projectile) {
		projectile.init(this);
		projectiles.add(projectile);
	}
	
	public void remove(Entity entity) {
		entities.remove(entity);
	}
	
	public void generateLevel() {
	}
	
	public void loadLevel(String path) {
		
		try {
			
			BufferedImage i = ImageIO.read(Level.class.getResource(path));
			this.width = i.getWidth();
			this.height = i.getHeight();
			tiles = new int[width * height];
			i.getRGB(0, 0, width, height, tiles, 0, width);
			
		}catch (Exception e) {
			
		}
		
	}
	
	public void tick() {
		for (int i = 0; i < entities.size(); i++) {
			entities.get(i).tick();
		}
		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).tick();
		}
		clearProjectiles();
	}
	
	protected void clearProjectiles() {
		for (int i = 0; i < projectiles.size(); i++) {
			Projectile p = projectiles.get(i);
			if (p.isRemoved()) {
				projectiles.remove(i);
			}
		}
	}
	
	private void time() {
		
	}
	
	public boolean tileCollision(double x, double y, double xd, double yd, int sizex, int sizey, int xOff, int yOff) {
		
		for (int c = 0; c < 4; c++) {
			int xt = (((int) x + (int) xd) + c % 2 * sizex + xOff) / Tiles.SIZE;
			int yt = (((int) y + (int) yd) + c / 2 * sizey + yOff) / Tiles.SIZE;
			if (this.getTile(xt, yt).isSolid()) return true;
		}
		
		return false;
		
	}
	
	public Player getPlayer() {
		
		for (int i = 0; i < entities.size(); i++) {
			if (entities.get(i) instanceof Player) return (Player) entities.get(i);
		}
//		i hope this never gets reached
		return null;
		
	}
	
	/**
	 * renders everything
	 * */
	public void render(int xScroll, int yScroll, Screen screen) {
		screen.setOffset(xScroll, yScroll);
		int x0 = xScroll >> Screen.TILE_SIZE;
		int x1 = (xScroll + screen.width + (1 << Screen.TILE_SIZE)) >> Screen.TILE_SIZE;
		int y0 = yScroll >> Screen.TILE_SIZE;
		int y1 = (yScroll + screen.height + (1 << Screen.TILE_SIZE)) >> Screen.TILE_SIZE;
		
		for (int y = y0; y < y1; y++) {
			for (int x = x0; x < x1; x++) {
				getTile(x, y).render(x, y, screen);
			}
		}
		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).render(screen);
		}
		for (int i = 0; i < entities.size(); i++) {
			entities.get(i).render(screen);
		}
	}
	
	public Tile getTile(int x, int y) {
		return Tiles.voidTile; //TODO: not engine
	}
	
	public boolean checkBounds(int x, int y) {
		return x < 0 || y < 0 || x >= width || y >= height;
	}
	
}
