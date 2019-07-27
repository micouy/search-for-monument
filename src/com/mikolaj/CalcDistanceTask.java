package com.mikolaj;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class CalcDistanceTask extends BukkitRunnable {
    private final Player player;
	private final BossBarHandler bossBar;


    public CalcDistanceTask(Player player) {
    	this.player = player;
        this.bossBar = new BossBarHandler(player);
    }

    @Override
    public void run() {
    	this.bossBar.updateDistance(calcDistance());
    }
    
    public void removeBossBar() {
    	this.bossBar.removePlayer();
    }
    
    private int calcDistance() {
    	return (int) Math.round(this.player.getLocation().subtract(100, 100, 100).length());
    }
}