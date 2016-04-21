//import net.java.games.jogl.GLU;
import javax.media.opengl.glu.*;
//import net.java.games.jogl.*;
import javax.media.opengl.*;


/**
 * <p>Title: Foundations of 3D Graphics Programming : Using JOGL and Java3D </p>
 *
 * <p>Description: GLUT and GLU quadrics </p>
 *
 * <p>Copyright: Copyright (c) 2005</p>
 *
 * <p>Company: George Mason University</p>
 *
 * @author Dr. Jim X. Chen
 * @version 1.0
 */
public class J5_1_Quadrics extends J4_8_Mipmap {

  GLU glu = new GLU();//canvas.getGLU(); // glut int. is inherited
  GLUquadric cylinder = glu.gluNewQuadric();
  GLUquadric sphere = glu.gluNewQuadric();

  public void drawSphere() {
    double r = 1;
    // number of points along longitudes and latitudes
    int nLongitudes = 20, nLatitudes = 20;

    // switch between two textures -- effect
    if ((cnt%1000)<500) {
      gl.glBindTexture(GL.GL_TEXTURE_2D, EARTH_TEX[0]);
    } else {
      gl.glBindTexture(GL.GL_TEXTURE_2D, IRIS_TEX[0]);
    }
    gl.glTexEnvf(GL.GL_TEXTURE_ENV,
                 GL.GL_TEXTURE_ENV_MODE, GL.GL_MODULATE);

    if (cnt%950<400) { // draw solid sphere with GLU

      // automatic generate texture coords
      glu.gluQuadricTexture(sphere, true);
      gl.glEnable(GL.GL_TEXTURE_2D);

      // draw a filled sphere
      glu.gluQuadricDrawStyle(sphere, GLU.GLU_FILL);
      glu.gluSphere(sphere, r, nLongitudes, nLatitudes);
    } else {

      // draw wireframe sphere with GLUT.
      glut.glutWireSphere(r, nLongitudes, nLatitudes);
    }
    gl.glDisable(GL.GL_TEXTURE_2D);

    if (cnt%800<400) { // for the background texture
      gl.glBindTexture(GL.GL_TEXTURE_2D, STARS_TEX[0]);
    } else {
      gl.glBindTexture(GL.GL_TEXTURE_2D, IRIS_TEX[0]);
    }
  }


  public void drawCone() {
    double r = 1, h = 1;
    int nLongitudes = 20, nLatitudes = 20;

    if (cnt%950>400) { // draw wireframe cone with GLUT
      glut.glutWireCone(r, h, nLongitudes, nLatitudes);
    } else {
      glut.glutSolidCone(r, h, nLongitudes, nLatitudes);
    }
  }


  public void drawCylinder() {
    double r = 1, h = 1;
    int nLongitudes = 20, nLatitudes = 20;

    // switching between two texture images
    if ((cnt%1000)<5000) {
      gl.glBindTexture(GL.GL_TEXTURE_2D, IRIS_TEX[0]);
    } else {
      gl.glBindTexture(GL.GL_TEXTURE_2D, EARTH_TEX[0]);
    }

    // automatic generate texture coords
    glu.gluQuadricTexture(cylinder, true);
    gl.glEnable(GL.GL_TEXTURE_2D);

    if (cnt%950<400) { // draw solid cylinder with GLU
      glu.gluQuadricDrawStyle(cylinder, GLU.GLU_FILL);
    } else { // draw point cylinder with GLU.
      glu.gluQuadricDrawStyle(cylinder, GLU.GLU_LINE);
    }
    // actually draw the cylinder
    glu.gluCylinder(cylinder, r, r, h, nLongitudes,
                    nLatitudes);

    gl.glDisable(GL.GL_TEXTURE_2D);
  }


  public static void main(String[] args) {
    J5_1_Quadrics f = new J5_1_Quadrics();

    f.setTitle("JOGL J5_1_Quadrics");
    f.setSize(WIDTH, HEIGHT);
    f.setVisible(true);
  }
}
