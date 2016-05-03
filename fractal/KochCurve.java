package fractal;

import geom.Line;
import geom.Point2f;

import java.awt.Graphics;
import java.awt.image.ImageObserver;

import main.MainMethod;

public class KochCurve extends Fractal {
	boolean fill = false;
	
	public KochCurve() {
		
	}
	
	@Override
	public void render(Graphics g, ImageObserver canvas) {
		drawLine(
			g,
			new Line(
				0,
				MainMethod.window.getCanvasSize().height / 2,
				
				MainMethod.window.getCanvasSize().width,
				MainMethod.window.getCanvasSize().height / 2
			),
			3
		);
	}
	
	private void drawLine(Graphics g, Line ln, int iterations) {
//		Line lnSeg1 = new Line(new Point2f(ln.x1, ln.y1), ln.getMidway(1/3f));
//		Line lnSeg2 = new Line(ln.getMidway(2/3f), new Point2f(ln.x2, ln.y2));
//		Line ln1 = new Line(ln.getMidway(1/3f), 0);
//		Line ln2 = new Line(0, ln.getMidway(2/3f));
		
		Point2f endpoint1 = new Point2f(ln.x1, ln.y1);
		Point2f endpoint2 = new Point2f(ln.x2, ln.y2);
		
		endpoint1.render(g, null);
		endpoint2.render(g, null);
		ln.getMidpoint().render(g, null);
		
//		lnSeg1.render(g, null);
//		lnSeg2.render(g, null);
		
	}
	
/*	private void drawLine(Graphics g, Line ln, int iterations) {
		Line ln1;
		Line ln2;
//		{
//			EquilateralTriangle tri = new EquilateralTriangle(
//				MainMethod.window.getCanvasSize().width / 2,
//				(MainMethod.window.getCanvasSize().height / 2),
//				ln.getLength() / 3,
//				false
//			);
//			tri.translate(0, (int) -tri.height);
//			
//			ln1 = new Line(tri.xpoints[0], tri.ypoints[0], tri.xpoints[2], tri.ypoints[2]);
//			ln2 = new Line(tri.xpoints[0], tri.ypoints[0], tri.xpoints[1], tri.ypoints[1]);
//		}
		{
			ln1 = new Line(
				ln.getMidway(1/3f),
				new Point2f(0,0)
			);
			ln2 = new Line(
				ln.getMidway(2/3f),
				new Point2f(0,0)
			);
		}
		
		ln.render(g, null);
		
		if (iterations <= 0) {
			return;
		}
		
//		ln1.render(g, null);
//		ln2.render(g, null);

		drawLine(g, ln1, iterations - 1);
		drawLine(g, ln2, iterations - 1);
	}*/

	/*private void fillLine(Graphics g, Line ln, int iterations) {
		EquilateralTriangle tri = new EquilateralTriangle(
			MainMethod.window.getCanvasSize().width / 2,
			(MainMethod.window.getCanvasSize().height / 2),
			ln.getLength() / 3,
			false
		);
		tri.translate(0, (int) -tri.height);
		
		ln.render(g, null);
		g.drawPolygon(tri.toAWTPolygon());
	}*/
}