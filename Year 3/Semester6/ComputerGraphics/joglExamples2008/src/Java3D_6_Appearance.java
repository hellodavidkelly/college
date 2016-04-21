/*
 * Created on 2004-4-21
 * @author Jim X. Chen: draw objects with appearance/light sources
 */
import com.sun.j3d.utils.geometry.*;
import javax.media.j3d.*;
import javax.vecmath.*;


public class Java3D_6_Appearance extends
    Java3D_5_Primitives {
  static Color3f redish = new Color3f(0.9f, 0.3f, 0.3f);
  static Color3f whitish = new Color3f(0.8f, 0.8f, 0.8f);
  static Color3f blackish = new Color3f(0.2f, 0.2f, 0.2f);
  static Color3f black = new Color3f(0f, 0f, 0f);

  // primitive sphere (cone, etc) rotate around y axis
  BranchGroup createSG1() {

    TransformGroup objSpin = new TransformGroup();
    BranchGroup objRoot = new BranchGroup();
    objRoot.addChild(objSpin);

    //1.  set material attributes 4 the app. of an sphere
    Appearance app1 = new Appearance();
    Material mat = new Material();
    mat.setAmbientColor(blackish);
    mat.setDiffuseColor(whitish);
    mat.setEmissiveColor(black);
    mat.setShininess(200);
    app1.setMaterial(mat);

    // sphare at origin
    Sphere sphere =
      new Sphere(0.2f, Primitive.GENERATE_NORMALS, 80, app1);
    sphere.setAppearance(app1);
    objSpin.addChild(sphere);

    //2. specify a cone rotating around the sphere
    Transform3D rotate = new Transform3D();
    Transform3D translate = new Transform3D();
    rotate.rotZ(Math.PI/2);

    Vector3f transV = new Vector3f(0.7f, 0f, 0f);
    translate.setTranslation(transV);
    translate.mul(rotate);

    TransformGroup objTransform =
      new TransformGroup(translate);
    // objTransform is a child of objSpin
    objSpin.addChild(objTransform);
    // cone is a child of objTransform
    Cone cone = new Cone(0.2f, 0.4f);
    objTransform.addChild(cone);

    //3. Set coloring attributes for appearance of a cone
    Appearance app = new Appearance();
    app.setColoringAttributes(
        new ColoringAttributes(redish, 1));
    cone.setAppearance(app);

    //4. Specify a light source that goes with the cone
    BoundingSphere lightbounds = new BoundingSphere();
    Vector3f light1Direction = new Vector3f(0f, 1f, 0.0f);
    // facing origin as cone
    DirectionalLight light1 = new DirectionalLight(
        redish, light1Direction);
    light1.setInfluencingBounds(lightbounds);
    // cone is a sibling, they go through same transform.
    objTransform.addChild(light1);


    //5. Specify another light source
    PointLight light2 = new PointLight();
    light2.setPosition(-1, 1, 1);
    light2.setInfluencingBounds(lightbounds);
    light2.setEnable(true);
    objRoot.addChild(light2);

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
    Java3D_6_Appearance frame = new Java3D_6_Appearance();
    frame.setSize(999, 999);
    frame.setVisible(true);
  }
}
