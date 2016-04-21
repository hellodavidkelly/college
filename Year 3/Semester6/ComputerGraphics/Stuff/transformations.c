#define DEG_TO_RAD 0.0174532925199
#include "glut.h"
#include <math.h>


//declare method prototypes
void translate(double,double);
void rotate_fixedp(double,double,double);
void find_centre();


//declare global variables
double square[4][2];
double cx;
double cy;


//initialise square vertices
void init_square(){
	square[0][0] = 100.0;
	square[0][1] = 100.0;
	square[1][0] = 100.0;
	square[1][1] = 200.0;
	square[2][0] = 200.0;
	square[2][1] = 200.0;
	square[3][0] = 200.0;
	square[3][1] = 100.0;
}

//draw the image
void display()
{
	int i,j;
	glClear(GL_COLOR_BUFFER_BIT);
	glBegin(GL_LINE_LOOP);
		glVertex2d(square[0][0],square[0][1]);
		glVertex2d(square[1][0],square[1][1]);
		glVertex2d(square[2][0],square[2][1]);
		glVertex2d(square[3][0],square[3][1]);
	glEnd();
	
	
	translate(1.0,1.0);
	find_centre();
	rotate_fixedp(1,cx,cy);

	glutSwapBuffers();
}


//translate the square by [dx dy]
void translate(double dx, double dy) {
	int i;
	for(i = 0;i<4;i++) {
		square[i][0] = square[i][0] + dx;
		square[i][1] = square[i][1] + dy;
	}
}

void rotate_fixedp(double theta, double xr, double yr)
{
	int i;
	double oldx;
	for(i = 0;i<4;i++) {
		oldx = square[i][0];
		square[i][0] = xr + (square[i][0]-xr)*cos(theta*DEG_TO_RAD)-(square[i][1]-yr)*sin(theta*DEG_TO_RAD);// what goes in here?
		square[i][1] = yr + (oldx-xr)*sin(theta*DEG_TO_RAD)+(square[i][1]-yr)*cos(theta*DEG_TO_RAD);// what goes in here?
	}
}

void find_centre() {

	cx = (square[0][0]+square[2][0])/2;
	cy = (square[0][1]+square[2][1])/2;
}




//initalise openGL
void init()
{
	glClearColor(0.0,0.0,0.0,0.0);
	glColor3f(1.0,1.0,1.0);
	glMatrixMode(GL_PROJECTION);
	gluOrtho2D(0,500,0,500);
}

//execute specified functions
int main(int argc, char** argv)
{
	init_square();
	glutInit(&argc, argv);
	glutInitDisplayMode(GLUT_DOUBLE | GLUT_RGB);
	glutInitWindowSize(500,500);
	glutInitWindowPosition(0,0);
	glutCreateWindow("line");
	glutDisplayFunc(display);
	glutIdleFunc(display);
	init();
	glutMainLoop();
}
