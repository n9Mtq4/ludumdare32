package com.n9mtq4.ludum.uw.engine.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by will on 4/18/15 at 1:32 AM.
 */
public class KeyBoard implements KeyListener {
	
	private boolean[] keys = new boolean[128]; // 128 keys
	public boolean up, down, left, right;
	
	public boolean hasKeyBeenPressed(int keyCode) {
		return keys[keyCode];
	}
	
	public void update() {
		
		up = keys[KeyEvent.VK_UP] || keys[KeyEvent.VK_W];
		down = keys[KeyEvent.VK_DOWN] || keys[KeyEvent.VK_S];
		left = keys[KeyEvent.VK_LEFT] || keys[KeyEvent.VK_A];
		right = keys[KeyEvent.VK_RIGHT] || keys[KeyEvent.VK_D];
		
	}
	
	@Override
	public void keyTyped(KeyEvent keyEvent) {
		
	}
	
	@Override
	public void keyPressed(KeyEvent keyEvent) {
		keys[keyEvent.getKeyCode()] = true;
	}
	
	@Override
	public void keyReleased(KeyEvent keyEvent) {
		keys[keyEvent.getKeyCode()] = false;
	}
	
}
