package com.mikolaj;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class MoveListener implements Listener {
	private double routeLength;
	
	public MoveListener() {
		this.routeLength = 0;
	}
	
	@EventHandler
    public void onMove(PlayerMoveEvent event) {
		double moveLength = event.getTo().clone().subtract(event.getFrom()).length();
		this.routeLength += moveLength;
    }
	
	public int gtRouteLength() {
		return (int) Math.round(this.routeLength);
	}
}
