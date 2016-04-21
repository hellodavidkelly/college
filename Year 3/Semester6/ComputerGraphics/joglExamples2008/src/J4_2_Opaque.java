//import net.java.games.jogl.*;
import javax.media.opengl.*;

public class J4_2_Opaque extends J4_1_Blending {
  float PI = (float)Math.PI;

  public void drawSolar(float E, float e,
                        float M, float m) {

    // Global coordinates
    gl.glLineWidth(2);
    drawColorCoord(WIDTH/6, WIDTH/6, WIDTH/6);

    gl.glPushMatrix();
    {
      gl.glRotatef(e, 0, 1, 0);
      // rotating around the "sun"; proceed angle
      gl.glRotatef(tiltAngle, 0, 0, 1); // tilt angle
      gl.glTranslatef(0, 1.5f*E, 0);

      gl.glPushMatrix();
      gl.glTranslatef(0, E, 0);
      gl.glScalef(E, E, E);
      drawSphere(); // the earth
      gl.glPopMatrix();

      gl.glPushMatrix();
      gl.glScalef(E/2, 1.5f*E, E/2);
      gl.glRotatef(90, 1, 0, 0); // orient the top
      drawCone(); // the top
      gl.glPopMatrix();

      // moons moved up a little
      gl.glTranslatef(0, E/2, 0);
      gl.glRotatef(m, 0, 1, 0); // initial rotation

      // blend for transparency
      gl.glEnable(GL.GL_BLEND);
      gl.glBlendFunc(GL.GL_SRC_ALPHA,
                     GL.GL_ONE_MINUS_SRC_ALPHA);
      gl.glDepthMask(false); // no writting into zbuffer

      gl.glPushMatrix();
      {
        gl.glTranslatef(2.5f*M, 0, 0);
        gl.glLineWidth(1);
        drawColorCoord(WIDTH/4, WIDTH/4, WIDTH/4);
        gl.glLightfv(GL.GL_LIGHT1,
                     GL.GL_SPOT_DIRECTION, spot_direction,0);
        gl.glLightf(GL.GL_LIGHT1, GL.GL_SPOT_CUTOFF, 5);
        gl.glLightfv(GL.GL_LIGHT1, GL.GL_POSITION, origin,0);

        gl.glPushMatrix();
        myMaterialColor(red, red, red, red); // red lit source
        gl.glScalef(E/8, E/8, E/8);
        drawSphere();
        gl.glPopMatrix();

        gl.glScaled(2.5*M, 2.5*M*Math.tan(PI*5/180),
                    2.5*M*Math.tan(PI*5/180)); // cutoff angle
        gl.glTranslatef(-1, 0, 0);
        gl.glRotatef(90, 0, 1, 0); // orient the cone
        myMaterialColor(tred, tred, tred, tred);
        drawCone(); // corresponds to the light source
      }
      gl.glPopMatrix();

      gl.glRotatef(120, 0, 1, 0); // 2nd moon
      gl.glPushMatrix();
      {
        gl.glTranslatef(2.5f*M, 0, 0);

        drawColorCoord(WIDTH/4, WIDTH/4, WIDTH/4);
        gl.glLightfv(GL.GL_LIGHT2, GL.GL_POSITION, origin,0);
        gl.glLightfv(GL.GL_LIGHT2,
                     GL.GL_SPOT_DIRECTION, spot_direction,0);
        gl.glLightf(GL.GL_LIGHT2, GL.GL_SPOT_CUTOFF, 10f);
        myMaterialColor(green, green, green, green);
        gl.glPushMatrix();
        gl.glScalef(E/8, E/8, E/8);
        drawSphere(); // green light source
        gl.glPopMatrix();

        gl.glScaled(2.5*M, 2.5f*M*Math.tan(PI*1/18),
                    2.5f*M*Math.tan(PI*1/18));
        gl.glTranslatef(-1, 0, 0);
        gl.glRotatef(90, 0, 1, 0); // orient the cone
        myMaterialColor(tgreen, tgreen, tgreen, tgreen);
        drawCone();
      }
      gl.glPopMatrix();

      gl.glRotatef(120, 0f, 1f, 0f); // 3rd moon

      gl.glTranslatef(2.5f*M, 0, 0);

      gl.glLightfv(GL.GL_LIGHT3, GL.GL_POSITION, origin,0);
      gl.glLightfv(GL.GL_LIGHT3,
                   GL.GL_SPOT_DIRECTION, spot_direction,0);
      gl.glLightf(GL.GL_LIGHT3, GL.GL_SPOT_CUTOFF, 15f);
      drawColorCoord(WIDTH/4, WIDTH/4, WIDTH/4);
      myMaterialColor(blue, blue, blue, blue);
      gl.glPushMatrix();
      gl.glScalef(E/8, E/8, E/8);
      drawSphere();
      gl.glPopMatrix();

      gl.glScaled(2.5*M, 2.5*M*Math.tan(PI*15/180),
                  2.5*M*Math.tan(PI*15/180));
      gl.glTranslatef(-1, 0, 0);
      gl.glRotatef(90, 0, 1, 0); // orient the cone
      myMaterialColor(tblue, tblue, tblue, tblue);
      drawCone();
      gl.glMaterialfv(GL.GL_FRONT, GL.GL_EMISSION, black,0);

    }
    gl.glPopMatrix();

    gl.glDepthMask(true); // allow writing into zbuffer
    gl.glDisable(GL.GL_BLEND); // no blending afterwards
    myMaterialColor(blackish, whitish, white, black);
  }


  public static void main(String[] args) {

    J4_2_Opaque f = new J4_2_Opaque();

    f.setTitle("JOGL J4_2_Opaque");
    f.setSize(WIDTH, HEIGHT);
    f.setVisible(true);
  }
}
