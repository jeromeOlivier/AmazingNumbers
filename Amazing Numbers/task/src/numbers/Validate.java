package numbers;

public class Validate {
    Check check = new Check();

    public boolean controlFlow(long loopedNumber, String specialProperty) {
        AmazingNumber legal = new AmazingNumber();
        if (specialProperty.equals(legal.evenName)) {
            return check.ifNumberIsEven(loopedNumber);
        } else if (specialProperty.equals(legal.oddName)) {
            return !check.ifNumberIsEven(loopedNumber);
        } else if (specialProperty.equals(legal.buzzName)) {
            return check.ifNumberIsBuzz(loopedNumber);
        } else if (specialProperty.equals(legal.duckName)) {
            return check.ifNumberIsDuck(loopedNumber);
        } else if (specialProperty.equals(legal.palindromicName)) {
            return check.ifNumberIsPalindromic(loopedNumber);
        } else if (specialProperty.equals(legal.gapfulName)) {
            return check.ifNumberIsGapful(loopedNumber);
        } else if (specialProperty.equals(legal.spyName)){
            return check.ifNumberIsSpy(loopedNumber);
        } else {
            return false;
        }
    }

    public AmazingNumber userInput(long numberToCheck) {
        AmazingNumber currentNumber = new AmazingNumber(numberToCheck);
        currentNumber.even = check.ifNumberIsEven(numberToCheck);
        currentNumber.odd = !check.ifNumberIsEven(numberToCheck);
        currentNumber.buzz = check.ifNumberIsBuzz(numberToCheck);
        currentNumber.duck = check.ifNumberIsDuck(numberToCheck);
        currentNumber.palindromic = check.ifNumberIsPalindromic(numberToCheck);
        currentNumber.gapful = check.ifNumberIsGapful(numberToCheck);
        currentNumber.spy = check.ifNumberIsSpy(numberToCheck);
        return currentNumber;
    }
}