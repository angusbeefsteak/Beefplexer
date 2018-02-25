package net.angusbeefgaming.mineplex.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.earth2me.essentials.api.Economy;
import com.earth2me.essentials.api.NoLoanPermittedException;
import com.earth2me.essentials.api.UserDoesNotExistException;

import net.angusbeefgaming.mineplex.util.Chat;
import net.angusbeefgaming.mineplex.util.Permissions;
import net.angusbeefgaming.mineplex.util.Rank;

public class GemCommand implements CommandExecutor {
	
	private Rank rankRequired = Rank.ADMIN;

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		double oldBal;
		Economy api = new Economy();
		if(!(sender instanceof Player)) {
			return false;
		}
		Player player = (Player) sender;
		if(!(Permissions.hasPermission(player, rankRequired))) {
			Permissions.sendNoPermMessage(player, rankRequired);
			return false;
		}
		else {
			if(!(api.playerExists(args[0]))) {
				Chat.sendMessage(player, "Player File Cannot be Found!", "Gems");
				return false;
			}
			try {
				oldBal = api.getMoney(args[0]);
			} catch (UserDoesNotExistException e) {
				Chat.sendMessage(player, "Player File Cannot be Found!", "Gems");
				return false;
			}
			
			try {
				api.setMoney(args[0], Double.parseDouble(args[1]) + oldBal);
			} catch (NumberFormatException e) {
				Chat.sendMessage(player, "There was an error parsing your request!", "Gems");
			} catch (NoLoanPermittedException e) {
				Chat.sendMessage(player, "Player Gem Balance cannot go negitive!", "Gems");
			} catch (UserDoesNotExistException e) {
				Chat.sendMessage(player, "Player File Cannot be Found!", "Gems");
			}
			return true;
		}
	}

}
