package ui;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JSplitPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import main.MainMethod;

public class Window extends javax.swing.JFrame {
	private static final long serialVersionUID = 1L;
	private JSplitPane contentPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
	private Canvas canvas = new Canvas();
	private JPanel sidebar = new JPanel();
	private JButton refresh = new JButton("Refresh");
	private JSlider recursion = new JSlider(1, 10);
	private boolean valueChanged = false;
	
	public Window() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Sierpenski");
		
		add(contentPane);
			contentPane.add(canvas);
				canvas.setPreferredSize(new Dimension(500, 500));
			contentPane.add(sidebar);
				sidebar.setPreferredSize(new Dimension(250, 500));
				sidebar.add(refresh);
				sidebar.add(recursion);
					recursion.setSnapToTicks(true);
					recursion.setMajorTickSpacing(1);
					recursion.setMinorTickSpacing(1);
					recursion.setPaintTicks(true);
					recursion.setPaintLabels(true);
					recursion.setValue(3);
					recursion.addChangeListener(new ChangeListener() {
						@Override
						public void stateChanged(ChangeEvent arg0) {
							if (recursion.getValueIsAdjusting()) {
								valueChanged = true;
							}
						}
					});
					recursion.addMouseListener(new MouseListener() {
					@Override
					public void mouseReleased(MouseEvent arg0) {
						if (valueChanged) {
							MainMethod.f.recursionLevel = recursion.getValue();
							canvas.repaint();
							valueChanged = false;
						}
					}
					@Override
					public void mousePressed(MouseEvent arg0) {}
					@Override
					public void mouseExited(MouseEvent arg0) {}
					@Override
					public void mouseEntered(MouseEvent arg0) {}
					@Override
					public void mouseClicked(MouseEvent arg0) {}
					});
		pack();
		setVisible(true);
		setLocationRelativeTo(null);
	}
	
	public Dimension getCanvasSize() {
		return new Dimension(canvas.getWidth(), canvas.getHeight());
	}
}