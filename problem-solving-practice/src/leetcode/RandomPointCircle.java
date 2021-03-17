package leetcode;

public class RandomPointCircle
{
	double r;
	double x;
	double y;

	public RandomPointCircle(double radius, double x_center, double y_center)
	{
		r = radius;
		x = x_center;
		y = y_center;
	}

	public double[] randPoint()
	{
		double random = Math.sqrt(Math.random()) * r;
		double angle = Math.random() * 2 * Math.PI;
		double xPoint = x + random * Math.cos(angle);
		double yPoint = y + random * Math.sin(angle);
		return new double[]{xPoint, yPoint};
	}
}
