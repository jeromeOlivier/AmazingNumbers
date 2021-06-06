package numbers;

public class Validate {
    Check check = new Check();

    public AmazingNumber userInput(long numberToCheck) {
        AmazingNumber currentNumber = new AmazingNumber(numberToCheck);
        currentNumber.even = check.ifNumberIsEven(numberToCheck);
        currentNumber.odd = !check.ifNumberIsEven(numberToCheck);
        currentNumber.buzz = check.ifNumberIsBuzz(numberToCheck);
        currentNumber.duck = check.ifNumberIsDuck(numberToCheck);
        currentNumber.palindromic = check.ifNumberIsPalindromic(numberToCheck);
        currentNumber.gapful = check.ifNumberIsGapful(numberToCheck);

        return currentNumber;
    }
}