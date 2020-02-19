package kema.hardcore.listener;

import org.bukkit.GameMode;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class JoinListener implements Listener {
	@EventHandler
	public void onLogin(PlayerLoginEvent event) {
		Player pl = event.getPlayer();

		if (pl.getGameMode().equals(GameMode.SURVIVAL)) {
			event.allow();
		}

	}

	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		Player p = event.getPlayer();

		if (p.getGameMode().equals(GameMode.SPECTATOR)) {
			event.setJoinMessage("");
		}else {
			event.setJoinMessage("§b" + p.getName() + " §eが参加しました!");
		}

		if (!p.hasPlayedBefore()) {

			p.sendMessage("§e---------------------------------");
			p.sendMessage(" §eハードコアサバイバルへようこそ！");
			p.sendMessage(" ");
			p.sendMessage(" §a1. 死ぬな！");
			p.sendMessage(" §a2. 諦めるな！");
			p.sendMessage(" §a3. 信じるな！");
			p.sendMessage(" ");
			p.sendMessage(" §6 GoodLuck HaveFun :D");
			p.sendMessage("§e---------------------------------");

			try {
				p.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(40.0);
				p.setHealth(40.0);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	@EventHandler
	public void onQuit(PlayerQuitEvent event) {
		Player p = event.getPlayer();

		if (p.getGameMode().equals(GameMode.SPECTATOR)) {
			event.setQuitMessage("");
		}else {
			event.setQuitMessage("§b" + p.getName() + " §eが退出しました!");
		}
	}

}
