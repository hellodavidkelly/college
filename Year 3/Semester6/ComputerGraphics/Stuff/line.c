/* 	Author: Simon McLoughlin
	Class: EL414 - Computer Graphics
	Description
	This program simply plots the first and last point of a line with 
	positive slope < 1 defined as (x1,y1) = (150,100), (x2,y2) = (400,250).
	The API used to do the scan conversion is openGL.
	You must modify the code in the display() function below to plot the 
	intermediate points on the line using Bresenhams algorithm as discussed 
	in lectures.
	Do not worry about the calls in the other routines(init(),main()) for the 
	moment 							*/

#include <glut.h>
#include <stdio.h>
void display()
{
	int x0,y0,xf,yf; //declare variables for first and last line points
	int m,d;
	int x,y;

	x0 = 150, y0 = 100, xf = 400, yf = 250;
	y = y0;
	m = (yf-y0)+(yf-y0);
	d = 0;

	glClear(GL_COLOR_BUFFER_BIT); //clear the color buffer
	glBegin(GL_POINTS); //tell openGL we are plotting points
		glVertex2i(x0, y0); //plot first point
		
		for(x=x0+1;x<xf;x++)
		{
			d = d + m;
			if (d > (xf-x0)) 
			{
				y = y + 1;
				d = d - ((xf-x0)+(xf-x0));
			}
			glVertex2i(x,y);
		}
		glVertex2i(xf, yf); //plot last point
	glEnd();
	glFlush(); //flush the frame buffer 
}

void init()
{
	glClearColor(0.0,0.0,0.0,0.0);
	glColor3f(1.0,1.0,1.0);
	glMatrixMode(GL_PROJECTION);
	glLoadIdentity();
	gluOrtho2D(0,500,0,500);
}

int main(int argc, char** argv)
{
	glutInit(&argc, argv);
	glutInitDisplayMode(GLUT_SINGLE | GLUT_RGB);
	glutInitWindowSize(500,500);
	glutInitWindowPosition(0,0);
	glutCreateWindow("line");
	glutDisplayFunc(display);
	init();
	glutMainLoop();
}
