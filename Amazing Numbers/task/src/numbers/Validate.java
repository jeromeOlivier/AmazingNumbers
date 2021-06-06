package numbers;

import java.util.ArrayList;
import java.util.List;

public class Validate {
    
    public AmazingNumber singleInput(long number) {
        AmazingNumber currentNumber = new AmazingNumber(number);
        currentNumber.even = checkIfNumberIsEven(number);
        currentNumber.odd = !checkIfNumberIsEven(number);
        currentNumber.buzz = checkIfNumberIsBuzz(number);
        currentNumber.duck = checkIfNumberIsDuck(number);
        currentNumber.palindromic = checkIfNumberIsPalindromic(number);
        currentNumber.gapful = checkIfNumberIsGapful(number);

        return currentNumber;
    }

    public String multipleInputs(long startValue) {
        List<String> arrayList = new ArrayList<>();

        if (checkIfNumberIsGapful(startValue)) {
            arrayList.add("gapful");
        }
        if (checkIfNumberIsPalindromic(startValue)) {
            arrayList.add("palindromic");
        }
        if (checkIfNumberIsDuck(startValue)) {
            arrayList.add("duck");
        }
        if (checkIfNumberIsBuzz(startValue)) {
            arrayList.add("buzz");
        }
        if (checkIfNumberIsEven(startValue)) {
            arrayList.add("even");
        }
        if (!checkIfNumberIsEven(startValue)) {
            arrayList.add("odd");
        }

        return String.join(", ", arrayList);
    }



    public boolean checkIfNumberIsEven(long number) {
        return number % 2 == 0;
    }

    public boolean checkIfNumberIsBuzz(long number) {
        boolean divisibleBySeven = number % 7 == 0;
        boolean endsWithSeven = number % 10 == 7;
        return (divisibleBySeven || endsWithSeven);
    }

    public boolean checkIfNumberIsDuck(long number) {
        String inputNumber = String.valueOf(number);
        return inputNumber.contains("0");
    }

    public boolean checkIfNumberIsPalindromic(long number) {
        String inputNumber = String.valueOf(number);
        StringBuilder sb = new StringBuilder(inputNumber);
        return inputNumber.equals(sb.reverse().toString());
    }

    public boolean checkIfNumberIsGapful(long number) {
        if (number < 100) {
            return false;
        }
        long numberOfdigits = (long) (Math.log10(number));
        long firstDigit = (number / (long) (Math.pow(10, numberOfdigits))) * 10;
        long lastDigit = number % 10;
        return number % (firstDigit + lastDigit) == 0;
    }

    public boolean checkIfNumberIsSpy(long startValue) {
        long digitNumber, sum = 0, prod = 1;

        while (startValue > 0) {
            digitNumber = startValue % 10;

            sum += digitNumber;
            prod *= digitNumber;

            startValue /= 10;
        }
        return (prod == sum);
    }

}