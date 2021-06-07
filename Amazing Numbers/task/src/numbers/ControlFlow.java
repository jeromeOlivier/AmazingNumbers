package numbers;

import java.util.Scanner;

public class ControlFlow {
	Print print = new Print();
	Validate validate = new Validate();
	AmazingNumber currentNumber = new AmazingNumber();

	public void welcomeUser() {
		print.welcome();
		print.instructions();
	}

	public void runAmazingNumbers() {
		while (true) {
			currentNumber.nameList();
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
					if (inputValidation.length == 1) { // example: 100
						long singleNumber = Long.parseLong(userInput);
						if (singleNumber < 0) {
							print.errorMessage();
						} else {
							currentNumber = validate.userInput(singleNumber);
							print.singleResult(currentNumber);
						}
					} else if (inputValidation.length == 2) { // example: 100 10
						long loopedNumber = Long.parseLong(inputValidation[0]);
						int iterations = Integer.parseInt(inputValidation[1]);
						if (loopedNumber <= 0) {
							print.startValueErrorMessage();
						} else if (iterations <= 0) {
							print.iterationErrorMessage();
						} else {
							for (int i = 0; i < iterations; i++) {
								currentNumber = validate.userInput(loopedNumber + i);
								print.loopedResult(currentNumber);
							}
						}
					} else { // example: 100 10 even
						long loopedNumber = Long.parseLong(inputValidation[0]);
						int iterations = Integer.parseInt(inputValidation[1]);
						String specialProperty = inputValidation[2].toLowerCase();
						if (!currentNumber.nameList.contains(specialProperty)) {
							print.specialPropertyErrorMessage(specialProperty);
							break;
						} else {
							long idx = 0;
							while (idx < iterations) {
								if (validate.controlFlow(loopedNumber, specialProperty)) {
									currentNumber = validate.userInput(loopedNumber);
									print.loopedResult(currentNumber);
									loopedNumber++;
									idx++;
								} else {
									loopedNumber++;
								}
							}
						}
					}
				}
			}
		}
	}
}
