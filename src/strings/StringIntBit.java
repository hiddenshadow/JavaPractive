/**
 * 
 */
package strings;

/**
toString, hashCode equals
 */

/**
 * @author niharika
 *
 */
public class StringIntBit {
	
	public static void test(){
		
		String a = "A man, a plan, a canal: Panama";
		
		System.out.println("isPalindrome -  "+isPalindrome(a));
		
	}
	
	public static  int isPalindrome(String a) {
		
		String lowerCase = a.toLowerCase(); 
		
		if(a == null || a.length() == 0) return 0;
		
		int sta=0, end=a.length()-1;
		
		while(sta <= end) {
			if( !isAlphaNumeric(lowerCase.charAt(sta)) ){
				sta++;
				continue;
			}
			
			if( !isAlphaNumeric(lowerCase.charAt(end)) ){
				end--;
				continue;
			}
			
			if( lowerCase.charAt(sta) == lowerCase.charAt(end) ){
				sta++; end--;
				continue;
			} else {
//				System.out.println("sta - "+ sta +"end  - "+end+" ");
				return 0;
			}
		}
		
		return 1;
	}
	
	public static boolean isAlphaNumeric(char ch){		

		if((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9')){
			return true;
		}
		
		return false;
	}
	

}
