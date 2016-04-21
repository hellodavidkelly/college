//import net.java.games.jogl.GL;
//import net.java.games.jogl.GLDrawable;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;

public class J3_3_Ambient extends J3_2_Emission {

  float white[] = {1, 1, 1, 1};
  float black[] = {0, 0, 0, 1};
  float red[] = {1, 0, 0, 1};
  float green[] = {0, 1, 0, 1};
  float blue[] = {0, 0, 1, 1};
  float cyan[] = {0, 1, 1, 1};
  float magenta[] = {1, 0, 1, 1};
  float yellow[] = {1, 1, 0, 1};


  public void init(GLAutoDrawable glDrawable) {

    super.init(glDrawable);

    gl.glEnable(GL.GL_LIGHTING);
    gl.glEnable(GL.GL_LIGHT0);
    gl.glLightfv(GL.GL_LIGHT0, GL.GL_AMBIENT, white,0);

    gl.glMaterialfv(GL.GL_FRONT, GL.GL_AMBIENT, yellow,0);
    gl.glMaterialfv(GL.GL_FRONT, GL.GL_EMISSION, black,0);
  }


  public static void main(String[] args) {

    J3_3_Ambient f = new J3_3_Ambient();

    f.setTitle("JOGL J3_3_Ambient");
    f.setSize(WIDTH, HEIGHT);
    f.setVisible(true);
  }

}
