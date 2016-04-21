/*
 * Created on 2004-4-21
 * @author Jim X. Chen: draw bitmap and stroke characters and strings
 */
import javax.media.opengl.*;
import com.sun.opengl.util.*;

//import net.java.games.jogl.*;
//import net.java.games.jogl.util.*;

public class J1_3_xFont extends J1_3_Triangle {
	static GLUT glut = new GLUT();

	// called for OpenGL rendering every reshape
	public void display(GLAutoDrawable drawable) {
		//generate a random line;
		int x0 = (int) (Math.random() * WIDTH);
		int y0 = (int) (Math.random() * HEIGHT);
		int xn = (int) ((Math.random() * WIDTH));
		int yn = (int) (Math.random() * HEIGHT);

		// draw a yellow line
		gl.glColor3f(1, 1, 0);
		bresenhamLine(x0, y0, xn, yn);

		gl.glRasterPos3f(x0, y0, 0); // start poistion
		glut.glutBitmapCharacter(GLUT.BITMAP_HELVETICA_12, 's');
		glut.glutBitmapString(GLUT.BITMAP_HELVETICA_12, "tart");

		gl.glPushMatrix();
		gl.glTranslatef(xn, yn, 0); // end position
		gl.glScalef(0.2f, 0.2f, 0.2f);
		glut.glutStrokeCharacter(GLUT.STROKE_ROMAN, 'e');
		glut.glutStrokeString(GLUT.STROKE_ROMAN, "nd");
		gl.glPopMatrix();

		// display() sleeps 100 ms to slow down the rendering
		try {
			Thread.sleep(100);
		} catch (Exception ignore) {
		}
	}

	public static void main(String[] args) {
		J1_3_xFont f = new J1_3_xFont();

		f.setTitle("JOGL J1_3_xFont");
		f.setSize(WIDTH, HEIGHT);
		f.setVisible(true);
	}
}
