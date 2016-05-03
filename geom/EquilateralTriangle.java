package geom;

public class EquilateralTriangle extends Polygon {
	public float sideLength;
	public float height;
	
	public EquilateralTriangle(float x, float y, float sideLength, boolean upsideDown) {
		super();
		verts.add(new Point2f(x, y));
		verts.add(new Point2f(x + (sideLength / 2), y + ((float) Math.sqrt(3) * sideLength / 2)));
		verts.add(new Point2f(x - (sideLength / 2), y + ((float) Math.sqrt(3) * sideLength / 2)));
		
		this.sideLength = sideLength;
		this.height = (float) (.5f * Math.sqrt(3) * this.sideLength);
		
		if (upsideDown) {
			this.flip();
		}
	}
	
	public void flip() {
		float x = verts.get(0).x;
		float y = verts.get(0).y;
		reset();
		
		verts.add(new Point2f(x, y));
		verts.add(new Point2f(x + (sideLength / 2), y - ((float) Math.sqrt(3) * sideLength / 2)));
		verts.add(new Point2f(x - (sideLength / 2), y - ((float) Math.sqrt(3) * sideLength / 2)));
	}
}