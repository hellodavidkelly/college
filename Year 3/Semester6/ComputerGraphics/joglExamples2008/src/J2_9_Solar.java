/*
 * Created on 2004-3-12
 * @author Jim X. Chen: draw a simplified solar system
 */
//import net.java.games.jogl.*;
//import net.java.games.jogl.util.*;
import javax.media.opengl.*;
import com.sun.opengl.util.*;


public class J2_9_Solar extends J2_8_Robot3d {

  static boolean coordOff=false; // cjx for images

  public void display(GLAutoDrawable glDrawable) {

    depth = (cnt/100)%6;
    cnt++;

    gl.glClear(GL.GL_COLOR_BUFFER_BIT|
               GL.GL_DEPTH_BUFFER_BIT);

    drawSolar(WIDTH/4, cnt, WIDTH/12, cnt);
  }


  public void drawColorCoord(float xlen, float ylen,
                             float zlen) {
    GLUT glut = new GLUT();

   // if (coordOff) return; // cjx for images

    gl.glBegin(GL.GL_LINES);
    gl.glColor3f(1, 0, 0);
    gl.glVertex3f(0, 0, 0);
    gl.glVertex3f(0, 0, zlen);
    gl.glColor3f(0, 1, 0);
    gl.glVertex3f(0, 0, 0);
    gl.glVertex3f(0, ylen, 0);
    gl.glColor3f(0, 0, 1);
    gl.glVertex3f(0, 0, 0);
    gl.glVertex3f(xlen, 0, 0);
    gl.glEnd();

    // coordinate labels: X, Y, Z
    gl.glPushMatrix();
    gl.glTranslatef(xlen, 0, 0);
    gl.glScalef(xlen/WIDTH, xlen/WIDTH, 1);
    glut.glutStrokeCharacter(GLUT.STROKE_ROMAN, 'X');
    gl.glPopMatrix();

    gl.glPushMatrix();
    gl.glColor3f(0, 1, 0);
    gl.glTranslatef(0, ylen, 0);
    gl.glScalef(ylen/WIDTH, ylen/WIDTH, 1);
    glut.glutStrokeCharacter(GLUT.STROKE_ROMAN, 'Y');
    gl.glPopMatrix();

    gl.glPushMatrix();
    gl.glColor3f(1, 0, 0);
    gl.glTranslatef(0, 0, zlen);
    gl.glScalef(zlen/WIDTH, zlen/WIDTH, 1);
    glut.glutStrokeCharacter(GLUT.STROKE_ROMAN, 'Z');
    gl.glPopMatrix();
  }


  void drawSolar(float E, float e, float M, float m) {

    drawColorCoord(WIDTH/4, WIDTH/4, WIDTH/4);

    gl.glPushMatrix();

    gl.glRotatef(e, 0.0f, 1.0f, 0.0f);
    // rotating around the "sun"; proceed angle
    gl.glTranslatef(E, 0.0f, 0.0f);

    gl.glPushMatrix();
    gl.glScalef(WIDTH/20f, WIDTH/20f, WIDTH/20f);
    drawSphere();
    gl.glPopMatrix();

    gl.glRotatef(m, 0.0f, 1.0f, 0.0f);
    // rotating around the "earth"
    gl.glTranslatef(M, 0.0f, 0.0f);
    drawColorCoord(WIDTH/8f, WIDTH/8f, WIDTH/8f);
    gl.glScalef(WIDTH/40f, WIDTH/40f, WIDTH/40f);
    drawSphere();

    gl.glPopMatrix();
  }


  public static void main(String[] args) {
    J2_9_Solar f = new J2_9_Solar();

    f.setTitle("JOGL J2_9_Solar");
    f.setSize(WIDTH, HEIGHT);
    f.setVisible(true);
  }
}
