package kema.hardcore.task;

import org.bukkit.Location;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class ArrowTask extends BukkitRunnable {

	public ArrowTask(Arrow arrow) {
		this.arrow = arrow;
	}

	private Arrow arrow;

	@Override
	public void run() {
		try {
			if (arrow.isDead() || arrow.isOnGround()) {
				this.cancel();
				return;
			}

			Entity target = null;
			double distance = 0;
			for (Entity e : arrow.getNearbyEntities(12, 3, 12)) {
				if (e != arrow.getShooter()) {
					if (e.getType().isAlive()) {
						if (target == null) {
							target = e;
							distance = target.getLocation().distanceSquared(arrow.getLocation());
						}else {
							if (e.getLocation().distanceSquared(arrow.getLocation()) < distance) {
								target = e;
							}
						}
					}
				}
			}

			if (target == null) {
				return;
			}

			Location from = arrow.getLocation();
			Location to = target.getLocation();

			Vector vF = from.toVector();
			Vector vT = to.toVector();
			Vector dir = vT.subtract(vF).normalize();

			arrow.setVelocity(dir);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
