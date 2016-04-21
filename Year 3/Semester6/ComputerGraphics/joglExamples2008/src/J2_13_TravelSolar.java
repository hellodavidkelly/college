/*
 * Created on 2004-3-17
 * @author Jim X. Chen: going backwards to the moon in generalized solar system
 */
//import net.java.games.jogl.*;
import javax.media.opengl.*;

public class J2_13_TravelSolar extends J2_12_RobotSolar {
  boolean myCameraView = false;

  public void display(GLAutoDrawable glDrawable) {

    cnt++;
 //   System.out.println(cnt); 
 //   cnt = 220; // for color plates 

    depth = (cnt/80)%5;
    gl.glClear(GL.GL_COLOR_BUFFER_BIT|
               GL.GL_DEPTH_BUFFER_BIT);

 //*
    if (cnt%60==0) {
      dalpha = -dalpha;
      dbeta = -dbeta;
      dgama = -dgama;
    }

     alpha += dalpha;
     beta += dbeta;
     gama += dgama;
//*/  
      

    gl.glPushMatrix();
    if (cnt%1000<300 || myCameraView) {
      // look at the solar system from the moon
      myCamera(A, B, C, alpha, beta, gama);
    }
    drawRobot(O, A, B, C, alpha, beta, gama);
    gl.glPopMatrix();
    
	try {
		Thread.sleep(10);
	} catch (Exception ignore) {
	}

  }


  void myCamera(
      float A,
      float B,
      float C,
      float alpha,
      float beta,
      float gama) {

    float E = WIDTH/4;
    float e = 2.5f*cnt;
    float M = WIDTH/6;
    float m = 1.5f*cnt;

    //1. camera faces the negative x axis
    gl.glRotatef(-90, 0, 1, 0);

    //2. camera on positive x axis
    gl.glTranslatef(-M*2, 0, 0);

    //3. camera rotates with the cylinder
    gl.glRotatef(-cylinderm, 0, 1, 0);

    // and so on reversing the solar transformation
    gl.glTranslatef(0, -E, 0);
    gl.glRotatef(-tiltAngle, 0, 0, 1); // tilt angle
    // rotating around the "sun"; proceed angle
    gl.glRotatef(-e, 0, 1, 0);

    // and reversing the robot transformation
    gl.glTranslatef(-C+B, 0, 0);
    gl.glRotatef(-gama, 0, 0, 1);
    gl.glTranslatef(-B+A, 0, 0);
    gl.glRotatef(-beta, 0, 0, 1);
    gl.glTranslatef(-A, 0, 0);
    gl.glRotatef(-alpha, 0, 0, 1);
    gl.glRotatef(-cnt, 0, 1, 0);
  }


  public static void main(String[] args) {
    J2_13_TravelSolar f = new J2_13_TravelSolar();

    f.setTitle("JOGL J2_13_TravelSolar");
    f.setSize(WIDTH, HEIGHT);
    f.setVisible(true);
  }
}
