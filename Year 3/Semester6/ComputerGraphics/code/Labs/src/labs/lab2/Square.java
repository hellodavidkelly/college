package lab2;


public class Square {
	
	public double [][] vertices = new double[4][2]; //not good to make this public but heh!
	public double rotateSpeed = .005;
	public double cx, cy;
	public int x,y;
	public double  sLength = 0;
	
	public Square(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4)
	{
	    vertices[0][0]=x1;
	    vertices[0][1]=y1;
	    vertices[1][0]=x2;
	    vertices[1][1]=y2;
	    vertices[2][0]=x3;
	    vertices[2][1]=y3;
	    vertices[3][0]=x4;
	    vertices[3][1]=y4;
	}
	
	public double area()
	{
		return (vertices[1][0]-vertices[0][0])*(vertices[1][0]-vertices[0][0])+(vertices[1][1]-vertices[0][1])*(vertices[1][1]-vertices[0][1]);
	}
	
	public double getCentreX() {

		cx = (vertices[0][0]+vertices[2][0])/2;
		return cx;
	}
	
	public double getCentreY() {

		cy = (vertices[0][1]+vertices[2][1])/2;
		return cy;
	}
	
	public void translate(double tx, double ty)
	{
		for(int i=0;i<vertices.length;i++)
		{
			vertices[i][0]+=tx;
			vertices[i][1]+=ty;
		}
	}
	
	public void rotate(double theta, double xr, double yr)
	{

		int i;
		double oldx;
		for(i = 0;i<vertices.length;i++) {
			oldx = vertices[i][0];
			vertices[i][0] = xr + (vertices[i][0]-xr)*Math.cos(theta*rotateSpeed)-(vertices[i][1]-yr)*Math.sin(theta*rotateSpeed);
			vertices[i][1] = yr + (oldx-xr)*Math.sin(theta*rotateSpeed)+(vertices[i][1]-yr)*Math.cos(theta*rotateSpeed);
		}	
	}
	
	public void scale(double sx, double sy)
	{
		int j;
		//boolean area = false;
		for(j=0;j<vertices.length;j++){
			vertices [j][1] = sx*(vertices[j][1]+(-this.getCentreX()))+this.getCentreX();
			vertices [j][0] = sy*(vertices[j][0]+(-this.getCentreY()))+this.getCentreY();
		}

	}

}