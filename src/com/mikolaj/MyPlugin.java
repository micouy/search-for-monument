package com.mikolaj;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;

public class MyPlugin extends JavaPlugin {
    private CalcDistanceTask task;
    private LeverSwitchListener leverListener;
    private MoveListener moveListener;
    private DoorHandler door;

	@Override
    public void onEnable() {
		this.door = new DoorHandler();
		this.leverListener = new LeverSwitchListener(this);
        getServer().getPluginManager().registerEvents(new BreakSpawnListener(), this);
        getServer().getPluginManager().registerEvents(new JoinListener(this), this);
	}
	
	public void prepareSpawn(Player player) {
		tpPlayerToSpawn(player);
		this.door.close(player);
		new InventoryHandler().clearInventory(player);

		stopMovementTracking();
        getServer().getPluginManager().registerEvents(this.leverListener, this);
	}
	
	public void tpPlayerToSpawn(Player player) {
		Location location = player.getLocation();
		// TODO get location from config
		location.setX(0);
		location.setY(70);
		location.setZ(0);
		player.teleport(location);
	}
	
	private void startMovementTracking(Player player) {
		this.moveListener = new MoveListener(player);
		getServer().getPluginManager().registerEvents(this.moveListener, this); 
		this.task = new CalcDistanceTask(this, player);
		// 1 minute = 60 seconds * 20 ticks
        this.task.runTaskTimer(this, 0, 60 * 20);
	}
	
	private void stopMovementTracking() {
		if (this.task != null) {
			this.task.removeBossBar();
			this.task.cancel();	
		}

		if (this.moveListener != null) {
			HandlerList.unregisterAll(this.moveListener);
		}
	}
	  
    public void startSearch(Player player) {
    	HandlerList.unregisterAll(this.leverListener);
    	this.door.open(player);
        new InventoryHandler().equipPlayer(player);
        startMovementTracking(player);
	}
    
    public void finishSearch(Player player) {
    	stopMovementTracking();
    	player.sendMessage(
    			"Congratulations! You've travelled "
    			+ Integer.toString(this.moveListener.getRouteLength())
    			+ "m.");
    }
}
