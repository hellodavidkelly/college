/*
 * Created on 2004-3-17
 * @author Jim X. Chen: draw a cone solar system with collisions of the moons.
 */
import java.lang.Math;
//import net.java.games.jogl.*;
import javax.media.opengl.*;

public class J2_11_ConeSolarCollision extends
    J2_11_ConeSolar {

  //direction and speed of rotation
  static float coneD = 1;
  static float sphereD = -1;
  static float cylinderD = 1;
  static float spherem = 180, cylinderm = 300;
  static float tmpD = 0, conem = 60;

  // centers of the objects
  static float[] earthC = new float[3];
  static float[] coneC = new float[3];
  static float[] sphereC = new float[3];
  static float[] cylinderC = new float[3];

  // current matrix on the matrix stack
  static float[] currM = new float[16];


  void drawSolar(float E, float e, float M, float m) {

  //coordOff = true; // cjx
   // Global coordinates
    gl.glLineWidth(4);
    drawColorCoord(WIDTH/8, WIDTH/8, WIDTH/8);

    gl.glPushMatrix();
    {
      gl.glRotatef(e, 0.0f, 1.0f, 0.0f);
      // rotating around the "sun"; proceed angle
      gl.glRotatef(45, 0.0f, 0.0f, 1.0f); // tilt angle
      gl.glTranslatef(0.0f, E, 0.0f);

      gl.glPushMatrix();
      gl.glScalef(WIDTH/20, WIDTH/20, WIDTH/20);
      drawSphere();
      // retrieve the center of the cylinder
      // the matrix is stored column major left to right
      gl.glGetFloatv(GL.GL_MODELVIEW_MATRIX, currM,0);
      earthC[0] = currM[12];
      earthC[1] = currM[13];
      earthC[2] = currM[14];
      gl.glPopMatrix();

      gl.glPushMatrix();
      gl.glScalef(E/8, E, E/8);
      gl.glRotatef(90, 1.0f, 0.0f, 0.0f);
      // orient the cone
      drawCone();
      gl.glPopMatrix();

      gl.glPushMatrix();
      cylinderm = cylinderm+cylinderD;
      gl.glRotatef(cylinderm, 0.0f, 1.0f, 0.0f);
      // rotating around the "earth"
      gl.glTranslatef(M*2, 0.0f, 0.0f);
      gl.glLineWidth(3);
      drawColorCoord(WIDTH/8, WIDTH/8, WIDTH/8);
      gl.glScalef(E/8, E/8, E/8);
      drawCylinder();
      // retrieve the center of the cylinder
      // the matrix is stored column major left to right
      gl.glGetFloatv(GL.GL_MODELVIEW_MATRIX, currM,0);
      cylinderC[0] = currM[12];
      cylinderC[1] = currM[13];
      cylinderC[2] = currM[14];
      gl.glPopMatrix();

      gl.glPushMatrix();
      spherem = spherem+sphereD;
      gl.glRotatef(spherem, 0.0f, 1.0f, 0.0f);
      // rotating around the "earth"
      gl.glTranslatef(M*2, 0.0f, 0.0f);
      drawColorCoord(WIDTH/8, WIDTH/8, WIDTH/8);
      gl.glScalef(E/8, E/8, E/8);
      drawSphere();
      // retrieve the center of the sphere
      gl.glGetFloatv(GL.GL_MODELVIEW_MATRIX, currM,0);
      sphereC[0] = currM[12];
      sphereC[1] = currM[13];
      sphereC[2] = currM[14];
      gl.glPopMatrix();

      gl.glPushMatrix();
      conem = conem+coneD;
      gl.glRotatef(conem, 0.0f, 1.0f, 0.0f);
      // rotating around the "earth"
      gl.glTranslatef(M*2, 0.0f, 0.0f);
      drawColorCoord(WIDTH/8, WIDTH/8, WIDTH/8);
      gl.glScalef(E/8, E/8, E/8);
      drawCone();
      // retrieve the center of the cone
      gl.glGetFloatv(GL.GL_MODELVIEW_MATRIX, currM,0);
      coneC[0] = currM[12];
      coneC[1] = currM[13];
      coneC[2] = currM[14];
      gl.glPopMatrix();
    }
    gl.glPopMatrix();

    if (distance(coneC, sphereC)<E/5) {
      // collision detected, swap the rotation directions
      tmpD = coneD;
      coneD = sphereD;
      sphereD = tmpD;
    }
    if (distance(coneC, cylinderC)<E/5) {
      // collision detected, swap the rotation directions
      tmpD = coneD;
      coneD = cylinderD;
      cylinderD = tmpD;
    }
    if (distance(cylinderC, sphereC)<E/5) {
      // collision detected, swap the rotation directions
      tmpD = cylinderD;
      cylinderD = sphereD;
      sphereD = tmpD;
    }
  }


  // distance between two points
  float distance(float[] c1, float[] c2) {
    float tmp = (c2[0]-c1[0])*(c2[0]-c1[0])+
                (c2[1]-c1[1])*(c2[1]-c1[1])+
                (c2[2]-c1[2])*(c2[2]-c1[2]);

    return ((float)Math.sqrt(tmp));
  }


  public static void main(String[] args) {
    J2_11_ConeSolarCollision f =
        new J2_11_ConeSolarCollision();

    f.setTitle("JOGL J2_11_ConeSolarCollision");
    f.setSize(WIDTH, HEIGHT);
    f.setVisible(true);
  }
}
