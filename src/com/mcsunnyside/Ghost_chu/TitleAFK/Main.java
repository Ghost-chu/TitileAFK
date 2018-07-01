package com.mcsunnyside.Ghost_chu.TitleAFK;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import com.earth2me.essentials.Essentials;
import com.earth2me.essentials.User;
import io.puharesource.mc.titlemanager.api.v2.TitleManagerAPI;

public class Main extends JavaPlugin implements Listener {
	public void onEnable() {
		this.saveDefaultConfig();
		Bukkit.getPluginManager().registerEvents(this, this);
		Essentials players = (Essentials) Bukkit.getPluginManager().getPlugin("Essentials");
		TitleManagerAPI api = (TitleManagerAPI) Bukkit.getPluginManager().getPlugin("TitleManager");
		Bukkit.getLogger().info("TitleAFK ÒÑÆô¶¯");
		new BukkitRunnable() {
			@Override
			public void run() {
				if (players.getOnlinePlayers().toArray().length != 0) {
					for (User user : players.getOnlineUsers()) {
						if (user.isAfk() == true) {
							api.sendTitle(user.getBase(), getConfig().getString("title"), getConfig().getInt("fade-in"),
									getConfig().getInt("stay"), getConfig().getInt("fade-out"));
							api.sendSubtitle(user.getBase(), getConfig().getString("subtitle"),
									getConfig().getInt("fade-in"), getConfig().getInt("stay"),
									getConfig().getInt("fade-out"));
						}
					}
				}
			}
		}.runTaskTimerAsynchronously(this, 1, 110);
	}
}
