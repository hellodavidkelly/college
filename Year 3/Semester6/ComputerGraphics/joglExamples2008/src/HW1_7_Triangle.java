//import net.java.games.jogl.GL;
//import net.java.games.jogl.GLDrawable; 
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;

/**


 * <p>Title: Foundations of 3D Graphics Programming : Using JOGL and Java3D </p>
 *
 * <p>Description: What this class is about ...</p>
 *
 * <p>Copyright: Copyright (c) 2005</p>
 *
 * <p>Company: George Mason University</p>
 *
 * @author Dr. Jim X. Chen
 * @version 1.0
 */
public class HW1_7_Triangle extends HW1_5_Clipping {
  public HW1_7_Triangle() {
    myClipping = false;
  }


  public void display(GLAutoDrawable drawable) {

    super.display(drawable);

    // generate a random triangle and display
    int v[][] = new int[3][3];

    if (!myClipping) {
      gl.glColor3f(1, 1, 1);
      for (int i = 0; i<3; i++) { // three vertices
        v[i][0] = (int)(WIDTH*Math.random());
        v[i][1] = (int)(HEIGHT*Math.random());
        v[i][2] = 0;
        drawPoint(v[i][0], v[i][1]);
        labelVertex(v[i][0]+5, v[i][1], i);
      }
      drawtriangle(v); // scan-convert triangle

      //    canvas.setAutoSwapBufferMode(false);
      drawable.swapBuffers(); // display it now
      //    canvas.setAutoSwapBufferMode(true);
      try {
        Thread.sleep(2000); // wait for examination
      } catch (Exception ignore) {}
    }
  }


  public void drawtriangle(int[][] v) {
    int ymin = 0, ymid = 0, ymax = 0;

    // order the vertices along y
    if (v[0][1]<=v[1][1]&&v[1][1]<=v[2][1]) { //012
      ymin = 0; // vo at tottom
      ymid = 1;
      ymax = 2; // v2 at top
    } else if (v[0][1]<=v[2][1]&&v[2][1]<=v[1][1]) { //021
      ymin = 0;
      ymid = 2;
      ymax = 1;
    } else if (v[1][1]<=v[0][1]&&v[0][1]<=v[2][1]) { //102
      ymin = 1;
      ymid = 0;
      ymax = 2; //v2 at top
    } else if (v[1][1]<=v[2][1]&&v[2][1]<=v[0][1]) { //120
      ymin = 1; // v1 at tottom
      ymid = 2;
      ymax = 0; // v0 at top
    } else if (v[2][1]<=v[0][1]&&v[0][1]<=v[1][1]) { //201
      ymin = 2;
      ymid = 0;
      ymax = 1; // v0 at top

    } else if (v[2][1]<=v[1][1]&&v[1][1]<=v[0][1]) { //210
      ymin = 2; //v2 at bottom
      ymid = 1;
      ymax = 0; //v0 at top
    }

    float m_1 = 0, m_2 = 0; // 1/m
    float x1 = 0, x2 = 0;
    int y;

    if (v[ymin][1]==v[ymid][1]) { // flat bottom
      int tmp = ymin;

      if (ymin==(ymid+1)%3) { // ymin order before ymid
        ymin = ymid;
        ymid = tmp;
      }

      x2 = v[ymin][0];
      m_2 = (float)(v[ymax][0]-v[ymin][0])
            /(v[ymax][1]-v[ymin][1]);
      x1 = v[ymid][0];
      m_1 = (float)(v[ymax][0]-v[ymid][0])
            /(v[ymax][1]-v[ymid][1]);
    } else { // one ymin at bottom
      int d = v[(ymin+1)%3][1]-v[ymin][1];
      m_1 = (float)(v[(ymin+1)%3][0]-v[ymin][0])/d;
      d = v[(ymin+2)%3][1]-v[ymin][1];
      m_2 = (float)(v[(ymin+2)%3][0]-v[ymin][0])/d;

      x1 = v[ymin][0];
      x2 = v[ymin][0];
    }

    if (x1+m_1<x2+m_2) { // sort on x
      // System.out.println("back-facing!");
      // operations such as culling (not implemented)
      float tmp = m_1;
      m_1 = m_2;
      m_2 = tmp;
      tmp = x1;
      x1 = x2;
      x2 = tmp;
    }

    for (y = v[ymin][1]; y<v[ymid][1]; y++) {
      // for each scan-line

      span((int)x2, (int)x1, y);
      x1 = x1+m_1;
      x2 = x2+m_2;
    }

    // the third edge
    if (v[ymin][1]!=v[ymid][1]
        &&v[ymid][1]!=v[ymax][1]) { // not flat bottom
      if (v[ymid][0]-x1<1&&v[ymid][0]-x1>-1) {
        m_1 = (float)(v[ymax][0]-v[ymid][0])
              /(v[ymax][1]-v[ymid][1]);
      } else {
        m_2 = (float)(v[ymax][0]-v[ymid][0])
              /(v[ymax][1]-v[ymid][1]);
      }
    }

    for (y = v[ymid][1]; y<=v[ymax][1]; y++) {
      // for each scan-line

      span((int)x2, (int)x1, y);
      x1 = x1+m_1;
      x2 = x2+m_2;
    }
  }


  void span(int x2, int x1, int y) {
    for (int x = x2; x<x1; x++) {
      gl.glColor3d(Math.random(), Math.random(),
                   Math.random());
      gl.glPointSize(1);
      drawPoint(x, y);
    }
  }


  public static void main(String[] args) {
    HW1_7_Triangle f = new HW1_7_Triangle();

    f.setTitle("HW1_7_Triangle - draw triangle");
    f.setSize(WIDTH, HEIGHT);
    f.setVisible(true);
  }

}
