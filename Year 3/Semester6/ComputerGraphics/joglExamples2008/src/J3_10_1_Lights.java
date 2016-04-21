//import net.java.games.jogl.*;
import javax.media.opengl.*;

public class J3_10_1_Lights extends J3_10_Lights {

  public void drawSolar(float E,
                        float e, float M, float m) {
    float alpha = 30;

    // centers of the objects
    float[] coneC = new float[3];
    float[] sphereC = new float[3];
    float[] cylinderC = new float[3];

    float[] currM = new float[16];

    float position[] = {0, 0, 0, 1};
    float spot_direction[] = { -1, 0, 0, 1};

    //gl.glDisable(GL.GL_LIGHT0);
    // Global coordinates
    gl.glLineWidth(3);
    drawColorCoord(WIDTH / 6, WIDTH / 6, WIDTH / 6);

    gl.glPushMatrix();

    gl.glRotatef(e, 0.0f, 1.0f, 0.0f);
    // rotating around the "sun"; proceed angle
    gl.glRotatef(tiltAngle, 0.0f, 0.0f, 1.0f); // tilt angle
    gl.glTranslatef(0.0f, 1.5f * E, 0.0f);

    gl.glPushMatrix();
    gl.glTranslatef(0, E / 1.5f, 0);
    gl.glScalef(E, E, E);
    drawSphere();
    gl.glPopMatrix();
    gl.glPushMatrix();
    gl.glScalef(E / 2, 1.5f * E, E / 2);
    gl.glRotatef(90, 1, 0, 0); // orient the cone
    drawCone();
    gl.glPopMatrix();

    gl.glTranslatef(0, E / 2, 0);

    gl.glPushMatrix();
  //  cylinderm = 60;
    cylinderm = cylinderm + cylinderD;

    gl.glRotatef(cylinderm, 0.0f, 1.0f, 0.0f);
    // rotating around the "earth"
    gl.glTranslatef(M *2.5f, 0.0f, 0.0f);
    gl.glLineWidth(1);
    drawColorCoord(WIDTH / 8, WIDTH / 8, WIDTH / 8);
    gl.glTranslatef(0f, 0.0f, -E / 8);
    gl.glScalef(E / 4, E / 4, E / 4);
    myMaterialColor(redish, redish, red, redish);
    gl.glLightf(GL.GL_LIGHT1, GL.GL_SPOT_CUTOFF, 30.0f);
    gl.glLightfv(GL.GL_LIGHT1,
                 GL.GL_SPOT_DIRECTION, spot_direction,0);
    gl.glLightf(GL.GL_LIGHT1, GL.GL_SPOT_EXPONENT, 2.0f);
    gl.glLightfv(GL.GL_LIGHT1, GL.GL_POSITION, position,0);
    drawCylinder();
    gl.glGetFloatv(GL.GL_MODELVIEW_MATRIX, currM,0);
    cylinderC[0] = currM[12];
    cylinderC[1] = currM[13];
    cylinderC[2] = currM[14];
    gl.glPopMatrix();

    gl.glPushMatrix();
  //  spherem = 180;
    spherem = spherem + sphereD;
    gl.glRotatef(spherem, 0.0f, 1.0f, 0.0f);
    // rotating around the "earth"
    gl.glTranslatef(M * 2.5f, 0.0f, 0.0f);
    drawColorCoord(WIDTH / 8, WIDTH / 8, WIDTH / 8);
    gl.glScalef(E / 4, E / 4, E / 4);
    gl.glLightf(GL.GL_LIGHT2, GL.GL_SPOT_CUTOFF, 30.0f);
    gl.glLightfv(GL.GL_LIGHT2,
                 GL.GL_SPOT_DIRECTION, spot_direction,0);
    gl.glLightfv(GL.GL_LIGHT2, GL.GL_POSITION, position,0);
    myMaterialColor(greenish, greenish, green, greenish);
    drawSphere();
    gl.glGetFloatv(GL.GL_MODELVIEW_MATRIX, currM,0);
    sphereC[0] = currM[12];
    sphereC[1] = currM[13];
    sphereC[2] = currM[14];
    gl.glPopMatrix();

    gl.glPushMatrix();
  //  conem = 300;
    conem = conem + coneD;
    gl.glRotatef(conem, 0.0f, 1.0f, 0.0f);
    // rotating around the "earth"
    gl.glTranslatef(M * 2.5f, 0.0f, 0.0f);
    drawColorCoord(WIDTH / 8, WIDTH / 8, WIDTH / 8);
    gl.glTranslatef(0f, 0.0f, -E / 8);
    gl.glScalef(E / 4, E / 4, E / 4);
    gl.glLightfv(GL.GL_LIGHT3, GL.GL_POSITION, position,0);
    gl.glLightf(GL.GL_LIGHT3, GL.GL_SPOT_CUTOFF, 30.0f);
    gl.glLightfv(GL.GL_LIGHT3,
                 GL.GL_SPOT_DIRECTION, spot_direction,0);
    myMaterialColor(blueish, blueish, blue, blueish);
    drawCone();
    gl.glMaterialfv(GL.GL_FRONT, GL.GL_EMISSION, black,0);
    gl.glGetFloatv(GL.GL_MODELVIEW_MATRIX, currM,0);
    coneC[0] = currM[12];
    coneC[1] = currM[13];
    coneC[2] = currM[14];
    gl.glPopMatrix();

    gl.glPopMatrix();
    myMaterialColor(blackish, whitish, white, black);

    if (distance(coneC, sphereC) < 3.1f * E / 8) {
      tmpD = coneD;
      coneD = sphereD;
      sphereD = tmpD;
    }
    if (distance(coneC, cylinderC) < 1.1f * E / 4) {
      tmpD = coneD;
      coneD = cylinderD;
      cylinderD = tmpD;
    }
    if (distance(cylinderC, sphereC) < 3.1f * E / 8) {
      tmpD = cylinderD;
      cylinderD = sphereD;
      sphereD = tmpD;
    }
  }


  public static void main(String[] args) {
    J3_10_1_Lights f = new J3_10_1_Lights();

    f.setTitle("JOGL J3_10_1_Lights");
    f.setSize(WIDTH, HEIGHT);
    f.setVisible(true);
  }
}
