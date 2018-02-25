package net.angusbeefgaming.mineplex.util;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class Chat {

	
	public static void sendMessage(Player target, String message, String sender) {
		target.sendMessage(ChatColor.BLUE + sender + "> " + ChatColor.GRAY + message);
	}
	
	public static void broadcastMessage(Player target, String message, String sender) {
		for(Player p : Bukkit.getOnlinePlayers()) {
			p.sendMessage(ChatColor.BLUE + sender + "> " + ChatColor.GRAY + message);
		}
	}
	
	
}
