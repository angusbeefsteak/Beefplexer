package net.angusbeefgaming.mineplex.event;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;

import net.angusbeefgaming.mineplex.Mineplexer;

public class connectGame implements Listener {
	
	private JavaPlugin plugin = Mineplexer.getInstance();

	@EventHandler
	public void onInvClick(InventoryClickEvent event) {
		Inventory inv = event.getInventory();
		Player player = (Player) event.getWhoClicked();
		if (inv.getTitle().equals("BedWars")) {
			if(event.getCurrentItem().getItemMeta().getDisplayName().equals("Server 1")) {
				ByteArrayDataOutput out = ByteStreams.newDataOutput();
				out.writeUTF("Connect");
				out.writeUTF("BW-1");
				player.sendPluginMessage(plugin, "BungeeCord", out.toByteArray());
			}
			if(event.getCurrentItem().getItemMeta().getDisplayName().equals("Server 2")) {
				ByteArrayDataOutput out = ByteStreams.newDataOutput();
				out.writeUTF("Connect");
				out.writeUTF("BW-2");
				player.sendPluginMessage(plugin, "BungeeCord", out.toByteArray());
			}
		}
		else {
			return;
		}
	}
}
