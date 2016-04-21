/*
 * Created on 2004-4-21
 * @author Jim X. Chen: draw two cubes with transformation
 */
import com.sun.j3d.utils.geometry.*;
import javax.media.j3d.*;
import javax.vecmath.Vector3f;


public class Java3D_3_Multiple extends Java3D_2_Transform {

  BranchGroup createSG() {

    //1. construct two scene graphs
    BranchGroup objRoot1 = createSG1();
    BranchGroup objRoot2 = createSG2();

    BranchGroup objRoot = new BranchGroup();
    objRoot.addChild(objRoot1);
    objRoot.addChild(objRoot2);

    return objRoot;
  }


  BranchGroup createSG2() {

    Transform3D rotate = new Transform3D();
    Transform3D translate = new Transform3D();
    rotate.rotY(Math.PI/8);

    //2. translate and rotate matrices are mult. together
    Vector3f transV = new Vector3f(0.4f, 0f, 0f);
    translate.setTranslation(transV);
    translate.mul(rotate);

    TransformGroup objTransform = new TransformGroup(
        translate);
    objTransform.addChild(new ColorCube(0.2));

    BranchGroup objRoot = new BranchGroup();
    objRoot.addChild(objTransform);
    return objRoot;
  }


  BranchGroup createSG1() {

    Transform3D rotate = new Transform3D();
    Transform3D translate = new Transform3D();
    rotate.rotX(Math.PI/8);

    Vector3f transV = new Vector3f(-0.4f, 0f, 0f);
    translate.setTranslation(transV);
    translate.mul(rotate);

    TransformGroup objTransform = new TransformGroup(
        translate);
    objTransform.addChild(new ColorCube(0.2));

    BranchGroup objRoot = new BranchGroup();
    objRoot.addChild(objTransform);
    return objRoot;
  }


  public static void main(String[] args) {
    Java3D_3_Multiple frame = new Java3D_3_Multiple();
    frame.setSize(999, 999);
    frame.setVisible(true);
  }
}
