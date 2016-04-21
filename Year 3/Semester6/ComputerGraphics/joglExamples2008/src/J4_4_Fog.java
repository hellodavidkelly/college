//import net.java.games.jogl.*;
import javax.media.opengl.*;

public class J4_4_Fog extends J4_3_Antialiasing {

  public void init(GLAutoDrawable glDrawable) {
    float fogColor[] = {0.3f, 0.3f, 0.0f, 1f};

    super.init(glDrawable);

    gl.glClearColor(0.3f, 0.3f, 0.1f, 1.0f);

    // lighting is calculated with viewpoint at origin
    // and models are transformed by MODELVIEW matrix
    // in our example, models are moved into -z in PROJECTION
    gl.glEnable(GL.GL_BLEND);
    gl.glEnable(GL.GL_FOG);

    // gl.glFogi (GL.GL_FOG_MODE, GL.GL_EXP);
    // gl.glFogi (GL.GL_FOG_MODE, GL.GL_EXP2);
    gl.glFogi(GL.GL_FOG_MODE, GL.GL_LINEAR);
    gl.glFogfv(GL.GL_FOG_COLOR, fogColor,0);
    // gl.glFogf (GL.GL_FOG_DENSITY, (float)(0.5/width));
    gl.glHint(GL.GL_FOG_HINT, GL.GL_NICEST);
    gl.glFogf(GL.GL_FOG_START, 0.1f*WIDTH);
    gl.glFogf(GL.GL_FOG_END, 0.5f*WIDTH);
  }


  public static void main(String[] args) {
    J4_4_Fog f = new J4_4_Fog();

    f.setTitle("JOGL J4_4_Fog");
    f.setSize(WIDTH, HEIGHT);
    f.setVisible(true);
  }
}
