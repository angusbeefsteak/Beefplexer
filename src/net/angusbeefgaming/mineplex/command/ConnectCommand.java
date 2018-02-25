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

public class ConnectCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)) {
			return false;
		}
		Player player = (Player) sender;
		if(args[0].equalsIgnoreCase("BedWars")) {
			Inventory inv = Bukkit.createInventory(null, 54, "BedWars");
			
			ItemStack Item1 = nameItem(Material.EMERALD_BLOCK, "Server 1");
			ItemStack Item2 = nameItem(Material.EMERALD_BLOCK, "Server 2");
			
			inv.setItem(19, Item1);
			inv.setItem(20, Item2);
			
			player.openInventory(inv);
			
			return true;
		}
		else {
			return false;
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
