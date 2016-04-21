/*
 * Created on 2004-3-7
 * @author Jim X. Chen: 2D robot transformation in OpenGL
 */
//import net.java.games.jogl.*;
import javax.media.opengl.*;

public class J2_4_Robot extends J2_3_Robot2d {

  public void display(GLAutoDrawable glDrawable) {

    gl.glClear(GL.GL_COLOR_BUFFER_BIT);

    alpha += dalpha;
    beta += dbeta;
    gama += dgama;

    gl.glLineWidth(7f); // draw a wide line for arm
   drawRobot(A, B, C, alpha, beta, gama);
  }


  void drawRobot(
      float A[],
      float B[],
      float C[],
      float alpha,
      float beta,
      float gama) {

    gl.glPushMatrix();

    gl.glColor3f(1, 1, 0);
    gl.glRotatef(alpha, 0.0f, 0.0f, 1.0f);
    // R_z(alpha) is on top of the matrix stack
    drawArm(O, A);

    gl.glColor3f(0, 1, 1);
    gl.glTranslatef(A[0], A[1], 0.0f);
    gl.glRotatef(beta, 0.0f, 0.0f, 1.0f);
    gl.glTranslatef(-A[0], -A[1], 0.0f);
    // R_z(alpha)T(A)R_z(beta)T(-A) is on top
    drawArm(A, B);

    gl.glColor3f(1, 0, 1);
    gl.glTranslatef(B[0], B[1], 0.0f);
    gl.glRotatef(gama, 0.0f, 0.0f, 1.0f);
    gl.glTranslatef(-B[0], -B[1], 0.0f);
    // R_z(alpha)T(A)R_z(beta)T(-A) is on top
    drawArm(B, C);

    gl.glPopMatrix();
  }


  public static void main(String[] args) {
    J2_4_Robot f = new J2_4_Robot();

    f.setTitle("JOGL J2_4_Robot");
    f.setSize(WIDTH, HEIGHT);
    f.setVisible(true);
  }
}
