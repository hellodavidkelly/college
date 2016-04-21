/*
 * Created on 2004-4-21
 * @author Jim X. Chen: draw a cube with transformation
 */
import com.sun.j3d.utils.geometry.*;
import javax.media.j3d.*;
import javax.vecmath.Vector3f;


public class Java3D_2_Transform extends Java3D_1_Hello {

  // Construct sceneGraph: object branch group
  BranchGroup createSG() {

    // translate object has composite transformation matrix
    Transform3D rotate = new Transform3D();
    Transform3D translate = new Transform3D();
    rotate.rotY(Math.PI/8);

    // translate object actually saves a matrix expression
    Vector3f transV = new Vector3f(0.4f, 0f, 0f);
    translate.setTranslation(transV);
    translate.mul(rotate); // final matrix: T*R

    TransformGroup objTransform = new TransformGroup(
        translate);
    objTransform.addChild(new ColorCube(0.2));

    BranchGroup objRoot = new BranchGroup();
    objRoot.addChild(objTransform);

    // Let Java3D perform optimizations on this scene graph.
    objRoot.compile();

    return objRoot;
  } // end of CreateSceneGraph method


  public static void main(String[] args) {

    Java3D_2_Transform frame = new Java3D_2_Transform();
    frame.setSize(999, 999);
    frame.setVisible(true);
  }
}
