//import net.java.games.jogl.*;
import javax.media.opengl.*;

public class J4_3_TransLight extends J4_2_Opaque {

  float lightAngle = 0;

  public void drawSolar(float E, float e, float M, float m) {

    gl.glLineWidth(2);
    drawColorCoord(WIDTH/6, WIDTH/6, WIDTH/6);

    gl.glPushMatrix();
    {
      gl.glRotatef(e, 0, 1, 0);
      // rotating around the "sun"; proceed angle
      gl.glRotatef(tiltAngle, 0, 0, 1); // tilt angle
      gl.glTranslated(0, 2*E, 0);

      gl.glPushMatrix();
      gl.glTranslatef(0, 1.5f*E, 0);
      gl.glScalef(E*2, E*1.5f, E*2);
      gl.glRotatef(-(m+e)/4, 0, 1, 0); // self rotation
      drawSphere();
      gl.glPopMatrix();

      gl.glPushMatrix();
      gl.glScalef(E, 2*E, E);
      gl.glRotatef(90, 1, 0, 0); // orient the cone
      drawCone();
      gl.glPopMatrix();

      gl.glEnable(GL.GL_BLEND);
      gl.glBlendFunc(GL.GL_SRC_ALPHA,
                     GL.GL_ONE_MINUS_SRC_ALPHA);

      if (lightAngle==10) {
        flip = -1;
      }
      if (lightAngle==-85) {
        flip = 1;
      }
      lightAngle += flip;

      gl.glRotatef(m, 0, 1, 0); // 1st moon
      gl.glDepthMask(false);
      gl.glPushMatrix();
      {
        gl.glTranslated(2.5*M, 0, 0);
        gl.glLineWidth(1);
        drawColorCoord(WIDTH/4, WIDTH/4, WIDTH/4);

        // light source rot up and down on earth center line
        gl.glRotatef(lightAngle, 0, 0, 1);

        gl.glLightfv(GL.GL_LIGHT1, GL.GL_POSITION, origin,0);
        gl.glLightfv(GL.GL_LIGHT1,
                     GL.GL_SPOT_DIRECTION, spot_direction,0);
        gl.glLightf(GL.GL_LIGHT1, GL.GL_SPOT_CUTOFF, 30);
        gl.glPushMatrix();
        myMaterialColor(red, red, red, red);
        gl.glScalef(E/8, E/8, E/8);
        drawSphere(); // light source with cutoff=15
        gl.glPopMatrix();

        // lighting cone corresponds to the light source
        gl.glScaled(2.5*M, 2.5*M*Math.tan(PI*15/180),
                    2.5*M*Math.tan(PI*15/180));
        gl.glTranslatef(-1, 0, 0);
        gl.glRotatef(90, 0, 1, 0); // orient the cone
        myMaterialColor(tred, tred, tred, tred); // trans.
        drawCone();
      }
      gl.glPopMatrix();

      gl.glRotatef(120, 0, 1, 0); // 2nd moon
      gl.glPushMatrix();
      {
        gl.glTranslated(2.5*M, 0, 0);
        drawColorCoord(WIDTH/4, WIDTH/4, WIDTH/4);
        gl.glRotatef(lightAngle, 0, 0, 1);
        gl.glLightfv(GL.GL_LIGHT2, GL.GL_POSITION, origin,0);
        gl.glLightfv(GL.GL_LIGHT2,
                     GL.GL_SPOT_DIRECTION, spot_direction,0);
        gl.glLightf(GL.GL_LIGHT2, GL.GL_SPOT_CUTOFF, 30f);
        myMaterialColor(green, green, green, green);
        gl.glPushMatrix();
        gl.glScalef(E/8, E/8, E/8);
        drawSphere();
        gl.glPopMatrix();

        gl.glScaled(2.5*M, 2.5*M*Math.tan(PI*15/180),
                    2.5*M*Math.tan(PI*15/180));
        gl.glTranslatef(-1, 0, 0);
        gl.glRotatef(90, 0, 1, 0); // orient the cone
        myMaterialColor(tgreen, tgreen, tgreen, tgreen);
        drawCone();
      }
      gl.glPopMatrix();

      gl.glRotatef(120, 0, 1, 0); // 3rd moon
      gl.glTranslated(2.5*M, 0, 0);
      gl.glRotatef(lightAngle, 0, 0, 1);
      gl.glLightfv(GL.GL_LIGHT3, GL.GL_POSITION, origin,0);
      gl.glLightfv(GL.GL_LIGHT3,
                   GL.GL_SPOT_DIRECTION, spot_direction,0);
      gl.glLightf(GL.GL_LIGHT3, GL.GL_SPOT_CUTOFF, 40f);
      drawColorCoord(WIDTH/4, WIDTH/4, WIDTH/4);
      myMaterialColor(blue, blue, blue, blue);
      gl.glPushMatrix();
      gl.glScalef(E/8, E/8, E/8);
      drawSphere();
      gl.glPopMatrix();

      gl.glScaled(2.5*M, 2.5*M*Math.tan(PI*20/180),
                  2.5*M*Math.tan(PI*20/180));
      gl.glTranslatef(-1f, 0f, 0f);
      gl.glRotatef(90, 0f, 1f, 0f); // orient the cone
      myMaterialColor(tblue, tblue, tblue, tblue);
      drawCone();
      gl.glMaterialfv(GL.GL_FRONT, GL.GL_EMISSION, black,0);
    }
    gl.glPopMatrix();
    gl.glDepthMask(true); // turn off emission
    gl.glDisable(GL.GL_BLEND);
    myMaterialColor(blackish, whitish, white, black);
  }


  public static void main(String[] args) {
    J4_3_TransLight f = new J4_3_TransLight();

    f.setTitle("JOGL J4_3_TransLight");
    f.setSize(WIDTH, HEIGHT);
    f.setVisible(true);
  }
}
