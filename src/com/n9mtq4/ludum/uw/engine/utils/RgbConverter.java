package com.n9mtq4.ludum.uw.engine.utils;

/**
 * Created by Will on 4/6/2015.
 */
public class RgbConverter {
	
	/**
	 * Into rGB.
	 *
	 * @param r the r
	 * @param g the g
	 * @param b the b
	 * @return the int
	 */
	public static int intoRGB(int r, int g, int b) {
		return (r << 16) | (g << 8) | b;
	}
	
	/**
	 * Gets red.
	 *
	 * @param rgb the rgb
	 * @return the red
	 */
	public static int getRed(int rgb) {
		return (rgb >> 16) & 0xFF;
	}
	
	/**
	 * Gets green.
	 *
	 * @param rgb the rgb
	 * @return the green
	 */
	public static int getGreen(int rgb) {
		return (rgb >> 8) & 0xFF;
	}
	
	/**
	 * Gets blue.
	 *
	 * @param rgb the rgb
	 * @return the blue
	 */
	public static int getBlue(int rgb) {
		return (rgb) & 0xFF;
	}
	
}
