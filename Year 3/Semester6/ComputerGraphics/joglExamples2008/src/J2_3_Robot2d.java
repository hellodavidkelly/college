/*
 * Created on 2004-3-6
 * @author Jim X. Chen: 2D robot arm transformations
 */
//import net.java.games.jogl.*;
import javax.media.opengl.*;

public class J2_3_Robot2d extends J2_0_2DTransform {
  // homogeneous coordinates
  float O[] = {0, 0, 1}, A[] = {100, 0, 1};
  float B[] = {160, 0, 1}, C[] = {200, 0, 1};
  float alpha=-40, beta=-40, gama=60,
      dalpha = 1f, dbeta = 1.2f, dgama = -2f;

  public void display(GLAutoDrawable glDrawable) {

    gl.glClear(GL.GL_COLOR_BUFFER_BIT);

    alpha += dalpha/100;
    beta += dbeta/100;
    gama += dgama/100;

    gl.glColor3f(0, 1, 1);
    transDrawArm1(alpha, beta, gama);

    gl.glColor3f(1, 1, 0);
    transDrawArm2(-beta, -gama, alpha);

    gl.glColor3f(1, 0, 1);
    transDrawArm3(gama, -alpha, -beta);
    
	try {
		Thread.sleep(20);
	} catch (Exception ignore) {
	}

  }


  // Method I: 2D robot arm transformations
  public void transDrawArm1(float a, float b, float g) {
    float Af[] = new float[3];
    float B1[] = new float[3];
    float C1[] = new float[3];
    float Bf[] = new float[3];
    float C2[] = new float[3];
    float Cf[] = new float[3];

    my2dLoadIdentity();
    my2dRotatef(a);
    my2dTransHomoVertex(A, Af);
    my2dTransHomoVertex(B, B1);
    my2dTransHomoVertex(C, C1);

    drawArm(O, Af);

    my2dLoadIdentity();
    my2dTranslatef(Af[0], Af[1]);
    my2dRotatef(b);
    my2dTranslatef(-Af[0], -Af[1]);
    my2dTransHomoVertex(B1, Bf);
    my2dTransHomoVertex(C1, C2);
    drawArm(Af, Bf);

    my2dLoadIdentity();
    my2dTranslatef(Bf[0], Bf[1]);
    my2dRotatef(g);
    my2dTranslatef(-Bf[0], -Bf[1]);
    my2dTransHomoVertex(C2, Cf);
    drawArm(Bf, Cf);
  }


  // Method II: 2D robot arm transformations
  public void transDrawArm2(float a, float b, float g) {

    my2dLoadIdentity();
    my2dRotatef(a);
    transDrawArm(O, A);
    my2dTranslatef(A[0], A[1]);
    my2dRotatef(b);
    my2dTranslatef(-A[0], -A[1]);
    transDrawArm(A, B);
    my2dTranslatef(B[0], B[1]);
    my2dRotatef(g);
    my2dTranslatef(-B[0], -B[1]);
    transDrawArm(B, C);
  }


  // Method III: 2D robot arm transformations
  public void transDrawArm3(float a, float b, float g) {
    float Af[] = new float[3];
    float Bf[] = new float[3];
    float Cf[] = new float[3];

    my2dLoadIdentity();
    my2dRotatef(a);
    my2dTransHomoVertex(A, Af);
    drawArm(O, Af);
    my2dLoadIdentity();
    my2dTranslatef(Af[0], Af[1]);
    my2dRotatef(a+b);
    my2dTranslatef(-A[0], -A[1]);
    my2dTransHomoVertex(B, Bf);
    drawArm(Af, Bf);
    my2dLoadIdentity();
    my2dTranslatef(Bf[0], Bf[1]);
    my2dRotatef(a+b+g);
    my2dTranslatef(-B[0], -B[1]);
    my2dTransHomoVertex(C, Cf);
    drawArm(Bf, Cf);
  }


  // trasform the coordinates and then draw
  private void transDrawArm(float C[], float H[]) {

    float End1[] = new float[3];
    float End2[] = new float[3];

    my2dTransHomoVertex(C, End1);
    // multiply the point with the matrix on the stack
    my2dTransHomoVertex(H, End2);

    // assuming z = w = 1;
    drawArm(End1, End2);
  }


  // draw the coordinates directly
  public void drawArm(float C[], float H[]) {

    gl.glLineWidth(5);

    // assuming z = w = 1;
    gl.glBegin(GL.GL_LINES);
    gl.glVertex3fv(C,0);
    gl.glVertex3fv(H,0);
    gl.glEnd();
  }


  public static void main(String[] args) {
    J2_3_Robot2d f = new J2_3_Robot2d();

    f.setTitle("JOGL J2_3_Robot2d");
    f.setSize(WIDTH, HEIGHT);
    f.setVisible(true);
  }
}
