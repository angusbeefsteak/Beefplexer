package net.angusbeefgaming.mineplex.command;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.angusbeefgaming.mineplex.util.Permissions;
import net.angusbeefgaming.mineplex.util.Rank;
import net.md_5.bungee.api.ChatColor;

public class GMCommand implements CommandExecutor {
	
	private Rank rankRequired = Rank.ADMIN;

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)) {
			return false;
		}
		Player player = (Player) sender;
		if(!(Permissions.hasPermission(player, rankRequired))) {
			Permissions.sendNoPermMessage(player, rankRequired);
			return false;
		}
		else {
			if(args.length <= 1) {
				if(player.getGameMode() == GameMode.SURVIVAL) {
					player.setGameMode(GameMode.CREATIVE);
					player.sendMessage(ChatColor.BLUE + "Game Mode> " + ChatColor.GRAY + player.getName() + "'s Game Mode: " + ChatColor.GREEN + "True");
				}
				else {
					player.setGameMode(GameMode.SURVIVAL);
					player.sendMessage(ChatColor.BLUE + "Game Mode> " + ChatColor.GRAY + player.getName() + "'s Game Mode: " + ChatColor.RED + "False");
				}
			}
			else {
				if(Bukkit.getPlayer(args[0]).getGameMode() == GameMode.SURVIVAL) {
					Bukkit.getPlayer(args[0]).setGameMode(GameMode.CREATIVE);
					Bukkit.getPlayer(args[0]).sendMessage(ChatColor.BLUE + "Game Mode> " + ChatColor.GRAY + Bukkit.getPlayer(args[0]).getName() + "'s Game Mode: " + ChatColor.GREEN + "True");
				}
				else {
					Bukkit.getPlayer(args[0]).setGameMode(GameMode.SURVIVAL);
					Bukkit.getPlayer(args[0]).sendMessage(ChatColor.BLUE + "Game Mode> " + ChatColor.GRAY + Bukkit.getPlayer(args[0]).getName() + "'s Game Mode: " + ChatColor.RED + "False");
				}
			}
			return true;
		}
	}

}
