/*
 * Created on 2004-3-5
 * @author Jim X. Chen: 2D clock hand transformation
 */

//import net.java.games.jogl.*;
import javax.media.opengl.*;

public class J2_1_Clock2d extends J2_0_2DTransform {
  static final float PI = 3.1415926f;
  // homogeneous coordinates
  static float c[] = {0, 0, 1};
  static float h[] = {0, WIDTH/6, 1};

  static long curTime;
  static float hAngle, hsecond, hminute, hhour;

  public void display(GLAutoDrawable glDrawable) {

    gl.glClear(GL.GL_COLOR_BUFFER_BIT);

    curTime = System.currentTimeMillis()/1000;
    // returns the current time in milliseconds

    hsecond = curTime%60;
    curTime = curTime/60;
    hminute = curTime%60 + hsecond/60;
    curTime = curTime/60;
    hhour = (curTime%12)+8+hminute/60;
    // Eastern Standard Time

    hAngle = PI*hsecond/30; // arc angle

    gl.glColor3f(1, 0, 0); // second hand in red
    my2dLoadIdentity();
    my2dTranslatef(c[0], c[1]);
    my2dRotatef(-hAngle);
    my2dTranslatef(-c[0], -c[1]);
    gl.glLineWidth(1);
    transDrawClock(c, h);

    gl.glColor3f(0, 1, 0); // minute hand in green
    my2dLoadIdentity();
    hAngle = PI*hminute/30; // arc angle
    my2dTranslatef(c[0], c[1]);
    my2dScalef(0.8f, 0.8f); // minute hand shorter
    my2dRotatef(-hAngle);
    my2dTranslatef(-c[0], -c[1]);
    gl.glLineWidth(2);
    transDrawClock(c, h);

    gl.glColor3f(0, 0, 1); // hour hand in blue
    my2dLoadIdentity();
    hAngle = PI*hhour/6; // arc angle
    my2dTranslatef(c[0], c[1]);
    my2dScalef(0.5f, 0.5f); // hour hand shortest
    my2dRotatef(-hAngle);
    my2dTranslatef(-c[0], -c[1]);
    gl.glLineWidth(3);
    transDrawClock(c, h);
  }


  public void transDrawClock(float C[], float H[]) {
    float End1[] = new float[3];
    float End2[] = new float[3];

    my2dTransHomoVertex(C, End1);
    // Transform the center by the current matrix
    my2dTransHomoVertex(H, End2);
    // Transform the end by the current matrix

    // assuming z = w = 1;
    gl.glBegin(GL.GL_LINES);
    gl.glVertex3fv(End1,0);
    gl.glVertex3fv(End2,0);
    gl.glEnd();
  }


  public static void main(String[] args) {
    J2_1_Clock2d f = new J2_1_Clock2d();

    f.setTitle("JOGL J2_1_Clock2d");
    f.setSize(WIDTH, HEIGHT);
    f.setVisible(true);
  }
}
