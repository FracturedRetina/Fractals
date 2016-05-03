package ui;

import java.awt.Graphics;

import main.MainMethod;

public class Canvas extends javax.swing.JPanel {
	private static final long serialVersionUID = 1L;

	@Override
	public void paintComponent(Graphics g) {
		g.clearRect(0, 0, this.getWidth(), this.getHeight());
		MainMethod.f.render(g, this);
	}
}