package assignment;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.GLProfile;
import javax.media.opengl.awt.GLCanvas;
import javax.media.opengl.glu.GLU;
import javax.swing.JFrame;

import com.sun.opengl.util.Animator;
import com.sun.opengl.util.FPSAnimator;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

/** Port of the NeHe OpenGL Tutorial (Lesson 6)
 * to Java using the Jogl interface to OpenGL.  Jogl can be obtained
 * at http://jogl.dev.java.net/
 *
 * @author Kevin Duling (jattier@hotmail.com)
 * @author Simon McLoughlin
 */
class TextureExample implements GLEventListener {
	GLProfile glp;
	GLCapabilities caps;
	GLCanvas canvas;
	
	
	private float xrot;        // X Rotation ( NEW )
    private float yrot;        // Y Rotation ( NEW )
    private float zrot;        // Z Rotation ( NEW )
    //going to use this to identify a texture, 
    //if we had more than one texture we would have some more variables here
    private int wood_tex;		
    TextureReader.Texture texture = null;

    private GLU glu = new GLU();
    
    public TextureExample()
	{
		glp = GLProfile.getDefault();
        caps = new GLCapabilities(glp);
        caps.setDoubleBuffered(true);
        canvas = new GLCanvas(caps);
        glu = new GLU();
        
        JFrame frame = new JFrame("Texture Example");
        frame.setSize(300, 300);
        frame.add(canvas);
        frame.setVisible(true);

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        canvas.addGLEventListener(this);
        canvas.requestFocus();
        Animator animator = new FPSAnimator(canvas,60);
        animator.add(canvas);
        animator.start();
		
	}
    
    public static void main(String[] args) {
		
		TextureExample tex = new TextureExample();
        
    }

    

    /** Called by the drawable to initiate OpenGL rendering by the client.
     * After all GLEventListeners have been notified of a display event, the
     * drawable will swap its buffers if necessary.
     * @param gLDrawable The GLAutoDrawable object.
     */
    public void display(GLAutoDrawable gLDrawable) {
        final GL2 gl = gLDrawable.getGL().getGL2();
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);
        
        gl.glLoadIdentity();  // Reset The View
        gl.glTranslatef(0.0f, 0.0f, -5.0f);
        gl.glRotatef(xrot, 1.0f, 0.0f, 0.0f);
        gl.glRotatef(yrot, 0.0f, 1.0f, 0.0f);
        gl.glRotatef(zrot, 0.0f, 0.0f, 1.0f);
        
        //we must inform openGL that this texture should become the current texture
    	//so subsequent texture functions will apply it, like the ones below
        gl.glBindTexture(GL.GL_TEXTURE_2D, wood_tex);
        
        //render the cube with texture mapping
        //note we use the function glTexCoord2f to map a position in texture space
        //to a vertex on the object
        gl.glBegin(GL2.GL_QUADS);
        // Front Face
        gl.glTexCoord2f(0.0f, 0.0f); //this texture point will be mapped to the vertex below it
        gl.glVertex3f(-1.0f, -1.0f, 1.0f);
        gl.glTexCoord2f(1.0f, 0.0f);
        gl.glVertex3f(1.0f, -1.0f, 1.0f);
        gl.glTexCoord2f(1.0f, 1.0f);
        gl.glVertex3f(1.0f, 1.0f, 1.0f);
        gl.glTexCoord2f(0.0f, 1.0f);
        gl.glVertex3f(-1.0f, 1.0f, 1.0f);
        // Back Face
        gl.glTexCoord2f(1.0f, 0.0f);
        gl.glVertex3f(-1.0f, -1.0f, -1.0f);
        gl.glTexCoord2f(1.0f, 1.0f);
        gl.glVertex3f(-1.0f, 1.0f, -1.0f);
        gl.glTexCoord2f(0.0f, 1.0f);
        gl.glVertex3f(1.0f, 1.0f, -1.0f);
        gl.glTexCoord2f(0.0f, 0.0f);
        gl.glVertex3f(1.0f, -1.0f, -1.0f);
        // Top Face
        gl.glTexCoord2f(0.0f, 1.0f);
        gl.glVertex3f(-1.0f, 1.0f, -1.0f);
        gl.glTexCoord2f(0.0f, 0.0f);
        gl.glVertex3f(-1.0f, 1.0f, 1.0f);
        gl.glTexCoord2f(1.0f, 0.0f);
        gl.glVertex3f(1.0f, 1.0f, 1.0f);
        gl.glTexCoord2f(1.0f, 1.0f);
        gl.glVertex3f(1.0f, 1.0f, -1.0f);
        // Bottom Face
        gl.glTexCoord2f(1.0f, 1.0f);
        gl.glVertex3f(-1.0f, -1.0f, -1.0f);
        gl.glTexCoord2f(0.0f, 1.0f);
        gl.glVertex3f(1.0f, -1.0f, -1.0f);
        gl.glTexCoord2f(0.0f, 0.0f);
        gl.glVertex3f(1.0f, -1.0f, 1.0f);
        gl.glTexCoord2f(1.0f, 0.0f);
        gl.glVertex3f(-1.0f, -1.0f, 1.0f);
        // Right face
        gl.glTexCoord2f(1.0f, 0.0f);
        gl.glVertex3f(1.0f, -1.0f, -1.0f);
        gl.glTexCoord2f(1.0f, 1.0f);
        gl.glVertex3f(1.0f, 1.0f, -1.0f);
        gl.glTexCoord2f(0.0f, 1.0f);
        gl.glVertex3f(1.0f, 1.0f, 1.0f);
        gl.glTexCoord2f(0.0f, 0.0f);
        gl.glVertex3f(1.0f, -1.0f, 1.0f);
        // Left Face
        gl.glTexCoord2f(0.0f, 0.0f);
        gl.glVertex3f(-1.0f, -1.0f, -1.0f);
        gl.glTexCoord2f(1.0f, 0.0f);
        gl.glVertex3f(-1.0f, -1.0f, 1.0f);
        gl.glTexCoord2f(1.0f, 1.0f);
        gl.glVertex3f(-1.0f, 1.0f, 1.0f);
        gl.glTexCoord2f(0.0f, 1.0f);
        gl.glVertex3f(-1.0f, 1.0f, -1.0f);
        gl.glEnd();

        xrot += 0.3f;
        yrot += 0.2f;
        zrot += 0.4f;
    }

    /** Called by the drawable immediately after the OpenGL context is
     * initialized for the first time. Can be used to perform one-time OpenGL
     * initialization such as setup of lights and display lists.
     * @param gLDrawable The GLAutoDrawable object.
     */
    public void init(GLAutoDrawable gLDrawable) {
        final GL2 gl = gLDrawable.getGL().getGL2();
        gl.glShadeModel(GL2.GL_SMOOTH);              // Enable Smooth Shading
        gl.glClearColor(0.0f, 0.0f, 0.0f, 0.5f);    // Black Background
        gl.glClearDepth(1.0f);                      // Depth Buffer Setup
        gl.glEnable(GL.GL_DEPTH_TEST);              // Enables Depth Testing
        gl.glDepthFunc(GL.GL_LEQUAL);               // The Type Of Depth Testing To Do 
        gl.glEnable(GL.GL_TEXTURE_2D);
        //here we are calling a function defined below to load in the image and return
        //a texture id that we can use with glBindTexture (see display)
        wood_tex = loadTexture("door1.png",gl);
    }

    /** Called by the drawable during the first repaint after the component has
     * been resized. The client can update the viewport and view volume of the
     * window appropriately, for example by a call to
     * GL.glViewport(int, int, int, int); note that for convenience the component
     * has already called GL.glViewport(int, int, int, int)(x, y, width, height)
     * when this method is called, so the client may not have to do anything in
     * this method.
     * @param gLDrawable The GLAutoDrawable object.
     * @param x The X Coordinate of the viewport rectangle.
     * @param y The Y coordinate of the viewport rectanble.
     * @param width The new width of the window.
     * @param height The new height of the window.
     */
    public void reshape(GLAutoDrawable gLDrawable, int x, int y, int width, 
            int height) {
        final GL2 gl = gLDrawable.getGL().getGL2();

        if (height <= 0) // avoid a divide by zero error!
            height = 1;
        final float h = (float) width / (float) height;
        gl.glViewport(0, 0, width, height);
        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluPerspective(45.0f, h, 1.0, 20.0);
        gl.glMatrixMode(GL2.GL_MODELVIEW);
        gl.glLoadIdentity();
    }

    private void makeRGBTexture(GL gl, GLU glu, TextureReader.Texture img, 
            int target, boolean mipmapped) {
    	
    	//the function glTexImage2D (below) loads the texture into video memory, once loaded we can free
    	//the image memory (in java the garbage collector will do this).
    	//Parameter 1:	GL_TEXTURE_2D -> inform openGL the texture is a 2D texture
    	//Parameter 2:	0-> Should remain 0 for us, used for building texture maps of different sizes
    	//				0 means just use the texture map in its current form
    	//Parameter 3:	GL_RGB->inform openGL the image is an RGB image (could also be GL_LUMINANCE)
    	//Parameter 4:	im_size-> user defined variable that defines the number of rows in the texture
    	//Parameter 5:	im_size-> user defined variable that defines the number of columns in the texture
    	//Parameter 6:	0-> sets the border of the texture (0 indicates no border)
    	//Parameter 7:	GL_RGB-> Specifies the type of texels to be used
    	//Parameter 8:	GL_UNSIGNED_BYTE-> Identifies the size the texels to be used 
    	//				GL_UNSIGNED_BYTE means 1 byte for each colour channel or 24 bit colour texels
    	//Parameter 9:	image-> the actual raw image pixel values to become texel values
        
        if (mipmapped) {
            glu.gluBuild2DMipmaps(target, GL.GL_RGB8, img.getWidth(), 
                    img.getHeight(), GL.GL_RGB, GL.GL_UNSIGNED_BYTE, img.getPixels());
        } else {
            gl.glTexImage2D(target, 0, GL.GL_RGB, img.getWidth(), 
                    img.getHeight(), 0, GL.GL_RGB, GL.GL_UNSIGNED_BYTE, img.getPixels());
        }
    }

    private int genTexture(GL gl) {
        final int[] tmp = new int[1];
        //glGenTextures generates an unused integer id for the texture were about
    	//to create, we can use this to reference the texture in future
        gl.glGenTextures(1, tmp, 0);
        return tmp[0];
    }
    
    private int loadTexture(String filename, GL gl)
    {
    	int tex_id = genTexture(gl);//create an unused id for the texture
    	//we must inform openGL that this texture should become the current texture
    	//so subsequent texture functions will apply it, like the ones below
        gl.glBindTexture(GL.GL_TEXTURE_2D, tex_id);
        //read in the image
        try {
            texture = TextureReader.readTexture(filename);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        //make an openGL texture from the image
        makeRGBTexture(gl, glu, texture, GL.GL_TEXTURE_2D, false);
        /*glTexParameteri is used to set various propertiers of the texturing procedure
    	all texture properties are set by glTexParameteri
        
        Each pixel in the rendered image corresponds to a small area on the surface of an object and
    	hence a small area of the texture map. If the object is far away from the viewer a single pixel
    	may be representative of a number of texels. If the object is close to the viewer a single texel 
    	may be representative of a number of pixels. This is called minification and magnification.
    	So openGL must either take the large area of the texture map and squash it into the smaller pixel
    	area or take the small texel area and magnify it so it fits into the larger pixel area.
    	The following function calls tell openGL how to do this
    	
    	GL_NEAREST and GL_LINEAR are two techniqes used for magnification/minification.
    	GL_NEAREST is faster but GL_LINEAR normally yields better results*/
        
        gl.glTexParameteri(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MIN_FILTER, GL.GL_LINEAR);
        gl.glTexParameteri(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MAG_FILTER, GL.GL_LINEAR);
        
        /* when using the 2D texture defined above, if the s texture coordinate goes outside of the
    	texture range (0->1) then clamp it, that is if its greater than 1 set it to one
    	if it is less than zeros set it to zero. Other option-> GL_REPEAT repeats the texure again
    	outside of the map bounds (0->1)*/

    	gl.glTexParameteri(GL.GL_TEXTURE_2D,GL.GL_TEXTURE_WRAP_S, GL2.GL_CLAMP);
    	//same goes for the t texture coordinate
    	gl.glTexParameteri(GL.GL_TEXTURE_2D,GL.GL_TEXTURE_WRAP_T, GL2.GL_CLAMP);
        return tex_id;
    	
    }


	@Override
	public void dispose(GLAutoDrawable arg0) {
		// TODO Auto-generated method stub
		
	}
}
