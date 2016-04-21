//import net.java.games.jogl.*;
import javax.media.opengl.*;
import java.nio.ByteBuffer;

public class J4_6_Texture extends J4_5_Image {

  public void init(GLAutoDrawable glDrawable) {

    super.init(glDrawable); // stars_image[] available
    initTexture(); // texture parameters initiated
  }


  public void display(GLAutoDrawable drawable) {
    gl.glClear(GL.GL_COLOR_BUFFER_BIT
               |GL.GL_DEPTH_BUFFER_BIT);

    // texture on a quad covering most of the drawing area
    drawTexture(-2.5f*WIDTH, -2.5f*HEIGHT, -2.0f*WIDTH);

    displayView();
  }


  void initTexture() {

    gl.glTexParameteri(GL.GL_TEXTURE_2D,
                       GL.GL_TEXTURE_MIN_FILTER,
                       GL.GL_NEAREST);
    gl.glTexParameteri(GL.GL_TEXTURE_2D,
                       GL.GL_TEXTURE_MAG_FILTER,
                       GL.GL_NEAREST);
    gl.glTexImage2D(GL.GL_TEXTURE_2D, 0, GL.GL_LUMINANCE,
                    imgW, imgH, 0, GL.GL_LUMINANCE,
                    GL.GL_UNSIGNED_BYTE, ByteBuffer.wrap(img));
  }


  public void drawTexture(float x, float y, float z) {

    gl.glTexEnvf(GL.GL_TEXTURE_ENV, GL.GL_TEXTURE_ENV_MODE,
                 GL.GL_REPLACE);

    gl.glEnable(GL.GL_TEXTURE_2D);
    {
      gl.glBegin(GL.GL_QUADS);
      gl.glTexCoord2f(0.0f, 2.0f);
      gl.glVertex3f(x, y, z);
      gl.glTexCoord2f(2.0f, 2.0f);
      gl.glVertex3f(-x, y, z);
      gl.glTexCoord2f(2.0f, 0.0f);
      gl.glVertex3f(-x, -y, z);
      gl.glTexCoord2f(0.0f, 0.0f);
      gl.glVertex3f(x, -y, z);
      gl.glEnd();
    }
    gl.glDisable(GL.GL_TEXTURE_2D);
  }


  public static void main(String[] args) {
    J4_6_Texture f = new J4_6_Texture();

    f.setTitle("JOGL J4_6_Texture");
    f.setSize(WIDTH, HEIGHT);
    f.setVisible(true);
  }
}
