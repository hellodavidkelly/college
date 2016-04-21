/*
 * Created on 2004-3-9
 * @author Jim X. Chen: draw a sphere by subdivision
 */
//import net.java.games.jogl.*;
import javax.media.opengl.*;

public class J2_7_Sphere extends J2_6_Cylinder {
  static float sVdata[][] = { {1.0f, 0.0f, 0.0f}
                            , {0.0f, 1.0f, 0.0f}
                            , {0.0f, 0.0f, 1.0f}
                            , {-1.0f, 0.0f, 0.0f}
                            , {0.0f, -1.0f, 0.0f}
                            , {0.0f, 0.0f, -1.0f}
  };


  public void display(GLAutoDrawable glDrawable) {

    if ((cRadius>(WIDTH/2))||(cRadius==1)) {
      flip = -flip;
      depth++;
      depth = depth%6;
    }

    cRadius += flip;

    // clear both framebuffer and zbuffer
    gl.glClear(GL.GL_COLOR_BUFFER_BIT|
               GL.GL_DEPTH_BUFFER_BIT);

    gl.glRotatef(1, 1, 1, 1);
    // rotate 1 degree alone vector (1, 1, 1)
    gl.glPushMatrix();
    gl.glScalef(cRadius, cRadius, cRadius);
    drawSphere();
    gl.glPopMatrix();
    
	try {
		Thread.sleep(30);
	} catch (Exception ignore) {
	}

  }


  private void subdivideSphere(
      float v1[],
      float v2[],
      float v3[],
      long depth) {
    float v12[] = new float[3];
    float v23[] = new float[3];
    float v31[] = new float[3];
    int i;

    if (depth==0) {
      gl.glColor3f(v1[0]*v1[0], v2[1]*v2[1], v3[2]*v3[2]);
      drawtriangle(v1, v2, v3);
      return;
    }
    for (i = 0; i<3; i++) {
      v12[i] = v1[i]+v2[i];
      v23[i] = v2[i]+v3[i];
      v31[i] = v3[i]+v1[i];
    }
    normalize(v12);
    normalize(v23);
    normalize(v31);
    subdivideSphere(v1, v12, v31, depth-1);
    subdivideSphere(v2, v23, v12, depth-1);
    subdivideSphere(v3, v31, v23, depth-1);
    subdivideSphere(v12, v23, v31, depth-1);
  }


  public void drawSphere() {
    subdivideSphere(sVdata[0], sVdata[1], sVdata[2], depth);
    subdivideSphere(sVdata[0], sVdata[2], sVdata[4], depth);
    subdivideSphere(sVdata[0], sVdata[4], sVdata[5], depth);
    subdivideSphere(sVdata[0], sVdata[5], sVdata[1], depth);

    subdivideSphere(sVdata[3], sVdata[1], sVdata[5], depth);
    subdivideSphere(sVdata[3], sVdata[5], sVdata[4], depth);
    subdivideSphere(sVdata[3], sVdata[4], sVdata[2], depth);
    subdivideSphere(sVdata[3], sVdata[2], sVdata[1], depth);
  }


  public static void main(String[] args) {
    J2_7_Sphere f = new J2_7_Sphere();

    f.setTitle("JOGL J2_7_Sphere");
    f.setSize(WIDTH, HEIGHT);
    f.setVisible(true);
  }
}
