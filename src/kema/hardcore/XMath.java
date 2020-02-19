package kema.hardcore;

public class XMath {
	public static float sqrt(float x) {
		float xHalf = 0.5f * x;
		int tmp = 0x5F3759DF - ((int) x >> 1 );
		float xRes = (float) tmp;

		xRes *= ( 1.5f - ( xHalf * xRes * xRes) );
		//xRes *= ( 1.5f - ( xHalf * xRes * xRes) );

		return xRes * x;
	}

	public static double sqrt(double x) {
		double xRes = Math.pow(x, 0.5);
		return xRes;
	}
}
