package com.mikolaj;

import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BreakSpawnListener implements Listener {
	@EventHandler(priority = EventPriority.LOW)
	public void onBreakSpawn(BlockBreakEvent event) {
		Location location = event.getBlock().getLocation();
		
		// Check if the player is trying to break the spawn and prevent it
		if (!(location.getX() > 2 || location.getX() < -2) &&
		    !(location.getZ() > 2 || location.getZ() < -2)) {
			event.setCancelled(true);
		}
	}
}
