package arrays;

public class StringCharAndEncoding {
	
	public static void test(){
		testCharStringEncoding();
	}
	
	public static void testCharStringEncoding(){
		char[] testChars = new char[260];
		testChars[0] = 258;
		System.out.println("Test char - "+testChars[0]);
		testChars[1] = '?';
		System.out.println("Test char - "+testChars[1]+", Ascii val - "+ (testChars[1] - 0));
		testChars[2] = 255;
		System.out.println("Test char - "+testChars[2]);
		testChars[3] = 259;
		System.out.println("Test char - "+testChars[3]);
		testChars[4] = 1259;
		System.out.println("Test char - "+testChars[4]);
		
		
	}

}
