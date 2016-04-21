package lab6.part2;

import zoo.Animal;
import zoo.Zoo;
import zoo.lizard;

public class LizardAdapter extends Animal{

	protected void feed() {
		lizard liz = new lizard(50);
		liz.feedlizard();
	}

}
