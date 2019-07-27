package com.mikolaj;

import java.util.UUID;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class MoveListener implements Listener {
	private double routeLength;
	private final UUID playerId;
	
	public MoveListener(Player player) {
		this.routeLength = 0;
		this.playerId = player.getUniqueId();
	}
	
	@EventHandler
    public void onMove(PlayerMoveEvent event) {
		if (event.getPlayer().getUniqueId() != this.playerId)
			return;

		double moveLength = event.getTo().clone().subtract(event.getFrom()).length();
		this.routeLength += moveLength;
    }
	
	public int gtRouteLength() {
		return (int) Math.round(this.routeLength);
	}
}
