//import net.java.games.jogl.GL;
//import net.java.games.jogl.GLDrawable; 
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;

/**
 * 
 * 
 * <p>
 * Title: Foundations of 3D Graphics Programming : Using JOGL and Java3D
 * </p>
 * 
 * <p>
 * Description: a point bounces in a circle ...
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2005
 * </p>
 * 
 * <p>
 * Company: George Mason University
 * </p>
 * 
 * @author Dr. Jim X. Chen
 * @version 1.0
 */
public class HW1_2_PointInCircle extends HW1_1_PointOnCirlcle {
	static final int pnum = 100; // number of points

	double direction[][] = new double[pnum][3]; // directions
	double point[][] = new double[pnum][3]; // points

	public HW1_2_PointInCircle() {

		for (int i = 0; i < pnum; i++) {
			direction[i][0] = Math.random();
			direction[i][1] = Math.random();
			direction[i][2] = 0;
			normalize(direction[i]); // make it a unit vector

			// generate a point inside the circle
			do {
				point[i][0] = Math.random() * WIDTH;
				point[i][1] = Math.random() * HEIGHT;
				point[i][2] = 0;
			} while (r < distance(cx, cy, point[i][0], point[i][1]));
		}
	}

	// Called for OpenGL rendering every reshape
	public void display(GLAutoDrawable drawable) {

		cx = WIDTH / 2;
		cy = HEIGHT / 2;
		r = WIDTH / 3;
		delta = 4 / (Math.PI * r);

		gl.glClear(GL.GL_COLOR_BUFFER_BIT);

		// draw a white circle
		gl.glColor3f(1.0f, 1.0f, 1.0f);
		gl.glPointSize(4);
		drawCircle(cx, cy, r);

		gl.glPointSize(6);
		for (int i = 0; i < pnum; i++) {
			// move in a direction
			point[i][0] = point[i][0] + direction[i][0];
			point[i][1] = point[i][1] + direction[i][1];

			// bounce when point on/outside the circle
			if (r < distance(cx, cy, point[i][0], point[i][1])) {

				// change the direction of the point around r
				bounceInCircle(point[i], direction[i]);
			}
			// draw a colored point in Circle
			if (i < pnum / 3) {
				gl.glColor3f(i * 3f / pnum, 0.0f, 0.9f);
			} else if (i < 2 * pnum / 3) {
				gl.glColor3f(0, i * 3f / (2f * pnum), 0.9f);
			} else {
				gl.glColor3f(0.9f, 0.9f, i / pnum);
			}
			drawPoint(point[i][0], point[i][1]);
		}
		// sleep to slow down the rendering
		try {
			Thread.sleep(20);
		} catch (Exception ignore) {
		}
	}

	public void bounceInCircle(double point[], double direction[]) {
		double n[] = new double[3];
		double rd[] = new double[3];

		//n: a vector from point to origin
		n[0] =  cx - point[0];
		n[1] = cy - point[1];
		n[2] = 0;
		normalize(n);
	//	normalize(direction);

		for (int i = 0; i < 3; i++) {
			rd[i] = -direction[i];
			point[i] += n[i]; // so remain in circle
		}
		reflect(rd, n, direction); 
	}

	double distance(double x0, double y0, double x1, double y1) {

		return (Math.sqrt((x1 - x0) * (x1 - x0) + (y1 - y0) * (y1 - y0)));
	}

	public static void main(String[] args) {
		HW1_2_PointInCircle f = new HW1_2_PointInCircle();

		f.setTitle("HW1_2 - points bounce in a circle");
		f.setSize(WIDTH, HEIGHT);
		f.setVisible(true);

	}
}
