package com.n9mtq4.ludum.uw.game;

import com.n9mtq4.ludum.uw.engine.Display;

import javax.swing.*;

/**
 * Created by will on 4/17/15.
 */
public class GameWindow {
	
	public static void main(String[] args) {
		
		JFrame frame = new JFrame("An Unconventional Weapon");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Display game = new Display();
		
		frame.add(game);
		
		frame.setResizable(false);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		game.start();
		
	}
	
}
