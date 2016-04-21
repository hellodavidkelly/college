//import net.java.games.jogl.GL;
//import net.java.games.jogl.GLU;
//import net.java.games.jogl.GLDrawable; 
import javax.media.opengl.GL;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.GLAutoDrawable;


/**
 * <p>Title: Foundations of 3D Graphics Programming : Using JOGL and Java3D </p>
 *
 * <p>Description: draw a hermite curve </p>
 *
 * <p>Copyright: Copyright (c) 2005</p>
 *
 * <p>Company: George Mason University</p>
 *
 * @author Dr. Jim X. Chen
 * @version 1.0
 */
public class J5_3_Hermite extends J5_2_Solids {

  double ctrlp[][] = { {-0.5, -0.5, -0.5}, {-1.0, 1.0, 1.0},
                     {1.0, -1.0, 1.0}, {0.5, 0.5, 1.0}
  }; // control points: two endpoints, two tangent vectors

  public void init(GLAutoDrawable glDrawable) {

    super.init(glDrawable); // texture objects available
  }


  public void myEvalCoordHermite(double t) {
    // evaluate the coordinates and specify the points
    double x, y, z, t_1, t2, t_2, t3, t_3;

    t_1 = 1-t;
    t2 = t*t;
    t_2 = t_1*t_1;
    t3 = t2*t;
    t_3 = t_2*t_1;

    x = t_3*ctrlp[0][0]+3*t*t_2*ctrlp[1][0]
        +3*t2*t_1*ctrlp[2][0]+t3*ctrlp[3][0];

    y = t_3*ctrlp[0][1]+3*t*t_2*ctrlp[1][1]
        +3*t2*t_1*ctrlp[2][1]+t3*ctrlp[3][1];

    z = t_3*ctrlp[0][2]+3*t*t_2*ctrlp[1][2]
        +3*t2*t_1*ctrlp[2][2]+t3*ctrlp[3][2];

    gl.glVertex3d(x, y, z);
  }




  public void drawSphere() {
    int i;

    myCameraView = true;

    gl.glLineWidth(4);
    gl.glBegin(GL.GL_LINE_STRIP);
    for (i = 0; i<=30; i++) {
      myEvalCoordHermite(i/30.0);
    }
    gl.glEnd();
    /* The following code displays the control points
     as dots. */
    gl.glPointSize(6.0f);
    gl.glBegin(GL.GL_POINTS);
    gl.glVertex3dv(ctrlp[0],0);
    gl.glVertex3dv(ctrlp[3],0);
    gl.glEnd();

    // for the background texture
    gl.glBindTexture(GL.GL_TEXTURE_2D, STARS_TEX[0]);
  }


  public void drawCone() {
  }


  public static void main(String[] args) {
    J5_3_Hermite f = new J5_3_Hermite();

    f.setTitle("JOGL J5_3_Hermite");
    f.setSize(WIDTH, HEIGHT);
    f.setVisible(true);
  }
}
