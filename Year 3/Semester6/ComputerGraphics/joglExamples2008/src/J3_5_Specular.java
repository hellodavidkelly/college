//import net.java.games.jogl.*;
import javax.media.opengl.*;

public class J3_5_Specular extends J3_4_Diffuse {

  public void init(GLAutoDrawable glDrawable) {

    super.init(glDrawable);

    gl.glEnable(GL.GL_LIGHTING);
    gl.glEnable(GL.GL_NORMALIZE);

    gl.glEnable(GL.GL_LIGHT0);
    gl.glLightfv(GL.GL_LIGHT0, GL.GL_POSITION, position,0);
    gl.glLightfv(GL.GL_LIGHT0, GL.GL_SPECULAR, white,0);

    gl.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, white,0);
    gl.glMaterialf(GL.GL_FRONT, GL.GL_SHININESS, 50.0f);

    gl.glMaterialfv(GL.GL_FRONT, GL.GL_DIFFUSE, black,0);
    gl.glMaterialfv(GL.GL_FRONT, GL.GL_AMBIENT, black,0);
    gl.glMaterialfv(GL.GL_FRONT, GL.GL_EMISSION, black,0);
  }


  public static void main(String[] args) {
    J3_5_Specular f = new J3_5_Specular();

    f.setTitle("JOGL J3_5_Specular");
    f.setSize(WIDTH, HEIGHT);
    f.setVisible(true);
  }
}
