package com.mikolaj;

import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import org.bukkit.Bukkit;

public class BossBarHandler {
	private final BossBar bar;
	
	public BossBarHandler() {
		this.bar = Bukkit.createBossBar("Distance to monument", BarColor.GREEN, BarStyle.SOLID);
	}
	
	public void addPlayer(Player player) {
		this.bar.addPlayer(player);
	}
	
	public void removePlayers() {
		this.bar.removeAll();
	}
	
	public void updateDistance(double distance) {
		this.bar.setProgress(distance / 10000.0);
	}
}
