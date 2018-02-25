package net.angusbeefgaming.mineplex.event;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;

import net.angusbeefgaming.mineplex.Mineplexer;
import net.md_5.bungee.api.ChatColor;

public class InvClick implements Listener {
	
	private JavaPlugin plugin = Mineplexer.getInstance();
	
	@EventHandler
	public void onInvClick(InventoryClickEvent event) {
		Inventory inv = event.getInventory();
		if (inv.getTitle().equals("Update Player Rank")) {
			Player player = (Player) event.getWhoClicked();
			String target = Mineplexer.nameStore;
			if(event.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.AQUA + "Ultra Rank")) {
				Bukkit.dispatchCommand(player, "updaterank " + target + " ULTRA");
				player.closeInventory();
				event.setCancelled(true);
				return;
			}
			if(event.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.LIGHT_PURPLE + "Hero Rank")) {
				Bukkit.dispatchCommand(player, "updaterank " + target + " HERO");
				player.closeInventory();
				event.setCancelled(true);
				return;
			}
			if(event.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GREEN + "Legend Rank")) {
				Bukkit.dispatchCommand(player, "updaterank " + target + " LEGEND");
				player.closeInventory();
				event.setCancelled(true);
				return;
			}
			if(event.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + "Titan Rank")) {
				Bukkit.dispatchCommand(player, "updaterank " + target + " TITAN");
				player.closeInventory();
				event.setCancelled(true);
				return;
			}
			if(event.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.DARK_AQUA + "Eternal Rank")) {
				Bukkit.dispatchCommand(player, "updaterank " + target + " ETERNAL");
				player.closeInventory();
				event.setCancelled(true);
				return;
			}
			
			
			
			
			if(event.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GOLD + "Trainee Rank")) {
				Bukkit.dispatchCommand(player, "updaterank " + target + " TRAINEE");
				player.closeInventory();
				event.setCancelled(true);
				return;
			}
			if(event.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GOLD + "Moderator Rank")) {
				Bukkit.dispatchCommand(player, "updaterank " + target + " MODERATOR");
				player.closeInventory();
				event.setCancelled(true);
				return;
			}
			if(event.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GOLD + "Sr Mod Rank")) {
				Bukkit.dispatchCommand(player, "updaterank " + target + " SRMOD");
				player.closeInventory();
				event.setCancelled(true);
				return;
			}
			if(event.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.DARK_RED + "Admin Rank")) {
				Bukkit.dispatchCommand(player, "updaterank " + target + " ADMIN");
				player.closeInventory();
				event.setCancelled(true);
				return;
			}
			if(event.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.DARK_RED + "Owner Rank")) {
				Bukkit.dispatchCommand(player, "updaterank " + target + " OWNER");
				player.closeInventory();
				event.setCancelled(true);
				return;
			}
			if(event.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GOLD + "Developer Rank")) {
				Bukkit.dispatchCommand(player, "updaterank " + target + " DEVELOPER");
				player.closeInventory();
				event.setCancelled(true);
				return;
			}
			if(event.getCurrentItem().getItemMeta().getDisplayName() == null) {
				event.setCancelled(true);
				return;
			}
		}
		else if(inv.getTitle().equals("Game Settings")) {
			Player player = (Player) event.getWhoClicked();
			if(event.getCurrentItem().getItemMeta().getDisplayName().equals("Admin Block Break (ON)")) {
				Bukkit.dispatchCommand(player, "setconfig AdminBlockBreak false");
				player.closeInventory();
				event.setCancelled(true);
				return;
			}
			if(event.getCurrentItem().getItemMeta().getDisplayName().equals("Admin Block Break (OFF)")) {
				Bukkit.dispatchCommand(player, "setconfig AdminBlockBreak true");
				player.closeInventory();
				event.setCancelled(true);
				return;
			}
		}
	}
}
