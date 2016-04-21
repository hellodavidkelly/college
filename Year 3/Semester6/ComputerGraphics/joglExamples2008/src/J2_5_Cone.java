/*
 * Created on 2004-3-9
 * @author Jim X. Chen: draw a cone by subdivision
 */
//import net.java.games.jogl.*;
import javax.media.opengl.*;

public class J2_5_Cone extends J2_4_Robot {

  public void reshape(
      GLAutoDrawable glDrawable,
      int x,
      int y,
      int w,
      int h) {

    WIDTH = w;
    HEIGHT = h;

    // enable depth buffer for hidden-surface removal
    gl.glEnable(GL.GL_DEPTH_TEST);
    //gl.glPolygonMode(GL.GL_FRONT_AND_BACK, GL.GL_LINE);
    //gl.glEnable(GL.GL_CULL_FACE); 
    //gl.glCullFace(GL.GL_BACK); 

    gl.glMatrixMode(GL.GL_PROJECTION);
    gl.glLoadIdentity();

    // make sure the cone is within the viewing volume
    gl.glOrtho(-w/2, w/2, -h/2, h/2, -w, w);

    gl.glMatrixMode(GL.GL_MODELVIEW);
    gl.glLoadIdentity();
    
	//interval to swap buffers to avoid rendering too fast

  }


  public void display(GLAutoDrawable glDrawable) {

    if ((cRadius>(WIDTH/2))|| (cRadius==1)) {
      flip = -flip;
      depth++;
      depth = depth%5;
    }
    cRadius += flip;

    // clear both framebuffer and zbuffer
    gl.glClear(GL.GL_COLOR_BUFFER_BIT|
               GL.GL_DEPTH_BUFFER_BIT);

    gl.glRotatef(1, 1, 1, 1);
    // rotate 1 degree alone vector (1, 1, 1)
    gl.glPushMatrix();
    gl.glScaled(cRadius, cRadius, cRadius);
    drawCone();
    gl.glPopMatrix();
	gl.setSwapInterval(1);
	try {
		Thread.sleep(30);
	} catch (Exception ignore) {
	}
  }


  private void subdivideCone(float v1[],
                             float v2[], int depth) {
    float v0[] = {0, 0, 0};
    float v12[] = new float[3];

    if (depth==0) {
      gl.glColor3f(v1[0]*v1[0], v1[1]*v1[1], v1[2]*v1[2]);

      drawtriangle(v2, v1, v0);
      // bottom cover of the cone

      v0[2] = 1; // height of the cone, the tip on z axis
      drawtriangle(v1, v2, v0); // side cover of the cone

      return;
    }

    for (int i = 0; i<3; i++) {
      v12[i] = v1[i]+v2[i];
    }
    normalize(v12);

    subdivideCone(v1, v12, depth-1);
    subdivideCone(v12, v2, depth-1);
  }


  public void drawCone() {
    subdivideCone(cVdata[0], cVdata[1], depth);
    subdivideCone(cVdata[1], cVdata[2], depth);
    subdivideCone(cVdata[2], cVdata[3], depth);
    subdivideCone(cVdata[3], cVdata[0], depth);
  }


  public static void main(String[] args) {
    J2_5_Cone f = new J2_5_Cone();

    f.setTitle("JOGL J2_5_Cone");
    f.setSize(WIDTH, HEIGHT);
    f.setVisible(true);
  }
}
