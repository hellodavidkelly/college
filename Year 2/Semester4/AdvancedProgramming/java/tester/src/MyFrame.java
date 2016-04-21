import javax.swing.JFrame;
import javax.swing.JButton;
import java.util.Locale;
import java.util.ResourceBundle;


public class MyFrame extends JFrame {

	JButton myButton;
	ResourceBundle res;
	Locale loc;

	public static void main(String[] args) 
	{
		new MyFrame();
	}

	
	public MyFrame()
	{
		loc = new Locale("en");
		
		res =res.getBundle("ProgramProperties", loc);
		
		myButton = new JButton(res.getString("tag1"));
		
		System.out.println(myButton.getText());

	}
}
