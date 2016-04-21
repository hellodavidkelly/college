public class OuterClass {
	int outerInt;

	public static void main(String[] args) {
		new OuterClass().new Inner().accessOuter();
		//This is an outer class
	}

	class Inner {
		//This is an inner class
		public void accessOuter() {
			System.out.println("Value is " + OuterClass.this.outerInt);
			OuterClass.this.outerInt=1;
			System.out.println("Value is " + OuterClass.this.outerInt);
		}
	}
}