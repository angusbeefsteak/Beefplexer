package net.angusbeefgaming.mineplex.event;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import net.angusbeefgaming.mineplex.Mineplexer;
import net.angusbeefgaming.mineplex.util.Config;
import net.angusbeefgaming.mineplex.util.Permissions;
import net.angusbeefgaming.mineplex.util.Rank;

public class onBlockPlaced implements Listener {

	@EventHandler
	public void onBlockPlace(BlockPlaceEvent event) {
		if(Permissions.hasPermission(event.getPlayer(), Rank.ADMIN)) {
			if(event.getPlayer().getWorld().getName().equalsIgnoreCase(Mineplexer.gameName)) {
				return;
			}
			if(Config.canAdminBreakBlock()) {
				return;
			}
			else {
				event.setCancelled(true);
				return;
			}
		}
		else {
			if(event.getPlayer().getWorld().getName().equalsIgnoreCase(Mineplexer.gameName)) {
				return;
			}
		}
	}
}
