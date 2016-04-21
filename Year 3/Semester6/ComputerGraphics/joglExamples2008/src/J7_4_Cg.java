/**
 * <p>Title: Foundations of 3D Graphics Programming : Using JOGL and Java3D </p>
 *
 * <p>Description: Cg Example: fragment bump mapping  </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: George Mason University</p>
 *
 * @author Dr. Jim X. Chen
 * @version 1.0
 */
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import javax.media.opengl.*;
import com.sun.opengl.cg.*;
import com.sun.opengl.util.GLUT;

public class J7_4_Cg extends J7_3_Cg {

	static CGparameter 
			normalmap; // bump map image
	
	static final int[] NORMAL_TEX = new int[1];
	// bump map image binding 

	public void init(GLAutoDrawable glDrawable) {

		super.init(glDrawable);

		vertexprog = CgGL.cgCreateProgramFromFile(cgcontext, CgGL.CG_SOURCE,
				"J7_4_VP.cg", VERTEXPROFILE, null, null);
		CgGL.cgGLLoadProgram(vertexprog);

		modelview = CgGL.cgGetNamedParameter(vertexprog, "modelView");
		modelviewprojection = CgGL.cgGetNamedParameter(vertexprog,
				"modelViewProjection");
		inversetranspose = CgGL.cgGetNamedParameter(vertexprog,
				"inverseTranspose");

		fragmentprog = CgGL.cgCreateProgramFromFile(cgcontext, CgGL.CG_SOURCE,
				"J7_4_FP.cg", FRAGMENTPROFILE, null, null);
		CgGL.cgGLLoadProgram(fragmentprog);	

		myLa = CgGL.cgGetNamedParameter(fragmentprog, "La");
		myLd = CgGL.cgGetNamedParameter(fragmentprog, "Ld");
		myLs = CgGL.cgGetNamedParameter(fragmentprog, "Ls");
		myLightPosition = CgGL.cgGetNamedParameter(fragmentprog,
				"lightPosition");
		myEyePosition = CgGL.cgGetNamedParameter(fragmentprog, "eyePosition");
		myMe = CgGL.cgGetNamedParameter(fragmentprog, "Me");
		myMa = CgGL.cgGetNamedParameter(fragmentprog, "Ma");
		myMd = CgGL.cgGetNamedParameter(fragmentprog, "Md");
		myMs = CgGL.cgGetNamedParameter(fragmentprog, "Ms");
		myShininess = CgGL.cgGetNamedParameter(fragmentprog, "shininess");

		// texture object name for Fragment Shader
		imgtexture = CgGL.cgGetNamedParameter(fragmentprog, "imgTexture");
		
		// bump map uniform sampler2D access in the fragment program
		normalmap = CgGL.cgGetNamedParameter(fragmentprog, "normalMap");

		gl.glEnable(GL.GL_LIGHTING);
		gl.glEnable(GL.GL_NORMALIZE);

		gl.glEnable(GL.GL_LIGHT0);

		gl.glLightfv(GL.GL_LIGHT0, GL.GL_AMBIENT, blackish, 0);
		CgGL.cgSetParameter4fv(myLa, blackish, 0);

		gl.glLightfv(GL.GL_LIGHT0, GL.GL_DIFFUSE, white, 0);
		CgGL.cgSetParameter4fv(myLd, white, 0);

		gl.glLightfv(GL.GL_LIGHT0, GL.GL_SPECULAR, white, 0);
		CgGL.cgSetParameter4fv(myLs, white, 0);
		coordOff = true;
	}

	public void display(GLAutoDrawable drawable) {

		CgGL.cgGLEnableProfile(VERTEXPROFILE);
		CgGL.cgGLBindProgram(vertexprog);
		CgGL.cgGLEnableProfile(FRAGMENTPROFILE);
		CgGL.cgGLBindProgram(fragmentprog);

		gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
		super.displayView();


		// 5. Disable the profile
		CgGL.cgGLDisableProfile(VERTEXPROFILE);
		CgGL.cgGLDisableProfile(FRAGMENTPROFILE);
	}

	void initTexture() {

		// initialize bumpmap texture obj
		gl.glGenTextures(1, IntBuffer.wrap(NORMAL_TEX));
		gl.glBindTexture(GL.GL_TEXTURE_2D, NORMAL_TEX[0]);
		gl.glTexParameteri(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MIN_FILTER,
				GL.GL_LINEAR);
		gl.glTexParameteri(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MAG_FILTER,
				GL.GL_LINEAR);
		readImage("NORMAL.jpg");

		gl.glTexImage2D(GL.GL_TEXTURE_2D, 0, GL.GL_RGB8, imgW, imgH, 0,
				GL.GL_BGR, GL.GL_UNSIGNED_BYTE, ByteBuffer.wrap(img));
		super.initTexture();
	}


	public void drawSphere() {

		CgGL.cgGLSetStateMatrixParameter(modelview,
				CgGL.CG_GL_MODELVIEW_MATRIX, CgGL.CG_GL_MATRIX_IDENTITY);
		CgGL.cgGLSetStateMatrixParameter(inversetranspose,
				CgGL.CG_GL_MODELVIEW_MATRIX,
				CgGL.CG_GL_MATRIX_INVERSE_TRANSPOSE);
		CgGL.cgGLSetStateMatrixParameter(modelviewprojection,
				CgGL.CG_GL_MODELVIEW_PROJECTION_MATRIX,
				CgGL.CG_GL_MATRIX_IDENTITY);

		if ((cnt % 1600) < 500) {
			gl.glBindTexture(GL.GL_TEXTURE_2D, EARTH_TEX[0]);
			CgGL.cgGLSetTextureParameter(imgtexture, EARTH_TEX[0]);
		} else if ((cnt % 1603) < 1000) {
			gl.glBindTexture(GL.GL_TEXTURE_2D, NORMAL_TEX[0]);
			CgGL.cgGLSetTextureParameter(imgtexture, NORMAL_TEX[0]);

		} else {
			gl.glBindTexture(GL.GL_TEXTURE_2D, IRIS_TEX[0]);
			CgGL.cgGLSetTextureParameter(imgtexture, IRIS_TEX[0]);
		}
		gl.glTexEnvf(GL.GL_TEXTURE_ENV, GL.GL_TEXTURE_ENV_MODE, GL.GL_MODULATE);

		CgGL.cgGLSetTextureParameter(normalmap, NORMAL_TEX[0]);
		CgGL.cgGLEnableTextureParameter(imgtexture);
		CgGL.cgGLEnableTextureParameter(normalmap);

		subdivideSphere(sVdata[0], sVdata[1], sVdata[2], depth);
		subdivideSphere(sVdata[0], sVdata[2], sVdata[4], depth);
		subdivideSphere(sVdata[0], sVdata[4], sVdata[5], depth);
		subdivideSphere(sVdata[0], sVdata[5], sVdata[1], depth);

		subdivideSphere(sVdata[3], sVdata[1], sVdata[5], depth);
		subdivideSphere(sVdata[3], sVdata[5], sVdata[4], depth);
		subdivideSphere(sVdata[3], sVdata[4], sVdata[2], depth);
		subdivideSphere(sVdata[3], sVdata[2], sVdata[1], depth);

	}


	public static void main(String[] args) {
		J7_4_Cg f = new J7_4_Cg();

		f.setTitle("JOGL J7_4_Cg");
		f.setSize(WIDTH, HEIGHT);
		f.setVisible(true);
	}
}
