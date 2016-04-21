#include "glut.h"
#include <math.h>
#include <stdio.h>

double polygon[100][2];
int polyindex = 0;

//declare method prototypes
void display();
void init();
void myMouse(int x, int y, int button, int state);

void display()
{
	int i=0;
	glClear(GL_COLOR_BUFFER_BIT);
	glBegin(GL_LINE_STRIP);

	for(i=0;i<polyindex;i++) {
		glVertex2d(polygon[i][0],polygon[i][1]);
	}
	glEnd();
	glutSwapBuffers();
}

//initalise openGL
void init()
{
	glClearColor(0.0,0.0,0.0,0.0);
	glColor3f(1.0,1.0,1.0);
	glMatrixMode(GL_PROJECTION);
	gluOrtho2D(0,500,0,500);
}

void myMouse(int button, int state, int x, int y) {

//every time a mouse event occurs this function is called 
//you should draw a sequence of lines between all the vertices defined in the polygon //data structure every time this function is called due to a left button press
//you should clear the screen and set all vertices back to zero when a right button is //pressed

	if(state == GLUT_DOWN && button == GLUT_LEFT_BUTTON)
	{
		polygon[polyindex][0] = x;
		polygon[polyindex][1] = 500 - y;
		polyindex++;
	}
	else if (state == GLUT_DOWN && button == GLUT_RIGHT_BUTTON)
	{
		glClear(GL_COLOR_BUFFER_BIT);
		polyindex = 0;
	}

	display();


}
//execute specified functions
int main(int argc, char** argv)
{
	glutInit(&argc, argv);
	glutInitDisplayMode(GLUT_DOUBLE | GLUT_RGB);
	glutInitWindowSize(500,500);
	glutInitWindowPosition(0,0);
	glutCreateWindow("mouse draw");
	glutDisplayFunc(display);
	glutMouseFunc(myMouse);
	init();
	glutMainLoop();
}
