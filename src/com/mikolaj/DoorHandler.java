package com.mikolaj;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.Openable;
import org.bukkit.entity.Player;

public class DoorHandler {
	// TODO get location from config
	private final static int doorX = 0;
	private final static int doorY = 71;
	private final static int doorZ = -2;
	
	private void setDoorState(Player player, boolean open) {
		Block door = player
				.getLocation()
				.getWorld()
				.getBlockAt(doorX, doorY, doorZ);
			
		if (door.getType() != Material.IRON_DOOR)
			return;
		
		BlockData blockData = door.getBlockData();

		if (blockData instanceof Openable) {
			((Openable) blockData).setOpen(open);
			door.setBlockData(blockData);
		}
	}

	public void open(Player player) {
		setDoorState(player, true);
	}
	
	public void close(Player player) {
		setDoorState(player, false);
	}
}
