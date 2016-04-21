#include "glut.h"
#include <math.h>
#include <stdio.h>


void display();
void init();
double x=20,y=20,z=20;


//draw the image
void display()
{
	glClear(GL_COLOR_BUFFER_BIT);
	glMatrixMode(GL_MODELVIEW);
	glLoadIdentity();
	gluLookAt(x,y,z,0,0,0,0,1,0);
	glutWireCube(5); // draws a cube centered at the origin of world space with side length 5
	glutSwapBuffers();
	x = x-0.01;
	y = y-0.01;
	z = z-0.01;
}
//initalise openGL

void init()
{
	glClearColor(0.0,0.0,0.0,0.0);
	glColor3f(1.0,1.0,1.0);
	glMatrixMode(GL_PROJECTION);
	glOrtho(-10,10,-10,10,-50,50);
}

//execute specified functions
int main(int argc, char** argv)
{
	glutInit(&argc, argv);
	glutInitDisplayMode(GLUT_DOUBLE | GLUT_RGB);
	glutInitWindowSize(500,500);
	glutInitWindowPosition(0,0);
	glutCreateWindow("projections");
	glutDisplayFunc(display);
	glutIdleFunc(display);
	init();
	glutMainLoop();
}
