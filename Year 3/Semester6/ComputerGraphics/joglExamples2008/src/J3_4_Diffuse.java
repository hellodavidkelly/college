//import net.java.games.jogl.*;
import javax.media.opengl.*;

public class J3_4_Diffuse extends J3_3_Ambient {

  float whitish[] = {0.8f, 0.8f, 0.8f, 1};
  float position[] = {1, 1, 1, 0};

  public void init(GLAutoDrawable glDrawable) {

    super.init(glDrawable);

    gl.glEnable(GL.GL_LIGHTING);
    gl.glEnable(GL.GL_NORMALIZE);

    gl.glEnable(GL.GL_LIGHT0);
    gl.glLightfv(GL.GL_LIGHT0, GL.GL_POSITION, position,0);
    gl.glLightfv(GL.GL_LIGHT0, GL.GL_DIFFUSE, white,0);

    gl.glMaterialfv(GL.GL_FRONT, GL.GL_DIFFUSE, whitish,0);
    gl.glMaterialfv(GL.GL_FRONT, GL.GL_AMBIENT, black,0);
    gl.glMaterialfv(GL.GL_FRONT, GL.GL_EMISSION, black,0);
  }


  public void drawSphereTriangle(float v1[],
                                  float v2[], float v3[]) {
    // add normals to triangle
    gl.glBegin(GL.GL_TRIANGLES);
    gl.glNormal3fv(v1,0);
    gl.glVertex3fv(v1,0);
    gl.glNormal3fv(v2,0);
    gl.glVertex3fv(v2,0);
    gl.glNormal3fv(v3,0);
    gl.glVertex3fv(v3,0);
    gl.glEnd();
  }


  public void drawConeSide(float v1[], float v2[],
                            float v3[]) {
    // add normals to cone side
    float v11[] = new float[3];
    float v22[] = new float[3];
    float v33[] = new float[3];

    for (int i = 0; i<3; i++) {
      v11[i] = v1[i]+v3[i]; // normal for cone vertex 1
      v22[i] = v2[i]+v3[i]; // normal for vertex 2
      v33[i] = v11[i]+v22[i]; // normal for vertex 3
    }

    gl.glBegin(GL.GL_TRIANGLES);
    gl.glNormal3fv(v11,0);
    gl.glVertex3fv(v1,0);
    gl.glNormal3fv(v22,0);
    gl.glVertex3fv(v2,0);
    gl.glNormal3fv(v33,0);
    gl.glVertex3fv(v3,0);
    gl.glEnd();
  }


  public void drawBottom(float v1[], float v2[], float v3[]) {
    float vb[] = {0, 0, 1};
    // normal to the cylinder bottom

    if (v3[2]<0.1) { //  bottom on the xy plane
      vb[2] = -1;
    }

    gl.glBegin(GL.GL_TRIANGLES);
    gl.glNormal3fv(vb,0);
    gl.glVertex3fv(v3,0);
    gl.glVertex3fv(v2,0);
    gl.glVertex3fv(v1,0);
    gl.glEnd();
  }


  public void subdivideSphere(
      float v1[],
      float v2[],
      float v3[],
      long depth) {
    float v12[] = new float[3];
    float v23[] = new float[3];
    float v31[] = new float[3];

    if (depth==0) {
      gl.glColor3f(v1[0]*v1[0], v2[1]*v2[1], v3[2]*v3[2]);
      // it's sphere triangle for sphere normals
      drawSphereTriangle(v1, v2, v3);
      return;
    }
    for (int i = 0; i<3; i++) {
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
    // replace original sphere drawing, add normals 4 lighting
    subdivideSphere(sVdata[0], sVdata[1], sVdata[2], depth);
    subdivideSphere(sVdata[0], sVdata[2], sVdata[4], depth);
    subdivideSphere(sVdata[0], sVdata[4], sVdata[5], depth);
    subdivideSphere(sVdata[0], sVdata[5], sVdata[1], depth);

    subdivideSphere(sVdata[3], sVdata[1], sVdata[5], depth);
    subdivideSphere(sVdata[3], sVdata[5], sVdata[4], depth);
    subdivideSphere(sVdata[3], sVdata[4], sVdata[2], depth);
    subdivideSphere(sVdata[3], sVdata[2], sVdata[1], depth);
  }


  private void subdivideCone(float v1[], float v2[],
                             int depth) {

    float v11[] = {0, 0, 0};
    float v22[] = {0, 0, 0};
    float v00[] = {0, 0, 0};
    float v12[] = {0, 0, 0};

    if (depth==0) {

      gl.glColor3f(v1[0]*v1[0], v1[1]*v1[1], v1[2]*v1[2]);

      for (int i = 0; i<3; i++) {
        v11[i] = v1[i];
        v22[i] = v2[i];
      }
      drawBottom(v11, v22, v00);
      // bottom cover of the cone

      v00[2] = 1; // height of cone, the tip on z axis
      drawConeSide(v11, v22, v00);
      // side cover of the cone, new normal added

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
    // replace original cone drawing, add normals 4 lighting

    subdivideCone(cVdata[0], cVdata[1], depth);
    subdivideCone(cVdata[1], cVdata[2], depth);
    subdivideCone(cVdata[2], cVdata[3], depth);
    subdivideCone(cVdata[3], cVdata[0], depth);
  }


  private void subdivideCylinder(float v1[],
                                 float v2[], int depth) {
    float v11[] = {0, 0, 0};
    float v22[] = {0, 0, 0};
    float v00[] = {0, 0, 0};
    float v12[] = {0, 0, 0};
    float v01[] = {0, 0, 0};
    float v02[] = {0, 0, 0};

    if (depth==0) {
      gl.glColor3f(v1[0]*v1[0], v1[1]*v1[1], v1[2]*v1[2]);

      for (int i = 0; i<3; i++) {
        v01[i] = v11[i] = v1[i];
        v02[i] = v22[i] = v2[i];
      }
      drawBottom(v11, v22, v00);
      // draw sphere at the cylinder's bottom with normals

      // the height of the cone along z axis
      v01[2] = v02[2] = v00[2] = 1;

      gl.glBegin(GL.GL_POLYGON);
      // draw the side rectangles of the cylinder, normals
      gl.glNormal3fv(v11,0);
      gl.glVertex3fv(v11,0);
      gl.glNormal3fv(v22,0);
      gl.glVertex3fv(v22,0);
      gl.glNormal3fv(v22,0);
      gl.glVertex3fv(v02,0);
      gl.glNormal3fv(v11,0);
      gl.glVertex3fv(v01,0);
      gl.glEnd();

      drawBottom(v02, v01, v00);
      // draw sphere at the cylinder's bottom

      return;
    }

    v12[0] = v1[0]+v2[0];
    v12[1] = v1[1]+v2[1];
    v12[2] = v1[2]+v2[2];
    normalize(v12);

    subdivideCylinder(v1, v12, depth-1);
    subdivideCylinder(v12, v2, depth-1);
  }


  public void drawCylinder() {
    // replace original cyl. drawing, add normals 4 lighting

    subdivideCylinder(cVdata[0], cVdata[1], depth);
    subdivideCylinder(cVdata[1], cVdata[2], depth);
    subdivideCylinder(cVdata[2], cVdata[3], depth);
    subdivideCylinder(cVdata[3], cVdata[0], depth);
  }


  public static void main(String[] args) {
    J3_4_Diffuse f = new J3_4_Diffuse();

    f.setTitle("JOGL J3_4_Diffuse");
    f.setSize(WIDTH, HEIGHT);
    f.setVisible(true);
  }
}
