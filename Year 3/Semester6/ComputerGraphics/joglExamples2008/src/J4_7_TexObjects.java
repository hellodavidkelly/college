//import net.java.games.jogl.*;
import javax.media.opengl.*;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;

public class J4_7_TexObjects extends J4_6_Texture {
  // name for texture objects
  static final int[] IRIS_TEX = new int[1];
  static final int[] EARTH_TEX = new int[1];
  static final int[] STARS_TEX = new int[1];

  void initTexture() {

    gl.glHint(GL.GL_PERSPECTIVE_CORRECTION_HINT,
              GL.GL_NICEST); // Perspective correction

    // initialize IRIS1 texture obj
    gl.glGenTextures(1, IntBuffer.wrap(IRIS_TEX));
    gl.glBindTexture(GL.GL_TEXTURE_2D, IRIS_TEX[0]);
    gl.glTexParameteri(GL.GL_TEXTURE_2D,
                       GL.GL_TEXTURE_MIN_FILTER,
                       GL.GL_LINEAR);
    gl.glTexParameteri(GL.GL_TEXTURE_2D,
                       GL.GL_TEXTURE_MAG_FILTER,
                       GL.GL_LINEAR);
    readImage("IRIS1.JPG");
    System.out.println("BufferedImage TYPE_3BYTE_BGR 5: "+imgType);
    //TYPE_BYTE_GRAY  10
    //TYPE_3BYTE_BGR 	5

    gl.glTexImage2D(GL.GL_TEXTURE_2D, 0, GL.GL_RGB8,
                    imgW, imgH, 0, GL.GL_BGR,
                    GL.GL_UNSIGNED_BYTE, ByteBuffer.wrap(img));

    // initialize EARTH texture obj
    gl.glGenTextures(1, IntBuffer.wrap(EARTH_TEX));
    gl.glBindTexture(GL.GL_TEXTURE_2D, EARTH_TEX[0]);
    gl.glTexParameteri(GL.GL_TEXTURE_2D,
                       GL.GL_TEXTURE_MIN_FILTER,
                       GL.GL_LINEAR);
    gl.glTexParameteri(GL.GL_TEXTURE_2D,
                       GL.GL_TEXTURE_MAG_FILTER,
                       GL.GL_LINEAR);
    readImage("EARTH2.JPG");
    gl.glTexImage2D(GL.GL_TEXTURE_2D, 0, GL.GL_RGB8,
                    imgW, imgH, 0, GL.GL_BGR,
                    GL.GL_UNSIGNED_BYTE, ByteBuffer.wrap(img));

    // initialize STARS texture obj
    gl.glGenTextures(1, IntBuffer.wrap(STARS_TEX));
    gl.glBindTexture(GL.GL_TEXTURE_2D, STARS_TEX[0]);
    gl.glTexParameteri(GL.GL_TEXTURE_2D,
                       GL.GL_TEXTURE_WRAP_S, GL.GL_REPEAT);
    gl.glTexParameteri(GL.GL_TEXTURE_2D,
                       GL.GL_TEXTURE_WRAP_T, GL.GL_REPEAT);
    gl.glTexParameteri(GL.GL_TEXTURE_2D,
                       GL.GL_TEXTURE_MIN_FILTER,
                       GL.GL_NEAREST);
    gl.glTexParameteri(GL.GL_TEXTURE_2D,
                       GL.GL_TEXTURE_MAG_FILTER,
                       GL.GL_NEAREST);
    readImage("STARS.JPG");
    gl.glTexImage2D(GL.GL_TEXTURE_2D, 0, GL.GL_LUMINANCE,
                    imgW, imgH, 0, GL.GL_LUMINANCE,
                    GL.GL_UNSIGNED_BYTE, ByteBuffer.wrap(img));
  }


  public void drawSphere() {

    //gl.glPolygonMode(GL.GL_FRONT_AND_BACK, GL.GL_POINT);


    if ((cnt%1503)<500) {
      gl.glBindTexture(GL.GL_TEXTURE_2D, EARTH_TEX[0]);
    } else {
      gl.glBindTexture(GL.GL_TEXTURE_2D, IRIS_TEX[0]);
    }
    gl.glTexEnvf(GL.GL_TEXTURE_ENV, GL.GL_TEXTURE_ENV_MODE,
                 GL.GL_MODULATE);

    if (cnt%1111<900) { // could turn texture off
      gl.glEnable(GL.GL_TEXTURE_2D);
    }

    if (cnt%1012<700) { // could turn fog on
      gl.glDisable(GL.GL_FOG);
    } else {
      gl.glEnable(GL.GL_FOG);
    }

    subdivideSphere(sVdata[0], sVdata[1], sVdata[2], depth);
    subdivideSphere(sVdata[0], sVdata[2], sVdata[4], depth);
    subdivideSphere(sVdata[0], sVdata[4], sVdata[5], depth);
    subdivideSphere(sVdata[0], sVdata[5], sVdata[1], depth);

    subdivideSphere(sVdata[3], sVdata[1], sVdata[5], depth);
    subdivideSphere(sVdata[3], sVdata[5], sVdata[4], depth);
    subdivideSphere(sVdata[3], sVdata[4], sVdata[2], depth);
    subdivideSphere(sVdata[3], sVdata[2], sVdata[1], depth);

    gl.glDisable(GL.GL_TEXTURE_2D);

    if (cnt%1800<1500) { // for the background texture
      gl.glBindTexture(GL.GL_TEXTURE_2D, STARS_TEX[0]);
    } else {
      gl.glBindTexture(GL.GL_TEXTURE_2D, IRIS_TEX[0]);
    }
  }


  public void drawSphereTriangle(float v1[],
                                 float v2[], float v3[]) {
    float[] s1 = new float[1], t1 = new float[1];
    float[] s2 = new float[1], t2 = new float[1];
    float[] s3 = new float[1], t3 = new float[1];

    texCoord(v1, s1, t1);
    texCoord(v2, s2, t2);
    texCoord(v3, s3, t3);

    // for coord at z=0
    if (s1[0]==-1.0f) {
      s1[0] = (s2[0]+s3[0])/2;
    } else if (s2[0]==-1.0f) {
      s2[0] = (s1[0]+s3[0])/2;
    } else if (s3[0]==-1.0f) {
      s3[0] = (s2[0]+s1[0])/2;
    }

    gl.glBegin(GL.GL_TRIANGLES);

    gl.glTexCoord2f(s1[0], t1[0]);
    gl.glNormal3fv(v1,0);
    gl.glVertex3fv(v1,0);
    gl.glTexCoord2f(s2[0], t2[0]);
    gl.glNormal3fv(v2,0);
    gl.glVertex3fv(v2,0);
    gl.glTexCoord2f(s3[0], t3[0]);
    gl.glNormal3fv(v3,0);
    gl.glVertex3fv(v3,0);

    gl.glEnd();
  }


  public void texCoord(float v[], float s[], float t[]) {
    // given the vertex on a sphere, find its texture (s,t)
    float x, y, z, PI = 3.14159f, PI2 = 6.283f;

    x = v[0];
    y = v[1];
    z = v[2];

    if (x>0) {
      if (z>0) {
        s[0] = (float)Math.atan(z/x)/PI2;
      } else {
        s[0] = 1f+(float)Math.atan(z/x)/PI2;
      }
    } else if (x<0) {
      s[0] = 0.5f+(float)Math.atan(z/x)/PI2;
    } else {
      if (z>0) {
        s[0] = 0.25f;
      }
      if (z<0) {
        s[0] = 0.75f;
      }
      if (z==0) {
        s[0] = -1.0f;
      }
    }
    t[0] = (float)Math.acos(y)/PI;
  }


  public void subdivideCyl(float v1[], float v2[],
                           int depth, float t1, float t2) {
    float v11[] = {0, 0, 0};
    float v22[] = {0, 0, 0};
    float v00[] = {0, 0, 0};
    float v12[] = {0, 0, 0};
    float v01[] = {0, 0, 0};
    float v02[] = {0, 0, 0};
    int i;

    if (depth==0) {
      drawBottom(v00, v1, v2);
      for (i = 0; i<3; i++) {
        v01[i] = v11[i] = v1[i];
        v02[i] = v22[i] = v2[i];
      }
      // the height of the cone along z axis
      v11[2] = v22[2] = 1;

      gl.glBegin(GL.GL_POLYGON);
      // draw the rectangles around the cylinder
      gl.glNormal3fv(v2,0);
      gl.glTexCoord2f(t1, 0.0f);
      gl.glVertex3fv(v1,0);
      gl.glTexCoord2f(t2, 0.0f);
      gl.glVertex3fv(v2,0);
      gl.glNormal3fv(v1,0);
      gl.glTexCoord2f(t2, 1.0f);
      gl.glVertex3fv(v22,0);
      gl.glTexCoord2f(t1, 1.0f);
      gl.glVertex3fv(v11,0);
      gl.glEnd();

      v00[2] = 1;
      drawBottom(v22, v11, v00); // draw the other bottom

      return;
    }

    v12[0] = v1[0]+v2[0];
    v12[1] = v1[1]+v2[1];
    v12[2] = v1[2]+v2[2];

    normalize(v12);

    subdivideCyl(v1, v12, depth-1, t1, (t2+t1)/2);
    subdivideCyl(v12, v2, depth-1, (t2+t1)/2, t2);
  }


  public void drawCylinder() {

    if ((cnt%1004)<501) {
      gl.glBindTexture(GL.GL_TEXTURE_2D, IRIS_TEX[0]);
    } else {
      gl.glBindTexture(GL.GL_TEXTURE_2D, EARTH_TEX[0]);
    }

    if (cnt%1100<980) { // turn off texture sometimes
      gl.glEnable(GL.GL_TEXTURE_2D);
    }

    subdivideCyl(cVdata[0], cVdata[1], depth, 0f, 0.25f);
    subdivideCyl(cVdata[1], cVdata[2], depth, 0.25f, 0.5f);
    subdivideCyl(cVdata[2], cVdata[3], depth, 0.5f, 0.75f);
    subdivideCyl(cVdata[3], cVdata[0], depth, 0.75f, 1.0f);

    gl.glDisable(GL.GL_TEXTURE_2D);
  }


  public static void main(String[] args) {
    J4_7_TexObjects f = new J4_7_TexObjects();

    f.setTitle("JOGL J4_7_TexObjects");
    f.setSize(WIDTH, HEIGHT);
    f.setVisible(true);
  }
}
