import java.util.Vector;

public class SampleStudentGroup {

	public static void main(String[] args) {
		ClassList bn002Started2006 = new ClassList();
		Student student1 = new Student("Carter",22,1);
		Student student2 = new Student("Kelly",21,1);
		VisitingStudent student3 = new VisitingStudent("Craemer",34,1,"UCLA");
	
		
		bn002Started2006.addToClass(student1);
		bn002Started2006.addToClass(student2);
		bn002Started2006.addToClass(student3);
		
		Vector sampleClassList = bn002Started2006.getClassList();
		
		for(int i = 0; i < sampleClassList.size(); i++) {
			Student student = (Student)sampleClassList.elementAt(i);
			System.out.println(student.getName());
		}
		if(!CollegeHelper.classSizeWithinLimit(sampleClassList.size())) {
			System.out.println("Class not within limits");
		}
		System.out.println("Pass grade is " + CollegeHelper.PASSGRADE);
	}

}
