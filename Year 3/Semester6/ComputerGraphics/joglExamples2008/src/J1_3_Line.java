/*
 * Created on 2004-2-26
 * @author Jim X. Chen: use Bresenham's algorithm to draw lines
 */
import javax.media.opengl.*;
//import net.java.games.jogl.*;


public class J1_3_Line extends J1_2_Line {

  // called for OpenGL rendering every reshape
  public void display(GLAutoDrawable drawable) {

    //generate a random line;
    int x0 = (int)(Math.random()*WIDTH);
    int y0 = (int)(Math.random()*HEIGHT);
    int xn = (int)((Math.random()*WIDTH));
    int yn = (int)(Math.random()*HEIGHT);

    // draw a white line using Bresenham's algorithm
    gl.glColor3f(1, 1, 1);
    bresenhamLine(x0, y0, xn, yn);
  }


  // Bresenham's midpoint line algorithm
  public void bresenhamLine(int x0, int y0, int xn, int yn) {
    int dx, dy, incrE, incrNE, d, x, y, flag = 0;

    if (xn<x0) {
      //swapd(&x0,&xn);
      int temp = x0;
      x0 = xn;
      xn = temp;

      //swapd(&y0,&yn);
      temp = y0;
      y0 = yn;
      yn = temp;
    }
    if (yn<y0) {
      y0 = -y0;
      yn = -yn;
      flag = 10;
    }

    dy = yn-y0;
    dx = xn-x0;

    if (dx<dy) {
      //swapd(&x0,&y0);
      int temp = x0;
      x0 = y0;
      y0 = temp;

      //swapd(&xn,&yn);
      temp = xn;
      xn = yn;
      yn = temp;

      //swapd(&dy,&dx);
      temp = dy;
      dy = dx;
      dx = temp;

      flag++;
    }

    x = x0;
    y = y0;
    d = 2*dy-dx;
    incrE = 2*dy;
    incrNE = 2*(dy-dx);

    while (x<xn+1) {
      writepixel(x, y, flag); /* write framebuffer */

      x++; /* consider next pixel */
      if (d<=0) {
        d += incrE;
      } else {
        y++;
        d += incrNE;
      }
    }
  }


  void writepixel(int x, int y, int flag) {
    double xf = x, yf = y;

    if (flag==1) {
      xf = y;
      yf = x;
    } else if (flag==10) {
      xf = x;
      yf = -y;
    } else if (flag==11) {
      xf = y;
      yf = -x;
    }
    drawPoint(xf, yf);
  }


  public static void main(String[] args) {
    J1_3_Line f = new J1_3_Line();

    f.setTitle("JOGL J1_3_Line");
    f.setSize(WIDTH, HEIGHT);
    f.setVisible(true);
  }
}
