/*
 * Created on 2004-3-12
 * @author Jim X. Chen: draw a generalized solar system
 */
//import net.java.games.jogl.*;
import javax.media.opengl.*;

public class J2_10_GenSolar extends J2_9_Solar {
  static float tiltAngle = 45;

  void drawSolar(float earthDistance,
                 float earthAngle,
                 float moonDistance,
                 float moonAngle) {


    // Global coordinates
    gl.glLineWidth(5);
    coordOff = false; // cjx for book images
    drawColorCoord(WIDTH/4, WIDTH/4, WIDTH/4);

    coordOff = true; // cjx for book images

    gl.glPushMatrix();
    gl.glRotatef(earthAngle, 0.0f, 1.0f, 0.0f);
    // rotating around the "sun"; proceed angle
    gl.glRotatef(tiltAngle, 0.0f, 0.0f, 1.0f);
    // tilt angle, angle between the center line and y axis
    gl.glBegin(GL.GL_LINES);
    gl.glVertex3f(0.0f, 0.0f, 0.0f);
    gl.glVertex3f(0.0f, earthDistance, 0.0f);
    gl.glEnd();
    gl.glTranslatef(0.0f, earthDistance, 0.0f);
    // cjx gl.glLineWidth(3);
    gl.glPushMatrix();
    drawColorCoord(WIDTH/6, WIDTH/6, WIDTH/6);
    gl.glScalef(WIDTH/20, WIDTH/20, WIDTH/20);
    drawSphere();
    gl.glPopMatrix();

    gl.glRotatef(moonAngle, 0.0f, 1.0f, 0.0f);
    // rotating around the "earth"
    gl.glTranslatef(moonDistance, 0.0f, 0.0f);
    gl.glLineWidth(3);
    drawColorCoord(WIDTH/8, WIDTH/8, WIDTH/8);
    gl.glScalef(WIDTH/40, WIDTH/40, WIDTH/40);
    drawSphere();
    gl.glPopMatrix();
  }


  public static void main(String[] args) {

    J2_10_GenSolar f = new J2_10_GenSolar();

    f.setTitle("JOGL J2_10_GenSolar");
    f.setSize(WIDTH, HEIGHT);
    f.setVisible(true);
  }
}
