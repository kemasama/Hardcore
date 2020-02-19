package kema.hardcore;

public class Damager {
	public static double increase(int lv, double base) {
		double d = 0.0D;

		/**
		 * Example
		 *
		 * Base: 15.0
		 * Level: 120
		 *
		 * per = 1.5
		 * d = (1.5 * (120 / 10))
		 * d = (1.5 * 12)
		 * d = 18
		 */
		if (lv > 10 && base > 10.0) {
			double per = base / 10;
			d += per * (lv / 10);
		}

		return d;
	}
	public static double reduce(int lv, double base) {
		double d = 0.0D;

		/**
		 * Example
		 *
		 * Base: 15.0
		 * Level: 120
		 *
		 * per = 0.15
		 * d = (0.15 * (120 / 10))
		 * d = (0.15 * 12)
		 * d = 1.8
		 */
		if (lv > 10 && base > 10.0) {
			double per = base / 100;
			d += per * (lv / 10);
		}

		return d;
	}
}
