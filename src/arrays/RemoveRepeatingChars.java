package arrays;

public class RemoveRepeatingChars {
	
	public static void test() {
		System.out.println("Res - "+(RemoveRepeatingChars.removeDuplicateCharsByBooleanFlagArr("badass")));
		System.out.println("Res - "+(RemoveRepeatingChars.removeDuplicateCharsByBooleanFlagArr("No repeat")));
		System.out.println("Res - "+(RemoveRepeatingChars.removeDuplicateCharsByBooleanFlagArr("aaaa")));
		System.out.println("Res - "+(RemoveRepeatingChars.removeDuplicateCharsByBooleanFlagArr("ata")));
	}
	
	public static String removeDuplicateCharsByBooleanFlagArr(String inputString) {
		boolean[] charFlags = new boolean[256];
		int nor = 0;
		char[] input = inputString.toCharArray();
		for(int i=0; i < input.length; i++){
			input[i-nor] = input[i];
			if(charFlags[input[i]]) {
				nor++;
			}
			charFlags[input[i]] = true;
		}
		
		return (new String(input)).substring(0, inputString.length()-1-nor+1);
	}
	
}
