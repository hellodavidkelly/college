/* 1/10/2008: a stochastic ray tracing compared to a simple ray tracing */
import javax.media.opengl.*;

public class J3_12_SrayTracing extends J3_11_rayTracing {

	public void display(GLAutoDrawable glDrawable) {
		double[] viewpt = new double[3], raypt = new double[3];
		// initial ray: viewpt -> raypt

		double[] color = new double[3]; // traced color
		double[] icolor = new double[3]; // traced color
		
				
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
				lightSrc[i][j] = - 2*WIDTH + 4*WIDTH * Math.random();
			}
		}

		// starting viewpoint on positive z axis
		viewpt[0] = 0;
		viewpt[1] = 0;
		viewpt[2] = 1.5*HEIGHT;

		// trace rays against the spheres and a plane
		for (double y = -HEIGHT/2; y < HEIGHT/2; y++) {
			for (double x = -WIDTH/2; x<WIDTH/2; x++) {

				// ray from viewpoint to a pixel on the screen
				// tracing the ray (viewpt to raypt) for depth bounces
				raypt[0] = x;
				raypt[1] = y;
				raypt[2] = 0;
				rayTracing(icolor, viewpt, raypt, depth);
				gl.glColor3dv(icolor, 0);
				//gl.glViewport(0, 0, WIDTH, HEIGHT); 
				//drawPoint(x, y);

				// stochastic raytracing 
				for (int i=0; i<20; i++) { 
					raypt[0] = x - 0.25 + Math.random()/2;
					raypt[1] = y - 0.25 + Math.random()/2;
					raypt[2] = 0;
					rayTracing(icolor, viewpt, raypt, depth);

					for (int j=0; j<3; j++) {
						color[j] = color[j] + icolor[j]; 
					}
				}
				for (int j=0; j<3; j++) {
					color[j] = color[j]/20; 
				}
				gl.glColor3dv(color, 0);
				gl.glViewport(0, 0, WIDTH, HEIGHT); 
				drawPoint(x, y);
			}
		}
	}


	public static void main(String[] args) {
		J3_12_SrayTracing f = new J3_12_SrayTracing();

		f.setTitle("JOGL J3_11_SrayTracing");
		f.setSize(2*WIDTH, HEIGHT);
		f.setVisible(true);
	}
}
