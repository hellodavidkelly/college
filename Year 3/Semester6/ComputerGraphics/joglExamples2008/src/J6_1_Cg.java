
/**
 * <p>Title: Foundations of 3D Graphics Programming : Using JOGL, CG, and Java3D </p>
 *
 * <p>Description: Cg Example: Scale vertex positions </p>
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


public class J6_1_Cg extends J1_5_Circle {
	
	   CGcontext cgcontext;
	   CGprogram vertexprog;
	  
	  // 1. Vertex profile: hardware specification/support
	   static final int VERTEXPROFILE=CgGL.CG_PROFILE_ARBVP1;

	  
  public void init(GLAutoDrawable glDrawable) {

    super.init(glDrawable); 
    
    if(!CgGL.cgGLIsProfileSupported(VERTEXPROFILE))
    {
      System.out.println("Profile not supported");
      System.exit(1);
    }

    // 2. Create Cg context for setting up the environment
    cgcontext=CgGL.cgCreateContext();
    
    
    // 3. Create vertex program from file with the profile 
    CgGL.cgGLSetOptimalOptions(VERTEXPROFILE);
    vertexprog=CgGL.cgCreateProgramFromFile(cgcontext, CgGL.CG_SOURCE, "J6_1_VP.cg", VERTEXPROFILE, null, null);
    CgGL.cgGLLoadProgram(vertexprog);
  }
  


  public void display(GLAutoDrawable drawable) {

	  // 4. Enable the profile and binding the vertex program
	  CgGL.cgGLEnableProfile(VERTEXPROFILE);
	  CgGL.cgGLBindProgram(vertexprog);	    

	  drawCircle(drawable); 
	 
	  // 5. Disable the profile 
	  CgGL.cgGLDisableProfile(VERTEXPROFILE);
}

  
  public void drawCircle(GLAutoDrawable drawable) {

	    super.display(drawable); 
}

  
  public static void main(String[] args) {
	  J6_1_Cg f = new J6_1_Cg();

    f.setTitle("JOGL J6_1_Cg");
    f.setSize(WIDTH, HEIGHT);
    f.setVisible(true);
  }
}
