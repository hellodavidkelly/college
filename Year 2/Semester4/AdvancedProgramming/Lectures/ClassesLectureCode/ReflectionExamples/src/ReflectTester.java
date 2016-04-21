import java.lang.reflect.Method;

public class ReflectTester {


	public String string1;//field


	public int multi(String test) {
		System.out.println("Hello, you called " + this.getClass().getName());
		return 0;
	}

	public void maxi() {
		System.out.println("Hello");

	}

	public void maxi2() {
			System.out.println("Hello");

	}

	public static void main(String[] args) {




		ReflectTester tester=null;

		try {
			tester = (ReflectTester)Class.forName("ReflectTester").newInstance();
			//tester = new ReflectTester()
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch(InstantiationException ex) {
			ex.printStackTrace();
		}
		catch(IllegalAccessException ex1) {
			ex1.printStackTrace();
		}

		tester.multi("test");//call to the method multi


		Method[] methods = tester.getClass().getDeclaredMethods();

		for(int i=0; i < methods.length; i++) {
			System.out.println(methods[i].getName());
		}

	}



}