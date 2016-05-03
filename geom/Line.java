package geom;


import java.awt.Graphics;
import java.awt.image.ImageObserver;

import ui.Renderable;

public class Line implements Renderable {
	public float x1;
	public float y1; 
	public float x2;
	public float y2;
	
	public Line(float x1, float y1, float x2, float y2) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}
	public Line(Point2f pt1, Point2f pt2) {
		this.x1 = pt1.x;
		this.y1 = pt1.y;
		this.x2 = pt2.x;
		this.y2 = pt2.y;
	}
	
	@Override
	public void render(Graphics g, ImageObserver canvas) {
		g.drawLine(
			Math.round(x1),
			Math.round(y1),
			Math.round(x2),
			Math.round(y2)
		);
	}
	
	public float getLength() {
		return (float) Math.sqrt(
			Math.pow(
				Math.abs(x1 - x2),
				2
			) +
			Math.pow(
				Math.abs(y1 - y2),
				2
			)
		);
	}
	
	public Point2f getMidpoint() {
		return new Point2f(
			(x1 + x2) / 2,
			(y1 + y2) / 2
		);
	}
	
	public float getSlope() {
		return (y1 - y2) / (x1 - x2);
	}
	
	public boolean congruentTo(Line ln) {
		return this.getLength() == ln.getLength();
	}
	
	public LinearFunction getPerpendicularBisector() {
		LinearFunction perp = (new LinearFunction(this)).getPerpendicular();
		
		/*
		 * Given:
		 *   slope
		 *   point
		 * Find:
		 *   y intercept
		 * 
		 * y=mx+b
		 * y-mx=b
		 */
		
		LinearFunction bisect = new LinearFunction(
			perp.slope,
			this.getMidpoint().y - perp.slope * this.getMidpoint().x
		);
		
		
		return bisect;
	}
}