package lab3;


import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.media.opengl.*;
import javax.media.opengl.awt.GLCanvas;
import javax.media.opengl.glu.*;


import com.sun.opengl.util.Animator;
import com.sun.opengl.util.FPSAnimator;


public class Object3D implements GLEventListener, KeyListener {
	
	GLProfile glp;
	GLCapabilities caps;
	GLCanvas canvas;
	GLU glu;
	boolean rotating = false;
	boolean scaling = false;
	boolean translate = false;
    double xCamera;
    double zCamera;
    double r=0;
	
	public Object3D()
	{
		glp = GLProfile.getDefault();
        caps = new GLCapabilities(glp);
        canvas = new GLCanvas(caps);
        glu = new GLU();
        
        Frame frame = new Frame("AWT Window Test");
        frame.setSize(300, 300);
        frame.add(canvas);
        frame.setVisible(true);

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        canvas.addGLEventListener(this);
        canvas.addKeyListener(this);
        canvas.requestFocus();
        Animator animator = new FPSAnimator(canvas,60);
        animator.add(canvas);
        animator.start();
		
	}
	
	public static void main(String[] args) {
		
		Object3D obj3d = new Object3D();
    }

	@Override
	public void display(GLAutoDrawable drawable) {
		GL2 gl = drawable.getGL().getGL2();	
		GLU glu = new GLU();
		gl.glClear(GL.GL_COLOR_BUFFER_BIT);

		/*
		//make sure we are in model_view mode
		gl.glMatrixMode(GL2.GL_MODELVIEW);
		gl.glLoadIdentity();
		*/
		
			
		//make sure we are in Projection mode
		gl.glMatrixMode(GL2.GL_PROJECTION);
		gl.glLoadIdentity();
		//gl.glOrtho(-10, 10, -10, 15, 5, 40);
        glu.gluPerspective(80.0f, 1, 1.0, 40.0);	
  		
      
        
		int d=25;
        xCamera = d*Math.sin(Math.toRadians(r));
        zCamera = d*Math.cos(Math.toRadians(r));
        r+=.5;
		glu.gluLookAt(xCamera,15,zCamera,0,2,0,0, 1, 0);
		update(gl);
	
		
		//glu.gluLookAt(15,15,15,0,2,0,0, 1, 0);
		//update(gl);

    	//render ground plane
    	gl.glColor3f(1, 1, 1);
		
		gl.glBegin(GL2.GL_LINE_LOOP);
			gl.glVertex3f(8, 0, 4);
			gl.glVertex3f(8, 0, -4);
			gl.glVertex3f(8, 10, -4);
			gl.glVertex3f(8, 14, 0);
			gl.glVertex3f(8, 10, 4);
		gl.glEnd();	
		
		gl.glBegin(GL2.GL_LINE_LOOP);
			gl.glVertex3f(-8, 0, 4);
			gl.glVertex3f(-8, 10, 4);
			gl.glVertex3f(-8, 14, 0);
			gl.glVertex3f(-8, 10, -4);
			gl.glVertex3f(-8, 0, -4);
		gl.glEnd();
	
		gl.glBegin(GL2.GL_LINE_LOOP);
			gl.glVertex3f(-8, 0, 4);
			gl.glVertex3f(8, 0, 4);
			gl.glVertex3f(8, 10, 4);
			gl.glVertex3f(-8, 10, 4);
		gl.glEnd();
	
		gl.glBegin(GL2.GL_LINE_LOOP);
			gl.glVertex3f(8, 0, -4);
			gl.glVertex3f(-8, 0, -4);
			gl.glVertex3f(-8, 10, -4);
			gl.glVertex3f(8, 10, -4);
		gl.glEnd();
	
		gl.glBegin(GL2.GL_LINE_LOOP);
			gl.glVertex3f(8, 0, 4);
			gl.glVertex3f(-8, 0, 4);
			gl.glVertex3f(-8, 0, -4);
			gl.glVertex3f(8, 0, -4);
		gl.glEnd();
		
		gl.glBegin(GL2.GL_LINE_LOOP);
			gl.glVertex3f(8, 10, 4);
			gl.glVertex3f(8, 14, 0);
			gl.glVertex3f(-8, 14, 0);
			gl.glVertex3f(-8, 10, 4);
		gl.glEnd();
		
		gl.glBegin(GL2.GL_LINE_LOOP);
			gl.glVertex3f(8, 10, -4);
			gl.glVertex3f(8, 14, 0);
			gl.glVertex3f(-8, 14, 0);
			gl.glVertex3f(-8, 10, -4);
		gl.glEnd();
		
		
		//gl.glRotatef(90, -1, 0, 0);
		
		/*
		//render cylinder
		gl.glColor3f(1, 0, 0);
		GLUquadric qobj0 = glu.gluNewQuadric();
		glu.gluQuadricDrawStyle( qobj0, GLU.GLU_LINE );
		glu.gluCylinder( qobj0, 2.0f, 2.0f, 4.0f,10, 10 );
		*/
		
	}

	@Override
	public void dispose(GLAutoDrawable drawable) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(GLAutoDrawable drawable) {	
		
	}

	@Override
	public void reshape(GLAutoDrawable drawable, int x, int y, int width,
			int height) {
		// TODO Auto-generated method stub
		GL2 gl = drawable.getGL().getGL2();
		GLU glu = new GLU();
		
		if (height < 1) { // avoid a divide by zero error!   
            height = 1;
        }
        
		float aspect = (float) width / (float) height;
        gl.glViewport(0, 0, width, height);
       
        //set up the camera
        gl.glMatrixMode(gl.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluPerspective(80.0f, aspect, 1.0, 40.0);	
	}
	
	int x;
	double y=1;
	boolean scaler = true;
	public void update(GL2 gl){	
		if(rotating){
			gl.glRotatef(x, 0, 1, 0);
			x=x+1;
		}
		
		if(scaling){
			gl.glScaled(y, y, y);

			if(y==1){
				scaler = false;
			}
			if(y<=0){
				scaler = true;
			}
			
			if(scaler){
				y=y+.01;
			}
			if(!scaler){
				y=y-.01;
			}
			
		}
		
		if(translate){
			gl.glTranslated(5, 0, 5);
		}
	}
	
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getKeyCode() == KeyEvent.VK_T)
			translate=!translate;
		
		if (arg0.getKeyCode() == KeyEvent.VK_R){
			rotating=!rotating;
		}
		if (arg0.getKeyCode() == KeyEvent.VK_S){
			scaling=!scaling;
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	

}
