//import net.java.games.jogl.*; 
import javax.media.opengl.*;

/**


 * <p>Title: Foundations of 3D Graphics Programming : Using JOGL and Java3D </p>
 *
 * <p>Description: What this class is about ...</p>
 *
 * <p>Copyright: Copyright (c) 2005</p>
 *
 * <p>Company: George Mason University</p>
 *
 * @author Dr. Jim X. Chen
 * @version 1.0
 */
public class HW1_8_Circle extends HW1_7_Triangle {
    // vertex data for the triangles
  static float cVdata[][] = { {1.0f, 0.0f, 0.0f}
                            , {0.0f, 1.0f, 0.0f}
                            , {-1.0f, 0.0f, 0.0f}
                            , {0.0f, -1.0f, 0.0f}
  };
  int cnt;


  public HW1_8_Circle() {
     myClipping = true;
     //circle = new J1_5_Circle();
 }


  public void display(GLAutoDrawable drawable) {

    cnt++;
    super.display(drawable);
    // generate a circle

    drawCircle((int)(8*r/10), cnt%6);
  }


  // draw a circle with center at the origin in xy plane
  public void drawCircle(int cRadius, int depth) {

    subdivideCircle(cRadius, cVdata[0], cVdata[1], depth);
    subdivideCircle(cRadius, cVdata[1], cVdata[2], depth);
    subdivideCircle(cRadius, cVdata[2], cVdata[3], depth);
    subdivideCircle(cRadius, cVdata[3], cVdata[0], depth);
  }


  // subdivide a triangle recursively, and draw them
  private void subdivideCircle(int radius, float[] v1,
                               float[] v2, int depth) {
    float v11[] = new float[3];
    float v22[] = new float[3];
    float v00[] = {0, 0, 0};
    float v12[] = new float[3];

    if (depth==0) {

      for (int i = 0; i<3; i++) {
        v11[i] = v1[i]*radius;
        v22[i] = v2[i]*radius;
      }
      drawtriangle(v11, v22, v00);
      return;
    }

    v12[0] = v1[0]+v2[0];
    v12[1] = v1[1]+v2[1];
    v12[2] = v1[2]+v2[2];

    normalize(v12);

    // subdivide a triangle recursively, and draw them
    subdivideCircle(radius, v1, v12, depth-1);
    subdivideCircle(radius, v12, v2, depth-1);
  }


  // normalize a 3D vector
  public void normalize(float vector[]) {
    float d = (float)Math.sqrt(vector[0]*vector[0]
                               +vector[1]*vector[1]
                               +vector[2]*vector[2]);

    if (d==0) {
      System.out.println("0 length vector: normalize().");
      return;
    }
    vector[0] /= d;
    vector[1] /= d;
    vector[2] /= d;
  }


  public void drawtriangle(float[] v1,
                           float[] v2, float[] v3) {
    int v[][] = new int[3][3];

    for (int i = 0; i<3; i++) {
      v[0][i] = (int)v1[i];
      v[1][i] = (int)v2[i];
      v[2][i] = (int)v3[i];
    }
    for (int i = 0; i<3; i++) {
     v[i][0] += (int)WIDTH/2;
     v[i][1] += (int)HEIGHT/2;
   }

    drawtriangle(v);
  }





  public static void main(String[] args) {
    HW1_8_Circle f = new HW1_8_Circle();

    f.setTitle("HW1_8_Circle - draw a filled circle ");
    f.setSize(WIDTH, HEIGHT);
    f.setVisible(true);
  }
}
