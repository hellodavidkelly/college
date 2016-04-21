
public class VisitingStudent extends Student {
	private String collegeOfOrigin;
	
	public VisitingStudent(String name, int age, int year, String collegeOfOrigin) {
		super(name,age,year);
		this.collegeOfOrigin=collegeOfOrigin;
	}
	
	public String getName() {
		return super.getName() + " from " + collegeOfOrigin;
	}
}
