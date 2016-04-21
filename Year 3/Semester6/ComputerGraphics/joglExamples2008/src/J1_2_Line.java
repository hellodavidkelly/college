/*
 * Created on 2004-2-20
 * @author Jim X. Chen: draw randomly generated lines
   with -1<m<1
 */
import javax.media.opengl.*;
//import net.java.games.jogl.*;

public class J1_2_Line extends J1_1_Point {

  // use super's constructor to initialize drawing

  // called for OpenGL rendering every reshape
  public void display(GLAutoDrawable drawable) {
    int x0, y0, xn, yn, dx, dy;

    //1. generate a random line with -1<m<1;
    do {
      x0 = (int)(Math.random()*WIDTH);
      y0 = (int)(Math.random()*HEIGHT);
      xn = (int)(Math.random()*WIDTH);
      yn = (int)(Math.random()*HEIGHT);
      dx = xn-x0;
      dy = yn-y0;

      if (x0>xn) {
        dx = -dx;
      }
      if (y0>yn) {
        dy = -dy;
      }
    } while (dy>dx);

    //2. draw a green line
    gl.glColor3f(0, 1, 0);
    line(x0, y0, xn, yn);
  }


  // scan-convert an integer line with slope -1<m<1
  void line(int x0, int y0, int xn, int yn) {
    int x;
    float m, y;

    m = (float)(yn-y0)/(xn-x0);

    x = x0;
    y = y0;

    while (x<xn+1) {
      //3. write a pixel into framebuffer
      drawPoint(x, y);
      x++;
      y += m; /* next pixel's position */
    }
  }


  public void drawPoint(double x, double y) {

  gl.glBegin(GL.GL_POINTS);
  gl.glVertex2d(x, y);
  gl.glEnd();
}


  public static void main(String[] args) {
    J1_2_Line f = new J1_2_Line();

    f.setTitle("JOGL J1_2_Line");
    f.setSize(WIDTH, HEIGHT);
    f.setVisible(true);
  }
}
