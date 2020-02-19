package kema.hardcore.listener;

import org.bukkit.Sound;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;

import kema.hardcore.Game;
import kema.hardcore.XMath;
import kema.hardcore.task.ArrowTask;

public class ArrowListener implements Listener {

	@EventHandler
	public void on(ProjectileLaunchEvent event) {
		if (event.getEntity() instanceof Arrow) {
			Arrow arrow = (Arrow) event.getEntity();
			ArrowTask task = new ArrowTask(arrow);
			task.runTaskTimer(Game.getInstance(), 0L, 30L);
		}
	}

	@EventHandler
	public void onDamage(EntityDamageByEntityEvent event) {
		if (event.getDamager() instanceof Projectile) {
			Projectile pro = (Projectile) event.getDamager();
			if (pro.getShooter() instanceof Player) {
				Player p = (Player) pro.getShooter();
				double distance = event.getEntity().getLocation().distanceSquared(p.getLocation());
				double dis = XMath.sqrt(distance);

				if (dis >= 20.0) {
					p.sendMessage(String.format("§eHit! %.1f blocks away!", dis));
				}

				p.playSound(p.getLocation(), Sound.ENTITY_ARROW_HIT, 1f, 1f);
			}
		}
	}

	@EventHandler
	public void onHit(ProjectileHitEvent event) {
		event.getEntity().remove();
	}
}
