#include <GL\glut.h>
#include <math.h>
#include <stdio.h>
#include <stdlib.h>
#define DTR 0.0174532925

//declare method prototypes
void display();
void init();
void drawCube();
void drawBarn();
void moveCam();
void idleFunction();

GLuint wood4; //declare texture ids (may be more than 1)
GLuint felt;


double xcam =30 ,ycam =30 ,zcam =30; //globals controlling viewer position
double theta = 0; //to rotate viewer
float lightPosition0[4] = {10,30,30,1};//position fo light source (tell you anything about shading pattern??)

//draw the image
void display()
{
	glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);	
	glShadeModel(GL_SMOOTH);
	glMatrixMode(GL_MODELVIEW);
	glLoadIdentity();

	gluLookAt(xcam,ycam,zcam,0,0,0,0,1,0); //position the viewer
	glLightfv(GL_LIGHT0, GL_POSITION,lightPosition0);//position the light source
	 
	//draw the object
	//drawCube();
	drawBarn();


	glutSwapBuffers();
	
	//move the viewer (could also move object, or even light sources)
	moveCam();
}

//function used for when openGL is idle-> redisplay
void idleFunction() {
	glutPostRedisplay();
}

//function to rotate camera about the origin
void moveCam() {
	double r;
	theta += 0.005;
	if (theta > 360)
		theta = 0;
	r = sqrt(xcam*xcam + zcam*zcam);
	xcam = r*cos(theta);
	zcam = r*sin(theta);


}


//NB: function to load a texture map and set texturing properties
GLuint readTexture(char * fname) {


	GLuint texture; //texture id-> will be returned


	//the following code reads in the 3 colour 
	//cahnnels of a PPM image into memory
	GLubyte* image;
	int im_size = 64;
	FILE   *fd;
	int nm,n,m,k;
	char  c;
	int  i;
	char b[70];
	int   red,   green,   blue; 
	fd =  fopen(fname,   "r"); 
	fscanf(fd,   "%[^\n]",   b); 
	if(b[0]   !=   'P' ||   b[1]   !=   '3') {
		printf("%s  is  not a PPM file!\n",   b); 
		exit(0);
	}


	fscanf(fd, "%c" , &c) ;
	fscanf(fd, "%c" , &c) ; 
	while(c ==   '#') {
		fscanf(fd, "%[^\n]",   b) ;
		fscanf(fd, "%c", &c) ; 
	}
	
	 
	fscanf(fd,   "%d %d %d",   &n,   &m,   &k) ;
	nm  =  n*m;
	image  =  malloc(3*sizeof(GLubyte)*nm) ;
	
	for(i   =  0;   i   <  nm; i++) {
		fscanf(fd,   "%d %d %d",   &red,   &green,   &blue);
		image[3*nm  -   3*i   -   3]   =   red;
		image[3*nm  -   3*i   -   2]   =  green;
		image[3*nm  -   3*i   -   1]   =  blue; 
	}
	//image has been read into array "image" as of this point
	//now lets load it into a texture map



	//texture stored in variable array image
	//must now load it into video memory through openGL call glTexImage2D

	//glTextures generates an unused integer id for texture were about
	//to create, we can use this to reference the texture in future
	glGenTextures(1,&texture);

	//we must inform openGL that this texture should become the current texture
	//so subsequent texture functions will apply it, like the ones below
	glBindTexture(GL_TEXTURE_2D,texture);
	
	//the function glTexImage2D loads the texture into video memory, once loaded we can free
	//the image memory.
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

	glTexImage2D(GL_TEXTURE_2D,0,GL_RGB,im_size,im_size,0,GL_RGB,GL_UNSIGNED_BYTE,image);

	//glTexParameterf is used to set various propertiers of the texturing procedure
	//all texture properties are set by glTexParameterf

	/*the first call to the function can be read as follows:

	when using the 2D texture defined above, if the s texture coordinate goes outside of the
	texture range (0->1) then clamp it, that is if its greater than 1 set it to one
	if it is less than zeros set it to zero. Other option-> GL_REPEAT repeats the texure again
	outside of the map bounds (0->1)*/

	glTexParameterf(GL_TEXTURE_2D,GL_TEXTURE_WRAP_S, GL_CLAMP);

	//same goes for the t texture coordinate
	glTexParameterf(GL_TEXTURE_2D,GL_TEXTURE_WRAP_T, GL_CLAMP);

	/*Each pixel in the rendered image corresponds to a small area on the surface of an object and
	hence a small area of the texture map. If the object is far away from the viewer a single pixel
	may be representative of a number of texels. If the object is close to the viewer a single texel 
	may be representative of a number of pixels. This is called minification and magnification.
	So openGL must either take the large area of the texture map and squash it into the smaller pixel
	area or take the small texel area and magnify it so it fits into the larger pixel area.
	The following function calls tell openGL how to do this*/

	glTexParameterf(GL_TEXTURE_2D,GL_TEXTURE_MAG_FILTER,GL_NEAREST);
	glTexParameterf(GL_TEXTURE_2D,GL_TEXTURE_MIN_FILTER,GL_NEAREST);


	/* GL_NEAREST and GL_LINEAR are two techniqes used for magnification/minification.
	GL_NEAREST is faster but GL_LINEAR normally yields better results*/

	free(image);

	return texture; //return the texture id


}


void drawBarn() {


	glTexEnvi(GL_TEXTURE,GL_TEXTURE_ENV_MODE,GL_REPLACE);
	
	//front
	//glBindTexture sets current texture to the wood4 texture
	glBindTexture(GL_TEXTURE_2D,wood4);
    glNormal3f(0, 0, 1);
	glBegin(GL_POLYGON);
		glTexCoord2f(0.0,1.0); glVertex3f(8,10,4);
		glTexCoord2f(1.0,1.0); glVertex3f(-8,10,4);
		glTexCoord2f(1.0,0.0); glVertex3f(-8,0,4);
		glTexCoord2f(0.0,0.0); glVertex3f(8,0,4);
	glEnd();

	// back side
	glNormal3f(0, 0, -1);
	glBegin(GL_POLYGON);
		glVertex3f(8,10,-4);
		glVertex3f(8,0,-4);
		glVertex3f(-8,0,-4);
		glVertex3f(-8,10,-4);
	glEnd();

	//front end
	glNormal3f(1, 0, 0);
	glBegin(GL_POLYGON);
		glTexCoord2f(0.5,1.0);	glVertex3f(8,14,0);
		glTexCoord2f(1.0,0.7);	glVertex3f(8,10,4);
		glTexCoord2f(1.0,0.0);	glVertex3f(8,0,4);
		glTexCoord2f(0.0,0.0);	glVertex3f(8,0,-4);
		glTexCoord2f(0.0,0.7);	glVertex3f(8,10,-4);
	glEnd();

	//back end
	glNormal3f(-1, 0, 0);
	glBegin(GL_POLYGON);
		glVertex3f(-8,14,0);
		glVertex3f(-8,10,-4);
		glVertex3f(-8,0,-4);
		glVertex3f(-8,0,4);
		glVertex3f(-8,10,4);
	glEnd();


	//floor
	glNormal3f(0, -1, 0);
	glBegin(GL_POLYGON);
		glVertex3f(8,0,4);
		glVertex3f(-8,0,4);
		glVertex3f(-8,0,-4);
		glVertex3f(8,0,-4);
	glEnd();


	glBindTexture(GL_TEXTURE_2D,felt);


	//front apex
	glNormal3f(0, 1, 1);
	glBegin(GL_POLYGON);
		glTexCoord2f(0.0,1.0); glVertex3f(8,10,4);
		glTexCoord2f(1.0,1.0); glVertex3f(8,14,0);
		glTexCoord2f(1.0,0.0); glVertex3f(-8,14,0);
		glTexCoord2f(0.0,0.0); glVertex3f(-8,10,4);
	glEnd();

	//back apex
	glNormal3f(0, -1, -1);
	glBegin(GL_POLYGON);
		glVertex3f(8,10,-4);
		glVertex3f(-8,10,-4);
		glVertex3f(-8,14,0);
		glVertex3f(8,14,0);
	glEnd();

	

}


	
//initalise openGL
void init()
{
	

	float diffuseColor0[4] = {1,1,1,1};
	float ambientColor0[4] = {0.5,0.5,0.5,0.5};

	glClearColor(1.0,1.0,1.0,1.0);
	glMatrixMode(GL_PROJECTION);
	gluPerspective(45,1,1,60);
	glEnable(GL_CULL_FACE);//for HSR
	glEnable(GL_DEPTH_TEST);//for HSR
	glEnable(GL_LIGHTING);//enable lighting
	glEnable(GL_LIGHT0);//enable light 0
	glEnable(GL_NORMALIZE); //enable normal normalisation
	glEnable(GL_TEXTURE_2D);//enable texturing
	glLightfv(GL_LIGHT0,GL_DIFFUSE,diffuseColor0);//set light colour
	glLightfv(GL_LIGHT0,GL_AMBIENT,ambientColor0);//set light colour
	glShadeModel(GL_SMOOTH);//set shade model to constant shading
	wood4 = readTexture("wood_tex4.ppm");//load a texture
	felt = readTexture("felt_tex.ppm");//load a texture
	

}

//execute specified functions
int main(int argc, char** argv)
{
	glutInit(&argc, argv);
	glutInitDisplayMode(GLUT_DOUBLE | GLUT_RGB);
	glutInitWindowSize(500,500);
	glutInitWindowPosition(0,0);
	glutCreateWindow("Texturing");
	init();
	glutDisplayFunc(display);
	glutIdleFunc(idleFunction);
	glutMainLoop();
}