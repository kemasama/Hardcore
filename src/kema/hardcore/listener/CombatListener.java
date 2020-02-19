package kema.hardcore.listener;

import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import kema.hardcore.Damager;

public class CombatListener implements Listener {
	@EventHandler
	public void onDamage(EntityDamageByEntityEvent event) {
		if (event.getDamager() instanceof Player) {
			Player p = (Player) event.getDamager();

			double damage = event.getDamage() + Damager.increase(p.getLevel(), event.getDamage());
			event.setDamage(damage);
		}
		if (event.getEntity() instanceof Player) {
			Player p = (Player) event.getEntity();

			double damage = event.getDamage() - Damager.reduce(p.getLevel(), event.getDamage());

			if (damage < 0.0D) {
				damage = 0.0D;
			}

			event.setDamage(damage);
		}
	}

	public void addPlate(LivingEntity live) {
		try {
			if (live.getPassengers().size() > 0) {
				return;
			}

			ArmorStand as = (ArmorStand) live.getWorld().spawnEntity(live.getLocation(), EntityType.ARMOR_STAND);
			as.setGravity(false);
			as.setSmall(false);
			as.setVisible(false);
			as.setInvulnerable(true);
			as.setCustomNameVisible(true);
			as.setCustomName(live.getName());

			live.addPassenger(as);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
