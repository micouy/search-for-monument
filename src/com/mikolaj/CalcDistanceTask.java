package com.mikolaj;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class CalcDistanceTask extends BukkitRunnable {

    private final Player player;

    public CalcDistanceTask(Player player) {
        this.player = player;
    }

    @Override
    public void run() {
        sendMessage(calcDistance());
    }
    
    private int calcDistance() {
    	return (int) Math.round(this.player.getLocation().subtract(100, 100, 100).length());
    }
    
    private void sendMessage(int distance) {
    	this.player.sendMessage(Integer.toString(distance) + " meters away");
    }
}