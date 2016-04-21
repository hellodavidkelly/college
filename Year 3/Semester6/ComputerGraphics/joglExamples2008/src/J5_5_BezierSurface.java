//import net.java.games.jogl.GL; 
import javax.media.opengl.GL;

/**


 * <p>Title: Foundations of 3D Graphics Programming : Using JOGL and Java3D </p>
 *
 * <p>Description: draw a Bezier surface using 2D evaluators ...</p>
 *
 * <p>Copyright: Copyright (c) 2005</p>
 *
 * <p>Company: George Mason University</p>
 *
 * @author Dr. Jim X. Chen
 * @version 1.0
 */
public class J5_5_BezierSurface extends J5_4_Bezier {
  double ctrlpts[] = { // C00, C01, C02, C03
                     -1.0, -1.0, 1, -1.0, -0.75, -1.0,
                     -1.0, 0.75, 1.0, -1.0, 1, -1.0,
                     // C10, C11, C12, C13
                     -0.75, -1.0, -1, -0.75, -0.75, 0,
                     -0.75, 0.75, -5.0, -0.75, 1, 1.0,
                     // C20, C21, C22, C23
                     0.75, -1.0, 1, 0.75, -0.75, 0,
                     0.75, 0.75, 1.0, 0.75, 1, -1.0,
                     // C30, C31, C32, C33
                     1, -1.0, -1, 1, -0.75, 1.0,
                     1, 0.75, -1.0, 1, 1, 1.0,
  };

  public void drawSphere() {
    int i, j;

    // define and invoke 2D evaluator
    gl.glMap2d(GL.GL_MAP2_VERTEX_3, 0, 1, 3, 4,
               0, 1, 12, 4, ctrlpts,0);
    gl.glEnable(GL.GL_MAP2_VERTEX_3);

    gl.glDisable(GL.GL_LIGHTING);
    gl.glLineWidth(3);
    for (j = 0; j<=10; j++) {
      gl.glBegin(GL.GL_LINE_STRIP);
      for (i = 0; i<=10; i++) {
        gl.glColor3f(i/10f, j/10f, 1f);
        // use OpenGL evaluator
        gl.glEvalCoord2d(i/10.0, j/10.0);
      }
      gl.glEnd();
      gl.glBegin(GL.GL_LINE_STRIP);
      for (i = 0; i<=10; i++) {
        gl.glColor3f(i/10f, j/10f, 1f);
      // use OpenGL evaluator
       gl.glEvalCoord2d(j/10.0, i/10.0);
      }
      gl.glEnd();
    }

    // Highlight the knots: white
    gl.glPointSize(6);
    gl.glColor3f(1, 1, 1);
    gl.glBegin(GL.GL_POINTS);
    for (j = 0; j<=10; j++) {
      for (i = 0; i<=10; i++) {
          // use OpenGL evaluator
        gl.glEvalCoord2d(i/10.0, j/10.0);
      }
    }
    gl.glEnd();

    // for the background texture
    gl.glBindTexture(GL.GL_TEXTURE_2D, STARS_TEX[0]);
  }


  public static void main(String[] args) {
    J5_5_BezierSurface f = new J5_5_BezierSurface();

    f.setTitle("JOGL J5_5_BezierSurface");
    f.setSize(WIDTH, HEIGHT);
    f.setVisible(true);
  }
}
