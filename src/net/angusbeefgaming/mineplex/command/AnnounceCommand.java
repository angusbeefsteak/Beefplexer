package net.angusbeefgaming.mineplex.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;

import net.angusbeefgaming.mineplex.Mineplexer;
import net.angusbeefgaming.mineplex.util.Permissions;
import net.angusbeefgaming.mineplex.util.Rank;

public class AnnounceCommand implements CommandExecutor {
	
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
			StringBuilder buffer = new StringBuilder();
			{
			    buffer.append(' ').append(args[0]);
			}
			String message = buffer.toString();
			ByteArrayDataOutput out = ByteStreams.newDataOutput();
			
			out.writeUTF("Announcement");
			out.writeUTF(message);
			
			player.sendPluginMessage(Mineplexer.getPlugin(Mineplexer.class), "BungeeCord", out.toByteArray());
			return true;
		}
	}

}
