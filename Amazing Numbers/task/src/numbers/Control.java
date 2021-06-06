package numbers;

import java.util.Scanner;

public class Control {
    Print print = new Print();
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
                        long singleNumber = Long.parseLong(userInput);
                        if (singleNumber < 0) {
                            print.errorMessage();
                        } else {
                            currentNumber = validate.userInput(singleNumber);
                            print.singleResult(currentNumber);
                        }
                    } else if (inputValidation.length == 2) {
                        long loopedNumber = Long.parseLong(inputValidation[0]);
                        int iterations = Integer.parseInt(inputValidation[1]);
                        if (loopedNumber <= 0) {
                            print.startValueErrorMessage();
                        } else if (iterations <= 0) {
                            print.iterationErrorMessage();
                        } else {
                            // do the looping here!!!
                            for (int i = 0; i < iterations; i++) {
                                currentNumber = validate.userInput(loopedNumber + i);
                                print.loopedResult(currentNumber);
                            }
                        }
                    } else {
                        long startValue = Long.parseLong(inputValidation[0]);
                        int iterations = Integer.parseInt(inputValidation[1]);
                        String specialProperty = inputValidation[2];

                    }
                }
            }
        }
    }
}
