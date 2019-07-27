package com.mikolaj;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.entity.Player;

public class JoinListener implements Listener {
    private final SearchForMonumentPlugin plugin;
    private CalcDistanceTask task;
    
    public JoinListener(SearchForMonumentPlugin plugin) {
    	this.plugin = plugin;
    }
    
    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
    	Player player = event.getPlayer();
    	
    	runDistanceTrackingTask(player);
    	new InventoryHandler().equipPlayer(player);
    }
	
	@EventHandler
	public void onQuit(PlayerQuitEvent event) {
		if (!this.task.isCancelled()) {
			cancelDistanceTask();
		}
	}
	
	public void runDistanceTrackingTask(Player player) {
		this.task = new CalcDistanceTask(player);
        this.task.runTaskTimer(this.plugin, 0L, 60L);

		this.plugin.getLogger().info("Started tracking distance");
	}
	
	public void cancelDistanceTask() {
		this.task.removeBossBar();
		this.task.cancel();
		this.plugin.getLogger().info("Canceled tracking distance");
	}

}