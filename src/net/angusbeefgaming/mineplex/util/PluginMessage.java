package net.angusbeefgaming.mineplex.util;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.messaging.PluginMessageListener;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;

import net.angusbeefgaming.mineplex.Mineplexer;

public class PluginMessage implements PluginMessageListener {

	private JavaPlugin plugin = Mineplexer.getInstance();
	
	@Override
	public void onPluginMessageReceived(String channel, Player player, byte[] message) {
		if(!channel.equals("BungeeCord"))return;
		
		ByteArrayDataInput input = ByteStreams.newDataInput(message);
		String subchannel = input.readUTF();
		
		if(subchannel.equals("PlayerCount")) {
			String server = input.readUTF();
			int playercount = input.readInt();
		}
		
	}
	
	public void getPlayerCount(Player player, String server) {
		ByteArrayDataOutput output = ByteStreams.newDataOutput();
		output.writeUTF("PlayerCount");
		output.writeUTF(server);
		
		player.sendPluginMessage(plugin, "BungeeCord", output.toByteArray());
	}
	
	public void connectToServer(Player player, String server) {
		ByteArrayDataOutput output = ByteStreams.newDataOutput();
		output.writeUTF(server);
		output.writeUTF(player.getName());
		
		player.sendPluginMessage(plugin, "BungeeCord", output.toByteArray());
	}

}
