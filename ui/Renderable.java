package ui;

import java.awt.Graphics;
import java.awt.image.ImageObserver;

public interface Renderable {
	public void render(Graphics g, ImageObserver canvas);
}