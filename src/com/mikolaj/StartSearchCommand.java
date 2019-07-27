package com.mikolaj;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StartSearchCommand implements CommandExecutor {
	private final SearchForMonumentPlugin plugin;
	
	public StartSearchCommand(SearchForMonumentPlugin plugin) {
		this.plugin = plugin;
	}

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    	if (args.length != 1) {
    		return false;
    	}
    	
    	Player player = Bukkit.getPlayer(args[0]);
    	
    	if (player == null) {
    		return false;
    	}

    	this.plugin.startSearch(player);
    	
        return true;
    }
  
}
