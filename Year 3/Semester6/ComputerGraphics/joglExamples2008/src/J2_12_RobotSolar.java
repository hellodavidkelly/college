/*
 * Created on 2004-3-17
 * @author Jim X. Chen: 3D transformation/viewing
 */
//import net.java.games.jogl.*;
import javax.media.opengl.*;

public class J2_12_RobotSolar extends
    J2_11_ConeSolarCollision {


  public void reshape(
      GLAutoDrawable glDrawable,
      int x,
      int y,
      int w,
      int h) {

    WIDTH = w;
    HEIGHT = h;
    A = (float)WIDTH/4;
    B = (float)0.4*WIDTH;
    C = (float)0.5*WIDTH;

    // enable zbuffer for hidden-surface removal
    gl.glEnable(GL.GL_DEPTH_TEST);

    // specify the drawing area within the frame window
    gl.glViewport(0, 0, w, h);

    // projection is carried on the projection matrix
    gl.glMatrixMode(GL.GL_PROJECTION);
    gl.glLoadIdentity();
    // specify perspective projection using glFrustum
    gl.glFrustum(-w/4, w/4, -h/4, h/4, w/2, 4*w);

    // put the models at the center of the viewing volume
    gl.glTranslatef(0, 0, -2*w);

    // transformations are on the modelvview matrix
    gl.glMatrixMode(GL.GL_MODELVIEW);
    gl.glLoadIdentity();
  }


  public void display(GLAutoDrawable glDrawable) {

    cnt++;
    depth = (cnt/50)%7;

    gl.glClear(GL.GL_COLOR_BUFFER_BIT|
               GL.GL_DEPTH_BUFFER_BIT);

    if (cnt%60==0) {
      dalpha = -dalpha;
      dbeta = -dbeta;
      dgama = -dgama;
    }
    alpha += dalpha;
    beta += dbeta;
    gama += dgama;

    drawRobot(O, A, B, C, alpha, beta, gama);
  }


  void drawRobot (
      float O,
      float A,
      float B,
      float C,
      float alpha,
      float beta,
      float gama) {

    // Global coordinates
    gl.glLineWidth(4);
    drawColorCoord(WIDTH/8, WIDTH/8, WIDTH/8);

    gl.glPushMatrix();

    gl.glRotatef(cnt, 0, 1, 0);
    gl.glRotatef(alpha, 0, 0, 1);
    // R_z(alpha) is on top of the matrix stack
    drawArm(O, A);

    gl.glTranslatef(A, 0, 0);
    gl.glRotatef(beta, 0, 0, 1);
    // R_z(alpha)T_x(A)R_z(beta) is on top of the stack
    drawArm(A, B);
//    drawSolar(WIDTH/4, 2.5f*cnt, WIDTH/6, 1.5f*cnt);

    gl.glTranslatef(B-A, 0, 0);
    gl.glRotatef(gama, 0, 0, 1);
    // R_z(alpha)T_x(A)R_z(beta)T_x(B)R_z(gama) is on top
    drawArm(B, C);

    // put the solar system at the end of the robot arm
    gl.glTranslatef(C-B, 0, 0);
    drawSolar(WIDTH/4, 2.5f*cnt, WIDTH/6, 1.5f*cnt);

    gl.glPopMatrix();
  }


  public static void main(String[] args) {
    J2_12_RobotSolar f = new J2_12_RobotSolar();

    f.setTitle("JOGL J2_12_RobotSolar");
    f.setSize(WIDTH, HEIGHT);
    f.setVisible(true);
  }
}
