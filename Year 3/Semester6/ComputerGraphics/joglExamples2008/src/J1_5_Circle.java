/*
 * Created on 2004-2-27
 * @author Jim X. Chen: animate a circle
 */
import javax.media.opengl.*;

// import net.java.games.jogl.*;

public class J1_5_Circle extends J1_4_Line {
	static int depth = 0; // number of subdivisions
	static int cRadius = 2, flip = 1;

	// vertex data for the triangles
	static float cVdata[][] = { { 1.0f, 0.0f, 0.0f }, { 0.0f, 1.0f, 0.0f },
			{ -1.0f, 0.0f, 0.0f }, { 0.0f, -1.0f, 0.0f } };

	public J1_5_Circle() {
		// use super's constructor to initialize drawing

		//1. specify using double buffers
		capabilities.setDoubleBuffered(true);
	}

	public void reshape(GLAutoDrawable drawable, int x, int y, int w, int h) {
		//2. the width and height of the new window
		WIDTH = w;
		HEIGHT = h;

		//3. origin at the center of the drawing area
		gl.glMatrixMode(GL.GL_PROJECTION);
		gl.glLoadIdentity();
		gl.glOrtho(-w / 2, w / 2, -h / 2, h / 2, -1, 1);

		//4. interval to swap buffers to avoid rendering too fast
		gl.setSwapInterval(1);

		// display OpenGL and graphics system information
		System.out.println("INIT GL IS: " + gl.getClass().getName());
		System.err.println(drawable.getChosenGLCapabilities());
		System.err.println("GL_VENDOR: " + gl.glGetString(GL.GL_VENDOR));
		System.err.println("GL_RENDERER: " + gl.glGetString(GL.GL_RENDERER));
		System.err.println("GL_VERSION: " + gl.glGetString(GL.GL_VERSION));
	}

	// Called for OpenGL rendering every reshape
	public void display(GLAutoDrawable drawable) {

		// when the circle is too big or small, change
		// the direction (growing or shrinking)
		if (cRadius >= (HEIGHT / 2) || cRadius == 1) {
			flip = -flip;
			depth++; // number of subdivisions
			depth = depth % 7;
		}
		cRadius += flip; // circle's radius change

		//5. clear the framebuffer and draw a new circle
		gl.glClear(GL.GL_COLOR_BUFFER_BIT);
		drawCircle(cRadius, depth);
		try {
			Thread.sleep(20);
		} catch (Exception ignore) {
		}
	}

	// draw a circle with center at the origin in xy plane
	public void drawCircle(int cRadius, int depth) {

		subdivideCircle(cRadius, cVdata[0], cVdata[1], depth);
		subdivideCircle(cRadius, cVdata[1], cVdata[2], depth);
		subdivideCircle(cRadius, cVdata[2], cVdata[3], depth);
		subdivideCircle(cRadius, cVdata[3], cVdata[0], depth);
	}

	// subdivide a triangle recursively, and draw them
	private void subdivideCircle(int radius, float[] v1, float[] v2, int depth) {
		float v11[] = new float[3];
		float v22[] = new float[3];
		float v00[] = { 0, 0, 0 };
		float v12[] = new float[3];

		if (depth == 0) {

			//6. specify a color related to triangle location
			gl.glColor3f(v1[0] * v1[0], v1[1] * v1[1], v1[2] * v1[2]);

			for (int i = 0; i < 3; i++) {
				v11[i] = v1[i] * radius;
				v22[i] = v2[i] * radius;
			}
			drawtriangle(v11, v22, v00);
			return;
		}

		v12[0] = v1[0] + v2[0];
		v12[1] = v1[1] + v2[1];
		v12[2] = v1[2] + v2[2];

		normalize(v12);

		// subdivide a triangle recursively, and draw them
		subdivideCircle(radius, v1, v12, depth - 1);
		subdivideCircle(radius, v12, v2, depth - 1);
	}

	// normalize a 3D vector
	public void normalize(float vector[]) {
		float d = (float) Math.sqrt(vector[0] * vector[0] + vector[1]
				* vector[1] + vector[2] * vector[2]);

		if (d == 0) {
			System.out.println("0 length vector: normalize().");
			return;
		}
		vector[0] /= d;
		vector[1] /= d;
		vector[2] /= d;
	}

	public void drawtriangle(float[] v1, float[] v2, float[] v3) {
		gl.glBegin(GL.GL_TRIANGLES);
		gl.glVertex3fv(v1, 0);
		gl.glVertex3fv(v2, 0);
		gl.glVertex3fv(v3, 0);
		gl.glEnd();
	}

	public static void main(String[] args) {
		J1_5_Circle f = new J1_5_Circle();

		f.setTitle("JOGL J1_5_Circle");
		f.setSize(WIDTH, HEIGHT);
		f.setVisible(true);
	}

}
