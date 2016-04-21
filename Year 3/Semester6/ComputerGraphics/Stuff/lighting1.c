#include "glut.h"
#include <math.h>
#include <stdio.h>

//declare method prototypes

void display();
void init();
void drawCube();




//draw the image
void display()
{



	float lightPosition[4] = {15, 15, 15, 1};
	GLfloat diffuse_mp[] = {1.0,0.0,0.0,1.0};
	GLfloat specular_mp[] = {0.5,0.5,0.5,1.0};

	glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

	glMatrixMode(GL_MODELVIEW);
	glLoadIdentity();


	gluLookAt(5,0,5,0,0,0,0,1,0);

	glLightfv(GL_LIGHT0, GL_POSITION, lightPosition);

	//drawCube();
	
	
	glMaterialfv(GL_FRONT_AND_BACK, GL_DIFFUSE, diffuse_mp);
	glMaterialfv(GL_FRONT_AND_BACK, GL_SPECULAR, specular_mp);
	glMaterialf(GL_FRONT_AND_BACK,GL_SHININESS,100); 

	glutSolidSphere(3,200,200);

	glutSwapBuffers();

}


void drawCube()
{

   //glColor4f(1.0,0.0,0.0,1.0);

	GLfloat diffuse_mp[] = {1.0,0.0,0.0,1.0};
	glMaterialfv(GL_FRONT_AND_BACK, GL_DIFFUSE, diffuse_mp);


   glBegin(GL_QUADS);
      // front

	  glNormal3f(0, 0, 1);
      glVertex3f(-1, 1, 1);
      glVertex3f(-1, -1, 1);
      glVertex3f(1, -1, 1);
      glVertex3f(1, 1, 1);

      // back
      glNormal3f(0, 0, -1);
      glVertex3f(-1, 1, -1);
      glVertex3f(1, 1, -1);
      glVertex3f(1, -1, -1);
      glVertex3f(-1, -1, -1);

      // top
      glNormal3f(0, 1, 0);
      glVertex3f(-1, 1, -1);
      glVertex3f(-1, 1, 1);
      glVertex3f(1, 1, 1);
      glVertex3f(1, 1, -1);

      // bottom
      glNormal3f(0, -1, 0);
      glVertex3f(-1, -1, -1);
      glVertex3f(1, -1, -1);
      glVertex3f(1, -1, 1);
      glVertex3f(-1, -1, 1);

      // left
      glNormal3f(-1, 0, 0);
      glVertex3f(-1, 1, -1);
      glVertex3f(-1, -1, -1);
      glVertex3f(-1, -1, 1);
      glVertex3f(-1, 1, 1);

      // right
      glNormal3f(1, 0, 0);
      glVertex3f(1, 1, 1);
      glVertex3f(1, -1, 1);
      glVertex3f(1, -1, -1);
      glVertex3f(1, 1, -1);
   glEnd();
}

//initalise openGL
void init()
{

	float diffuseColor[4] = {1, 1, 1, 1}; //default
	glClearColor(0.0,0.0,0.0,0.0);
	glMatrixMode(GL_PROJECTION);
	gluPerspective(45,1,1,50);
	glEnable(GL_CULL_FACE);
	glEnable(GL_DEPTH_TEST);

	glEnable(GL_LIGHTING);
	glEnable(GL_LIGHT0);
	glShadeModel(GL_SMOOTH);
   
	glLightfv(GL_LIGHT0, GL_DIFFUSE, diffuseColor);


}

//execute specified functions
int main(int argc, char** argv)
{
	glutInit(&argc, argv);
	glutInitDisplayMode(GLUT_DOUBLE | GLUT_RGB);
	glutInitWindowSize(500,500);
	glutInitWindowPosition(0,0);
	glutCreateWindow("Lighting");
	glutDisplayFunc(display);
	glutIdleFunc(display);
	init();
	glutMainLoop();
}