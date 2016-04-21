//import net.java.games.jogl.*;
import javax.media.opengl.*;

public class J3_7_MoveLight extends J3_6_Materials {
  float origin[] = {0, 0, 0, 1};

  public void drawSolar(float E, float e, float M, float m) {

    // Global coordinates
    gl.glLineWidth(2);
    drawColorCoord(WIDTH/6, WIDTH/6, WIDTH/6);

    gl.glPushMatrix();

    gl.glRotatef(e, 0, 1, 0);
    // rotating around the "sun"; proceed angle
    gl.glRotatef(tiltAngle, 0, 0, 1); // tilt angle
    gl.glTranslatef(0, E, 0);

    gl.glPushMatrix();
    gl.glTranslatef(0, E, 0);
    gl.glScalef(E, E, E);
    drawSphere(); // the "earth"
    gl.glPopMatrix();

    gl.glPushMatrix();
    gl.glScalef(E/4, E, E/4);
    gl.glRotatef(90, 1, 0, 0); // orient the cone
    drawCone();
    gl.glPopMatrix();

    gl.glTranslatef(0, E/2, 0);
    gl.glRotatef(m+90, 0, 1, 0); // rot around the "earth"

    gl.glPushMatrix();
    gl.glTranslatef(2*M, 0, 0);
    gl.glLineWidth(1);
    drawColorCoord(WIDTH/8, WIDTH/8, WIDTH/8);
    gl.glScalef(E/8, E/8, E/8);
    gl.glMaterialfv(GL.GL_FRONT, GL.GL_EMISSION, whitish,0);
    gl.glLightfv(GL.GL_LIGHT0, GL.GL_POSITION, origin,0);
    drawSphere();
    gl.glMaterialfv(GL.GL_FRONT, GL.GL_EMISSION, black,0);
    gl.glPopMatrix();

    gl.glPopMatrix();
  }


  public static void main(String[] args) {
    J3_7_MoveLight f = new J3_7_MoveLight();

    f.setTitle("JOGL J3_7_MoveLight");
    f.setSize(WIDTH, HEIGHT);
    f.setVisible(true);
  }
}
