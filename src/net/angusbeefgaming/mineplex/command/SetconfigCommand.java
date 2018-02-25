package net.angusbeefgaming.mineplex.command;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.angusbeefgaming.mineplex.util.Chat;
import net.angusbeefgaming.mineplex.util.Config;
import net.angusbeefgaming.mineplex.util.Permissions;
import net.angusbeefgaming.mineplex.util.Rank;

public class SetconfigCommand implements CommandExecutor {
	
	private Rank rankRequired = Rank.ADMIN;

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		ItemStack Item1;
		if(!(sender instanceof Player)) {
			return false;
		}
		Player player = (Player) sender;
		if(!(Permissions.hasPermission(player, rankRequired))) {
			Permissions.sendNoPermMessage(player, rankRequired);
			return false;
		}
		else {
			if(!(args.length >= 1)) {
				Inventory inv = Bukkit.createInventory(null, 27, "Game Settings");
				
				if(Config.canAdminBreakBlock()) {
					Item1 = nameItem(Material.LAVA_BUCKET, "Admin Block Break (ON)");
				}
				else {
					Item1 = nameItem(Material.WATER_BUCKET, "Admin Block Break (OFF)");
				}
				
				inv.setItem(10, Item1);
				
				player.openInventory(inv);
				return true;
			}
			if(args[0].equalsIgnoreCase("adminBlockBreak")) {
				if(args[1].equalsIgnoreCase("true")) {
					Config.setAdminBreakBlock(true);
					Chat.sendMessage(player, "Config 'adminBlockBreak' has been set to 'true'!", "Settings");
					return true;
				}
				if(args[1].equalsIgnoreCase("false")) {
					Config.setAdminBreakBlock(false);
					Chat.sendMessage(player, "Config 'adminBlockBreak' has been set to 'false'!", "Settings");
					return true;
				}
				else {
					Chat.sendMessage(player, "You must provide a valid Value!", "Game");
					return false;
				}
			}
			else {
				Chat.sendMessage(player, "You must provide a valid Key!", "Game");
				return false;
			}
		}
	}
	
    private ItemStack nameItem(ItemStack item, String name) {
    	ItemMeta meta = item.getItemMeta();
    	meta.setDisplayName(name);
    	item.setItemMeta(meta);
    	return item;
    }

    private ItemStack nameItem(Material item, String name) {
    	return nameItem(new ItemStack(item), name);
    }

}
