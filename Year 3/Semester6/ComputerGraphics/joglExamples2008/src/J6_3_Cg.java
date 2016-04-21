/**
 * <p>Title: Foundations of 3D Graphics Programming : Using JOGL and Java3D </p>
 *
 * <p>Description: Cg Example: Fragment Program -- reduce pixel intensity </p>
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


public class J6_3_Cg extends J6_2_Cg {
	
    CGprogram fragmentprog;
    static final int FRAGMENTPROFILE=CgGL.CG_PROFILE_ARBFP1;
	  

  public void init(GLAutoDrawable glDrawable) {

    super.init(glDrawable); 
    
    if(!CgGL.cgGLIsProfileSupported(FRAGMENTPROFILE))
    {
      System.out.println("Fragment profile not supported");
      System.exit(1);
    }
    
    CgGL.cgGLSetOptimalOptions(FRAGMENTPROFILE);
    fragmentprog=CgGL.cgCreateProgramFromFile(cgcontext, CgGL.CG_SOURCE, "J6_3_FP.cg", FRAGMENTPROFILE, null, null);
    CgGL.cgGLLoadProgram(fragmentprog);  
     
  }
  


  public void display(GLAutoDrawable drawable) {

	    CgGL.cgGLEnableProfile(VERTEXPROFILE);
	    CgGL.cgGLBindProgram(vertexprog);	    
	    CgGL.cgGLSetStateMatrixParameter(modelviewprojection, CgGL.CG_GL_MODELVIEW_PROJECTION_MATRIX, CgGL.CG_GL_MATRIX_IDENTITY);

	    CgGL.cgGLEnableProfile(FRAGMENTPROFILE);
	    CgGL.cgGLBindProgram(fragmentprog);


	    drawCircle(drawable); 
	    
	
	    CgGL.cgGLDisableProfile(VERTEXPROFILE);
		CgGL.cgGLDisableProfile(FRAGMENTPROFILE);
	     
	  }

  

  public static void main(String[] args) {
	  J6_3_Cg f = new J6_3_Cg();

    f.setTitle("JOGL J6_3_Cg");
    f.setSize(WIDTH, HEIGHT);
    f.setVisible(true);
  }
}
