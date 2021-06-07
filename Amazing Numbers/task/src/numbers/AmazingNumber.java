package numbers;

import java.util.ArrayList;
import java.util.List;

public class AmazingNumber {

	boolean even, odd, buzz, duck, palindromic, gapful, spy;
	long value;

	String evenName = "even";
	String oddName = "odd";
	String buzzName = "buzz";
	String duckName = "duck";
	String palindromicName = "palindromic";
	String gapfulName = "gapful";
	String spyName = "spy";

	List<String> nameList = new ArrayList<>();

	public void nameList() {
		nameList.add(evenName);
		nameList.add(oddName);
		nameList.add(buzzName);
		nameList.add(duckName);
		nameList.add(palindromicName);
		nameList.add(gapfulName);
		nameList.add(spyName);
	}

	AmazingNumber(long number) {
		this.value = number;
	}

	AmazingNumber() { }

}