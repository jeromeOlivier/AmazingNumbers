package numbers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Control control = new Control();
        control.welcomeUser();
        control.runAmazingNumbers();
    }
}

class Control {
    View view = new View();
    Check check = new Check();

    public void welcomeUser() {
        view.displayWelcome();
        view.displayInstructions();
    }

    public void runAmazingNumbers() {
        while (true) {
            view.promptUser();
            String userInput = new Scanner(System.in).nextLine();

            switch (userInput) {
                case ("0"): {
                    view.displayGoodbye();
                    return;
                }
                case (""): {
                    view.displayInstructions();
                    break;
                }
                default: {
                    String[] inputValidation = userInput.split(" ");
                    if (inputValidation.length == 1) {
                        long number = Long.parseLong(userInput);
                        if (number < 0) {
                            view.displayErrorMessage();
                        } else {
                            view.displaySingleResult(number);
                        }
                    } else {
                        long firstParameter = Long.parseLong(inputValidation[0]);
                        int secondParameter = Integer.parseInt(inputValidation[1]);
                        if (firstParameter <= 0) {
                            view.displayFirstParameterErrorMessage();
                        } else if (secondParameter <= 0) {
                            view.displaySecondParameterErrorMessage();
                        } else {
                            view.displayMultipleResult(firstParameter, secondParameter);
                        }
                    }
                }
            }
        }
    }
}

class View {

    Check check = new Check();

    public void displayWelcome() {
        System.out.println("Welcome to Amazing Numbers!\n");
    }

    public void displayInstructions() {
        System.out.println("Supported requests:\n" +
                "- enter a natural number to know its properties;\n" +
                "- enter two natural numbers to obtain the properties of the list:\n" +
                "  * the first parameter represents a starting number;\n" +
                "  * the second parameter shows how many consecutive numbers are to be printed;\n" +
                "- separate the parameters with one space;\n" +
                "- enter 0 to exit.");
    }

    public void promptUser() {
        System.out.print("\nEnter a request: ");
    }

    public void displaySingleResult(long number) {
        System.out.println("\nThe properties of " + number);
        System.out.printf("%17s %-1s", "buzz:", check.ifNumberIsBuzz(number) + "\n");
        System.out.printf("%17s %-1s", "duck:", (check.ifNumberIsDuck(number)) + "\n");
        System.out.printf("%17s %-1s", "palindromic:", (check.ifNumberIsPalindromic(number)) + "\n");
        System.out.printf("%17s %-1s", "gapful:", (check.ifNumberIsGapful(number)) + "\n");
        System.out.printf("%17s %-1s", "even:", check.ifNumberIsEven(number) + "\n");
        System.out.printf("%17s %-1s", "odd:", !check.ifNumberIsEven(number) + "\n\n");
    }

    public void displayMultipleResult(long firstParameter, int secondParameter) {
        for (int i = 0; i < secondParameter; i++) {
            System.out.printf("%20s %-1s %-1s", firstParameter + i, "is",
                    check.multipleResults(firstParameter + i) + "\n");
        }
    }

    public void displayErrorMessage() {
        System.out.println("\nThe first parameter should be a natural number or zero.\n");
    }

    public void displayFirstParameterErrorMessage() {
        System.out.println("The first parameter should be a natural number or zero.");
    }

    public void displaySecondParameterErrorMessage() {
        System.out.println("The second parameter should be a natural number.");
    }

    public void displayGoodbye() {
        System.out.println("\nGoodbye.\n");
    }
}

class Check {

    public boolean ifNumberIsEven(long number) {
        return number % 2 == 0;
    }

    public boolean ifNumberIsBuzz(long number) {
        boolean divisibleBySeven = number % 7 == 0;
        boolean endsWithSeven = number % 10 == 7;
        return (divisibleBySeven || endsWithSeven);
    }

    public boolean ifNumberIsDuck(long number) {
        String inputNumber = String.valueOf(number);
        return inputNumber.contains("0");
    }

    public boolean ifNumberIsPalindromic(long number) {
        String inputNumber = String.valueOf(number);
        StringBuilder sb = new StringBuilder(inputNumber);
        return inputNumber.equals(sb.reverse().toString());
    }

    public boolean ifNumberIsGapful(long number) {
        if (number < 100) {
            return false;
        }
        long numberOfdigits = (long) (Math.log10(number));
        long firstDigit = (number / (long) (Math.pow(10, numberOfdigits))) * 10;
        long lastDigit = number % 10;
        return number % (firstDigit + lastDigit) == 0;
    }

    public String multipleResults(long firstParameter) {
        List<String> arrayList = new ArrayList<>();

        if (ifNumberIsGapful(firstParameter)) {
            arrayList.add("gapful");
        }
        if (ifNumberIsPalindromic(firstParameter)) {
            arrayList.add("palindromic");
        }
        if (ifNumberIsDuck(firstParameter)) {
            arrayList.add("duck");
        }
        if (ifNumberIsBuzz(firstParameter)) {
            arrayList.add("buzz");
        }
        if (ifNumberIsEven(firstParameter)) {
            arrayList.add("even");
        }
        if (!ifNumberIsEven(firstParameter)) {
            arrayList.add("odd");
        }

        return String.join(", ", arrayList);
    }
}