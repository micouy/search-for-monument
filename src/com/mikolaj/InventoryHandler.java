package com.mikolaj;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

public class InventoryHandler {
	@EventHandler
    public void onJoin(PlayerJoinEvent event) {
    	equipPlayer(event.getPlayer());
    }

	public void equipPlayer(Player player) {
		PlayerInventory inventory = player.getInventory();
		inventory.clear();

		setArmor(inventory);
		giveSword(inventory);
		giveFood(inventory);
	}
	
	private void giveFood(PlayerInventory inventory) {
		ItemStack jerky = new ItemStack(Material.COOKED_BEEF, 3);
		
		// Set meta
		ItemMeta meta = jerky.getItemMeta();
		meta.setDisplayName("Jerky");
		jerky.setItemMeta(meta);

		inventory.addItem(jerky);
	}
	
	private void giveSword(PlayerInventory inventory) {
		inventory.addItem(new ItemStack(Material.STONE_SWORD));
	}
	
	private void setArmor(PlayerInventory inventory) {
		ItemStack[] armor = {
				new ItemStack(Material.LEATHER_BOOTS),
				new ItemStack(Material.LEATHER_LEGGINGS),
				new ItemStack(Material.LEATHER_CHESTPLATE),
				new ItemStack(Material.IRON_HELMET)
		};
		inventory.setArmorContents(armor);
	}
}
