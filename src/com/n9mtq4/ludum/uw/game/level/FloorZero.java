package com.n9mtq4.ludum.uw.game.level;

import com.n9mtq4.ludum.uw.game.entity.monster.Ghost;

/**
 * Created by will on 4/18/15 at 11:51 PM.
 */
public class FloorZero extends Floor {
	
	public FloorZero() {
		super("/levels/floor0.png");
		
//		entity spawns
		System.out.println("SPAWN");
		for (int i = 0; i < 10; i++) {
			this.add(new Ghost(28, 5));
			this.add(new Ghost(21, 13));
			this.add(new Ghost(12, 13));
			this.add(new Ghost(3, 13));
			this.add(new Ghost(14, 29));
		}
		
	}
	
}
