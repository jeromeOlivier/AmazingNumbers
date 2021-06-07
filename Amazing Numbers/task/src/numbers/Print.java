package numbers;

import java.util.ArrayList;
import java.util.List;

public class Print {

	AmazingNumber legal = new AmazingNumber();

	// prompt user input & display results

	public void promptMessage() {
		System.out.print("\nEnter a request: ");
	}

	public void singleResult(AmazingNumber currentNumber) {
		System.out.println("\nThe properties of " + currentNumber.value);
		System.out.printf("%17s %-1s", (legal.buzzName + ":"), currentNumber.buzz + "\n");
		System.out.printf("%17s %-1s", (legal.duckName + ":"), currentNumber.duck + "\n");
		System.out.printf("%17s %-1s", (legal.palindromicName + ":"), currentNumber.palindromic + "\n");
		System.out.printf("%17s %-1s", (legal.gapfulName + ":"), currentNumber.gapful + "\n");
		System.out.printf("%17s %-1s", (legal.evenName + ":"), currentNumber.even + "\n");
		System.out.printf("%17s %-1s", (legal.oddName + ":"), !currentNumber.even + "\n");
		System.out.printf("%17s %-1s", (legal.spyName + ":"), currentNumber.spy + "\n");
	}

	public void loopedResult(AmazingNumber currentNumber) {
		List<String> arrayList = new ArrayList<>();

		if (currentNumber.gapful) { arrayList.add(legal.gapfulName); }
		if (currentNumber.palindromic) { arrayList.add(legal.palindromicName); }
		if (currentNumber.duck) { arrayList.add(legal.duckName); }
		if (currentNumber.buzz) { arrayList.add(legal.buzzName); }
		if (currentNumber.even) { arrayList.add(legal.evenName); }
		if (!currentNumber.even) { arrayList.add(legal.oddName); }
		if (currentNumber.spy) { arrayList.add(legal.spyName); }
		System.out.printf("%20s %-1s %-1s", currentNumber.value, "is", String.join(", ", arrayList) + "\n");
	}

	// hello, goodbye & instructions

	public void welcome() {
		System.out.println("Welcome to Amazing Numbers!");
	}

	public void instructions() {
		System.out.println("Supported requests:\n" +
				"- enter a natural number to know its properties;\n" +
				"- enter two natural numbers to obtain the properties of the list:\n" +
				"  * the first parameter represents a starting number;\n" +
				"  * the second parameter shows how many consecutive numbers are to be printed;\n" +
				"- two natural numbers and a property to search for;\n" +
				"- separate the parameters with one space;\n" +
				"- enter 0 to exit.");
	}

	public void goodbyeMessage() {
		System.out.println("\nGoodbye.\n");
	}

	// Error messages
	public void errorMessage() {
		System.out.println("\nThe first parameter should be a natural number or zero.\n");
	}

	public void startValueErrorMessage() {
		System.out.println("The first parameter should be a natural number or zero.");
	}

	public void iterationErrorMessage() {
		System.out.println("The second parameter should be a natural number.");
	}

	public void specialPropertyErrorMessage(String specialProperty) {
		legal.nameList();
		System.out.println("\nThe property [" + specialProperty.toUpperCase() + "] is wrong.\n" +
				"Available properties: [" + (String.join(", ", legal.nameList)).toUpperCase() + "]");
	}

}