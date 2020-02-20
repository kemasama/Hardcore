package kema.hardcore.listener;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;

import kema.hardcore.Game;

public class DeathListener implements Listener {
	@EventHandler
	public void onDeath(PlayerDeathEvent event) {
		Player p = event.getEntity();

		p.getWorld().strikeLightningEffect(p.getLocation());
		p.getWorld().playSound(p.getLocation(), Sound.ENTITY_LIGHTNING_THUNDER, 1f, 1f);
		p.setBedSpawnLocation(null);

		Game.getHideHelper().hide(p);
	}

	@EventHandler
	public void onDeath(EntityDeathEvent event) {
		if (event.getEntity() instanceof Player) {
			return;
		}

		LivingEntity live = event.getEntity();

		if (event.getDroppedExp() > 0) {
			event.setDroppedExp(event.getDroppedExp() * 2);
		}

		if (live.getType().equals(EntityType.ENDERMAN)) {
			if (event.getDrops().size() == 0) {
				event.getDrops().add(new ItemStack(Material.ENDER_PEARL));
			}
		}

		if (live.getType().equals(EntityType.SKELETON)) {
			event.getDrops().clear();
			event.getDrops().add(new ItemStack(Material.ARROW));
			if (getRand()) {
				event.getDrops().add(new ItemStack(Material.BOW));
			}
		}


		for (Entity e : live.getPassengers()) {
			if (e instanceof ArmorStand) {
				e.remove();
			}
		}

	}

	private Random random = new Random();
	private boolean getRand() {
		return random.nextBoolean();
	}
}
