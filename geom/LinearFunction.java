package geom;

public class LinearFunction {
	protected float slope;
	protected float yIntercept;
	
	public LinearFunction(float slope, float yIntercept) {
		this.slope = slope;
		this.yIntercept = yIntercept;
	}
	public LinearFunction(float x1, float y1, float x2, float y2) {
		this(new Line(x1, y1, x2, y2));
	}
	public LinearFunction(Point2f pt1, Point2f pt2) {
		this(new Line(pt1.x, pt1.y, pt2.x, pt2.y));
	}
	public LinearFunction(Line ln) {
		slope = ln.getSlope();
		yIntercept = ln.y1 - slope * ln.x1;
		/*
		 * y=mx+b
		 * y-mx=b
		 */
	}
	
	public float getSlope() {
		return slope;
	}
	public float getYIntercept() {
		return yIntercept;
	}
	
	public float getX(float y) {
		/*
		 * y=mx+b
		 * y-b=mx
		 * (y-b)/m=x
		 */
		return (y - yIntercept) / slope;
	}
	public float getY(float x) {
		/*
		 * y=mx+b
		 */
		return slope * x + yIntercept;
	}
	
	public LinearFunction getPerpendicular() {
		return new LinearFunction(-1 / slope, yIntercept);
	}
	
	public boolean contains(Point2f pt) {
		return (pt.y == slope * pt.x + yIntercept);
	}
}