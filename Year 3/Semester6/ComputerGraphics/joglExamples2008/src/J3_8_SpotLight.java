//import net.java.games.jogl.*;
import javax.media.opengl.*;

public class J3_8_SpotLight extends J3_7_MoveLight {

  float spot_direction[] = {-1, 0, 0, 1};

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
    gl.glScalef(E*1.2f, E*1.2f, E*1.2f);
    drawSphere();
    gl.glPopMatrix();

    gl.glPushMatrix();
    gl.glScalef(E/4, E, E/4);
    gl.glRotatef(90, 1, 0, 0); // orient the cone
    drawCone();
    gl.glPopMatrix();

    gl.glTranslatef(0, E/2, 0);
    gl.glRotatef(m+90, 0, 1, 0);
    // 1st moon rotating around the "earth"

    gl.glPushMatrix();
    gl.glTranslatef(2.5f*M, 0, 0);
    gl.glLineWidth(1);
    drawColorCoord(WIDTH/8, WIDTH/8, WIDTH/8);
    gl.glScalef(E/8, E/8, E/8);
    gl.glLightf(GL.GL_LIGHT0, GL.GL_SPOT_CUTOFF, 20f);
    gl.glLightfv(GL.GL_LIGHT0, GL.GL_SPOT_DIRECTION,
                 spot_direction,0); // facing x axis initially
    gl.glLightf(GL.GL_LIGHT0, GL.GL_SPOT_EXPONENT, 2f);
    gl.glLightfv(GL.GL_LIGHT0, GL.GL_POSITION, origin,0);
    gl.glMaterialfv(GL.GL_FRONT, GL.GL_EMISSION, whitish,0);
    drawSphere();
    gl.glMaterialfv(GL.GL_FRONT, GL.GL_EMISSION, black,0);
    gl.glPopMatrix();

    gl.glPopMatrix();
  }


  public static void main(String[] args) {

    J3_8_SpotLight f = new J3_8_SpotLight();

    f.setTitle("JOGL J3_8_SpotLight");
    f.setSize(WIDTH, HEIGHT);
    f.setVisible(true);
  }
}
