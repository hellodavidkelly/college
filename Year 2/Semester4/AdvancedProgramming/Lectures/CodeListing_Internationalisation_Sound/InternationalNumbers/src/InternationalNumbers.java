import java.text.DateFormatSymbols;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class InternationalNumbers {

	public static void main(String[] args) {
		int interestRate=10,years=10,loan=5,monthlyPay=2000,totalPay=60000;
		Locale locale = new Locale("de"); //For Germany
	    // Get formatters
	    NumberFormat percForm = NumberFormat.getPercentInstance(locale);
	    NumberFormat currencyForm =
	    NumberFormat.getCurrencyInstance(locale);
	    NumberFormat numberForm = NumberFormat.getNumberInstance(locale);
	    percForm.setMinimumFractionDigits(2);

	    // Display formatted input
	    System.out.println(percForm.format(interestRate*12));
	    System.out.println(numberForm.format(years));
	    System.out.println(currencyForm.format(loan));

	    // Display results in currency format
	    System.out.println(currencyForm.format(monthlyPay));
	    System.out.println(currencyForm.format(totalPay));

	    //Some internationalised date stuff!!!
	    DateFormatSymbols dfs = new DateFormatSymbols(locale);
	    String dayNames[] = dfs.getWeekdays();

	    // Set calendar days
	    for (int i=0; i<7; i++)
	    {
	    	System.out.println(dayNames[i+1]);
	    }

	}

}
