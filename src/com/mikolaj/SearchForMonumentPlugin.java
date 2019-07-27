package com.mikolaj;

import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;

public class SearchForMonumentPlugin extends JavaPlugin {
    private CalcDistanceTask task;
    private LeverSwitchListener leverListener;

	@Override
    public void onEnable() {
		this.getCommand("startsearch").setExecutor(new StartSearchCommand(this));
		
		this.leverListener = new LeverSwitchListener(this);
        getServer().getPluginManager().registerEvents(new BreakSpawnListener(), this);
        getServer().getPluginManager().registerEvents(this.leverListener, this);
	}
	  
    public void startSearch(Player player) {
    	// Stop listening for lever switch
    	HandlerList.unregisterAll(this.leverListener);
    	
		this.task = new CalcDistanceTask(player);
        this.task.runTaskTimer(this, 0L, 60L);
        new InventoryHandler().equipPlayer(player);
        

		getLogger().info("Started tracking movement");
        getServer().getPluginManager().registerEvents(new MoveListener(player), this);
	}
}
