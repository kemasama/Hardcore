package kema.hardcore.listener;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

public class SpawnListener implements Listener {
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onSpawn(PlayerRespawnEvent event) {
		Player pl = event.getPlayer();
		pl.setGameMode(GameMode.SPECTATOR);

		pl.sendTitle("§c§lYou died", "");
	}

}
