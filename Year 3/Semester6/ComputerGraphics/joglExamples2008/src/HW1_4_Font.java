//import net.java.games.jogl.GLDrawable;
//import net.java.games.jogl.util.GLUT; 
import javax.media.opengl.GLAutoDrawable;
import com.sun.opengl.util.GLUT;


/**


 * <p>Title: Foundations of 3D Graphics Programming : Using JOGL and Java3D </p>
 *
 * <p>Description: using glut fonts ...</p>
 *
 * <p>Copyright: Copyright (c) 2005</p>
 *
 * <p>Company: George Mason University</p>
 *
 * @author Dr. Jim X. Chen
 * @version 1.0
 */
public class HW1_4_Font extends HW1_3_Pentagon {

  public void display(GLAutoDrawable drawable) {

    super.display(drawable);

    // draw a stroke string in the center (no clipping)
    gl.glPushMatrix();
    gl.glTranslated(cx-80, cy-5, 0);
    gl.glScalef(0.1f, 0.1f, 0.1f);
    glut.glutStrokeString(GLUT.STROKE_ROMAN,
                          "HELLO WORLD");
    gl.glPopMatrix();

    // delta is about a pixel width in logical coord.
    theta = theta-delta;

    for (int i = 1; i<=5; i++) {
      int x = (int)(r*Math.cos(theta+2*i*Math.PI/5)+cx);
      int y = (int)(r*Math.sin(theta+2*i*Math.PI/5)+cy);

      //draw a red point on Circle
      gl.glPointSize(8);
      gl.glColor3f(1.0f, 0.0f, 0.0f);
      drawPoint(x, y);

      // label the current vertex
      gl.glColor3f(1f, 1f, 0f);
      labelVertex(x, y, i);
    }
  }


  public void labelVertex(int x, int y, int i) {

    // label the vertex
    gl.glRasterPos3f(x, y, 0); // start poistion
    glut.glutBitmapString(GLUT.BITMAP_HELVETICA_12,
                          "  Vertex[");
    glut.glutBitmapString(GLUT.BITMAP_HELVETICA_12,
                          Integer.toString(i));
    glut.glutBitmapCharacter(GLUT.BITMAP_HELVETICA_12,
                             ']');
  }


  public static void main(String[] args) {
    HW1_4_Font f = new HW1_4_Font();

    f.setTitle("HW1_4 - using font");
    f.setSize(WIDTH, HEIGHT);
    f.setVisible(true);

  }
}
