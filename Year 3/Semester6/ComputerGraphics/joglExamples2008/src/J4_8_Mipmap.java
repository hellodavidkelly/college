//import net.java.games.jogl.*;
import javax.media.opengl.*;
import java.nio.ByteBuffer;

/**
 * <p>Title: Foundations of 3D Graphics Programming : Using JOGL and Java3D </p>
 *
 * <p>Description: Multiple LOD in OpenGL - mipmaps </p>
 *
 * <p>Copyright: Copyright (c) 2005</p>
 *
 * <p>Company: George Mason University</p>
 *
 * @author Dr. Jim X. Chen
 * @version 1.0
 */
public class J4_8_Mipmap extends J4_7_TexObjects {

  public void init(GLAutoDrawable glDrawable) {

    super.init(glDrawable); // texture objects available

    // Redefine LOD mipmap for IRIS
    gl.glBindTexture(GL.GL_TEXTURE_2D, IRIS_TEX[0]);
    gl.glTexParameteri(GL.GL_TEXTURE_2D,
                       GL.GL_TEXTURE_MIN_FILTER,
                       GL.GL_LINEAR_MIPMAP_LINEAR);

    readImage("IRIS1_256_256.JPG");
    gl.glTexImage2D(GL.GL_TEXTURE_2D, 0, GL.GL_RGB8,
                    imgW, imgH, 0, GL.GL_BGR,
                    GL.GL_UNSIGNED_BYTE, ByteBuffer.wrap(img));

    readImage("IRIS1_128_128.JPG");
    gl.glTexImage2D(GL.GL_TEXTURE_2D, 1, GL.GL_RGB8,
                    imgW, imgH, 0, GL.GL_BGR,
                    GL.GL_UNSIGNED_BYTE, ByteBuffer.wrap(img));

    readImage("IRIS1_64_64.JPG");
    gl.glTexImage2D(GL.GL_TEXTURE_2D, 2, GL.GL_RGB8,
                    imgW, imgH, 0, GL.GL_BGR,
                    GL.GL_UNSIGNED_BYTE, ByteBuffer.wrap(img));

    readImage("IRIS1_32_32.JPG");
    gl.glTexImage2D(GL.GL_TEXTURE_2D, 3, GL.GL_RGB8,
                    imgW, imgH, 0, GL.GL_BGR,
                    GL.GL_UNSIGNED_BYTE, ByteBuffer.wrap(img));

    readImage("IRIS1_16_16.JPG");
    gl.glTexImage2D(GL.GL_TEXTURE_2D, 4, GL.GL_RGB8,
                    imgW, imgH, 0, GL.GL_BGR,
                    GL.GL_UNSIGNED_BYTE, ByteBuffer.wrap(img));

    readImage("IRIS1_8_8.JPG");
    gl.glTexImage2D(GL.GL_TEXTURE_2D, 5, GL.GL_RGB8,
                    imgW, imgH, 0, GL.GL_BGR,
                    GL.GL_UNSIGNED_BYTE, ByteBuffer.wrap(img));

    readImage("IRIS1_4_4.JPG");
    gl.glTexImage2D(GL.GL_TEXTURE_2D, 6, GL.GL_RGB8,
                    imgW, imgH, 0, GL.GL_BGR,
                    GL.GL_UNSIGNED_BYTE, ByteBuffer.wrap(img));

    readImage("IRIS1_2_2.JPG");
    gl.glTexImage2D(GL.GL_TEXTURE_2D, 7, GL.GL_RGB8,
                    imgW, imgH, 0, GL.GL_BGR,
                    GL.GL_UNSIGNED_BYTE, ByteBuffer.wrap(img));

    readImage("IRIS1_1_1.JPG");
    gl.glTexImage2D(GL.GL_TEXTURE_2D, 8, GL.GL_RGB8,
                    imgW, imgH, 0, GL.GL_BGR,
                    GL.GL_UNSIGNED_BYTE, ByteBuffer.wrap(img));
                    
  }


  public static void main(String[] args) {
    J4_8_Mipmap f = new J4_8_Mipmap();

    f.setTitle("JOGL J4_8_Mipmap");
    f.setSize(WIDTH, HEIGHT);
    f.setVisible(true);
  }
}
