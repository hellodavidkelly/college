package assignment;

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
import com.sun.opengl.util.gl2.GLUT;


public class Object3DPushPop implements GLEventListener, KeyListener {
	
	GLProfile glp;
	GLCapabilities caps;
	GLCanvas canvas;
	GLU glu;
	GLUT glut;
	
	double theta = 0;
	
	public Object3DPushPop()
	{
		glp = GLProfile.getDefault();
        caps = new GLCapabilities(glp);
        caps.setDoubleBuffered(true);
        canvas = new GLCanvas(caps);
        glu = new GLU();
        glut = new GLUT();
        
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
		
		Object3DPushPop obj3d = new Object3DPushPop();
        
    }

	@Override
	public void display(GLAutoDrawable drawable) {
		GL2 gl = drawable.getGL().getGL2();	
		GLU glu = new GLU();
		gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
		
		gl.glMatrixMode(gl.GL_MODELVIEW);
		gl.glLoadIdentity();
		//position viewer
		glu.gluLookAt(15,15,15,0,0,0,0, 1, 0);
		
    	//we just want to rotate the cylinder so we use push and pop matrix
		//we push the current modelview matrix and pop it after we have transformed
		//and rendered the cylinder
    	gl.glPushMatrix();
		gl.glTranslatef(0, 4, 0);
		gl.glRotated(theta, 0.0, 1.0, 0.0);
		gl.glRotated(90.0, -1.0, 0.0, 0.0);
		//render cylinder
		gl.glColor3f(1, 0, 0);
		GLUquadric qobj0 = glu.gluNewQuadric();
		glu.gluQuadricDrawStyle( qobj0, GLU.GLU_LINE );
		glu.gluCylinder( qobj0, 2.0f, 2.0f, 4.0f,10, 10 );
		gl.glPopMatrix();
		
    	//render teapot
    	gl.glColor3f(1, 1, 1);
		glut.glutWireTeapot(5.0);
	
		theta+=0.1;
		
	}

	@Override
	public void dispose(GLAutoDrawable drawable) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(GLAutoDrawable drawable) {	
		
		GL2 gl = drawable.getGL().getGL2();
		gl.glEnable(GL.GL_DEPTH_TEST);
		
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
        gl.glMatrixMode(gl.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluPerspective(45.0f, aspect, 1.0, 30.0);
        
        
		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
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