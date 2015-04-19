package com.n9mtq4.ludum.uw.engine.hud;

import com.n9mtq4.ludum.uw.engine.graphics.Screen;
import com.n9mtq4.ludum.uw.game.Sprites;

/**
 * Created by will on 4/18/15 at 10:44 PM.
 */
public class HealthBar {
	
	public int health;
	public int maxHealth;
	
	public void render(Screen screen) {
		
//		math
		int maxBars = screen.width - (16 * 2);
		int fullBars = (maxBars * health) / maxHealth;
//		start
		if (fullBars > 0) {
			screen.renderPlayer(16, 16, Sprites.healthStartFull);
		}else {
			screen.renderPlayer(16, 16, Sprites.healthStartEmpty);
		}
//		segments in middle
		for (int b = 1; b < maxBars - 1; b++) {
			int x = b << 4; // multiply by 16
			if (b > fullBars) {
				screen.renderPlayer(x, 16, Sprites.healthMidFull);
			}else {
				screen.renderPlayer(x, 16, Sprites.healthMidEmpty);
			}
		}
//		end
		if (fullBars == maxBars) {
			screen.renderPlayer(screen.width - 16, 16, Sprites.healthEndFull);
		}else {
			screen.renderPlayer(screen.width - 16, 16, Sprites.healthEndEmpty);
		}
		
	}
	
}
