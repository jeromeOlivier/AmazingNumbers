package numbers;

import java.util.Scanner;

public class Control {
    Printer print = new Printer();
    Validate validate = new Validate();
    AmazingNumber currentNumber = new AmazingNumber();

    public void welcomeUser() {
        print.welcome();
        print.instructions();
    }

    public void runAmazingNumbers() {
        while (true) {
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
                        long number = Long.parseLong(userInput);
                        if (number < 0) {
                            print.errorMessage();
                        } else {
                            currentNumber = validate.singleInput(number);
                            print.singleResult(currentNumber);
                        }
                    } else if (inputValidation.length == 2) {
                        long startValue = Long.parseLong(inputValidation[0]);
                        int iterations = Integer.parseInt(inputValidation[1]);
                        if (startValue <= 0) {
                            print.startValueErrorMessage();
                        } else if (iterations <= 0) {
                            print.iterationErrorMessage();
                        } else {
                            print.multipleResults(startValue, iterations);
                        }
                    } else {
                        long startValue = Long.parseLong(inputValidation[0]);
                        int iterations = Integer.parseInt(inputValidation[1]);
                        String specialProperty = inputValidation[2].toString();

                    }
                }
            }
        }
    }
}
