//import net.java.games.jogl.GL;
import javax.media.opengl.GL;

/**
 * <p>Title: Foundations of 3D Graphics Programming : Using JOGL and Java3D </p>
 *
 * <p>Description: display GLUT solids: tori, polyhedra, and teapots</p>
 *
 * <p>Copyright: Copyright (c) 2005</p>
 *
 * <p>Company: George Mason University</p>
 *
 * @author Dr. Jim X. Chen
 * @version 1.0
 */
public class J5_2_Solids extends J5_1_Quadrics {

  public void drawSphere() {

    myCameraView = true; // focus on just the model

    gl.glPushMatrix();
    gl.glScaled(0.5, 2/3f, 0.5);
    if (cnt%2000<100) {
      glut.glutSolidCone(1, 1, 20, 20);
    } else
    if (cnt%2000<200) {
      glut.glutWireCone(1, 1, 20, 20);
    } else
    if (cnt%2000<300) {
      glut.glutSolidCube(1);
    } else
    if (cnt%2000<400) {
      glut.glutWireCube(1);
    } else
    if (cnt%2000<500) {
      glut.glutSolidDodecahedron();
    } else
    if (cnt%2000<600) {
      glut.glutWireDodecahedron();
    } else
    if (cnt%2000<700) {
      glut.glutSolidIcosahedron();
    } else
    if (cnt%2000<800) {
      glut.glutWireIcosahedron();
    } else
    if (cnt%2000<900) {
      glut.glutSolidOctahedron();
    } else
    if (cnt%2000<1000) {
      glut.glutWireOctahedron();
    } else
    if (cnt%2000<1100) {
      glut.glutSolidSphere(1, 20, 20);
    } else
    if (cnt%2000<1200) {
      glut.glutWireSphere(1, 20, 20);
    } else
    if (cnt%2000<1300) {
      gl.glBindTexture(GL.GL_TEXTURE_2D, EARTH_TEX[0]);
      gl.glTexEnvf(GL.GL_TEXTURE_ENV,
                   GL.GL_TEXTURE_ENV_MODE, GL.GL_MODULATE);
      gl.glEnable(GL.GL_TEXTURE_2D);
      gl.glFrontFace(GL.GL_CW);
      // the faces are clockwise
//      glut.glutSolidTeapot(gl, 1);
      gl.glFrontFace(GL.GL_CCW);
      // return to normal
      gl.glDisable(GL.GL_TEXTURE_2D);
    } else
    if (cnt%2000<1400) {
//      glut.glutWireTeapot(gl, 1);
    } else
    if (cnt%2000<1500) {
      glut.glutSolidTetrahedron();
    } else
    if (cnt%2000<1600) {
      glut.glutWireTetrahedron();
    } else
    if (cnt%2000<1700) {
      glut.glutSolidTorus(0.5, 1, 20, 20);
    } else if (cnt%2000<1800) {
      glut.glutWireTorus(0.5, 1, 20, 20);
    }
    gl.glPopMatrix();

    // for the background texture
    gl.glBindTexture(GL.GL_TEXTURE_2D, STARS_TEX[0]);
  }


  public static void main(String[] args) {
    J5_2_Solids f = new J5_2_Solids();

    f.setTitle("JOGL J5_2_Solids");
    f.setSize(WIDTH, HEIGHT);
    f.setVisible(true);
  }
}
