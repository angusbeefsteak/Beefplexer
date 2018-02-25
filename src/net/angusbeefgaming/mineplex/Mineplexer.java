package net.angusbeefgaming.mineplex;

import java.util.Map;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.messaging.PluginMessageListener;

import net.angusbeefgaming.mineplex.command.AnnounceCommand;
import net.angusbeefgaming.mineplex.command.ConnectCommand;
import net.angusbeefgaming.mineplex.command.GMCommand;
import net.angusbeefgaming.mineplex.command.GemCommand;
import net.angusbeefgaming.mineplex.command.HelpCommand;
import net.angusbeefgaming.mineplex.command.OfficeCommand;
import net.angusbeefgaming.mineplex.command.SetconfigCommand;
import net.angusbeefgaming.mineplex.command.UpdaterankCommand;
import net.angusbeefgaming.mineplex.event.InvClick;
import net.angusbeefgaming.mineplex.event.PlayerJoin;
import net.angusbeefgaming.mineplex.event.connectGame;
import net.angusbeefgaming.mineplex.event.onBlockBroken;
import net.angusbeefgaming.mineplex.event.onBlockPlaced;

public class Mineplexer extends JavaPlugin implements PluginMessageListener {
	
	public static String gameName = "Lobby";
	
	private Map<String, Integer> online;
	
	public static String nameStore;
	
	private static Mineplexer instance;
	
	@Override
	public void onEnable() {
		
		getCommand("help").setExecutor(new HelpCommand());
		getCommand("updaterank").setExecutor(new UpdaterankCommand());
		getCommand("setconfig").setExecutor(new SetconfigCommand());
		getCommand("gm").setExecutor(new GMCommand());
		getCommand("office").setExecutor(new OfficeCommand());
		getCommand("announce").setExecutor(new AnnounceCommand());
		getCommand("gem").setExecutor(new GemCommand());
		getCommand("connect").setExecutor(new ConnectCommand());
		
		
		getServer().getPluginManager().registerEvents(new onBlockBroken(), this);
		getServer().getPluginManager().registerEvents(new onBlockPlaced(), this);
		getServer().getPluginManager().registerEvents(new PlayerJoin(), this);
		getServer().getPluginManager().registerEvents(new InvClick(), this);
		getServer().getPluginManager().registerEvents(new connectGame(), this);
		
		
		// Plugin Massaging Channel Stuff
		getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
		getServer().getMessenger().registerIncomingPluginChannel(this, "BungeeCord", this);
		
		
		
	}
	
	public static Mineplexer getInstance() {
		return instance;
	}
	
	@Override
	public void onDisable() {
		
		
	}

	@Override
	public void onPluginMessageReceived(String arg0, Player arg1, byte[] arg2) {
		
	}

}
