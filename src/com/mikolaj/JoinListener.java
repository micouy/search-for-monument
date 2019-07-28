package com.mikolaj;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.Listener;

public class JoinListener implements Listener {
	private final MyPlugin plugin;
	
	public JoinListener(MyPlugin plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		this.plugin.prepareSpawn(event.getPlayer());
	}
}
