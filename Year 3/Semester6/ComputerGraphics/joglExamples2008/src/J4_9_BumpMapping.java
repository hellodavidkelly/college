//import net.java.games.jogl.*;
import javax.media.opengl.*;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;

public class J4_9_BumpMapping extends J4_7_TexObjects {
  // name for texture objects
 
	
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

    double n[] = new double [3]; 
    
    gl.glTexCoord2f(s1[0], t1[0]);
    bumpMap(s1[0], t1[0], v1, n); 
    gl.glNormal3dv(n,0);
    gl.glVertex3fv(v1,0);
    gl.glTexCoord2f(s2[0], t2[0]);
    gl.glNormal3dv(n,0);
    gl.glNormal3fv(v2,0);
    gl.glVertex3fv(v2,0);
    gl.glTexCoord2f(s3[0], t3[0]);
    gl.glNormal3fv(v3,0);
    gl.glVertex3fv(v3,0);

    gl.glEnd();
  }

 public void bumpMap(float s, float t, float[] v, double[] n) {
	 
	 double T[] = new double[3], B[] = new double [3], N[] = new double[3]; 
	 
	 for (int i=0; i<3; i++) {
		 T[i] = 0; 
		 N[i] = v[i]; 
	 }
	 T[1] = 1; 

	 normalize(T); 
	 
	 
	 T[0] = 0; T[1] = 0; T[2] = 1; 
	 crossprod(T, N, B); 
	 crossprod(N, B, T); 
	 
	 
	 n[0] = (100*s % 6) - 3; 
	 n[1] = (100*t % 6) - 3; 
	 n[2] = Math.sqrt(18 - n[0]*n[0] - n[1]*n[1]); 
	 normalize(n); 
	 for (int i=0; i<3; i++) {
		 n[i] = n[i]*v[i]; 
	 }
	 normalize(n); 
 }



  public static void main(String[] args) {
	  J4_9_BumpMapping f = new J4_9_BumpMapping();

    f.setTitle("JOGL J4_9_BumpMapping");
    f.setSize(WIDTH, HEIGHT);
    f.setVisible(true);
  }
}
