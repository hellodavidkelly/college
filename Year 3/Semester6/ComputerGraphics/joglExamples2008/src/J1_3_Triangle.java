/*
 * Created on 2004-4-21
 *
 * @author Jim X. Chen
 *
 * draw a randomly generated filled triangle 
 */

import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;

public class J1_3_Triangle extends J1_3_Line {

	public void display(GLAutoDrawable drawable) {
		// generate a random triangle and display
		int v[][] = new int[3][3];

		for (int i = 0; i < 3; i++) { // three random vertices
			v[i][0] = (int) (WIDTH * Math.random());
			v[i][1] = (int) (HEIGHT * Math.random());
			v[i][2] = 0;
		}

		gl.glClear(GL.GL_COLOR_BUFFER_BIT); 
		
		// scan-convert the triangle
		drawtriangle(v);

		// draw edges of the triangle
		bresenhamLine(v[0][0], v[0][1], v[1][0], v[1][1]);
		bresenhamLine(v[1][0], v[1][1], v[2][0], v[2][1]);
		bresenhamLine(v[2][0], v[2][1], v[0][0], v[0][1]);

		gl.setSwapInterval(30);
		try {
			Thread.sleep(200);
		} catch (Exception ignore) {
		}
	}


	public void drawtriangle(int[][] v) {
		int ymin = 0, ymid = 0, ymax = 0; // 3 vertices' y location

		// 1. sort the vertices along y
		if (v[0][1] < v[1][1]) { // 201; 021; 012
			if (v[0][1] < v[2][1]) { // 021 or 012
				ymin = 0;
				if (v[1][1] < v[2][1]) { // 012
					ymid = 1;
					ymax = 2;
				} else { // 021
					ymid = 2;
					ymax = 1;
				}
			} else {// 201
				ymin = 2;
				ymid = 0;
				ymax = 1;
			}
		} else { // 210; 120; 102
			if (v[1][1] < v[2][1]) { // 120; 102
				ymin = 1;
				if (v[0][1] < v[2][1]) { // 102
					ymid = 0;
					ymax = 2;
				} else { // 120
					ymid = 2;
					ymax = 0;
				}
			} else {// 210
				ymin = 2;
				ymid = 1;
				ymax = 0;
			}
		}

		// 2. Calculate 1/m for each edges
		// Given y, when y = y + 1, x = x + 1/m on an edge
		float m_nd = 0, m_nx = 0, m_dx = 0; // 1/m of min-mid; min-max; mid-max
											// edges
		float x1 = v[ymin][0], x2 = v[ymin][0];
		int y = v[ymin][1], dy;

		// calculate 1/m for min-max edge
		if ((dy = v[ymax][1] - v[ymin][1]) > 0)
			m_nx = (float) (v[ymax][0] - v[ymin][0]) / dy;
		else
			return; // trivial; triangle has no size

		// calculate 1/m for min-mid edge
		if ((dy = v[ymid][1] - v[ymin][1]) > 0) {
			m_nd = (float) (v[ymid][0] - v[ymin][0]) / dy;

		} else { // flat bottom
			x1 = v[ymid][0];
		}

		// calculate 1/m for mid-max edge
		if ((dy = v[ymax][1] - v[ymid][1]) > 0) {
			m_dx = (float) (v[ymax][0] - v[ymid][0]) / dy;

		} else { // flat top
		}

		//3. For each y, draw a horizontal line between x1 and x2 on the two edges
		for (y = v[ymin][1]; y < v[ymid][1]; y++) {
			// for each scan-line

			span((int) x2, (int) x1, y);
			x1 = x1 + m_nd;
			x2 = x2 + m_nx;
		}

		for (y = v[ymid][1]; y < v[ymax][1]; y++) {
			// for each scan-line

			span((int) x2, (int) x1, y);
			x1 = x1 + m_dx;
			x2 = x2 + m_nx;
		}
	}

	
	// draw a horizontal line
	void span(int x2, int x1, int y) {
		if (x1 > x2) {
			int tmp = x2;
			x2 = x1;
			x1 = tmp;
		}
		for (int x = x1; x < x2; x++) {
			gl.glColor3d(Math.random(), Math.random(), Math.random());
			drawPoint(x, y);
		}
		gl.glColor3d(1, 1, 1);

	}

	public static void main(String[] args) {
		J1_3_Triangle f = new J1_3_Triangle();

		f.setTitle("J1_3_Triangle - draw triangle");
		f.setSize(WIDTH, HEIGHT);
		f.setVisible(true);
	}

}
