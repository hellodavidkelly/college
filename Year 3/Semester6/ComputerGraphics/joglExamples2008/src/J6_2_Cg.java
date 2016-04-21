/**
 * <p>Title: Foundations of 3D Graphics Programming : Using JOGL and Java3D </p>
 *
 * <p>Description: Cg Example: Modelview and Projection matrix </p>
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

public class J6_2_Cg extends J6_1_Cg {
	
	static CGparameter modelviewprojection;
	  

  public void init(GLAutoDrawable glDrawable) {

    super.init(glDrawable); 
    
    vertexprog=CgGL.cgCreateProgramFromFile(cgcontext, CgGL.CG_SOURCE, "J6_2_VP.cg", VERTEXPROFILE, null, null);
    CgGL.cgGLLoadProgram(vertexprog);
    
    // modelview and projection matrix
    modelviewprojection=CgGL.cgGetNamedParameter(vertexprog, "modelViewProjection");
 }
  


  public void display(GLAutoDrawable drawable) {

	    CgGL.cgGLEnableProfile(VERTEXPROFILE);
	    CgGL.cgGLBindProgram(vertexprog);	    
	    // retrieve the current modelview and projection matrix 
	    CgGL.cgGLSetStateMatrixParameter(modelviewprojection, CgGL.CG_GL_MODELVIEW_PROJECTION_MATRIX, CgGL.CG_GL_MATRIX_IDENTITY);

	    drawCircle(drawable); 
	     
	    CgGL.cgGLDisableProfile(VERTEXPROFILE);
	  }


  public static void main(String[] args) {
	  J6_2_Cg f = new J6_2_Cg();

    f.setTitle("JOGL J6_2_Cg");
    f.setSize(WIDTH, HEIGHT);
    f.setVisible(true);
  }
}
