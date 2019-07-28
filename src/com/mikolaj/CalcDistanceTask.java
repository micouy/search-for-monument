package com.mikolaj;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class CalcDistanceTask extends BukkitRunnable {
	private final MyPlugin plugin;
    private final Player player;
	private final BossBarHandler bossBar;

	// TODO get location from config
	private final static int monumentX = -3494;
	private final static int monumentY = 71;
	private final static int monumentZ = 942;


    public CalcDistanceTask(MyPlugin plugin, Player player) {
    	this.plugin = plugin;
    	this.player = player;
        this.bossBar = new BossBarHandler(player);
    }

    @Override
    public void run() {
    	int distance = calcDistance();
    	this.bossBar.updateDistance(distance);

    	if (distance < 5) {
    		this.plugin.finishSearch(this.player);
    	}
    }
    
    public void removeBossBar() {
    	this.bossBar.removePlayer();
    }
    
    private int calcDistance() {
    	// TODO get Monument's position from config
    	return (int) Math.round(
    		this.player
	    		.getLocation()
	    		.subtract(monumentX, monumentY, monumentZ)
	    		.length()
    	);
    }
}