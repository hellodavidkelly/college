//import net.java.games.jogl.GL;
//import net.java.games.jogl.GLDrawable; 
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;

/**


 * <p>Title: Foundations of 3D Graphics Programming : Using JOGL and Java3D </p>
 *
 * <p>Description: draw a pentagon rotating in the circle </p>
 *
 * <p>Copyright: Copyright (c) 2005</p>
 *
 * <p>Company: George Mason University</p>
 *
 * @author Dr. Jim X. Chen
 * @version 1.0
 */
public class HW1_3_Pentagon extends HW1_2_PointInCircle {
  public HW1_3_Pentagon() {
  }


  // Called for OpenGL rendering every reshape
  public void display(GLAutoDrawable drawable) {

    super.display(drawable);

    // delta is about a pixel width in logical coord.
    theta = theta-delta;

    // starting point
    int x0 = (int)(r*Math.cos(theta)+cx);
    int y0 = (int)(r*Math.sin(theta)+cy);

    for (int i = 1; i<=5; i++) {
      int x = (int)(r*Math.cos(theta+2*i*Math.PI/5)+cx);
      int y = (int)(r*Math.sin(theta+2*i*Math.PI/5)+cy);

      gl.glPointSize(1);
      antialiasedLine(x0, y0, x, y);
      x0 = x;
      y0 = y;

      //draw a red point on Circle
      gl.glPointSize(8);
      gl.glColor3f(1.0f, 0.0f, 0.0f);
      drawPoint(x, y);
    }
  }


  void IntensifyPixel(int x, int y, float D, int flag) {
    float d, r1, g1, b1;

    if (D<0) {
      d = -D; // negative if the pixel is above the line
    } else {
      d = D;
    }

    // calculate intensity according to the distance d
    r1 = (float)(1-d/2.5f);
    g1 = (float)(1-d/2.5f);
    b1 = (float)(1-d/2.5f);

    gl.glColor3f(r1, g1, b1);
    writepixel(x, y, flag);
  }


  public static void main(String[] args) {
    HW1_3_Pentagon f = new HW1_3_Pentagon();

    f.setTitle("HW1_3 - rotating pentagon");
    f.setSize(WIDTH, HEIGHT);
    f.setVisible(true);

  }

}
