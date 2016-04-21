/*
 * Created on 2004-2-29
 * @author Jim X. Chen: 2D transformation OpenGL style implementatoin
 */

import javax.media.opengl.*;
//import net.java.games.jogl.*;


public class J2_0_2DTransform extends J1_5_Circle {
  private static float my2dMatStack[][][] =
      new float[24][3][3];
  private static int stackPtr = 0;
  static float vdata[][] = { {1.0f, 0.0f, 0.0f}
                           , {0.0f, 1.0f, 0.0f}
                           , {-1.0f, 0.0f, 0.0f}
                           , {0.0f, -1.0f, 0.0f}
  };
  static int cnt = 1;

  // called for OpenGL rendering every reshape
  public void display(GLAutoDrawable drawable) {

    if (cnt<1||cnt>200) {
      flip = -flip;
    }
    cnt = cnt+flip;

    gl.glClear(GL.GL_COLOR_BUFFER_BIT);

    // white triangle is scaled
    gl.glColor3f(1, 1, 1);
    my2dLoadIdentity();
    my2dScalef(cnt, cnt);
    transDrawTriangle(vdata[0], vdata[1], vdata[2]);

    // red triangle is rotated and scaled
    gl.glColor3f(1, 0, 0);
    my2dRotatef((float)cnt/15);
    transDrawTriangle(vdata[0], vdata[1], vdata[2]);

    // green triangle is translated, rotated, and scaled
    gl.glColor3f(0, 1, 0);
    my2dTranslatef((float)cnt/100, 0.0f);
    transDrawTriangle(vdata[0], vdata[1], vdata[2]);
    
	try {
		Thread.sleep(20);
	} catch (Exception ignore) {
	}

  }


  // the vertices are transformed first then drawn
  public void transDrawTriangle(float[] v1,
                                 float[] v2, float[] v3) {
    float v[][] = new float[3][3];

    my2dTransformf(v1, v[0]);
    my2dTransformf(v2, v[1]);
    my2dTransformf(v3, v[2]);

    gl.glBegin(GL.GL_TRIANGLES);
    gl.glVertex3fv(v[0],0);
    gl.glVertex3fv(v[1],0);
    gl.glVertex3fv(v[2],0);
    gl.glEnd();
  }


  // initialize a 3*3 matrix to all zeros
  private void my2dClearMatrix(float mat[][]) {

    for (int i = 0; i<3; i++) {
      for (int j = 0; j<3; j++) {
        mat[i][j] = 0.0f;
      }
    }
  }


  // initialize a matrix to Identity matrix
  private void my2dIdentity(float mat[][]) {

    my2dClearMatrix(mat);
    for (int i = 0; i<3; i++) {
      mat[i][i] = 1.0f;
    }
  }


  // initialize the current matrix to Identity matrix
  public void my2dLoadIdentity() {
    my2dIdentity(my2dMatStack[stackPtr]);
  }


  // multiply the current matrix with mat
  public void my2dMultMatrix(float mat[][]) {
    float matTmp[][] = new float[3][3];

    my2dClearMatrix(matTmp);

    for (int i = 0; i<3; i++) {
      for (int j = 0; j<3; j++) {
        for (int k = 0; k<3; k++) {
          matTmp[i][j] +=
              my2dMatStack[stackPtr][i][k]*mat[k][j];
        }
      }
    }
    // save the result on the current matrix
    for (int i = 0; i<3; i++) {
      for (int j = 0; j<3; j++) {
        my2dMatStack[stackPtr][i][j] = matTmp[i][j];
      }
    }
  }


  // multiply the current matrix with a translation matrix
  public void my2dTranslatef(float x, float y) {
    float T[][] = new float[3][3];

    my2dIdentity(T);

    T[0][2] = x;
    T[1][2] = y;

    my2dMultMatrix(T);
  }


  // multiply the current matrix with a rotation matrix
  public void my2dRotatef(float angle) {
    float R[][] = new float[3][3];

    my2dIdentity(R);

    R[0][0] = (float)Math.cos(angle);
    R[0][1] = (float)-Math.sin(angle);
    R[1][0] = (float)Math.sin(angle);
    R[1][1] = (float)Math.cos(angle);

    my2dMultMatrix(R);
  }


  // multiply the current matrix with a scale matrix
  public void my2dScalef(float x, float y) {
    float S[][] = new float[3][3];

    my2dIdentity(S);

    S[0][0] = x;
    S[1][1] = y;

    my2dMultMatrix(S);
  }


  // v1 = (the current matrix) * v
  // here v and v1 are vertices in homogeneous coord.
  public void my2dTransHomoVertex(float v[], float v1[]) {
    int i, j;

    for (i = 0; i<3; i++) {
      v1[i] = 0.0f;

    }
    for (i = 0; i<3; i++) {
      for (j = 0; j<3; j++) {
        v1[i] +=
            my2dMatStack[stackPtr][i][j]*v[j];
      }
    }
  }


  // vertex = (the current matrix) * vertex
  // here vertex is in homogeneous coord.
  public void my2dTransHomoVertex(float vertex[]) {
      float vertex1[] = new float[3];

    my2dTransHomoVertex(vertex, vertex1);
    for (int i = 0; i<3; i++) {
      vertex[i] = vertex1[i];
    }
  }


  // transform v to v1 by the current matrix
  // here v and v1 are not in homogeneous coordinates
  public void my2dTransformf(float v[], float v1[]) {
    float vertex[] = new float[3];

    // extend to homogenius coord
     vertex[0] = v[0];
    vertex[1] = v[1];
    vertex[2] = 1;

    // multiply the vertex by the current matrix
    my2dTransHomoVertex(vertex);

    // return to 3D coord
    v1[0] = vertex[0]/vertex[2];
    v1[1] = vertex[1]/vertex[2];
  }


  // transform v by the current matrix
   // here v is not in homogeneous coordinates
  public void my2dTransformf(float[] v) {

    float vertex[] = new float[3];

    // extend to homogenius coord
    vertex[0] = v[0];
    vertex[1] = v[1];
    vertex[2] = 1;

    // multiply the vertex by the current matrix
    my2dTransHomoVertex(vertex);

    // return to 3D coord
    v[0] = vertex[0]/vertex[2];
    v[1] = vertex[1]/vertex[2];
  }


  // move the stack pointer up, and copy the previous
  // matrix to the current matrix
  public void my2dPushMatrix() {
    int tmp = stackPtr+1;

    for (int i = 0; i<3; i++) {
      for (int j = 0; j<3; j++) {
        my2dMatStack[tmp][i][j] =
            my2dMatStack[stackPtr][i][j];
      }
    }
    stackPtr++;
  }


  // move the stack pointer down
  public void my2dPopMatrix() {

    stackPtr--;
  }


  public static void main(String[] args) {
    J2_0_2DTransform f = new J2_0_2DTransform();

    f.setTitle("JOGL J2_0_2DTransform");
    f.setSize(WIDTH, HEIGHT);
    f.setVisible(true);
  }
}
