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

import net.angusbeefgaming.mineplex.Mineplexer;
import net.angusbeefgaming.mineplex.util.Chat;
import net.angusbeefgaming.mineplex.util.Permissions;
import net.angusbeefgaming.mineplex.util.Rank;
import net.md_5.bungee.api.ChatColor;

public class UpdaterankCommand implements CommandExecutor {
	
	private Rank rankRequired = Rank.OWNER;

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
			if(!(args.length >= 1)) {
				Chat.sendMessage(player, "Invalid Player", "Client Manager");
				return false;
			}
			if(!(args.length >= 2)) {
				// New GUI Feature
				Inventory inv = Bukkit.createInventory(null, 54, "Update Player Rank");
				
				ItemStack Item1 = nameItem(Material.DIAMOND_BLOCK, ChatColor.AQUA + "Ultra Rank");
				ItemStack Item2 = nameItem(Material.PURPUR_BLOCK, ChatColor.LIGHT_PURPLE + "Hero Rank");
				ItemStack Item3 = nameItem(Material.EMERALD_BLOCK, ChatColor.GREEN + "Legend Rank");
				ItemStack Item4 = nameItem(Material.NETHER_WART_BLOCK, ChatColor.RED + "Titan Rank");
				ItemStack Item5 = nameItem(Material.LAPIS_BLOCK, ChatColor.DARK_AQUA + "Eternal Rank");
				
				
				ItemStack Item6 = nameItem(Material.IRON_BLOCK, ChatColor.GOLD + "Trainee Rank");
				ItemStack Item7 = nameItem(Material.GOLD_BLOCK, ChatColor.GOLD + "Moderator Rank");
				ItemStack Item8 = nameItem(Material.GOLD_BLOCK, ChatColor.GOLD + "Sr Mod Rank");
				ItemStack Item9 = nameItem(Material.REDSTONE_BLOCK, ChatColor.DARK_RED + "Admin Rank");
				ItemStack Item10 = nameItem(Material.REDSTONE_BLOCK, ChatColor.DARK_RED + "Owner Rank");
				ItemStack Item11 = nameItem(Material.GOLD_BLOCK, ChatColor.GOLD + "Developer Rank");
				
				inv.setItem(10, Item1);
				inv.setItem(11, Item2);
				inv.setItem(12, Item3);
				inv.setItem(13, Item4);
				inv.setItem(14, Item5);
				inv.setItem(28, Item6);
				inv.setItem(29, Item7);
				inv.setItem(30, Item8);
				inv.setItem(37, Item9);
				inv.setItem(38, Item10);
				inv.setItem(39, Item11);
				
				Mineplexer.nameStore = args[0];
				
				player.openInventory(inv);
				return true;
			}
			
			// Main Code for the commands
			if(args[1].equals("ALL")) {
				Permissions.updateRank(args[0], Rank.NORANK);
				Chat.sendMessage(player, args[0] + "'s Rank has been Updated to All!", "Client Manager");
				if(Bukkit.getPlayer(args[0]) != null) {
					Chat.sendMessage(Bukkit.getPlayer(args[0]), "Your Rank has been updated to All!", "Client Manager");
				}
				return true;
			}
			if(args[1].equals("ULTRA")) {
				Permissions.updateRank(args[0], Rank.ULTRA);
				Chat.sendMessage(player, args[0] + "'s Rank has been Updated to Ultra!", "Client Manager");
				if(Bukkit.getPlayer(args[0]) != null) {
					Chat.sendMessage(Bukkit.getPlayer(args[0]), "Your Rank has been updated to Ultra!", "Client Manager");
				}
				return true;
			}
			if(args[1].equals("HERO")) {
				Permissions.updateRank(args[0], Rank.HERO);
				Chat.sendMessage(player, args[0] + "'s Rank has been Updated to Hero!", "Client Manager");
				if(Bukkit.getPlayer(args[0]) != null) {
					Chat.sendMessage(Bukkit.getPlayer(args[0]), "Your Rank has been updated to Hero!", "Client Manager");
				}
				return true;
			}
			if(args[1].equals("LEGEND")) {
				Permissions.updateRank(args[0], Rank.LEGEND);
				Chat.sendMessage(player, args[0] + "'s Rank has been Updated to Legend!", "Client Manager");
				if(Bukkit.getPlayer(args[0]) != null) {
					Chat.sendMessage(Bukkit.getPlayer(args[0]), "Your Rank has been updated to Legend!", "Client Manager");
				}
				return true;
			}
			if(args[1].equals("TITAN")) {
				Permissions.updateRank(args[0], Rank.TITAN);
				Chat.sendMessage(player, args[0] + "'s Rank has been Updated to Titan!", "Client Manager");
				if(Bukkit.getPlayer(args[0]) != null) {
					Chat.sendMessage(Bukkit.getPlayer(args[0]), "Your Rank has been updated to Titan!", "Client Manager");
				}
				return true;
			}
			if(args[1].equals("ETERNAL")) {
				Permissions.updateRank(args[0], Rank.ETERNAL);
				Chat.sendMessage(player, args[0] + "'s Rank has been Updated to Eternal!", "Client Manager");
				if(Bukkit.getPlayer(args[0]) != null) {
					Chat.sendMessage(Bukkit.getPlayer(args[0]), "Your Rank has been updated to Eternal!", "Client Manager");
				}
				return true;
			}
			if(args[1].equals("TRAINEE")) {
				Permissions.updateRank(args[0], Rank.TRAINEE);
				Chat.sendMessage(player, args[0] + "'s Rank has been Updated to Trainee!", "Client Manager");
				if(Bukkit.getPlayer(args[0]) != null) {
					Chat.sendMessage(Bukkit.getPlayer(args[0]), "Your Rank has been updated to Trainee!", "Client Manager");
				}
				return true;
			}
			if(args[1].equals("MODERATOR")) {
				Permissions.updateRank(args[0], Rank.MOD);
				Chat.sendMessage(player, args[0] + "'s Rank has been Updated to Mod!", "Client Manager");
				if(Bukkit.getPlayer(args[0]) != null) {
					Chat.sendMessage(Bukkit.getPlayer(args[0]), "Your Rank has been updated to Mod!", "Client Manager");
				}
				return true;
			}
			if(args[1].equals("SRMOD")) {
				Permissions.updateRank(args[0], Rank.SNRMOD);
				Chat.sendMessage(player, args[0] + "'s Rank has been Updated to Sr Mod!", "Client Manager");
				if(Bukkit.getPlayer(args[0]) != null) {
					Chat.sendMessage(Bukkit.getPlayer(args[0]), "Your Rank has been updated to Sr Mod!", "Client Manager");
				}
				return true;
			}
			if(args[1].equals("ADMIN")) {
				Permissions.updateRank(args[0], Rank.ADMIN);
				Chat.sendMessage(player, args[0] + "'s Rank has been Updated to Admin!", "Client Manager");
				if(Bukkit.getPlayer(args[0]) != null) {
					Chat.sendMessage(Bukkit.getPlayer(args[0]), "Your Rank has been updated to Admin!", "Client Manager");
				}
				return true;
			}
			if(args[1].equals("OWNER")) {
				Permissions.updateRank(args[0], Rank.OWNER);
				Chat.sendMessage(player, args[0] + "'s Rank has been Updated to Owner!", "Client Manager");
				if(Bukkit.getPlayer(args[0]) != null) {
					Chat.sendMessage(Bukkit.getPlayer(args[0]), "Your Rank has been updated to Owner!", "Client Manager");
				}
				return true;
			}
			if(args[1].equals("LEADER")) {
				Permissions.updateRank(args[0], Rank.LEADER);
				Chat.sendMessage(player, args[0] + "'s Rank has been Updated to Leader!", "Client Manager");
				if(Bukkit.getPlayer(args[0]) != null) {
					Chat.sendMessage(Bukkit.getPlayer(args[0]), "Your Rank has been updated to Leader!", "Client Manager");
				}
				return true;
			}
			if(args[1].equals("DEVELOPER")) {
				Permissions.updateRank(args[0], Rank.DEV);
				Chat.sendMessage(player, args[0] + "'s Rank has been Updated to Dev!", "Client Manager");
				if(Bukkit.getPlayer(args[0]) != null) {
					Chat.sendMessage(Bukkit.getPlayer(args[0]), "Your Rank has been updated to Dev!", "Client Manager");
				}
				return true;
			}
			else {
				Chat.sendMessage(player, "Invalid Rank", "Client Manager");
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
