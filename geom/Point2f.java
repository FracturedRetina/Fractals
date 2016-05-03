package geom;

import java.awt.Graphics;
import java.awt.image.ImageObserver;

public class Point2f implements ui.Renderable {
	public float x;
	public float y;
	
	public Point2f(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public String toString() {
		return super.toString() + '{' + x + ',' + y + '}';
	}
	
	public void translate(float dx, float dy) {
		x += dx;
		y += dy;
	}

	@Override
	public void render(Graphics g, ImageObserver canvas) {
		g.fillOval(Math.round(x) - 3, Math.round(y) - 3, 6, 6);
	}
}