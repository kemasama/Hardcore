package kema.hardcore.listener;

import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.ProjectileHitEvent;

import kema.hardcore.XMath;

public class ArrowListener implements Listener {

	@EventHandler
	public void onDamage(EntityDamageByEntityEvent event) {
		if (event.getDamager() instanceof Projectile) {
			Projectile pro = (Projectile) event.getDamager();
			if (pro.getShooter() instanceof Player) {
				Player p = (Player) pro.getShooter();
				double distance = event.getEntity().getLocation().distanceSquared(p.getLocation());
				double dis = XMath.sqrt(distance);

				p.sendMessage("§eHit! " + dis + " blocks away!");
			}
		}
	}

	@EventHandler
	public void onHit(ProjectileHitEvent event) {
		event.getEntity().remove();
	}
}
