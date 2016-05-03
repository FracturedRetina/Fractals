package fractal;

import geom.EquilateralTriangle;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.ImageObserver;

import main.MainMethod;

public class Sierpenski extends Fractal {
	EquilateralTriangle base;
	
	public Sierpenski() {
		this(MainMethod.window.getCanvasSize().width);
	}
	
	public Sierpenski(int sideLength) {
		base = new EquilateralTriangle(
			MainMethod.window.getCanvasSize().width / 2,
			(MainMethod.window.getCanvasSize().height / 2) - (sideLength / 2),
			sideLength,
			false
		);
		
		recursionLevel = 3;
	}
	
	@Override
	public void render(Graphics g, ImageObserver canvas) {
		//Draw root triangle
		g.drawPolygon(base.toAWTPolygon());
		
		//Draw gaps
		EquilateralTriangle gap = new EquilateralTriangle(
			base.getVert(0).x,
			base.getVert(0).y + base.height,
			base.sideLength / 2,
			true
		);
		drawGaps(g, gap, recursionLevel);
	}
	
	private void drawGaps(Graphics g, EquilateralTriangle tri, int iterations) {
		EquilateralTriangle small = new EquilateralTriangle(
			tri.getVert(0).x,
			tri.getVert(0).y,
			tri.sideLength / 2,
			true
		);
		
		g.fillPolygon(tri.toAWTPolygon());
		
		if (iterations <= 0) {
			return;
		}
		
		g.setColor(Color.RED);
		{
			EquilateralTriangle sml1 = small;
			sml1.translate(-sml1.sideLength, 0);
			drawGaps(g, sml1, iterations - 1);
		}
		g.setColor(Color.GREEN);
		{
			EquilateralTriangle sml2 = small;
			sml2.translate(sml2.sideLength * 2, 0);
			g.drawPolygon(sml2.toAWTPolygon());
			drawGaps(g, sml2, iterations - 1);
		}
		g.setColor(Color.BLUE);
		{
			EquilateralTriangle sml3 = small;
			sml3.translate(-sml3.sideLength, -(sml3.height * 2));
			g.drawPolygon(sml3.toAWTPolygon());
			drawGaps(g, sml3, iterations - 1);
		}
	}
}