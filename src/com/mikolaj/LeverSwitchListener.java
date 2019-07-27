package com.mikolaj;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;

public class LeverSwitchListener implements Listener {
	private SearchForMonumentPlugin plugin;
	
	public LeverSwitchListener(SearchForMonumentPlugin plugin) {
		this.plugin = plugin;
	}

	@EventHandler
    public void onLeverSwitch(PlayerInteractEvent event) {
		Location location = event.getClickedBlock().getLocation();
		Material material = event.getClickedBlock().getType();
		
		if (material != Material.LEVER)
			return;
		
		if (event.getHand() != EquipmentSlot.HAND)
			return;
		
		if (!(location.getX() == 0
			|| location.getY() == 71
			|| location.getZ() == 1))
			return;

		this.plugin.startSearch(event.getPlayer());
    }
}
