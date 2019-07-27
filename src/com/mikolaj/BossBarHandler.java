package com.mikolaj;

import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import org.bukkit.Bukkit;

public class BossBarHandler {
	private final BossBar bar;
	
	public BossBarHandler(Player player) {
		this.bar = Bukkit.createBossBar("Distance to monument", BarColor.GREEN, BarStyle.SOLID);
		this.bar.addPlayer(player);
	}
	
	public void removePlayer() {
		this.bar.removeAll();
	}
	
	public void updateDistance(double distance) {
		// This formula fits any positive real number (distance) into <0, 1>
		double progress = 1.0 - Math.tanh(distance / 10000.0);
		this.bar.setProgress(progress);
	}
}
