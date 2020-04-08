package _01_Bit_Shifting;

public class BitShifter {
	public static void main(String[] args) {
		// 1. Jot down the value of num in binary.
		int num = 4;
		int numShifted = num << 1;
		
		// 2. Print the value of numShifted, and convert that value to binary.
		System.out.println(numShifted);
		// 3. Compare the two binary values. Can you figure out what the << operator is for?
		//it moves the values over 1 so 0 0 0 1 0 0 = 0 0 1 0 0 0
		// 4. Try shifting num 3 places.
		int numShifted3 = num<<3;
		System.out.println(numShifted3); 
		// FYI: Binary values can be shifted to the right as well using the >> operator.	
	}
}
