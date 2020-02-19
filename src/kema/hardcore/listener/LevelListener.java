package kema.hardcore.listener;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLevelChangeEvent;

public class LevelListener implements Listener {
	@EventHandler
	public void onLevelChange(PlayerLevelChangeEvent event) {
		if (event.getNewLevel() > event.getOldLevel()) {
			Player pl = event.getPlayer();

			if (event.getNewLevel() % 10 == 0) {
				pl.sendMessage("§a§lReach the " + event.getNewLevel() + " levels!!");
				if (event.getNewLevel() % 100 == 0) {
					Bukkit.broadcastMessage("§a" + pl.getName() + " reach the " + event.getNewLevel() + " levels");
				}
			}

		}
	}
}
