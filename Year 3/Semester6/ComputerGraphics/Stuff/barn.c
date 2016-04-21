#include "glut.h"
#include <math.h>
#include <stdio.h>

void display();
void init();

void barn() {

	/*
	//front side
	glBegin(GL_LINE_LOOP);
		glVertex3f(8,10,4);
		glVertex3f(-8,10,4);
		glVertex3f(-8,0,4);
		glVertex3f(8,0,4);
	glEnd();

	// back side
	glBegin(GL_LINE_LOOP);
		glVertex3f(8,10,-4);
		glVertex3f(8,0,-4);
		glVertex3f(-8,0,-4);
		glVertex3f(-8,10,-4);
	glEnd();

	//front end
	glBegin(GL_LINE_LOOP);
		glVertex3f(8,14,0);
		glVertex3f(8,10,4);
		glVertex3f(8,0,4);
		glVertex3f(8,0,-4);
		glVertex3f(8,10,-4);
	glEnd();

	//back end
	glBegin(GL_LINE_LOOP);
		glVertex3f(-8,14,0);
		glVertex3f(-8,10,-4);
		glVertex3f(-8,0,-4);
		glVertex3f(-8,0,4);
		glVertex3f(-8,10,4);
	glEnd();


	//front apex
	glBegin(GL_LINE_LOOP);
		glVertex3f(8,10,4);
		glVertex3f(8,14,0);
		glVertex3f(-8,14,0);
		glVertex3f(-8,10,4);
	glEnd();

	//back apex
	glBegin(GL_LINE_LOOP);
		glVertex3f(8,10,-4);
		glVertex3f(-8,10,-4);
		glVertex3f(-8,14,0);
		glVertex3f(8,14,0);
	glEnd();


	//floor
	glBegin(GL_LINE_LOOP);
		glVertex3f(8,0,4);
		glVertex3f(-8,0,4);
		glVertex3f(-8,0,-4);
		glVertex3f(8,0,-4);
	glEnd();
	*/

	glColor3f(1,0,0);
	//front side

	glBegin(GL_POLYGON);
		glVertex3f(8,10,4);
		glVertex3f(-8,10,4);
		glVertex3f(-8,0,4);
		glVertex3f(8,0,4);
	glEnd();

	glColor3f(0,1,0);
	// back side
	glBegin(GL_POLYGON);
		glVertex3f(8,10,-4);
		glVertex3f(8,0,-4);
		glVertex3f(-8,0,-4);
		glVertex3f(-8,10,-4);
	glEnd();

	glColor3f(0,0,1);
	//front end
	glBegin(GL_POLYGON);
		glVertex3f(8,14,0);
		glVertex3f(8,10,4);
		glVertex3f(8,0,4);
		glVertex3f(8,0,-4);
		glVertex3f(8,10,-4);
	glEnd();

	glColor3f(1,1,0);
	//back end
	glBegin(GL_POLYGON);
		glVertex3f(-8,14,0);
		glVertex3f(-8,10,-4);
		glVertex3f(-8,0,-4);
		glVertex3f(-8,0,4);
		glVertex3f(-8,10,4);
	glEnd();

	glColor3f(0,1,1);
	//front apex
	glBegin(GL_POLYGON);
		glVertex3f(8,10,4);
		glVertex3f(8,14,0);
		glVertex3f(-8,14,0);
		glVertex3f(-8,10,4);
	glEnd();

	glColor3f(1,0,1);
	//back apex
	glBegin(GL_POLYGON);
		glVertex3f(8,10,-4);
		glVertex3f(-8,10,-4);
		glVertex3f(-8,14,0);
		glVertex3f(8,14,0);
	glEnd();

	glColor3f(1,1,1);
	//floor
	glBegin(GL_POLYGON);
		glVertex3f(8,0,4);
		glVertex3f(-8,0,4);
		glVertex3f(-8,0,-4);
		glVertex3f(8,0,-4);
	glEnd();
	
}

//draw the image
void display()
{
	glClear(GL_COLOR_BUFFER_BIT);
	glMatrixMode(GL_MODELVIEW);
	glLoadIdentity();
	gluLookAt(30,30,30,0,0,0,0,1,0); //positive z direction

	glEnable(GL_CULL_FACE);
	glCullFace(GL_BACK); // do not worry what they do for the moment

	barn();
	glutSwapBuffers();
}

void moveCam()
{
// Enter your code in here that changes global variables that move the camera
glutPostRedisplay();
}

//initalise openGL
void init()
{
	glClearColor(0.0,0.0,0.0,0.0);
	glColor3f(1.0,1.0,1.0);
	glMatrixMode(GL_PROJECTION);
	gluPerspective(45,1,1,75);
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