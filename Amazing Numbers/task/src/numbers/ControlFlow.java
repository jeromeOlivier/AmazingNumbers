package numbers;

import java.util.Scanner;

public class ControlFlow {
	Print print = new Print();
	Validate validate = new Validate();
	AmazingNumber amazingNumber = new AmazingNumber();

	public void welcomeUser() {
		print.welcome();
		print.instructions();
	}

	public void runAmazingNumbers() {
		while (true) {
			amazingNumber.nameList();
			print.promptMessage();
			String userInput = new Scanner(System.in).nextLine();

			switch (userInput) {
				case ("0"): {
					print.goodbyeMessage();
					return;
				}
				case (""): {
					print.instructions();
					break;
				}
				default: {
					String[] inputValidation = userInput.split(" ");
					if (inputValidation.length == 1) {
						runForSingleInput(userInput);
					} else if (inputValidation.length == 2) { // example: 100 10
						runForDoubleInput(inputValidation);
					} else if (inputValidation.length == 3) { // example: 100 10 even
						runForTripleInput(inputValidation);
					} else if (inputValidation.length == 4) {
						runForQuadInput(inputValidation);
					} else {
						System.out.println("Big BooBoo!");
					}
				}
			}
		}
	}

	private void runForSingleInput(String userInput) {
		long singleNumber = Long.parseLong(userInput);
		if (singleNumber < 0) {
			print.errorMessage();
		} else {
			amazingNumber = validate.userInput(singleNumber);
			print.singleResult(amazingNumber);
		}
	}

	private void runForDoubleInput(String[] inputValidation) {
		long loopedNumber = Long.parseLong(inputValidation[0]);
		int iterations = Integer.parseInt(inputValidation[1]);
		if (loopedNumber <= 0) {
			print.startValueErrorMessage();
		} else if (iterations <= 0) {
			print.iterationErrorMessage();
		} else {
			for (int i = 0; i < iterations; i++) {
				amazingNumber = validate.userInput(loopedNumber + i);
				print.loopedResult(amazingNumber);
			}
		}
	}

	private void runForTripleInput(String[] inputValidation) {
		long loopedNumber = Long.parseLong(inputValidation[0]);
		int iterations = Integer.parseInt(inputValidation[1]);
		String specialProperty = inputValidation[2].toLowerCase();
		if (!amazingNumber.nameList.contains(specialProperty)) { // if user inputs illegal term
			print.specialPropertyErrorMessage(specialProperty);
		} else { // otherwise go at it
			long idx = 0;
			while (idx < iterations) {
				if (validate.controlFlow(loopedNumber, specialProperty)) {
					amazingNumber = validate.userInput(loopedNumber);
					print.loopedResult(amazingNumber);
					loopedNumber++;
					idx++;
				} else {
					loopedNumber++;
				}
			}
		}
	}

	private void runForQuadInput(String[] inputValidation) {
		long loopedNumber = Long.parseLong(inputValidation[0]);
		int iterations = Integer.parseInt(inputValidation[1]);
		String firstSpecialProperty = inputValidation[2].toLowerCase();
		String secondSpecialProperty = inputValidation[3].toLowerCase();
		String specialProperty = "";
		String squaredProperty = "";

		if (firstSpecialProperty.equals(amazingNumber.squareName)) {
			squaredProperty = firstSpecialProperty;
			specialProperty = secondSpecialProperty;
		} else if (secondSpecialProperty.equals(amazingNumber.squareName)) {
			squaredProperty = secondSpecialProperty;
			specialProperty = firstSpecialProperty;
		}

		if (!amazingNumber.nameList.contains(firstSpecialProperty) && !amazingNumber.nameList.contains(secondSpecialProperty)) {
			print.bothPropertyErrorMessage(firstSpecialProperty, secondSpecialProperty);
		} else if (!amazingNumber.nameList.contains(firstSpecialProperty)) {
			print.specialPropertyErrorMessage(firstSpecialProperty);
		} else if (!amazingNumber.nameList.contains(secondSpecialProperty)) {
			print.specialPropertyErrorMessage(secondSpecialProperty);
		} else if (validate.mutuallyExclusiveFilter(firstSpecialProperty, secondSpecialProperty)) {
			print.mutuallyExclusiveErrorMessage(firstSpecialProperty, secondSpecialProperty);
		} else if (squaredProperty.equals(amazingNumber.squareName)) {
			int i = 0;
			while (i < iterations) {
				long number = (long) Math.pow(loopedNumber, 2);
				amazingNumber = validate.userInput(number);
				if (validate.controlFlow(number, specialProperty)) {
					print.loopedResult(amazingNumber);
					i++;
					loopedNumber++;
				} else {
					loopedNumber++;
				}
			}
		}
		else {
			int i = 0;
			while (i < iterations) {
				amazingNumber = validate.userInput(loopedNumber);
				if (validate.controlFlow(amazingNumber.value, firstSpecialProperty)
						&& validate.controlFlow(amazingNumber.value, secondSpecialProperty)) {
					print.loopedResult(amazingNumber);
					i++;
					loopedNumber++;
				} else {
					loopedNumber++;
				}
			}
		}
	}
}