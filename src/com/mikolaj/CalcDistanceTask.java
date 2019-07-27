package com.mikolaj;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class CalcDistanceTask extends BukkitRunnable {
	private final SearchForMonumentPlugin plugin;
    private final Player player;
	private final BossBarHandler bossBar;


    public CalcDistanceTask(SearchForMonumentPlugin plugin, Player player) {
    	this.plugin = plugin;
    	this.player = player;
        this.bossBar = new BossBarHandler(player);
    }

    @Override
    public void run() {
    	int distance = calcDistance();
    	this.bossBar.updateDistance(distance);
    	this.player.sendMessage(Integer.toString(distance));

    	if (distance < 2) {
    		this.plugin.stopSearch(this.player);
    	}
    }
    
    public void removeBossBar() {
    	this.bossBar.removePlayer();
    }
    
    private int calcDistance() {
    	// TODO get Monument's position from config
    	return (int) Math.round(this.player.getLocation().subtract(-3494, 71, 942).length());
    }
}