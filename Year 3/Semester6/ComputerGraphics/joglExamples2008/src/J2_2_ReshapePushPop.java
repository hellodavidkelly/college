/*
 * Created on 2004-3-5
 * @author Jim X. Chen: reshape the rectangular drawing area
 * Same as J2_2_Reshape.java except using push and popmatrix
 */
//import net.java.games.jogl.*;
import javax.media.opengl.*;
import java.awt.event.*;


public class J2_2_ReshapePushPop extends J2_1_Clock2d implements
    MouseMotionListener {
  // the point to be dragged as the lowerleft corner
  private static float P1[] = {-WIDTH/4, -HEIGHT/4};

  // the lowerleft and upperright corners of the rectangle
  private static float v0[] = {-WIDTH/4, -HEIGHT/4};
  private static float v1[] = {WIDTH/4, HEIGHT/4};

  // reshape scale value
  private float sx = 1, sy = 1;

  // when mouse is dragged, a new lowerleft point
  // and scale value for the rectangular area
  public void mouseDragged(MouseEvent e) {
    float wd1 = v1[0]-v0[0];
    float ht1 = v1[1]-v0[1];

    // The mouse location, new lowerleft corner
    P1[0] = e.getX()-WIDTH/2;
    P1[1] = HEIGHT/2-e.getY();
    float wd2 = v1[0]-P1[0];
    float ht2 = v1[1]-P1[1];

    // scale value of the current rectangular area
    sx = wd2/wd1;
    sy = ht2/ht1;
  }


  public void mouseMoved(MouseEvent e) {
  }


  public void init(GLAutoDrawable drawable) {

    super.init(drawable);
    // listen to mouse motioin
    drawable.addMouseMotionListener(this);
  }


  public void display(GLAutoDrawable glDrawable) {

    // reshape according to the current scale
    my2dLoadIdentity();
    my2dTranslatef(P1[0], P1[1]);
    my2dScalef(sx, sy);
    my2dTranslatef(-v0[0], -v0[1]);

    gl.glClear(GL.GL_COLOR_BUFFER_BIT);
    gl.glColor3f(1, 1, 1); // the rectangle is white

    // rectangle area
    float v00[] = new float[2], v11[] = new float[2];
    my2dTransformf(v0, v00);
    my2dTransformf(v1, v11);
    gl.glBegin(GL.GL_LINE_LOOP);
    gl.glVertex3f(v00[0], v00[1], 0);
    gl.glVertex3f(v11[0], v00[1], 0);
    gl.glVertex3f(v11[0], v11[1], 0);
    gl.glVertex3f(v00[0], v11[1], 0);
    gl.glEnd();

    // the clock hands go through the same transformation
    curTime = System.currentTimeMillis()/1000;
    hsecond = curTime%60;
    curTime = curTime/60;
    hminute = curTime%60+hsecond/60;
    curTime = curTime/60;
    hhour = (curTime%12)+8+hminute/60;
    // Eastern Standard Time

    hAngle = PI*hsecond/30; // arc angle

    gl.glColor3f(1, 0, 0); // second hand in red
    my2dPushMatrix();
    {
      my2dTranslatef(c[0], c[1]);
      my2dRotatef(-hAngle);
      my2dTranslatef(-c[0], -c[1]);
      gl.glLineWidth(3);
      transDrawClock(c, h);
    }
    my2dPopMatrix();

    gl.glColor3f(0, 1, 0); // minute hand in green
    my2dPushMatrix();
    {
      hAngle = PI*hminute/30; // arc angle
      my2dTranslatef(c[0], c[1]);
      my2dScalef(0.8f, 0.8f); // minute hand shorter
      my2dRotatef(-hAngle);
      my2dTranslatef(-c[0], -c[1]);
      gl.glLineWidth(5);
      transDrawClock(c, h);
    }
    my2dPopMatrix();

    gl.glColor3f(0, 0, 1); // hour hand in blue
    hAngle = PI*hhour/6; // arc angle
    my2dTranslatef(c[0], c[1]);
    my2dScalef(0.5f, 0.5f); // hour hand shortest
    my2dRotatef(-hAngle);
    my2dTranslatef(-c[0], -c[1]);
    gl.glLineWidth(7);
    transDrawClock(c, h);
  }


  public static void main(String[] args) {
    J2_2_Reshape f = new J2_2_Reshape();

    f.setTitle("JOGL J2_2_ReshapePushPop");
    f.setSize(WIDTH, HEIGHT);
    f.setVisible(true);
  }

}
