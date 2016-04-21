/**
 * @author Jim X. Chen:
 * Example J3_1_Shading.java: OpenGL flat or smooth shading
 */
//import net.java.games.jogl.*;
import javax.media.opengl.*;

public class J3_1_Shading extends J2_13_TravelSolar {

  // static float vdata[3][3]
  private static float vdata[][] = { {1.0f, 0, 0}
                           , {0, 1.0f, 0}
                           , {0, 0, 1.0f}
  };


  public void display(GLAutoDrawable glDrawable) {

    cnt++;

    gl.glClear(GL.GL_COLOR_BUFFER_BIT|
               GL.GL_DEPTH_BUFFER_BIT);

    // alternate between flat and smooth
    if (cnt%50==0) {
      gl.glShadeModel(GL.GL_SMOOTH);
    }
    if (cnt%100==0) {
      gl.glShadeModel(GL.GL_FLAT);
    }

    gl.glPushMatrix();
    gl.glRotatef(cnt, 1, 1, 1);
    gl.glScalef(WIDTH/1.2f, WIDTH/1.2f, WIDTH/1.2f);
    gl.glLineWidth(6);
    drawColorCoord(1.0f, 1.0f, 1.0f);
    drawColorTriangle(vdata[0], vdata[1], vdata[2]);
    gl.glPopMatrix();
    
	try {
		Thread.sleep(20);
	} catch (Exception ignore) {
	}

  }


  private void drawColorTriangle(float[] v1,
                                 float[] v2,
                                 float[] v3) {

    gl.glBegin(GL.GL_TRIANGLES);
    gl.glColor3f(1, 0, 0);
    gl.glVertex3fv(v1,0);
    gl.glColor3f(0, 1, 0);
    gl.glVertex3fv(v2,0);
    gl.glColor3f(0, 0, 1);
    gl.glVertex3fv(v3,0);
    gl.glEnd();
  }


  public static void main(String[] args) {
    J3_1_Shading f = new J3_1_Shading();

    f.setTitle("JOGL J3_1_Shading");
    f.setSize(WIDTH, HEIGHT);
    f.setVisible(true);
  }
}
