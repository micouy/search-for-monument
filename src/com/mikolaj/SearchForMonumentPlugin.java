package com.mikolaj;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class SearchForMonumentPlugin extends JavaPlugin {
    private CalcDistanceTask task;

	@Override
    public void onEnable() {
		this.getCommand("startsearch").setExecutor(new StartSearchCommand(this));
    }
	  
    public void startTrackingMovement(Player player) {
		this.task = new CalcDistanceTask(player);
        this.task.runTaskTimer(this, 0L, 60L);

		getLogger().info("Started tracking movement");
        getServer().getPluginManager().registerEvents(new MoveListener(), this);
	}
}
