import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class Calculator extends JLabel implements Chain
{
	private Chain nextChain;

	public Calculator()
	{
		setBorder(new TitledBorder("Calculator Ouptut"));
		setText("Answer : ");
	}
	public void addChain(Chain c)
	{
		nextChain = c;
	}

	public void sendToChain(String mesg)
	{
		if (mesg.indexOf('+') != -1)
			doCalculation(mesg);
		else
		{
			if (nextChain != null)
				nextChain.sendToChain(mesg);
		}
    }


	public Chain getChain()
	{
		return nextChain;
    }

	private void doCalculation(String calc)
	{
		String operand1, operand2;
		String operator;

		int opindex = calc.indexOf('+');
		operand1 = calc.substring(0, opindex);
		operand2 = calc.substring(opindex + 1, calc.length());

		int answer = Integer.parseInt(operand1)
		             + Integer.parseInt(operand2);
		setText(calc + " = " + answer);
    }
}