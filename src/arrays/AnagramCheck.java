package arrays;

public class AnagramCheck {
	
	public static void test(){
		
		String s1 = "bat";
		String s2 = "fat";
		System.out.println("s1 - "+s1+", s2 - "+s2+", "+testIfAnagrams(s1, s2));
		
		s1 = "ring";
		s2 = "grin";
		System.out.println("s1 - "+s1+", s2 - "+s2+", "+testIfAnagrams(s1, s2));
		
		s1 = "raan";
		s2 = "ran";
		System.out.println("s1 - "+s1+", s2 - "+s2+", "+testIfAnagrams(s1, s2));
		
	}
	
	public static boolean testIfAnagrams(String s1, String s2){
		
		if(s1.length() != s2.length())return false;
		
		int[] count = new int[256];
		for(int i=0; i< s1.length(); i++){
			count[s1.charAt(i)]++;
			count[s2.charAt(i)]--;
		}
		
		for(int i=0; i< s1.length(); i++){
			if(count[s1.charAt(i)] != 0) return false;
			if(count[s2.charAt(i)] != 0) return false;
		}
		
		return true;
	}

}
