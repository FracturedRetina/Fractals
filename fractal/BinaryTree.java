package fractal;

import geom.Line;

import java.awt.Graphics;
import java.awt.image.ImageObserver;

import main.MainMethod;

public class BinaryTree extends Fractal {
	private int width, height;
	
	public BinaryTree() {
		this(
			MainMethod.window.getCanvasSize().width,
			MainMethod.window.getCanvasSize().height
		);
	}
	public BinaryTree(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	@Override
	public void render(Graphics g, ImageObserver canvas) {
		// TODO Auto-generated method stub
		
	}
	
	private void drawBranch(Line stem) {
		
	}
}