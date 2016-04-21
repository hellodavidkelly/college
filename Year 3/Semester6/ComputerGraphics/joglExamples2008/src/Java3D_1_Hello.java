/*
 * Created on 2004-4-21
 * @author Jim X. Chen: draw a cube in Java3D
 */
import java.awt.*;
import java.awt.GraphicsConfiguration;
import com.sun.j3d.utils.universe.*;
import com.sun.j3d.utils.geometry.*;
import javax.media.j3d.*;
import java.awt.event.*;


// renders a single cube.
public class Java3D_1_Hello extends Frame {

  Java3D_1_Hello() {

    //1. Create a drawing area canvas3D
    setLayout(new BorderLayout());
    GraphicsConfiguration gc =
        SimpleUniverse.getPreferredConfiguration();
    Canvas3D canvas3D = new Canvas3D(gc);
    add(canvas3D);

    //2. Create a simple universe with standard view branch
    SimpleUniverse simpleU = new SimpleUniverse(canvas3D);

    //3. Move the ViewPlatform back to view object at origin
    simpleU.getViewingPlatform().setNominalViewingTransform();

    //4. Construct sceneGraph: object branch group
    BranchGroup objBG = createSG();

    //5. Go live under simpleUniverse
    simpleU.addBranchGraph(objBG);

    // exit windows with proper disposal
    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        dispose();
        System.exit(0);
      }
    }
    );
  }


  BranchGroup createSG() {
    BranchGroup objBG = new BranchGroup();
    objBG.addChild(new ColorCube(0.2));
    return (objBG);
  }


  public static void main(String[] args) {

    Java3D_1_Hello frame = new Java3D_1_Hello();
    frame.setSize(500, 500);
    frame.setVisible(true);
  }
}
