package net.angusbeefgaming.mineplex.event;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import net.md_5.bungee.api.ChatColor;

public class PlayerJoin implements Listener {
	
	@EventHandler
	public void whenPlayerJoin(PlayerJoinEvent event) {
		for(Player p : Bukkit.getOnlinePlayers()) {
			p.sendMessage(ChatColor.DARK_GRAY + "Join> " + ChatColor.GRAY + event.getPlayer().getName());
		}
	}

}
