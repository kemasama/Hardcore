package kema.hardcore.task;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import kema.hardcore.util.ScoreHelper;

public class ScoreTask extends BukkitRunnable {

	@Override
	public void run() {
		try {

			for (Player pl : Bukkit.getOnlinePlayers()) {
				ScoreHelper helper;
				if (ScoreHelper.hasScore(pl)) {
					helper = ScoreHelper.getByPlayer(pl);
				}else {
					helper = ScoreHelper.createScore(pl);
				}

				helper.setTitle("");
				helper.setSlot(9, "§1§l>> Player Info");
				helper.setSlot(8, "§fLevel §e" + pl.getLevel());
				helper.setSlot(7, "");
				helper.setSlot(6, "");
				helper.setSlot(5, "");
				helper.setSlot(4, "");
				helper.setSlot(3, "");
				helper.setSlot(2, "");
				helper.setSlot(1, "§eHardCoreSurvival");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
