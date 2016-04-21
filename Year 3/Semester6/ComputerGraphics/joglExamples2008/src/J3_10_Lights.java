//import net.java.games.jogl.*;
import javax.media.opengl.*;

public class J3_10_Lights extends J3_9_AttLight {
  float redish[] = {.3f, 0, 0, 1};
  float greenish[] = {0, .3f, 0, 1};
  float blueish[] = {0, 0, .3f, 1};
  float yellish[] = {.7f, .7f, 0.0f, 1};

  public void init(GLAutoDrawable glDrawable) {

    super.init(glDrawable);

   // gl.glShadeModel(GL.GL_FLAT);
    // back face culling is discussed in Section 3.4
    gl.glEnable(GL.GL_CULL_FACE);
    // removing all back-facing polygons
    gl.glCullFace(GL.GL_BACK);

    gl.glEnable(GL.GL_LIGHTING);
    gl.glEnable(GL.GL_NORMALIZE);

    //gl.glDisable(GL.GL_LIGHT0);
    gl.glEnable(GL.GL_LIGHT1);
    gl.glEnable(GL.GL_LIGHT2);
    gl.glEnable(GL.GL_LIGHT3);

    gl.glLightfv(GL.GL_LIGHT0, GL.GL_POSITION, position,0);
    gl.glLightfv(GL.GL_LIGHT0, GL.GL_AMBIENT, blackish,0);
    gl.glLightfv(GL.GL_LIGHT0, GL.GL_DIFFUSE, whitish,0);
    gl.glLightfv(GL.GL_LIGHT0, GL.GL_SPECULAR, white,0);

    gl.glLightfv(GL.GL_LIGHT1, GL.GL_AMBIENT, redish,0);
    gl.glLightfv(GL.GL_LIGHT1, GL.GL_DIFFUSE, red,0);
    gl.glLightfv(GL.GL_LIGHT1, GL.GL_SPECULAR, red,0);

    gl.glLightfv(GL.GL_LIGHT2, GL.GL_AMBIENT, greenish,0);
    gl.glLightfv(GL.GL_LIGHT2, GL.GL_DIFFUSE, green,0);
    gl.glLightfv(GL.GL_LIGHT2, GL.GL_SPECULAR, green,0);

    gl.glLightfv(GL.GL_LIGHT3, GL.GL_AMBIENT, blueish,0);
    gl.glLightfv(GL.GL_LIGHT3, GL.GL_DIFFUSE, blue,0);
    gl.glLightfv(GL.GL_LIGHT3, GL.GL_SPECULAR, blue,0);

    myMaterialColor(blackish, whitish, white, black);
  }


  public void myMaterialColor(
      float myA[],
      float myD[],
      float myS[],
      float myE[]) {

    gl.glMaterialfv(GL.GL_FRONT, GL.GL_AMBIENT, myA,0);
    gl.glMaterialfv(GL.GL_FRONT, GL.GL_DIFFUSE, myD,0);
    gl.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, myS,0);
    gl.glMaterialfv(GL.GL_FRONT, GL.GL_EMISSION, myE,0);
  }


  public void drawSolar(float E, float e,
                        float M, float m) {

//    gl.glDisable(GL.GL_LIGHT0); // cjx for images



    // Global coordinates
    gl.glLineWidth(2);
    drawColorCoord(WIDTH/6, WIDTH/6, WIDTH/6);

    myMaterialColor(blackish, whitish, white, black);

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

    gl.glTranslatef(0, E/2, 0);
    gl.glRotatef(m, 0, 1, 0); // 1st moon
    gl.glPushMatrix();
    gl.glTranslatef(2*M, 0, 0);
    gl.glLineWidth(1);
    drawColorCoord(WIDTH/4, WIDTH/4, WIDTH/4);
    gl.glScalef(E/4, E/4, E/4);
    myMaterialColor(redish, redish, red, redish);
    gl.glLightfv(GL.GL_LIGHT1, GL.GL_POSITION, origin,0);
    drawSphere();
    gl.glPopMatrix();

    gl.glRotatef(120, 0, 1, 0); // 2nd moon
    gl.glPushMatrix();
    gl.glTranslatef(2*M, 0, 0);
    drawColorCoord(WIDTH/4, WIDTH/4, WIDTH/4);
    gl.glLightfv(GL.GL_LIGHT2, GL.GL_POSITION, origin,0);
    gl.glScalef(E/4, E/4, E/4);
    myMaterialColor(greenish, greenish, green, greenish);
    drawSphere();
    gl.glPopMatrix();

    gl.glRotatef(120, 0f, 1f, 0f); // 3rd moon
    gl.glTranslatef(2*M, 0, 0);
    gl.glLightfv(GL.GL_LIGHT3, GL.GL_POSITION, origin,0);
    drawColorCoord(WIDTH/4, WIDTH/4, WIDTH/4);
    gl.glScalef(E/4, E/4, E/4);
    myMaterialColor(blueish, blueish, blue, blueish);
    drawSphere();

    gl.glPopMatrix();
    myMaterialColor(blackish, whitish, white, black);
  }


  public static void main(String[] args) {
    J3_10_Lights f = new J3_10_Lights();

    f.setTitle("JOGL J3_10_Lights");
    f.setSize(WIDTH, HEIGHT);
    f.setVisible(true);
  }
}
