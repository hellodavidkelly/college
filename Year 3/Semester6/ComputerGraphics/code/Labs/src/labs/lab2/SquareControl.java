package lab2;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.media.opengl.*;
import javax.media.opengl.awt.GLCanvas;

import com.sun.opengl.util.Animator;
import com.sun.opengl.util.FPSAnimator;

public class SquareControl implements GLEventListener, KeyListener {
	
	Square square = new Square(100,100,200,100,200,200,100,200);
	boolean rotating = false;
	boolean scaling = false;
	boolean enlarge = true;
	double theta = 5;
	double rx, ry;
	double sx = 1.01, sy = 1.01;
	GLProfile glp;
	GLCapabilities caps;
	GLCanvas canvas;
	boolean ch = false;
	
	public SquareControl()
	{
		glp = GLProfile.getDefault();
        	caps = new GLCapabilities(glp);
        	canvas = new GLCanvas(caps);
        
        	Frame frame = new Frame("AWT David Test");
        	frame.setSize(500, 500);
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
		
		SquareControl sqc = new SquareControl();
        
    }
	
	public void update()
	{
		if (rotating){
			square.rotate(theta, square.getCentreX(), square.getCentreY());
		}

		if (scaling)
		{
			square.scale(sx, sy);
			//scale square, but make sure it goes bigger then smaller, then bigger, smaller etc	
			if(square.area()<15000){
				sx=1.01;
				sy=1.01;
				square.scale(sx, sy);
			}
			
			if(square.area()>64999){
				sx=.99;
				sy=.99;
				square.scale(sx, sy);
			}
			
		}
	}

	@Override
	public void display(GLAutoDrawable drawable) {
		update();
		GL2 gl = drawable.getGL().getGL2();
		gl.glClear(GL.GL_COLOR_BUFFER_BIT);
		gl.glColor3f(1, 0, 0);
		gl.glBegin(GL.GL_LINE_LOOP);
        		gl.glVertex2d(square.vertices[0][0], square.vertices[0][1]);
        		gl.glVertex2d(square.vertices[1][0], square.vertices[1][1]);
        		gl.glVertex2d(square.vertices[2][0], square.vertices[2][1]);
        		gl.glVertex2d(square.vertices[3][0], square.vertices[3][1]);
        	gl.glEnd();
	}

	@Override
	public void dispose(GLAutoDrawable drawable) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(GLAutoDrawable drawable) {
		// TODO Auto-generated method stub
		GL2 gl = drawable.getGL().getGL2();
    		gl.glMatrixMode(gl.GL_PROJECTION);
    		gl.glLoadIdentity();
    		gl.glOrtho(0, 300, 0, 300, -1, 1);
    		gl.glViewport(0, 0, 300, 300);
		
	}

	@Override
	public void reshape(GLAutoDrawable drawable, int x, int y, int width,
			int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		
		if (arg0.getKeyCode() == KeyEvent.VK_RIGHT)
			square.translate(10, 0);
		else if (arg0.getKeyCode() == KeyEvent.VK_LEFT)
			square.translate(-10, 0);
		else if (arg0.getKeyCode() == KeyEvent.VK_UP)
			square.translate(0, 10);
		else if (arg0.getKeyCode() == KeyEvent.VK_DOWN)
			square.translate(0, -10);

		//also add code to toggle rotation/scaling
		else if (arg0.getKeyCode() == KeyEvent.VK_R){
			rotating=!rotating;
		}
		else if (arg0.getKeyCode() == KeyEvent.VK_S){
			//square.scale!
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