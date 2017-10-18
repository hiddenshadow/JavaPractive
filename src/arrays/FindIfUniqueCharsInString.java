package arrays;

public class FindIfUniqueCharsInString {
	
	
	public static void test() {
		String input = "Quality defeats quantity";
		input = "only";
				
/*		System.out.println("hasUniqueCharsByDoubleLoop - " + FindIfUniqueCharsInString.hasUniqueCharsByDoubleLoop(input));
		System.out.println("hasUniqueCharsByBooleanFlagArr - " + FindIfUniqueCharsInString.hasUniqueCharsByBooleanFlagArr(input));*/
		System.out.println("hasUniqueCharsByVector - " + FindIfUniqueCharsInString.hasUniqueCharsByVector(input));

	}
	
	public static boolean isUniqueChars2(String str) {
		 boolean[] char_set = new boolean[256];
		 for (int i = 0; i < str.length(); i++) {
		 int val = str.charAt(i);
		 if (char_set[val]) return false;
		 char_set[val] = true;
		 }
		 return true;
		 }
	
	
	public static boolean hasUniqueCharsByVector(String input){
		int vector = 0;
		
		for(int i=0; i < input.length(); i++){			
			int mask = 1 << (input.charAt(i) - 'a');
			if( (vector & mask) == 1 ) return false;
			vector |= mask;
			
			System.out.println(" Char At - "+ (input.charAt(i) - 'a') +", mask is "+ Integer.toString(mask, 2) + ", vector is "+ Integer.toString(vector, 2));
		}
		
		return true;
	}
	
	
	public static boolean hasUniqueCharsByBooleanFlagArr(String input) {
		boolean[] charFlags = new boolean[256];
		
		for(int i=0; i < input.length(); i++){			
			if(charFlags[input.charAt(i)]) return false;
			charFlags[input.charAt(i)] = true;
		}
		
		return true;
	}
	
	public static boolean hasUniqueCharsByDoubleLoop(String input) {		
		for (int i = 0; i < input.length() - 1; i++) {
			for(int j=i+1; j < input.length(); j++){
				if(input.charAt(i) == input.charAt(j)) return false;				
			}
		}
				
		return true;
	}

}
