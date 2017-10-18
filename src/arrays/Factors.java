/**
 * 
 */
package arrays;

import java.util.ArrayList;

/**
toString, hashCode equals
 */

/**
 * @author niharika
 *
 */
public class Factors {

	public static void test(){
		System.out.println(allFactors(10));
	}
	
	public static ArrayList<Integer> allFactors(int a) {

		ArrayList<Integer> res = new ArrayList<Integer>();

		res.add(1);
		
		
		for(int i=2; i <= a; i++){
			System.out.println("I = "+i+", res - "+(a / i));
			if( (a % i) == 0){
				res.add(i);
			}
		}

		res.add(a);
		
//		sachins
		
		return res;
	}


}
