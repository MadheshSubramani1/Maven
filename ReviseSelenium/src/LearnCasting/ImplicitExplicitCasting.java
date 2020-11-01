package LearnCasting;

public class ImplicitExplicitCasting {

	public static void imlicitCasting() {
		int a = 10;
		long b = a;

		System.out.println(a);
	}

	public static void explicitCasting() {

		float a = 10;
		int b = (int) a;

		System.out.println(b);
	}

	public static void main(String[] args) {
		imlicitCasting();
		explicitCasting();
	}

}
