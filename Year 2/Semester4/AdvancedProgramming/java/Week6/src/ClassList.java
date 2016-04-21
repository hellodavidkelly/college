import java.util.Vector;

public class ClassList {

	private Vector classList = new Vector(); 
	
	public ClassList() {
		classList = new Vector();
	}
	
	public void addToClass(Student student) {
		classList.add(student);
	}
	
	public Vector getClassList() {
		return classList;
	}

}
