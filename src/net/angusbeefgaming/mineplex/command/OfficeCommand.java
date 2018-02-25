package net.angusbeefgaming.mineplex.command;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.angusbeefgaming.mineplex.Mineplexer;
import net.angusbeefgaming.mineplex.util.Chat;
import net.angusbeefgaming.mineplex.util.Permissions;
import net.angusbeefgaming.mineplex.util.Rank;

public class OfficeCommand implements CommandExecutor {
	
	private Rank rankRequired = Rank.TRAINEE;

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
			if(Mineplexer.gameName.equals("Lobby")) {
				Chat.sendMessage(player, "You have been sent to the Beefplex Offices", "Offices");
				Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tp " + player.getName() + " 215 63 -117");
				return true;
			}
			else {
				Chat.sendMessage(player, "You must be on a Lobby server to run this!", "Offices");
				return false;
			}
		}
	}

}
