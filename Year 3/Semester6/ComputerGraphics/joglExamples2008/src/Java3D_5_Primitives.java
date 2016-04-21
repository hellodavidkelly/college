/*
 * Created on 2004-4-21
 * @author Jim X. Chen: draw multiple primitives
 */
import com.sun.j3d.utils.geometry.*;
import javax.media.j3d.*;
import javax.vecmath.*;


public class Java3D_5_Primitives extends Java3D_4_Animate {
  static Color3f red = new Color3f(1.0f, 0.0f, 0.0f);
  static Color3f green = new Color3f(0.0f, 1.0f, 0.0f);
  static Color3f blue = new Color3f(0.0f, 0.0f, 1.0f);
  static Color3f white = new Color3f(1.0f, 1.0f, 1.0f);

  //Create sphere (cone, etc) rotateing around y axis
  BranchGroup createSG1() {

    Transform3D rotate = new Transform3D();
    Transform3D translate = new Transform3D();
    rotate.rotX(Math.PI/8);

    Vector3f transV = new Vector3f(0.4f, 0f, 0f);
    translate.setTranslation(transV);
    translate.mul(rotate);

    TransformGroup objTransform = new TransformGroup(
        translate);
    TransformGroup objSpin = new TransformGroup();
    BranchGroup objRoot = new BranchGroup();
    objRoot.addChild(objSpin);

    objSpin.addChild(objTransform);

    //1. draw a sphere, cone, box, or cylinder
    Appearance app = new Appearance();
    Sphere sphere = new Sphere(0.2f);
    sphere.setAppearance(app);
    objTransform.addChild(sphere);

//		Cone cone = new Cone(0.2f, 0.2f);
//		cone.setAppearance(app);
//		objSpin.addChild(cone);

//		Box box = new Box(0.2f, 0.2f, 0.2f, app);
//		box.setAppearance(app);
//		objSpin.addChild(box);

//		Cylinder cylinder = new Cylinder(0.2f, 0.2f);
//		cylinder.setAppearance(app);
//		objSpin.addChild(cylinder);


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


  // primitive points, lines, triangles, etc.
  BranchGroup createSG2() {

    BranchGroup axisBG = new BranchGroup();

    //2. Create two points, may not be obviously visible
    PointArray points =
        new PointArray(2, PointArray.COORDINATES);
    axisBG.addChild(new Shape3D(points));

    points.setCoordinate(0, new Point3f(.5f, .5f, 0));
    points.setCoordinate(1, new Point3f(-.5f, -.5f, 0));

    //3. Create line for X axis
    LineArray xLine =
        new LineArray(2, LineArray.COORDINATES
                      |LineArray.COLOR_3);
    axisBG.addChild(new Shape3D(xLine));

    xLine.setCoordinate(0, new Point3f(-1.0f, 0.0f, 0.0f));
    xLine.setCoordinate(1, new Point3f(1.0f, 0.0f, 0.0f));
    xLine.setColor(0, red);
    xLine.setColor(1, green);

    //4. Create line for Y axis
    LineArray yLine =
        new LineArray(2, LineArray.COORDINATES
                      |LineArray.COLOR_3);
    axisBG.addChild(new Shape3D(yLine));

    yLine.setCoordinate(0, new Point3f(0.0f, -1.0f, 0.0f));
    yLine.setCoordinate(1, new Point3f(0.0f, 1.0f, 0.0f));
    yLine.setColor(0, white);
    yLine.setColor(1, blue);

    //5. Create a triangle
    TriangleArray triangle =
        new TriangleArray(3, TriangleArray.COORDINATES
                          |TriangleArray.COLOR_3);
    axisBG.addChild(new Shape3D(triangle));

    triangle.setCoordinate(0, new Point3f(-.9f, .1f, -.5f));
    triangle.setCoordinate(1, new Point3f(-.1f, .1f, .0f));
    triangle.setCoordinate(2, new Point3f(-.1f, .7f, .5f));

    triangle.setColor(0, red);
    triangle.setColor(1, green);
    triangle.setColor(2, blue);

    return axisBG;
  }


  public static void main(String[] args) {

    Java3D_5_Primitives frame = new Java3D_5_Primitives();
    frame.setSize(999, 999);
    frame.setVisible(true);
  }
}
