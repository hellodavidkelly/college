//import net.java.games.jogl.*;
//import net.java.games.jogl.util.GLUT;
import javax.media.opengl.*;
import com.sun.opengl.util.GLUT;

public class J3_6_Materials extends J3_5_Specular {

  float blackish[] = {0.3f, 0.3f, 0.3f, 0.3f};

  public void init(GLAutoDrawable glDrawable) {

    super.init(glDrawable);

    gl.glEnable(GL.GL_LIGHTING);
    gl.glEnable(GL.GL_NORMALIZE);
    gl.glEnable(GL.GL_CULL_FACE);

    gl.glEnable(GL.GL_LIGHT0);
    gl.glLightfv(GL.GL_LIGHT0, GL.GL_POSITION, position,0);
    gl.glLightfv(GL.GL_LIGHT0, GL.GL_AMBIENT, whitish,0);
    gl.glLightfv(GL.GL_LIGHT0, GL.GL_DIFFUSE, white,0);
    gl.glLightfv(GL.GL_LIGHT0, GL.GL_SPECULAR, white,0);

    gl.glMaterialfv(GL.GL_FRONT, GL.GL_AMBIENT, black,0);
    gl.glMaterialfv(GL.GL_FRONT, GL.GL_DIFFUSE, whitish,0);
    gl.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, white,0);
    gl.glMaterialf(GL.GL_FRONT, GL.GL_SHININESS, 100.0f);
    gl.glMaterialfv(GL.GL_FRONT, GL.GL_EMISSION, black,0);
  }


  public void drawColorCoord(float xlen,
                             float ylen, float zlen) {

    GLUT glut = new GLUT();

    if (coordOff) return; // cjx for images

    gl.glBegin(GL.GL_LINES);
    gl.glMaterialfv(GL.GL_FRONT, GL.GL_EMISSION, red,0);
    gl.glColor3f(1, 0, 0);
    gl.glVertex3f(0, 0, 0);
    gl.glVertex3f(0, 0, zlen);
    gl.glMaterialfv(GL.GL_FRONT, GL.GL_EMISSION, green,0);
    gl.glColor3f(0, 1, 0);
    gl.glVertex3f(0, 0, 0);
    gl.glVertex3f(0, ylen, 0);
    gl.glMaterialfv(GL.GL_FRONT, GL.GL_EMISSION, blue,0);
    gl.glColor3f(0, 0, 1);
    gl.glVertex3f(0, 0, 0);
    gl.glVertex3f(xlen, 0, 0);
    gl.glEnd();

    // coordinate labels: X, Y, Z
    gl.glPushMatrix();
    gl.glTranslatef(xlen, 0, 0);
    gl.glScalef(xlen/WIDTH, xlen/WIDTH, 1);
    glut.glutStrokeCharacter(GLUT.STROKE_ROMAN, 'X');
    gl.glPopMatrix();

    gl.glPushMatrix();
    gl.glMaterialfv(GL.GL_FRONT, GL.GL_EMISSION, green,0);
    gl.glColor3f(0, 1, 0);
    gl.glTranslatef(0, ylen, 0);
    gl.glScalef(ylen/WIDTH, ylen/WIDTH, 1);
    glut.glutStrokeCharacter(GLUT.STROKE_ROMAN, 'Y');
    gl.glPopMatrix();

    gl.glPushMatrix();
    gl.glMaterialfv(GL.GL_FRONT, GL.GL_EMISSION, red,0);
    gl.glColor3f(1, 0, 0);
    gl.glTranslatef(0, 0, zlen);
    gl.glScalef(zlen/WIDTH, zlen/WIDTH, 1);
    glut.glutStrokeCharacter(GLUT.STROKE_ROMAN, 'Z');
    gl.glPopMatrix();

    gl.glMaterialfv(GL.GL_FRONT, GL.GL_EMISSION, black,0);
  }


  public static void main(String[] args) {

    J3_6_Materials f = new J3_6_Materials();

    f.setTitle("JOGL J3_6_Materials");
    f.setSize(WIDTH, HEIGHT);
    f.setVisible(true);
  }

}
