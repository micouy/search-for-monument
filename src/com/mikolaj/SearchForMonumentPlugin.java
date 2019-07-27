package com.mikolaj;

import org.bukkit.plugin.java.JavaPlugin;

public class SearchForMonumentPlugin extends JavaPlugin {
	@Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new JoinListener(this), this);
        getServer().getPluginManager().registerEvents(new MoveListener(), this);
    }
}
