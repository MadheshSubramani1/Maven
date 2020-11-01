package LearnCasting;

public class FirstChild extends Parent {

	int sampleValue = 10;

	public void Money() {
		System.out.println("i also getting money from my job");
	}

	public static void main(String[] args) {

		Parent parent = new FirstChild();

		parent.property();

		FirstChild child2 = (FirstChild) parent;


	}

}
