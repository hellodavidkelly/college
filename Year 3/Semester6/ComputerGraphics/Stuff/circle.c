#include "glut.h"
void display()
{
	int rad, E, v;
	int x,y;
	rad = 100;
	x = 0;
	y = rad;
	E = 0;

	 /* glClear(Glbitfield mask) clears the buffers who’s bits are set in the mask it 	takes as a parameter. GL_COLOR_BUFFER_BIT clears any colors that are in the color 	buffer for the window size specified - default clear color is black */		glClear(GL_COLOR_BUFFER_BIT);

	/* glBegin(Glenum mode) specifies the beginning of an object of type mode. Mode 	types include GL_POINTS, GL_LINES, GL_POLYGON ………*/ 
	glBegin(GL_POINTS); //tell openGL we are plotting points

		//need to draw circle, plot the first point
		glVertex2i(x,y);
		for (x=1; x<=y; x++) {

			//calculate new E value

			E = E + x + x +1;

			//Test E to see if y should be decremented
			
			v = y + y -1;

			if (v < E+E) {

				y--;
				E = E -(y+y) +1;
			}
			
			glVertex2i(x+250,y+250);
			glVertex2i(y+250,x+250);

			//update E if y is decremented

		}

	/* end the object */
	glEnd();

	/* glFlush tells openGL to execute the commands by flushing the frame buffer or 	drawing on the screen */
	glFlush(); //flush the frame buffer 
}

void init()
{
	/* allows to change the color used when clearing the 	color buffer */
	glClearColor(0.0,0.0,0.0,0.0);

	/* allows us to set the present drawing color */
	glColor3f(1.0,1.0,1.0);
	
	/* void glMatrix(Glenum mode) specifies which matrix 	will be affected by subsequent transformations. Mode 	is usually GL_PROJECTION or GL_MODELVIEW */
	glMatrixMode(GL_PROJECTION);

	/* gluOrtho2D(Gldouble left, Gldouble right, Gldouble 	bottom, Gldouble top) Informs openGL how much of the 	object world the user wishes to display - openGL uses 	this to get the scaling correct within the window */

	gluOrtho2D(0,500,0,500);
}

int main(int argc, char** argv)
{
	/* glutInit() initialises glut and should be called 	before any openGL functions */
	glutInit(&argc, argv);

	/*void glutInitDisplayMode (unsigned int mode) - 	Requests a display window with properties in mode. 	Below we say were using RGB coloring and single 	buffering*/
	glutInitDisplayMode(GLUT_SINGLE | GLUT_RGB);

	/*allow us to specify the window size in pixels*/
	glutInitWindowSize(500,500);

	/*specifies the top left hand corner of the window 	measured in pixels from the top left hand corner of 	the screen */
	glutInitWindowPosition(0,0);

	/* int glutCreateWindow(*char title)- Creates a 	window on the screen with the title specified by the 	argument. It returns a integer to reference that 	window in multi-window situations */
	glutCreateWindow("Circle");

	/* calls the display function*/
	glutDisplayFunc(display);

	/* calls the init() function*/
	init();

	/* Causes the program to enter an event processing 	loop. This should be the last statement in main */ 

	glutMainLoop();
}