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
public class ProductOfNumbers {

	/**
	 * 
	 * @param a
	 * @param b
	 */
	public static String multiply(String a, String b){
		
		if(a == null || b == null)
			return null;
		
		StringBuffer sb = new StringBuffer();
		
		char[] ac = sb.append(a).reverse().toString().toCharArray();
		char[] bc = sb.append(b).reverse().toString().toCharArray();
		
		
		
		
		return "No result yet";
	}
	
	
}
