import javax.media.j3d.*;
import com.sun.j3d.utils.geometry.*;
import javax.media.j3d.*;
import com.sun.j3d.utils.image.TextureLoader;


/**
 * <p>Title: Foundations of 3D Graphics Programming : Using JOGL and Java3D </p>
 *
 * <p>Description: Java3D texture mapping ...</p>
 *
 * <p>Copyright: Copyright (c) 2005</p>
 *
 * <p>Company: George Mason University</p>
 *
 * @author Dr. Jim X. Chen
 * @version 1.0
 */
public class Java3D_7_Texture extends Java3D_6_Appearance {


  BranchGroup createSG1() {

    TransformGroup objSpin = new TransformGroup();
    BranchGroup objRoot = new BranchGroup();
    objRoot.addChild(objSpin);

    //1.  set material attributes 4 the app. of an sphere
    Appearance app = new Appearance();

    // Create Texture object
    TextureLoader loader =
        new TextureLoader("EARTH1.JPG", this);
    Texture earth = loader.getTexture();

    // Attach Texture object to Appearance object
    app.setTexture(earth);

    // Create a sphere with texture
    Sphere sphere =
       new Sphere(0.4f,Primitive.GENERATE_TEXTURE_COORDS,
                  50,app);
    objSpin.addChild(sphere);

    objSpin.setCapability(TransformGroup.
                          ALLOW_TRANSFORM_WRITE);

    Alpha a = new Alpha(-1, 5000);
    RotationInterpolator rotator =
        new RotationInterpolator(a, objSpin);
    BoundingSphere bounds = new BoundingSphere();
    rotator.setSchedulingBounds(bounds);
    objSpin.addChild(rotator);

    return objRoot;
  }


  public static void main(String[] args) {
    Java3D_7_Texture frame = new Java3D_7_Texture();
    frame.setSize(999, 999);
    frame.setVisible(true);
  }
}
