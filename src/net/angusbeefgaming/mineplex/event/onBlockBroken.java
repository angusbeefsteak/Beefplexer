package net.angusbeefgaming.mineplex.event;

import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import net.angusbeefgaming.mineplex.Mineplexer;
import net.angusbeefgaming.mineplex.util.Config;
import net.angusbeefgaming.mineplex.util.Permissions;
import net.angusbeefgaming.mineplex.util.Rank;

public class onBlockBroken implements Listener {

	@EventHandler
	public void onBlockBreak(BlockBreakEvent event) {
		if(Permissions.hasPermission(event.getPlayer(), Rank.ADMIN)) {
			if(event.getPlayer().getWorld().getName().equalsIgnoreCase(Mineplexer.gameName)) {
				return;
			}
			if(event.getPlayer().getGameMode() == GameMode.CREATIVE) {
				if(Config.canAdminBreakBlock()) {
					return;
				}
				else {
					event.setCancelled(true);
					return;
				}
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
