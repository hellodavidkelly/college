#include "glut.h"
#include <math.h>
#include <stdio.h>

#define PI 3.14159
double theta=0,r=20;


void display();
void init();

//draw the image
void display()
{
	glClear(GL_COLOR_BUFFER_BIT);
	glMatrixMode(GL_MODELVIEW);
	glLoadIdentity();
	gluLookAt(r*cos(theta/180*PI),0,r*sin(theta/180*PI),0,0,0,0,1,0); //positive z direction
	glutWireTeapot(4);
	glutSwapBuffers();
}

void moveCam()
{
// Enter your code in here that changes global variables that move the camera
	theta = theta + 0.1;
glutPostRedisplay();
}

//initalise openGL
void init()
{
	glClearColor(0.0,0.0,0.0,0.0);
	glColor3f(1.0,1.0,1.0);
	glMatrixMode(GL_PROJECTION);
	gluPerspective(45,1,1,25);
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
	glutIdleFunc(moveCam);
	init();
	glutMainLoop();
}
