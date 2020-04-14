package _04_Base64_Decoder;

public class Base64Decoder {
	/*
	 * Base 64 is a way of encoding binary data using text. Each number 0-63 is
	 * mapped to a character. NOTE: THIS IS NOT THE SAME AS ASCII OR UNICODE
	 * ENCODING! Since the numbers 0 through 63 can be represented using 6 bits,
	 * every four (4) characters will represent twenty four (24) bits of data. 4 * 6
	 * = 24
	 * 
	 * For this exercise, we won't worry about what happens if the total bits being
	 * converted do not divide evenly by 24.
	 * 
	 * If one char is 8 bits, is this an efficient way of storing binary data?
	 * (hint: no)
	 * 
	 * It is, however, useful for things such as storing media data inside an HTML
	 * file (for web development), so that way a web site does not have to look for
	 * an image, sound, library, or whatever in a separate location.
	 * 
	 * View this link for a full description of Base64 encoding
	 * https://en.wikipedia.org/wiki/Base64
	 */

	final static char[] base64Chars = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
			'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
			'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5',
			'6', '7', '8', '9', '+', '/' };

	// 2. Complete this method so that it returns the the element in
	// the base64Chars array that corresponds to the passed in char.
	public static byte convertBase64Char(char c) {
		for (int i = 0; i < base64Chars.length; i++) {
			if (base64Chars[i] == c) {
				return (byte) i;
			}
		}
		return 0;

	}

	// 2. Complete this method so that it will take in a string that is 4
	// characters long and return an array of 3 bytes (24 bits). The byte
	// array should be the binary value of the encoded characters.
	public static byte[] convert4CharsTo24Bits(String s) {
		byte[] bytes = { 0, 0, 0, 0 };
		byte[] toReturn = { 0, 0, 0 };
		for (int j = 0; j < s.length(); j++) {
			bytes[j] = convertBase64Char(s.charAt(j));
		}
		byte num1a = bytes[0];
		byte num1b = bytes[1];
		num1a <<= 2;
		num1b >>= 4;
		byte num2a = bytes[1];
		byte num2b = bytes[2];
		num2a <<= 4;
		num2b >>= 2;
		byte num3a = bytes[2];
		byte num3b = bytes[3];
		num3a <<= 6;

		toReturn[0] = (byte) (num1a + num1b);
		toReturn[1] = (byte) (num2a + num2b);
		toReturn[2] = (byte) (num3a + num3b);

//		System.out.println(num2a);
//		System.out.println(num2b);

		return toReturn;
	}

	// 3. Complete this method so that it takes in a string of any length
	// and returns the full byte array of the decoded base64 characters.
	public static byte[] base64StringToByteArray(String file) {
		byte[] bytes = new byte[(file.length() / 4 )* 3];
		byte[] temp;
		int k = 0;
		for (int j = 0; j < file.length(); j += 4) {
			
			temp = convert4CharsTo24Bits(file.substring(j, 4 + j));
			
			for (int i = 0; i < temp.length; i++) {
				
				bytes[k+i] = temp[i];
			}
			k += 3;
		}
	
		return bytes;
	}
}
