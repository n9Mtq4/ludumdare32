package com.n9mtq4.ludum.uw.engine.hud;

import com.n9mtq4.ludum.uw.engine.graphics.Screen;
import com.n9mtq4.ludum.uw.game.Sprites;

/**
 * Created by will on 4/18/15 at 10:44 PM.
 */
public class HealthBar {
	
	public int health;
	public int maxHealth;
	private int y = 8;
	
	public void render(Screen screen) {
		
//		math
		int maxBars = (screen.width - (16 * 2)) / 8;
		int fullBars = (maxBars * health) / maxHealth;
//		System.out.println(fullBars + " / " + maxBars);
//		start
		if (fullBars > 0) {
			screen.renderSpriteAbs(12, y, Sprites.healthStartFull); // 16 - (8 / 2) = 12
		}else {
			screen.renderSpriteAbs(12, y, Sprites.healthStartEmpty); // 16 - (8 / 2) = 12
		}
//		segments in middle
		for (int b = 1; b < maxBars; b++) {
			int x = (b << 3) + 8; // multiply by 8 and add the length of the sprite = 8
			if (b < fullBars) {
				screen.renderSpriteAbs(x, y, Sprites.healthMidFull);
			}else {
				screen.renderSpriteAbs(x, y, Sprites.healthMidEmpty);
			}
		}
//		end
		if (fullBars == maxBars) {
			screen.renderSpriteAbs(screen.width - 24, y, Sprites.healthEndFull); // 16 + 8 = 24
		}else {
			screen.renderSpriteAbs(screen.width - 24, y, Sprites.healthEndEmpty); // 16 + 8 = 24
		}
		
	}
	
}
