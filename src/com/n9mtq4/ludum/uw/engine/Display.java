package com.n9mtq4.ludum.uw.engine;

import com.n9mtq4.ludum.uw.engine.entitiy.mob.Player;
import com.n9mtq4.ludum.uw.engine.graphics.Screen;
import com.n9mtq4.ludum.uw.engine.hud.Hud;
import com.n9mtq4.ludum.uw.engine.input.KeyBoard;
import com.n9mtq4.ludum.uw.engine.input.Mouse;
import com.n9mtq4.ludum.uw.engine.level.Level;
import com.n9mtq4.ludum.uw.game.level.Bedroom;
import com.n9mtq4.ludum.uw.game.level.FloorZero;
import com.n9mtq4.ludum.uw.game.entity.player.MainPlayer;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

/**
 * Created by will on 4/17/15.
 */
public class Display extends Canvas implements Runnable {
	
	public static final int WIDTH = 720; // must be multiple of 16
	public static final int HEIGHT = (WIDTH / 16) * 9; // 16 by 9 ratio. if width = 720, height = 405
	public static final int SCALE = 1;
	public static final double GAME_SPEED = 60.0d;
	public static final boolean DEBUG = true;
	
	private Thread thread;
	private boolean running;
	private boolean shouldTick = true;
	private int fps;
	
	private Screen screen;
	private Hud hud;
	private Level level;
	private KeyBoard keyBoard;
	private Player player;
	int progress = 0;
	
	private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
	
	public Display() {
		super(); // canvas constructor doesn't actually do anything, but its nice to have
		Dimension size = new Dimension(WIDTH * SCALE, HEIGHT * SCALE);
		setPreferredSize(size);
		this.screen = new Screen(WIDTH, HEIGHT);
		this.keyBoard = new KeyBoard();
		addKeyListener(keyBoard);
		Mouse mouse = new Mouse(this);
		addMouseListener(mouse);
		addMouseMotionListener(mouse);
		level = new Bedroom();
		player = new MainPlayer(6, 6, keyBoard, this);
		player.init(level);
		level.add(player);
		hud = new Hud();
	}
	
	public synchronized void start() {
		
		if (thread != null) stop();
		running = true;
		thread = new Thread(this, "Display");
		thread.start();
		
	}
	
	public synchronized void stop() {
		try {
			running = false;
			if (thread != null) thread.join();
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void nextLevel() {
		
		if (progress == 0) {
//			TODO: play cut scene?
			level = new FloorZero();
			player.init(level);
			level.add(player);
			progress++;
		}
		
	}
	
	public void render() {
		
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}
		
		screen.clear();
		int xScroll = player.x - screen.width / 2;
		int yScroll = player.y - screen.height / 2;
		level.render(xScroll, yScroll, screen);
//		player.render(screen);
		hud.render(screen);
		
		if (player.health <= 0 || player.hasWon) {
			screen.clear();
		}
		
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = screen.pixels[i];
		}
		
		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.BLACK);
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		
		if (player.health <= 0) {
//			TODO: loose condition
			g.setColor(new Color(255, 255, 0));
			g.setFont(new Font("Verdana", Font.BOLD, 36));
			g.drawString("You have died.", 240, 50);
			g.drawString("Your score was : " + level.score + " out of 50", 240, 80);
			shouldTick = false;
		}
		if (player.hasWon) {
//			TODO: wind condition
			g.setColor(new Color(255, 255, 0));
			g.setFont(new Font("Verdana", Font.BOLD, 36));
			g.drawString("You have Won!.", 240, 50);
			g.drawString("Your score was : " + level.score + " out of 50", 240, 70);
			shouldTick = false;
		}
		
		if (DEBUG) {
			g.setColor(new Color(255, 255, 0));
			g.setFont(new Font("Verdana", Font.BOLD, 36));
			g.drawString(String.valueOf(fps + " fps | " + level.score + " Score out of 50"), 0, HEIGHT - 18);
			g.setFont(new Font("Verdana", Font.BOLD, 12));
		}
		
		g.dispose();
		bs.show();
		
	}
	
	public void mouseUpdate(int x, int y) {
		
//		hud.crossair.render(screen, x, y);
		
	}
	
	public void customCursor(String path, String name, int x, int y) {
		try {
			Toolkit toolkit = Toolkit.getDefaultToolkit();
			BufferedImage image = ImageIO.read(Display.class.getResource(path));
			Cursor cursor = toolkit.createCustomCursor(image, new Point(x, y), name);
			setCursor(cursor);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void tick() {
		
		keyBoard.update();
		level.tick();
		hud.tick(player);
		
	}
	
	@Override
	public void run() {
		
		int frames = 0;
		double unprocessedSeconds = 0;
		long previousTime = System.nanoTime();
		double clockSpeed = 1 / GAME_SPEED;
		int tickCount = 0;
		boolean ticked = false;
		
		requestFocus();
		requestFocusInWindow();
		tick();
		customCursor("/textures/crossair.png", "Crosshair", 5, 5);
		while (running) {
			
//			game loop
			long currentTime = System.nanoTime();
			long passedTime = currentTime - previousTime;
			previousTime = currentTime;
			unprocessedSeconds += passedTime / 1000000000.0;
			
			while (unprocessedSeconds > clockSpeed) {
				
				if (shouldTick) {
					tick();
					ticked = true;
					tickCount++;
				}
				unprocessedSeconds -= clockSpeed;
				if (tickCount % GAME_SPEED == 0) {
					
					System.out.println(tickCount + " ups, " + frames + " fps");
					previousTime += 1000;
					fps = frames;
					frames = 0;
					tickCount = 0;
					
				}
				
			}
			
			if (ticked) {
				
				render();
				frames++;
				ticked = false;
				
			}
			
			render();
			frames++;
			
		}
		
	}
	
	public static int getWindowWidth() {
		return WIDTH * SCALE;
	}
	
	public static int getWindowHeight() {
		return HEIGHT * SCALE;
	}
	
}
