package kema.hardcore;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class HideHelper {
	public void hide(Player target) {
		for (Player pl : Bukkit.getOnlinePlayers()) {
			hide(target, pl);
		}
	}

	public void hide(Player target, Player own) {
		own.hidePlayer(Game.getInstance(), target);
	}

	public void show(Player target) {
		for (Player pl : Bukkit.getOnlinePlayers()) {
			show(target, pl);
		}
	}

	public void show(Player target, Player own) {
		own.showPlayer(Game.getInstance(), target);
	}
}
