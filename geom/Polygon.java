package geom;

import java.util.ArrayList;
import java.util.List;

public class Polygon {
	protected List<Point2f> verts;
	
	public Polygon() {
		verts = new ArrayList<Point2f>();
	}
	public Polygon(java.awt.Polygon awtPolygon) {
		verts = new ArrayList<Point2f>();
		
		for (int i = 0; i < awtPolygon.npoints; i++) {
			verts.add(new Point2f(awtPolygon.xpoints[i], awtPolygon.ypoints[i]));
		}
	}
	public Polygon(List<Point2f> vertices) {
		verts = vertices;
	}
	
	public List<Point2f> getVerts() {
		return verts;
	}
	public Point2f getVert(int index) {
		return verts.get(index);
	}
	
	public java.awt.Polygon toAWTPolygon() {
		int npoints = verts.size();
		int[] xpoints = new int[npoints];
		int[] ypoints = new int[npoints];
		
		for (int i = 0; i < npoints; i++) {
			xpoints[i] = Math.round(verts.get(i).x);
			ypoints[i] = Math.round(verts.get(i).y);
		}
		
		
		return new java.awt.Polygon(xpoints, ypoints, npoints);
	}
	
	public void reset() {
		verts = new ArrayList<Point2f>();
	}
	
	public void translate(float dx, float dy) {
		for (Point2f v : verts) {
//			System.out.println(v);
			v.translate(dx, dy);
//			System.out.println(v);
//			System.out.println("--");
		}
	}
}