/**
 * <p>Title: Foundations of 3D Graphics Programming : Using JOGL and Java3D </p>
 *
 * <p>Description: Cg Example: fragment lighting  </p>
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


public class J7_2_Cg extends J7_1_Cg {
    CGprogram fragmentprog;
    static final int FRAGMENTPROFILE=CgGL.CG_PROFILE_ARBFP1;

	public void init(GLAutoDrawable glDrawable) {

		super.init(glDrawable);

		if (!CgGL.cgGLIsProfileSupported(FRAGMENTPROFILE)) {
			System.out.println("Fragment profile not supported");
			System.exit(1);
		}

		CgGL.cgGLSetOptimalOptions(VERTEXPROFILE);
		vertexprog = CgGL.cgCreateProgramFromFile(cgcontext, CgGL.CG_SOURCE,
				"J7_2_VP.cg", VERTEXPROFILE, null, null);
		CgGL.cgGLLoadProgram(vertexprog);

		// matrix transformation in Vertex Shader
		modelview = CgGL.cgGetNamedParameter(vertexprog, "modelView");
		modelviewprojection = CgGL.cgGetNamedParameter(vertexprog,
				"modelViewProjection");
		inversetranspose = CgGL.cgGetNamedParameter(vertexprog, "inverseTranspose");
	
		CgGL.cgGLSetOptimalOptions(FRAGMENTPROFILE);
		fragmentprog = CgGL.cgCreateProgramFromFile(cgcontext, CgGL.CG_SOURCE,
				"J7_2_FP.cg", FRAGMENTPROFILE, null, null);
		CgGL.cgGLLoadProgram(fragmentprog);

		// lighting calculation in Fragment Shader
		myLa = CgGL.cgGetNamedParameter(fragmentprog, "La");
		myLd = CgGL.cgGetNamedParameter(fragmentprog, "Ld");
		myLs = CgGL.cgGetNamedParameter(fragmentprog, "Ls");
		myLightPosition = CgGL.cgGetNamedParameter(fragmentprog,
				"lightPosition");
		myEyePosition = CgGL.cgGetNamedParameter(fragmentprog,
				"eyePosition");
		myMe = CgGL.cgGetNamedParameter(fragmentprog, "Me");
		myMa = CgGL.cgGetNamedParameter(fragmentprog, "Ma");
		myMd = CgGL.cgGetNamedParameter(fragmentprog, "Md");
		myMs = CgGL.cgGetNamedParameter(fragmentprog, "Ms");
		myShininess = CgGL.cgGetNamedParameter(fragmentprog,
				"shininess");

		gl.glEnable(GL.GL_LIGHTING);
		gl.glEnable(GL.GL_NORMALIZE);

		gl.glEnable(GL.GL_LIGHT0);

		gl.glLightfv(GL.GL_LIGHT0, GL.GL_AMBIENT, blackish, 0);
		CgGL.cgSetParameter4fv(myLa, blackish,0);

		gl.glLightfv(GL.GL_LIGHT0, GL.GL_DIFFUSE, white, 0);
		CgGL.cgSetParameter4fv(myLd, white, 0);

		gl.glLightfv(GL.GL_LIGHT0, GL.GL_SPECULAR, white, 0);
		CgGL.cgSetParameter4fv(myLs, white, 0);
	}

	public void display(GLAutoDrawable drawable) {

		// 4. Enable the profile and binding the vertex program
		CgGL.cgGLEnableProfile(VERTEXPROFILE);
		CgGL.cgGLBindProgram(vertexprog);
		CgGL.cgGLEnableProfile(FRAGMENTPROFILE);
		CgGL.cgGLBindProgram(fragmentprog);

		displayRobot(drawable);

		// 5. Disable the profile
		CgGL.cgGLDisableProfile(VERTEXPROFILE);
		CgGL.cgGLDisableProfile(FRAGMENTPROFILE);
	}


	public static void main(String[] args) {
		J7_2_Cg f = new J7_2_Cg();

		f.setTitle("JOGL J7_2_Cg");
		f.setSize(WIDTH, HEIGHT);
		f.setVisible(true);
	}
}
