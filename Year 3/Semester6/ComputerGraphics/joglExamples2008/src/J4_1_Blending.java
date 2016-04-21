//import net.java.games.jogl.*;
import javax.media.opengl.*;

public class J4_1_Blending extends J3_10_Lights {
  // alpha 4 transparency
  float tred[] = {1, 0, 0, 0.8f};
  float tgreen[] = {0, 1, 0, 0.3f};
  float tblue[] = {0, 0, 1, 0.3f};


  public void drawSolar(float E, float e,
                        float M, float m) {

    // Global coordinates
    gl.glLineWidth(2);
    drawColorCoord(WIDTH/6, WIDTH/6, WIDTH/6);

    myMaterialColor(blackish, whitish, white, black);
    // earth and top material

    gl.glPushMatrix();
    gl.glRotatef(e, 0, 1, 0);
    // rotating around the "sun"; proceed angle
    gl.glRotatef(tiltAngle, 0, 0, 1); // tilt angle
    gl.glTranslatef(0, 1.5f*E, 0);

    gl.glPushMatrix();
    gl.glTranslatef(0, E, 0);
    gl.glScalef(E, E, E);
    drawSphere();
    gl.glPopMatrix();

    gl.glPushMatrix();
    gl.glScalef(E/2, 1.5f*E, E/2);
    gl.glRotatef(90, 1, 0, 0); // orient the cone
    drawCone();
    gl.glPopMatrix();

    // enable blending for moons
    gl.glEnable(GL.GL_BLEND);
    gl.glBlendFunc(GL.GL_SRC_ALPHA,
                   GL.GL_ONE_MINUS_SRC_ALPHA);

    gl.glTranslatef(0, E/2, 0);
    gl.glRotatef(m, 0, 1, 0); // 1st moon
    gl.glPushMatrix();
    gl.glTranslatef(2*M, 0, 0);
    gl.glLineWidth(1);
    drawColorCoord(WIDTH/4, WIDTH/4, WIDTH/4);
    gl.glScalef(E/2, E/2, E/2);
    myMaterialColor(tred, tred, tred, tred); // transparent
    gl.glLightfv(GL.GL_LIGHT1, GL.GL_POSITION, origin,0);
    drawSphere();
    gl.glPopMatrix();

    gl.glRotatef(120, 0, 1, 0); // 2nd moon
    gl.glPushMatrix();
    gl.glTranslatef(2*M, 0, 0);
    drawColorCoord(WIDTH/4, WIDTH/4, WIDTH/4);
    gl.glLightfv(GL.GL_LIGHT2, GL.GL_POSITION, origin,0);
    gl.glScalef(E/2, E/2, E/2);
    myMaterialColor(tgreen, tgreen, tgreen, tgreen); // trans.
    drawSphere();
    gl.glPopMatrix();

    gl.glRotatef(120, 0f, 1f, 0f); // 3rd moon
    gl.glTranslatef(2*M, 0, 0);
    gl.glLightfv(GL.GL_LIGHT3, GL.GL_POSITION, origin,0);
    drawColorCoord(WIDTH/4, WIDTH/4, WIDTH/4);
    gl.glScalef(E/2, E/2, E/2);
    myMaterialColor(tblue, tblue, tblue, tblue);
    drawSphere();

    gl.glPopMatrix();
    myMaterialColor(blackish, whitish, white, black);
  }


  public static void main(String[] args) {
    J4_1_Blending f = new J4_1_Blending();

    f.setTitle("JOGL J4_1_Blending");
    f.setSize(WIDTH, HEIGHT);
    f.setVisible(true);
  }
}
