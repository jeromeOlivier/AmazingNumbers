package numbers;

public class Check {

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

	public boolean ifNumberIsSpy(long number) {
		long digitNumber, sum = 0, prod = 1;

		while (number > 0) {
			digitNumber = number % 10;

			sum += digitNumber;
			prod *= digitNumber;

			number /= 10;
		}
		return (prod == sum);
	}
}