/*
 * Created on 2004-3-17
 * @author Jim X. Chen: draw a cone solar system
 */
public class J2_11_ConeSolar extends J2_10_GenSolar {

  void drawSolar(float E, float e, float M, float m) {

    // Global coordinates
    gl.glLineWidth(5);
//coordOff = false; // cjx
    drawColorCoord(WIDTH/4, WIDTH/4, WIDTH/4);
//coordOff = true; // cjx
    gl.glPushMatrix();
    gl.glRotatef(e, 0.0f, 1.0f, 0.0f);
    // rotating around the "sun"; proceed angle
    gl.glRotatef(tiltAngle, 0.0f, 0.0f, 1.0f); // tilt angle
    gl.glTranslatef(0.0f, E, 0.0f);
    gl.glPushMatrix();
    gl.glScalef(WIDTH/20, WIDTH/20, WIDTH/20);
    drawSphere();
    gl.glPopMatrix();
    gl.glPushMatrix();
    gl.glScalef(E/8, E, E/8);
    gl.glRotatef(90, 1.0f, 0.0f, 0.0f); // orient the cone
    drawCone();
    gl.glPopMatrix();

    gl.glRotatef(m, 0.0f, 1.0f, 0.0f);
    // rotating around the "earth"
    gl.glTranslatef(M, 0.0f, 0.0f);
    gl.glLineWidth(3);
    drawColorCoord(WIDTH/8, WIDTH/8, WIDTH/8);
    gl.glScalef(E/8, E/8, E/8);
    drawSphere();
    gl.glPopMatrix();
  }


  public static void main(String[] args) {

    J2_11_ConeSolar f = new J2_11_ConeSolar();

    f.setTitle("JOGL J2_11_ConeSolar");
    f.setSize(WIDTH, HEIGHT);
    f.setVisible(true);
  }
}
