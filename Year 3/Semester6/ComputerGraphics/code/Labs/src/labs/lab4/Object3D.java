package lab4;

import java.awt.Frame;
import java.awt.event.*;

import javax.media.opengl.*;
import javax.media.opengl.awt.*;
import javax.media.opengl.glu.*;
import javax.media.opengl.glu.gl2.*;
import javax.media.opengl.fixedfunc.*;

import com.sun.opengl.util.*;
import com.sun.opengl.util.gl2.*;



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
        frame.setSize(600, 600);
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
		GLUT glut = new GLUT();
		gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
			
		
		/////////////////////////////////////View modes
		/*
		//make sure we are in model_view mode
		//For rotating house with STATIC CAMERA!!
		gl.glMatrixMode(GL2.GL_MODELVIEW);
		gl.glLoadIdentity();
		*/
			
		//make sure we are in Projection mode
		//For rotating camera around Y AXIS!!
		gl.glMatrixMode(GL2.GL_PROJECTION);
		gl.glLoadIdentity();
		//gl.glOrtho(-10, 10, -10, 15, 5, 40);
        glu.gluPerspective(80.0f, 1, 1.0, 40.0);	
  		
		///////////////////////////////////////End view modes
		
		/**
		 * Rotating Camera around Y axis while in MODELVIEW mode doesn't work
		 */
		//////////////////////////////////////Camera
		
        //Rotates the camera around the Y axis
		int d=25;
        xCamera = d*Math.sin(Math.toRadians(r));
        zCamera = d*Math.cos(Math.toRadians(r));
        r+=.5;
		glu.gluLookAt(xCamera,15,zCamera,0,2,0,0, 20, 0);
		update(gl);
		
		/*
		//Set up static camera
		glu.gluLookAt(-15,15,20,0,2,0,0, 1, 0);
		update(gl);
		*/
		//////////////////////////////////////End Camera

    	//render ground plane
    	gl.glColor3f(1, 1, 1);
		
    	
    	
		//////////////////////////////////////Render the sphere with edges
		//gl.glShadeModel(gl.GL_FLAT);
		
		//Render the sphere smooth
		gl.glShadeModel(gl.GL_SMOOTH);
		
		//Setting the width of the cone for specular reflection n=width of cone
		float [] n = {1.0f,1.0f,1.0f,1.0f};
		
		//needs to be commented in or out
		//With specular lighting
		gl.glMaterialfv(gl.GL_FRONT_AND_BACK,gl.GL_SPECULAR,n,0);
		gl.glMaterialf(gl.GL_FRONT_AND_BACK,gl.GL_SHININESS,100);
		glut.glutSolidSphere(15,20,20);
		
		
		//Without specular lighting
		glut.glutSolidSphere(15,20,20);
		//////////////////////////////////////End sphere with edges
		
		
		/*
		
    	//Create Polygon House
		gl.glBegin(GL2.GL_POLYGON);
			//Gable End positive x
			gl.glNormal3f(1, 0, 0);
			gl.glVertex3f(8, 0, 4);
			gl.glVertex3f(8, 0, -4);
			gl.glVertex3f(8, 10, -4);
			gl.glVertex3f(8, 14, 0);
			gl.glVertex3f(8, 10, 4);
		gl.glEnd();	
		
		gl.glBegin(GL2.GL_POLYGON);
			//Gable End negative x
			gl.glNormal3f(-1, 0, 0);
			gl.glVertex3f(-8, 0, 4);
			gl.glVertex3f(-8, 10, 4);
			gl.glVertex3f(-8, 14, 0);
			gl.glVertex3f(-8, 10, -4);
			gl.glVertex3f(-8, 0, -4);
		gl.glEnd();
	
		gl.glBegin(GL2.GL_POLYGON);
			//Side of house positive z
			gl.glNormal3f(0, 0, 1);
			gl.glVertex3f(-8, 0, 4);
			gl.glVertex3f(8, 0, 4);
			gl.glVertex3f(8, 10, 4);
			gl.glVertex3f(-8, 10, 4);
		gl.glEnd();
	
		gl.glBegin(GL2.GL_POLYGON);
			//Side of house negative z
			gl.glNormal3f(0, 0, -1);
			gl.glVertex3f(8, 0, -4);
			gl.glVertex3f(-8, 0, -4);
			gl.glVertex3f(-8, 10, -4);
			gl.glVertex3f(8, 10, -4);
		gl.glEnd();
	
		gl.glBegin(GL2.GL_POLYGON);
			//Bottom of house bottom
			gl.glNormal3f(0, -1, 0);
			gl.glVertex3f(8, 0, 4);
			gl.glVertex3f(-8, 0, 4);
			gl.glVertex3f(-8, 0, -4);
			gl.glVertex3f(8, 0, -4);
		gl.glEnd();
		
		gl.glBegin(GL2.GL_POLYGON);
			//Roof of house positive
			gl.glNormal3f(0, 8, 8);
			gl.glVertex3f(8, 10, 4);
			gl.glVertex3f(8, 14, 0);
			gl.glVertex3f(-8, 14, 0);
			gl.glVertex3f(-8, 10, 4);
		gl.glEnd();
		
		gl.glBegin(GL2.GL_POLYGON);
			//Roof of house negative
			gl.glNormal3f(0, 8, -6);
			gl.glVertex3f(-8, 10, -4);
			gl.glVertex3f(-8, 14, 0);
			gl.glVertex3f(8, 14, 0);
			gl.glVertex3f(8, 10, -4);
		gl.glEnd();
		//End polygon house creation
			*/
	}

	@Override
	public void dispose(GLAutoDrawable drawable) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(GLAutoDrawable drawable) {	
		GL2 gl = drawable.getGL().getGL2();
		
		gl.glEnable(GL.GL_CULL_FACE); 
		gl.glCullFace(GL.GL_BACK); 
		gl.glEnable(GL.GL_DEPTH_TEST);
		
		gl.glEnable(gl.GL_LIGHTING);
		gl.glEnable(gl.GL_LIGHT0);
		float [] whiteLight = {1, 1, 1, 1};
		float [] ambientLight = {0.1f, 0.1f, 0.1f, 1.0f}; 
		gl.glLightfv(gl.GL_LIGHT0, gl.GL_DIFFUSE, whiteLight, 0); 
		gl.glLightfv(gl.GL_LIGHT0, gl.GL_SPECULAR, whiteLight, 0); 
		gl.glLightfv(gl.GL_LIGHT0, gl.GL_AMBIENT, ambientLight, 0);
		float [] lightPosition = {25, 25, 25,1}; 
		gl.glLightfv(gl.GL_LIGHT0, gl.GL_POSITION, lightPosition, 0);
		
		/*
		//Second Light to illuminate negative side of house
		gl.glEnable(gl.GL_LIGHT1);
		gl.glLightfv(gl.GL_LIGHT1, gl.GL_DIFFUSE, whiteLight, 0); 
		gl.glLightfv(gl.GL_LIGHT1, gl.GL_SPECULAR, whiteLight, 0); 
		gl.glLightfv(gl.GL_LIGHT1, gl.GL_AMBIENT, ambientLight, 0);
		float [] lightPosition1 = {-25, -25, -25,1}; 
		gl.glLightfv(gl.GL_LIGHT1, gl.GL_POSITION, lightPosition1, 0);		
		*/
		
		float [] diffuse_mp = {0.0f,0.0f,1.0f,1.0f};//red 
		gl.glMaterialfv(gl.GL_FRONT_AND_BACK, gl.GL_DIFFUSE, diffuse_mp,0);		
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