package numbers;

public class Printer {

    Validate validate = new Validate();

    public void welcome() {
        System.out.println("Welcome to Amazing Numbers!");
    }

    public void instructions() {
        System.out.println("\nSupported requests:\n" +
                "- enter a natural number to know its properties;\n" +
                "- enter two natural numbers to obtain the properties of the list:\n" +
                "  * the first parameter represents a starting number;\n" +
                "  * the second parameter shows how many consecutive numbers are to be printed;\n" +
                "- separate the parameters with one space;\n" +
                "- enter 0 to exit.");
    }

    public void promptMessage() {
        System.out.print("\nEnter a request: ");
    }

    public void singleResult(AmazingNumber currentNumber) {
        System.out.println("\nThe properties of " + currentNumber.value);
        System.out.printf("%17s %-1s", "buzz:", currentNumber.buzz + "\n");
        System.out.printf("%17s %-1s", "duck:", currentNumber.duck + "\n");
        System.out.printf("%17s %-1s", "palindromic:", currentNumber.palindromic + "\n");
        System.out.printf("%17s %-1s", "gapful:", currentNumber.gapful + "\n");
        System.out.printf("%17s %-1s", "even:", currentNumber.even + "\n");
        System.out.printf("%17s %-1s", "odd:", !currentNumber.even + "\n\n");
    }

    public void multipleResults(long startValue, int iterations) {
        for (int i = 0; i < iterations; i++) {
            System.out.printf("%20s %-1s %-1s", startValue + i, "is",
                    validate.multipleInputs(startValue + i) + "\n");
        }
    }

    public void errorMessage() {
        System.out.println("\nThe first parameter should be a natural number or zero.\n");
    }

    public void startValueErrorMessage() {
        System.out.println("The first parameter should be a natural number or zero.");
    }

    public void iterationErrorMessage() {
        System.out.println("The second parameter should be a natural number.");
    }

    public void goodbyeMessage() {
        System.out.println("\nGoodbye.\n");
    }
}