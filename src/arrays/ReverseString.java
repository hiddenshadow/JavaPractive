package arrays;

public class ReverseString {
	
	public static void test(){
		System.out.println("Rev "+reverseString("Marine"));
	}
	
	public static String reverseString(String input){
		 char[] inputArr = input.toCharArray();
		 
		 for(int l=0, r=inputArr.length-1; l < r  ; l++, r--){
			 char temp = inputArr[l];
			 inputArr[l] = inputArr[r];
			 inputArr[r] = temp;
		 }
		 return new String(inputArr);
	}

}
