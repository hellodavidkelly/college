//import net.java.games.jogl.*;
import javax.media.opengl.*;

public class J3_9_AttLight extends J3_8_SpotLight {
  float dist = 0;


  public void drawSolar(float E, float e, float M, float m) {

    gl.glLineWidth(2);
    drawColorCoord(WIDTH/6, WIDTH/6, WIDTH/6);

    gl.glPushMatrix();

    gl.glRotatef(e, 0.0f, 1.0f, 0.0f);
    // rotating around the "sun"; proceed angle
    gl.glRotatef(tiltAngle, 0.0f, 0.0f, 1.0f); // tilt angle
    gl.glTranslatef(0.0f, E, 0.0f);

    gl.glPushMatrix();
    gl.glTranslatef(0, E, 0);
    gl.glScalef(E, E, E);
    drawSphere();
    gl.glPopMatrix();

    gl.glPushMatrix();
    gl.glScalef(E/4, E, E/4);
    gl.glRotatef(90f, 1.0f, 0.0f, 0.0f); // orient the cone
    drawCone();
    gl.glPopMatrix();

    gl.glTranslatef(0, E/2, 0);
    gl.glRotatef(m+200, 0.0f, 1.0f, 0.0f);
    // 1st moon rotating around the "earth"

    gl.glPushMatrix();

    if (dist>6*M) {
      flip = -1;
    } else if (dist<M/2) {
      flip = 1;
    }
    if (dist==0) {
      dist = 1.5f*M;
    }
    dist = dist+flip;

    gl.glTranslatef(-dist, 0, 0);
    gl.glScalef(E/8, E/8, E/8);

    gl.glLightf(GL.GL_LIGHT0, GL.GL_CONSTANT_ATTENUATION, 0.2f);
    gl.glLightf(GL.GL_LIGHT0, GL.GL_LINEAR_ATTENUATION,
                0.0005f);
    gl.glLightf(GL.GL_LIGHT0, GL.GL_QUADRATIC_ATTENUATION,
                0.00005f);
    gl.glLightfv(GL.GL_LIGHT0, GL.GL_POSITION, origin,0);
    gl.glMaterialfv(GL.GL_FRONT, GL.GL_EMISSION, whitish,0);
    drawSphere();
    gl.glMaterialfv(GL.GL_FRONT, GL.GL_EMISSION, black,0);

    gl.glPopMatrix();

    gl.glPopMatrix();
  }


  public static void main(String[] args) {

    J3_9_AttLight f = new J3_9_AttLight();

    f.setTitle("JOGL J3_9_AttLight");
    f.setSize(WIDTH, HEIGHT);
    f.setVisible(true);
  }
}
