package kema.hardcore.listener;

import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathListener implements Listener {
	@EventHandler
	public void onDeath(PlayerDeathEvent event) {
		Player p = event.getEntity();

		p.getWorld().strikeLightningEffect(p.getLocation());

		p.sendMessage("§7-----------------------");
		p.sendMessage(" §c死んでしまった...！");
		p.sendMessage(" §a§l/belive §aコマンドで25%の確率で復活");
		p.sendMessage("§7-----------------------");

		p.setBedSpawnLocation(null);
	}

	@EventHandler
	public void onDeath(EntityDeathEvent event) {
		if (event.getEntity() instanceof Player) {
			return;
		}

		LivingEntity live = event.getEntity();

		int exp = event.getDroppedExp() + 1;
		if (event.getDrops().size() > 0) {
			exp += event.getDrops().size();
		}

		event.setDroppedExp(exp);

		for (Entity e : live.getPassengers()) {
			if (e instanceof ArmorStand) {
				e.remove();
			}
		}

	}
}