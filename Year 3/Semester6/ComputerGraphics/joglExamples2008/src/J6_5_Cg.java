/**
 * <p>Title: Foundations of 3D Graphics Programming : Using JOGL and Java3D </p>
 *
 * <p>Description: Cg Example: Fragment Program -- random or constant pixel colors </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: George Mason University</p>
 *
 * @author Dr. Jim X. Chen
 * @version 1.0
 */

import com.sun.opengl.cg.*;
import javax.media.opengl.*;

public class J6_5_Cg extends J6_4_Cg {

	static CGparameter fragmentColor;

	public void init(GLAutoDrawable glDrawable) {

		super.init(glDrawable);

		fragmentprog = CgGL.cgCreateProgramFromFile(cgcontext, CgGL.CG_SOURCE,
				"J6_5_FP.cg", FRAGMENTPROFILE, null, null);
		CgGL.cgGLLoadProgram(fragmentprog);

		modelviewprojection = CgGL.cgGetNamedParameter(vertexprog,
				"modelViewProjection");
		fragmentColor = CgGL.cgGetNamedParameter(fragmentprog, "fColor");

	}

	
	public void drawtriangle(float[] v1, float[] v2, float[] v3) {

		float color[] = new float[4];
		
		color[0] = (float) Math.random();
		color[1] = (float) Math.random();
		color[2] = (float) Math.random();
		color[3] = 0; 
		CgGL.cgSetParameter3fv(fragmentColor, color, 0);


		gl.glBegin(GL.GL_TRIANGLES);
		gl.glVertex3fv(v1, 0);
		gl.glVertex3fv(v2, 0);
		gl.glVertex3fv(v3, 0);
		gl.glEnd();
	}

	public static void main(String[] args) {
		J6_5_Cg f = new J6_5_Cg();

		f.setTitle("JOGL J6_5_Cg");
		f.setSize(WIDTH, HEIGHT);
		f.setVisible(true);
	}
}
