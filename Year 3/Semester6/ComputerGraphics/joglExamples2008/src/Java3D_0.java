/*
 * Created on 2004-4-20
 * @author Jim X. Chen: draw a cube in Java3D topdown approach
 */
import java.awt.*;
import java.awt.event.*;
import javax.media.j3d.*;
import com.sun.j3d.utils.geometry.ColorCube;
import javax.vecmath.Vector3f;
import com.sun.j3d.utils.universe.*;


public class Java3D_0 extends Frame {

  Java3D_0() {

	//1. Create a drawing area canvas3D
	setLayout(new BorderLayout());
	GraphicsConfiguration gc =
	   SimpleUniverse.getPreferredConfiguration();
	Canvas3D canvas3D = new Canvas3D(gc);
	add(canvas3D);

	// Quite window with disposal
	addWindowListener(new WindowAdapter()
	  {public void windowClosing(WindowEvent e)
		 {dispose(); System.exit(0);}
	  }
	);

	//2. Construct ViewBranch topdown
	BranchGroup viewBG = createVB(canvas3D);

	//3. Construct sceneGraph: a color cube
	BranchGroup objBG = new BranchGroup();
	objBG.addChild(new ColorCube(0.2));

	//4. Go live under locale in the virtualUniverse
	VirtualUniverse universe = new VirtualUniverse();
	Locale locale = new Locale(universe);
	locale.addBranchGraph(viewBG);
	locale.addBranchGraph(objBG);
  }

  BranchGroup createVB(Canvas3D canvas3D) {

	//5. Initialize view branch
	BranchGroup viewBG = new BranchGroup();
	TransformGroup viewTG = new TransformGroup();
	ViewPlatform myViewPlatform = new ViewPlatform();
	viewBG.addChild(viewTG);
	viewTG.addChild(myViewPlatform);

	//6. Move the view branch to view object at origin
	Vector3f transV = new Vector3f(0f, 0f, 2.4f);
	Transform3D translate = new Transform3D();
	translate.setTranslation(transV);
	viewTG.setTransform(translate);

	//7. Construct view for myViewPlatform
	View view = new View();
	view.addCanvas3D(canvas3D);
	view.setPhysicalBody(new PhysicalBody());
	view.setPhysicalEnvironment(new PhysicalEnvironment());
	view.attachViewPlatform(myViewPlatform);

	return (viewBG);
  }


  public static void main(String args[]) {
	Java3D_0 frame = new Java3D_0();
	frame.setSize(999,999);
	frame.setVisible(true);
  }
}
