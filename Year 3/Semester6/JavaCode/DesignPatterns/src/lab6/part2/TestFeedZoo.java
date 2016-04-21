package lab6.part2;

public class TestFeedZoo {

	public static void main(String[] args) {
		LizardAdapter lAdapt = new LizardAdapter();
		AlligatorAdapter aAdapt = new AlligatorAdapter();
		lAdapt.feed();
		System.out.println("\n");
		aAdapt.feed();
	}

}
