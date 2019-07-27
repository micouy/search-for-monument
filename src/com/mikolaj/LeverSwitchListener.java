package com.mikolaj;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.Openable;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;

public class LeverSwitchListener implements Listener {
	private final SearchForMonumentPlugin plugin;
	
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

		openDoor(event.getPlayer());
		this.plugin.startSearch(event.getPlayer());
    }
	
	private void openDoor(Player player) {
		Block door = player.getLocation().getWorld().getBlockAt(0, 71, -2);
		
		if (door.getType() != Material.IRON_DOOR)
			return;
		
		BlockData blockData = door.getBlockData();

		if (blockData instanceof Openable) {
			((Openable) blockData).setOpen(true);
			door.setBlockData(blockData);
		}		
	}
}
