/*
 * Created on 2004-2-27
 * @author Jim X. Chen: scan-convert randomly generated lines with antialiasing
 */
//import net.java.games.jogl.*;
import javax.media.opengl.*;

public class J1_4_Line extends J1_3_xFont {
	private float r, g, b;

	// called for OpenGL rendering every reshape
	public void display(GLAutoDrawable drawable) {

	//	gl.glClear(GL.GL_COLOR_BUFFER_BIT);
		// generate a random line;
		int x0 = (int) (Math.random() * WIDTH);
		int y0 = (int) (Math.random() * HEIGHT);
		int xn = (int) ((Math.random() * WIDTH));
		int yn = (int) (Math.random() * HEIGHT);

		// generate a random color for this line
		r = (float) ((Math.random() * 9)) / 8;
		g = (float) ((Math.random() * 9)) / 8;
		b = (float) ((Math.random() * 9)) / 8;

		gl.glColor3f(r, g, b);
		// draw a three pixel antialiased line
		antialiasedLine(x0, y0, xn, yn);

		// sleep to slow down the rendering
		try {
			Thread.sleep(100);
		} catch (Exception ignore) {
		}
	}

	public void reshape(GLAutoDrawable drawable, int x, int y, int width,
			int height) {

		WIDTH = width; // new width and height saved
		HEIGHT = height;
		gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
		gl.glClear(GL.GL_COLOR_BUFFER_BIT);

		// 7. specify the drawing area (frame) coordinates
		gl.glMatrixMode(GL.GL_PROJECTION);
		gl.glLoadIdentity();
		gl.glOrtho(0, width, 0, height, -1.0, 1.0);
	}

	// draw pixel with intensity by its distance to the line
	void IntensifyPixel(int x, int y, float D, int flag) {
		float d, r1, g1, b1;

		if (D < 0) {
			d = -D; // negative if the pixel is above the line
		} else {
			d = D;
		}

		// calculate intensity according to the distance d
		r1 = (float) (r * (1 - d / 2.5));
		g1 = (float) (g * (1 - d / 2.5));
		b1 = (float) (b * (1 - d / 2.5));

		gl.glColor3f(r1, g1, b1);
		writepixel(x, y, flag);
	}

	// scan-convert a 3 pixel wide antialiased line
	void antialiasedLine(int x0, int y0, int xn, int yn) {
		int dx, dy, incrE, incrNE, d, x, y, flag = 0;
		float D = 0, sin_a, cos_a, sin_cos_a, Denom;

		if (xn < x0) {
			// swapd(& x0, & xn);
			int temp = x0;
			x0 = xn;
			xn = temp;
			// swapd(& y0, & yn);
			temp = y0;
			y0 = yn;
			yn = temp;
		}

		if (yn < y0) {
			y0 = -y0;
			yn = -yn;
			flag = 10;
		}

		dy = yn - y0;
		dx = xn - x0;
		if (dx < dy) {
			// swapd(& x0, & y0);
			int temp = x0;
			x0 = y0;
			y0 = temp;
			// swapd(& xn, & yn);
			temp = xn;
			xn = yn;
			yn = temp;
			// swapd(& dy, & dx);
			temp = dy;
			dy = dx;
			dx = temp;

			flag++;
		}

		x = x0;
		y = y0;
		d = 2 * dy - dx; // decision factor
		incrE = 2 * dy;
		incrNE = 2 * (dy - dx);

		Denom = (float) Math.sqrt((double) (dx * dx + dy * dy));
		sin_a = dy / Denom;
		cos_a = dx / Denom;
		sin_cos_a = sin_a - cos_a;

		while (x < xn + 1) {
			IntensifyPixel(x, y, D, flag);
			IntensifyPixel(x, y + 1, D - cos_a, flag); // N
			IntensifyPixel(x, y - 1, D + cos_a, flag); // S
			IntensifyPixel(x, y + 2, D - 2*cos_a, flag); // N
			IntensifyPixel(x, y - 2, D + 2*cos_a, flag); // S

			x++;
			// consider the next pixel
			if (d <= 0) {
				D += sin_a; // distance to the line from E
				d += incrE;
			} else {
				D += sin_cos_a; // distance to the line: NE
				y++;
				d += incrNE;
			}
		}
	}

	public static void main(String[] args) {
		J1_4_Line f = new J1_4_Line();

		f.setTitle("JOGL J1_4_Line");
		f.setSize(WIDTH, HEIGHT);
		f.setVisible(true);
	}
}
