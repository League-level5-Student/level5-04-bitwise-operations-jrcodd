package _03_Printing_Binary;

public class BinaryPrinter {
	// Complete the methods below so they print the passed in parameter in binary.
	// Use bit shifting and bit masking to print the binary numbers.
	// Do not use the Integer.toBinaryString method!
	// Don't be afraid to use the methods that are already complete to finish the
	// others.
	// Create a main method to test your methods.
	public static void main(String[] args) {
		Byte b = 127;
		short s = 32767;
		BinaryPrinter bp = new BinaryPrinter();
		bp.printByteBinary(b);
		bp.printShortBinary(s);
		
		
	}

//1100100
	public void printByteBinary(byte b) {
//		byte mask = 0b10000000;
//		for (int i = 7; i >= 0; i--) {
//			System.out.print( (b & mask) >> i);
//			mask>>=1;
//		}
		String str = "";
		while ((b != 0)) {
			if ((b & 1) != 0) {
				str = '1' + str;
			} else {
				str = '0' + str;
			}
			b >>= 1;

		}
		System.out.println(str);

	}

	public void printShortBinary(short s) {
		String str = "";
		while ((s != 0)) {
			if ((s & 1) != 0) {
				str = '1' + str;
			} else {
				str = '0' + str;
			}
			s >>= 1;

		}
		System.out.println(str);

	}

	public void printIntBinary(int i) {
		String str = "";
		while ((i != 0)) {
			if ((i & 1) != 0) {
				str = '1' + str;
			} else {
				str = '0' + str;
			}
			i >>= 1;

		}
		System.out.println(str);

	}

	public void printLongBinary(long l) {
		String str = "";
		while ((l != 0)) {
			if ((l & 1) != 0) {
				str = '1' + str;
			} else {
				str = '0' + str;
			}
			l >>= 1;

		}
		System.out.println(str);

	}
}
