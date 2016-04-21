/**
 * <p>Title: Foundations of 3D Graphics Programming : Using JOGL and Java3D </p>
 *
 * <p>Description: A point moves in a cirlce ...</p>
 *
 * <p>Copyright: Copyright (c) 2005</p>
 *
 * <p>Company: George Mason University</p>
 *
 * @author Dr. Jim X. Chen
 * @version 1.0
 */
//import net.java.games.jogl.*;
import javax.media.opengl.*;

public class HW1_1_PointOnCirlcle extends J1_4_Line {

  double cx = WIDTH/2, cy = HEIGHT/2, r = WIDTH/3, theta;
  double delta = 1/r;


  public HW1_1_PointOnCirlcle() {

    // use super's constructor to initialize drawing
    // specify using only a single buffer
    capabilities.setDoubleBuffered(true);
  }


// Called for OpenGL rendering every reshape
  public void display(GLAutoDrawable drawable) {

    gl.glClear(GL.GL_COLOR_BUFFER_BIT);

    //draw a white circle
    gl.glColor3f(1.0f, 1.0f, 1.0f);
    gl.glPointSize(1);
    drawCircle(cx, cy, r);

    // delta is about a pixel width in logical coord.
    theta = theta+delta;
    double x = r*Math.cos(theta)+cx;
    double y = r*Math.sin(theta)+cy;

    //draw a red point on Circle
    gl.glPointSize(8);
    gl.glColor3f(1.0f, 0.0f, 0.0f);
    drawPoint(x, y);
	// sleep to slow down the rendering
	try {
		Thread.sleep(20);
	} catch (Exception ignore) {
	}
   }


  public void drawCircle(double x0, double y0, double r) {

    double th = 0;
    while (th<=2*Math.PI) {
      th = th+delta;
      double x = r*Math.cos(th)+x0;
      double y = r*Math.sin(th)+y0;
      drawPoint(x, y);
    }
  }


  public static void main(String[] args) {
    HW1_1_PointOnCirlcle f = new HW1_1_PointOnCirlcle();

    //modified by ddu to show this example title
    f.setTitle("HW1 - a point moves in a circle");
    f.setSize(WIDTH, HEIGHT);
    f.setVisible(true);

  }


}
