/*
 * Created on 2004-3-17
 * @author Jim X. Chen: clipping against an arbitray plane.
 */
import java.lang.Math; // import net.java.games.jogl.*;
import javax.media.opengl.*;

public class J2_12_Clipping extends J2_11_ConeSolarCollision {

	static double[] eqn = {0, 0, 1, 0};

	// plane equation ax + by + cz + d = 0

	public void display(GLAutoDrawable glDrawable) {

		//1. specify plane equation x = 0;
		//eqn[0] = 1;
		//2. tell OpenGL system the plane eqn is a clipping plane
		gl.glClipPlane(GL.GL_CLIP_PLANE0, eqn, 0);
		//3. Enable clipping of the plane. 
		gl.glEnable(GL.GL_CLIP_PLANE0);

		super.display(glDrawable);
	}

	public static void main(String[] args) {
		J2_12_Clipping f = new J2_12_Clipping();

		f.setTitle("JOGL J2_12_Clipping");
		f.setSize(WIDTH, HEIGHT);
		f.setVisible(true);
	}
}
