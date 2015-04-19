package com.n9mtq4.ludum.uw.engine.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * Created by will on 4/19/15 at 12:49 AM.
 */
public class Mouse implements MouseListener, MouseMotionListener {
	
	private static int mouseX = -1;
	private static int mouseY = -1;
	private static int mouseB = -1;
	
	public static int getMouseX() {
		return mouseX;
	}
	
	public static int getMouseY() {
		return mouseY;
	}
	
	public static int getButton() {
		return mouseB;
	}
	
	@Override
	public void mouseClicked(MouseEvent mouseEvent) {
		
	}
	
	@Override
	public void mousePressed(MouseEvent mouseEvent) {
		mouseB = mouseEvent.getButton();
	}
	
	@Override
	public void mouseReleased(MouseEvent mouseEvent) {
		mouseB = -1;
	}
	
	@Override
	public void mouseEntered(MouseEvent mouseEvent) {
		
	}
	
	@Override
	public void mouseExited(MouseEvent mouseEvent) {
		
	}
	
	@Override
	public void mouseDragged(MouseEvent mouseEvent) {
		mouseX = mouseEvent.getX();
		mouseY = mouseEvent.getY();
	}
	
	@Override
	public void mouseMoved(MouseEvent mouseEvent) {
		mouseX = mouseEvent.getX();
		mouseY = mouseEvent.getY();
	}
	
}
