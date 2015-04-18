package com.n9mtq4.ludum.uw.engine;

import com.n9mtq4.ludum.uw.engine.graphics.Screen;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

/**
 * Created by will on 4/17/15.
 */
public class Display extends Canvas implements Runnable {
	
	public static final int WIDTH = 720;
	public static final int HEIGHT = (WIDTH / 16) * 9; // 16 by 9 ratio. if width = 720, height = 405
	public static final int SCALE = 1;
	public static final double GAME_SPEED = 30.0d;
	
	private Thread thread;
	private boolean running;
	private int fps;
	
	private Screen screen;
	
	private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
	
	public Display() {
		super(); // canvas constructor doesn't actually do anything, but its nice to have
		Dimension size = new Dimension(WIDTH * SCALE, HEIGHT * SCALE);
		setPreferredSize(size);
		screen = new Screen(WIDTH, HEIGHT);
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
	
	public void render() {
		
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}
		
		screen.clear();
		screen.render();
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = screen.pixels[i];
		}
		
		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		
		if (true) { // TODO: change to debug latter
			g.setColor(new Color(255, 255, 0));
			g.setFont(new Font("Verdana", Font.BOLD, 36));
			g.drawString(String.valueOf(fps), 0, 30);
		}
		
		g.dispose();
		bs.show();
		
	}
	
	public void tick() {
		
		
		
	}
	
	@Override
	public void run() {
		
		int frames = 0;
		double unprocessedSeconds = 0;
		long previousTime = System.nanoTime();
		double clockSpeed = 1 / GAME_SPEED;
		int tickCount = 0;
		boolean ticked = false;
		
		while (running) {
			
//			game loop
			long currentTime = System.nanoTime();
			long passedTime = currentTime - previousTime;
			previousTime = currentTime;
			unprocessedSeconds += passedTime / 1000000000.0;
			
			while (unprocessedSeconds > clockSpeed) {
				
				tick();
				unprocessedSeconds -= clockSpeed;
				ticked = true;
				tickCount++;
				if (tickCount % GAME_SPEED == 0) {
					
					System.out.println(frames + " fps");
					previousTime += 1000;
					fps = frames;
					frames = 0;
					
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
	
}
