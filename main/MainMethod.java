package main;

import ui.Window;
import fractal.BinaryTree;
import fractal.Fractal;
import fractal.KochCurve;
import fractal.Sierpenski;

public class MainMethod {
	public static Window window;
	public static Fractal f;
	
	public static void main(String[] args) {
		window = new Window();
//		f = new Sierpenski();
//		f = new KochCurve();
		f = new BinaryTree();
	}
}