/*
 * Created on 2004-2-20
 * @author Jim X. Chen: draw randomly generated points
 */

import javax.media.opengl.*;

import com.sun.opengl.util.Animator; // import net.java.games.jogl.*;
import java.awt.event.*;

// built on J1_O_Point class
public class J1_1_Point extends J1_0_Point {
	static Animator animator; // drive display() in a loop

	public J1_1_Point() {

		// use super's constructor to initialize drawing

		// 1. specify using only a single buffer
		capabilities.setDoubleBuffered(false);

		// 2. add a listener for window closing
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				animator.stop(); // stop animation
				System.exit(0);
			}
		});
	}

	// called one-time for OpenGL initialization
	public void init(GLAutoDrawable drawable) {

		// specify a drawing color: red
		gl.glColor3f(1.0f, 0.0f, 0.0f);

		// 3. clear the background to black
		gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
		gl.glClear(GL.GL_COLOR_BUFFER_BIT);

		// 4. drive the display() in a loop
		animator = new Animator(canvas);
		animator.start(); // start animator thread
		
		// display OpenGL and graphics system information
		System.out.println("INIT GL IS: " + gl.getClass().getName());
		System.err.println(drawable.getChosenGLCapabilities());
		System.err.println("GL_VENDOR: " + gl.glGetString(GL.GL_VENDOR));
		System.err.println("GL_RENDERER: " + gl.glGetString(GL.GL_RENDERER));
		System.err.println("GL_VERSION: " + gl.glGetString(GL.GL_VERSION));
	}
	
	public void reshape(GLAutoDrawable drawable, int x, int y, int width,
			int height) {

		WIDTH = width; // new width and height saved
		HEIGHT = height;

		// 7. specify the drawing area (frame) coordinates
		gl.glMatrixMode(GL.GL_PROJECTION);
		gl.glLoadIdentity();
		gl.glOrtho(0, width, 0, height, -1.0, 1.0);
		gl.glMatrixMode(GL.GL_MODELVIEW);
		gl.glLoadIdentity();
		
		//gl.glViewport(0, 100, 100, 50);
	}


	// called for OpenGL rendering every reshape
	public void display(GLAutoDrawable drawable) {
		// 5. generate a random point
		double x = Math.random() * WIDTH;
		double y = Math.random() * HEIGHT;


		// specify to draw a point
		gl.glBegin(GL.GL_POINTS);
		gl.glVertex2d(x, y);
		gl.glEnd();
	}

	public static void main(String[] args) {
		J1_1_Point f = new J1_1_Point();

		// 6. add a title on the frame
		f.setTitle("JOGL J1_1_Point");

		f.setSize(WIDTH, HEIGHT);
		f.setVisible(true);
	}

	/* some math operations used often */

	// dot product of two vectors
	public double dotprod(double[] a, double[] b) {

		return (a[0] * b[0] + a[1] * b[1] + a[2] * b[2]);
	}

	// cros product of two vectors
	public void crossprod(double[] a, double[] b, double[] v) {

		v[0] = a[1] * b[2] - a[2] * b[1];
		v[1] = a[2] * b[0] - a[0] * b[2];
		v[2] = a[0] * b[1] - a[1] * b[0];
	}

	// distance between two points
	public double distance(double[] a, double[] b) {

		return (Math.sqrt((b[0] - a[0]) * (b[0] - a[0]) + (b[1] - a[1])
				* (b[1] - a[1]) + (b[2] - a[2]) * (b[2] - a[2])));
	}

	// normalize a vector to unit vector
	public void normalize(double vector[]) {
		double d = Math.sqrt(vector[0] * vector[0] + vector[1] * vector[1]
				+ vector[2] * vector[2]);

		if (d == 0) {
			System.err.println("0 length vector: normalize().");
			return;
		}
		vector[0] /= d;
		vector[1] /= d;
		vector[2] /= d;
	}

	// reflect v1 around n to v2
	public void reflect(double v1[], double n[], double v2[]) {

		// v2 = 2*dot(v1, n)*n + v1
		for (int i = 0; i < 3; i++) {
			v2[i] = 2 * dotprod(v1, n) * n[i] - v1[i];
		}
	}
	
	public boolean quadraticFormula(double a, double b, double c, double ans[]) {

		double d = b*b - 4*a*c; 
		if (d<0) {
			return (false); 
			
		} else {
			ans[0] = (-b+Math.sqrt(d))/(2*a); 
			ans[1] = (-b-Math.sqrt(d))/(2*a); 
			return (true); 
		}
	}
}
