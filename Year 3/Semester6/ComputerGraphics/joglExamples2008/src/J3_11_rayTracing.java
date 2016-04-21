/* 1/10/2008: a ray tracing example */
import javax.media.opengl.*;

public class J3_11_rayTracing extends J3_10_Lights {

	double[][] sphere = new double[4][4]; // 4 spheres with radius and center
	static int ns = 3; // number of spheres

	double[][] lightSrc = new double[3][3]; // 3 light sources
	static int nl = 3; // number of light sources

	static int depth = 5; // depth of ray tracing recursion
	static int yplane = -HEIGHT / 8; // a reflective plane

	public void reshape(GLAutoDrawable glDrawable, int x, int y, int w, int h) {

		gl.glMatrixMode(GL.GL_PROJECTION);
		gl.glLoadIdentity();

		gl.glOrtho(-WIDTH / 2, WIDTH / 2, -HEIGHT / 2, HEIGHT / 2, -4 * HEIGHT,
				4 * HEIGHT);

		gl.glDisable(GL.GL_LIGHTING); // calculate color by ray tracing
	}

	public void display(GLAutoDrawable glDrawable) {
		double[] viewpt = new double[3], raypt = new double[3];
		// initial ray: viewpt -> raypt

		double[] color = new double[3]; // traced color

		// initialize 'ns' number of spheres
		for (int i = 0; i < ns; i++) {
			sphere[i][0] = 10 + WIDTH * Math.random() / 10; // radius
			for (int j = 1; j < 4; j++) { // center
				sphere[i][j] = -WIDTH / 4 + WIDTH * Math.random() / 2; 
			}
		}

		// initialize 'nl' light source locations
		for (int i = 0; i < nl; i++) {
			for (int j = 0; j < 3; j++) { // light source positions
				lightSrc[i][j] = -8 * WIDTH + 40 * WIDTH * Math.random();
			}
		}

		// starting viewpoint on positive z axis
		viewpt[0] = 0;
		viewpt[1] = 0;
		viewpt[2] = 1.5*HEIGHT;

		// trace rays against the spheres and a plane
		for (double y = -HEIGHT / 2; y < HEIGHT / 2; y++) {
			for (double x = -WIDTH / 2; x < WIDTH / 2; x++) {

				// ray from viewpoint to a pixel on the screen
				raypt[0] = x;
				raypt[1] = y;
				raypt[2] = 0;

				// tracing the ray (viewpt to raypt) for depth bounces
				rayTracing(color, viewpt, raypt, depth);
				gl.glColor3dv(color, 0);
				drawPoint(x, y);
			}
		}
	}

	
	// recursive rayTracing from vpt to rpt for depth bounces, finding final color
	public void rayTracing(double[] color, double[] vpt, double[] rpt, int depth) {

		double[] reflectClr = new double[3], transmitClr = new double[3];
		double[] rpoint = new double[3]; // a point on ray direction
		double[] rD = new double[3]; // ray direction
		double[] vD = new double[3]; // view direction
		double[] n = new double[3]; // normal
		double[] p = new double[3]; // intersection point

		for (int i = 0; i < 3; i++) {
			color[i] = 0;
		}

		if (depth != 0) {// calculate color

			// find intersection of ray from vpt to rpt
			// with the closest object or the background
			intersect(vpt, rpt, p, n); // intersect at p with normal n

			// calculate lighting of the intersection point
			if (n[0] * n[0] + n[1] * n[1] + n[2] * n[2] > 0.001) {

				// view direction vector for lighting and reflection
				for (int i = 0; i < 3; i++) {
					vD[i] = vpt[i] - rpt[i];
				}

				normalize(n);
				normalize(vD);

				// calculate color using Phong shading
				phong(color, p, vD, n);

				// reflected ray
				reflect(vD, n, rD);

				for (int i = 0; i < 3; i++) {
					// a point on the reflected ray starting from p
					rpoint[i] = rD[i] + p[i];
				}
				
				// recursion to find a bounce at lower level
				rayTracing(reflectClr, p, rpoint, depth - 1);
				//rayTracing(transmitClr, p, rpoint, depth - 1);
				for (int i = 0; i < 3; i++) {
					color[i] = (color[i] + 0.9 * reflectClr[i]);
					if (color[i] > 1) //color values are not normalized. 
						color[i] = 1; 
				}
			}
		}
	}

	public void phong(double[] color, double[] point, double[] vD, double[] n) {
		double[] s = new double[3]; // light source direction + view direction
		double[] lgtsd = new double[3]; // light source direction
		double[] inormal = new double[3]; // for shadow
		double[] ipoint = new double[3]; // for shadow

		for (int i = 0; i < nl; i++) {

			// if intersect objects between light source, point in shadow
			intersect(point, lightSrc[i], ipoint, inormal);

			if (inormal[0] * inormal[0] + inormal[1] * inormal[1] + inormal[2]
					* inormal[2] < 0.001) { // point not in shadow

				for (int j = 0; j < 3; j++) {
					lgtsd[j] = lightSrc[i][j] - point[j];
					// light source direction
				}
				normalize(lgtsd);
				for (int j = 0; j < 3; j++) {
					s[j] = lgtsd[j] + vD[j]; // for specular term
				}
				normalize(s);

				double diffuse = dotprod(lgtsd, n);
				double specular = Math.pow(dotprod(s, n), 100);

				if (diffuse < 0)
					diffuse = 0;
				if (specular < 0)
					specular = 0;
				// 3 color channels correspond to 3 light sources 
				color[i] = 0.5 * diffuse + 0.7 * specular;
			}
		//	color[1] = color[2] = color[0]; 
		}
	}

	public void intersect(double[] vpt, double[] rpt, double[] point,
			double[] normal) {

		// calculate intersection of ray with the closest sphere
		// Ray equation:
		// x/y/z = vpt + t*(rpt - vpt);
		// Sphere equation:
		// (x-cx)^2 + (y-cy)^2 + (z-cz)^2 = r^2;
		// We can solve quadratic formula for t and find the intersection
		// t has to be > 0 to intersect with an object
		double t = 0;
		double a, b, c, d, e, f; // temp for solving the intersection

		normal[0] = 0;
		normal[1] = 0;
		normal[2] = 0;

		for (int i = 0; i < ns; i++) {
			a = vpt[0] - sphere[i][1];
			b = rpt[0] - vpt[0];
			c = vpt[1] - sphere[i][2];
			d = rpt[1] - vpt[1];
			e = vpt[2] - sphere[i][3];
			f = rpt[2] - vpt[2];

			double A = b * b + d * d + f * f;
			double B = 2 * (a * b + c * d + e * f);
			double C = a * a + c * c + e * e - sphere[i][0] * sphere[i][0];

			double answers[] = new double[2];

			if (quadraticFormula(A,B,C,answers)) {// intersection
				if (answers[0] < answers[1])
					t = answers[0];
				else t = answers[1]; 
				if (t < 0.001) {
					t = 0; 
					break;
				}
				else {
					// return point and normal
					point[0] = vpt[0] + t * (rpt[0] - vpt[0]);
					point[1] = vpt[1] + t * (rpt[1] - vpt[1]);
					point[2] = vpt[2] + t * (rpt[2] - vpt[2]);
					normal[0] = point[0] - sphere[i][1];
					normal[1] = point[1] - sphere[i][2];
					normal[2] = point[2] - sphere[i][3];
				}
			}
		}
		// calculate ray intersect with plane y = yplane
		// y = vpt + t(rpt - vpt) = yplane; => t = (yplane - vpt)/(rpt -vpt);

		double tmp = (yplane - vpt[1]) / (rpt[1] - vpt[1]);
		double[] ipoint = new double[3]; // for shadow
		if ((tmp > 0.001) && (tmp < t || t == 0)) {
			t = tmp;
			ipoint[0] = vpt[0] + t * (rpt[0] - vpt[0]);
			ipoint[1] = yplane;
			ipoint[2] = vpt[2] + t * (rpt[2] - vpt[2]);
			// if x&z in the rectangle, intersect with plane
			if ((ipoint[0] > -HEIGHT / 2) && (ipoint[0] < HEIGHT / 2)
					&& (ipoint[2] > -HEIGHT / 2) && (ipoint[2] < HEIGHT / 2)
					&& t > 0) {
				// plane normal
				point[0] = ipoint[0];
				point[1] = ipoint[1];
				point[2] = ipoint[2];
				normal[0] = 0;
				normal[1] = 1;
				normal[2] = 0;
			}
		}
		
		
		// calculate ray intersect with zplane = yplane*8
		// z = vpt + t(rpt - vpt) = zplane; => t = (zplane - vpt)/(rpt -vpt);
		tmp = (yplane*8 - vpt[2]) / (rpt[2] - vpt[2]);
		if ((tmp > 0.001) && (tmp < t || t == 0)) {
			t = tmp;
			ipoint[0] = vpt[0] + t * (rpt[0] - vpt[0]);
			ipoint[2] = yplane*8;
			ipoint[1] = vpt[1] + t * (rpt[1] - vpt[1]);
			// if x&z in the rectangle, intersect with plane
			if ((ipoint[0] > -HEIGHT / 2) && (ipoint[0] < HEIGHT / 2)
					&& (ipoint[1] > -HEIGHT / 2) && (ipoint[1] < HEIGHT / 2)
					&& t > 0) {
				// plane normal
				point[0] = ipoint[0];
				point[1] = ipoint[1];
				point[2] = ipoint[2];
				normal[0] = 0;
				normal[1] = 0;
				normal[2] = 1;
			}
		}
	}

	public static void main(String[] args) {
		J3_11_rayTracing f = new J3_11_rayTracing();

		f.setTitle("JOGL J3_11_rayTracing");
		f.setSize(WIDTH, HEIGHT);
		f.setVisible(true);
	}
}
