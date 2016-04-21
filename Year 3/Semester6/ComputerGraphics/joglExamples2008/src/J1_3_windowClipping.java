/*
 * Created on 2008-1-21
 * @author Jim X. Chen: point clipping inside a window
 */
import javax.media.opengl.*;

import com.sun.opengl.util.*;

//import net.java.games.jogl.*;
//import net.java.games.jogl.util.*;

public class J1_3_windowClipping extends J1_3_Triangle {

	double lLeft[] = { WIDTH / 8, HEIGHT / 4, 0 };
	double uRight[] = { 7 * WIDTH / 8, 3 * HEIGHT / 4, 0 };

	public void display(GLAutoDrawable drawable) {

		super.display(drawable);

		// draw the clipping window
		gl.glBegin(GL.GL_LINE_LOOP);
		gl.glVertex2d(lLeft[0] - 1, lLeft[1] - 1);
		gl.glVertex2d(uRight[0] + 1, lLeft[1] - 1);
		gl.glVertex2d(uRight[0] + 1, uRight[1] + 1);
		gl.glVertex2d(lLeft[0] - 1, uRight[1] + 1);
		gl.glEnd();
	}

	public void drawPoint(double x, double y) {

		// clip against the window
		if (x < lLeft[0] || x > uRight[0]) {
			return;
		}
		if (y < lLeft[1] || y > uRight[1]) {
			return;
		}

		super.drawPoint(x, y);

	}

	public static void main(String[] args) {
		J1_3_windowClipping f = new J1_3_windowClipping();

		f.setTitle("JOGL J1_3_windowClipping");
		f.setSize(WIDTH, HEIGHT);
		f.setVisible(true);
	}
}
