/*
 * Created on 2004-4-21
 * @author Jim X. Chen: draw a cube with transformation
 */
import com.sun.j3d.utils.geometry.*;
import javax.media.j3d.*;
import javax.vecmath.Vector3f;


public class Java3D_4_Animate extends Java3D_3_Multiple {

  BranchGroup createSG1() {

    Transform3D rotate = new Transform3D();
    Transform3D translate = new Transform3D();
    rotate.rotX(Math.PI/8);

    Vector3f transV = new Vector3f(-0.4f, 0f, 0f);
    translate.setTranslation(transV);
    translate.mul(rotate);

    TransformGroup objTransform = new TransformGroup(
        translate);
    BranchGroup objRoot = new BranchGroup();
    objRoot.addChild(objTransform);

    //1. Node closer to leaf object takes effect first
    //	 Here objSpin transformation happens first,
    //   then objTransform
    TransformGroup objSpin = new TransformGroup();
    objTransform.addChild(objSpin);
    objSpin.addChild(new ColorCube(0.2));

    //2. setCapability allows live change, and the default
    //   change is rot on Y axis
    objSpin.setCapability(TransformGroup.
                          ALLOW_TRANSFORM_WRITE);

    //3. Alpha provides a variable value of 0-1 for
    // the angle of rotation; -1 means infinite loop
    // 5000 means in 5 second alpha goes from 0 to 1
    Alpha a = new Alpha(-1, 5000);

    //4. rotator is a behavior node in reference to ojbSpin
    // i.e., rotator links ojbSpin to alpha for rotation
    RotationInterpolator rotator = new RotationInterpolator(
        a, objSpin);
    //5. Bounding sphere specifies a region in which a
    // behavior is active. Here a sphere centered at the
    // origin with radius of 1 is created.
    BoundingSphere bounds = new BoundingSphere();
    rotator.setSchedulingBounds(bounds);

    //6. rotator (behavior node) is child of objSpin (TG)
    objSpin.addChild(rotator);

    return objRoot;
  }


  public static void main(String[] args) {

    Java3D_4_Animate frame = new Java3D_4_Animate();
    frame.setSize(999, 999);
    frame.setVisible(true);
  }

}
