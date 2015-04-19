package com.n9mtq4.ludum.uw.engine.input;

import com.n9mtq4.ludum.uw.engine.Display;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * Created by will on 4/19/15 at 12:49 AM.
 */
public class Mouse implements MouseListener, MouseMotionListener {
	
	public volatile static int mouseX = -1;
	public volatile static int mouseY = -1;
	public static int mouseB = -1;
	
	private Display display;
	
	public Mouse(Display display) {
		this.display = display;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		mouseB = e.getButton();
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		mouseB = -1;
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
		
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
		
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		display.mouseUpdate(e.getX(), e.getY());
		mouseX = e.getX();
		mouseY = e.getY();
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		display.mouseUpdate(e.getX(), e.getY());
		mouseX = e.getX();
		mouseY = e.getY();
	}
	
}
