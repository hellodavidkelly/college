//import net.java.games.jogl.*;
import javax.media.opengl.*;

/**


 * <p>Title: Foundations of 3D Graphics Programming : Using JOGL and Java3D </p>
 *
 * <p>Description: trivial clipping  ...</p>
 *
 * <p>Copyright: Copyright (c) 2005</p>
 *
 * <p>Company: George Mason University</p>
 *
 * @author Dr. Jim X. Chen
 * @version 1.0
 */
public class HW1_5_Clipping extends HW1_4_Font {
  // clipping window
  double lLeft[] = {WIDTH/8, HEIGHT/4, 0};
  double uRight[] = {7*WIDTH/8, 3*HEIGHT/4, 0};
  boolean myClipping = true;

  public void display(GLAutoDrawable drawable) {
    lLeft[0] = WIDTH/8;
    lLeft[1] = HEIGHT/4;
    uRight[0] = 7*WIDTH/8;
    uRight[1] = 3*HEIGHT/4;

    super.display(drawable);

    // draw the clipping window
    if (myClipping) {
      gl.glBegin(GL.GL_LINE_LOOP);
      gl.glVertex2d(lLeft[0]-1, lLeft[1]-1);
      gl.glVertex2d(uRight[0]+1, lLeft[1]-1);
      gl.glVertex2d(uRight[0]+1, uRight[1]+1);
      gl.glVertex2d(lLeft[0]-1, uRight[1]+1);
      gl.glEnd();
    }
  }


  public void labelVertex(int x, int y, int i) {

    // clip against the window, partial clipping
    if ((x<lLeft[0]||x>uRight[0]) && myClipping) {
      return;
    }
    if ((y<lLeft[1]||y>uRight[1]) && myClipping) {
      return;
    }

    super.labelVertex(x, y, i);

  }


  public void drawPoint(double x, double y) {

      // clip against the window
      if ((x<lLeft[0]||x>uRight[0]) && myClipping) {
       return;
      }
      if ((y<lLeft[1]||y>uRight[1]) && myClipping) {
        return;
      }

      super.drawPoint(x, y);

  }


  public static void main(String[] args) {
    HW1_5_Clipping f = new HW1_5_Clipping();

    f.setTitle("HW1_5 - clipping");
    f.setSize(WIDTH, HEIGHT);
    f.setVisible(true);

  }

}
