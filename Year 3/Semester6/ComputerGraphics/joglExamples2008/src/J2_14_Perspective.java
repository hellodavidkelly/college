/*
 * Created on 2004-11-17
 * @author Jim X. Chen: simulate gluPerspective
 */
//import net.java.games.jogl.*;
import javax.media.opengl.*;
import java.lang.Math;


public class J2_14_Perspective extends
    J2_13_TravelSolar {

  public void myPerspective(double fovy, double aspect,
                            double near, double far) {
    double left, right, bottom, top;

    fovy = fovy*Math.PI/180; // convert degree to arc

    top = near*Math.tan(fovy/2);
    bottom = -top;
    right = aspect*top;
    left = -right;

    gl.glMatrixMode(GL.GL_PROJECTION);
    gl.glLoadIdentity();
    gl.glFrustum(left, right, bottom, top, near, far);
  }


  public void reshape(
      GLAutoDrawable glDrawable,
      int x,
      int y,
      int width,
      int height) {

    O = 0;
    A = (float)WIDTH/4;
    B = (float)0.4*WIDTH;
    C = (float)0.5*WIDTH;
    WIDTH = width;
    HEIGHT = height;

    // enable zbuffer for hidden-surface removal
    gl.glEnable(GL.GL_DEPTH_TEST);
    gl.glViewport(0, 0, width, height);

    myPerspective(40, width/height, width/2, 4*width);

    gl.glMatrixMode(GL.GL_MODELVIEW);
    gl.glLoadIdentity();
    gl.glTranslatef(0, 0, -2*width);
  }


  public static void main(String[] args) {
    J2_14_Perspective f = new J2_14_Perspective();

    f.setTitle("JOGL J2_14_Perspective");
    f.setSize(WIDTH, HEIGHT);
    f.setVisible(true);
  }

}
