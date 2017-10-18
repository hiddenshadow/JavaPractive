/**
 * 
 */
package math;

import java.util.ArrayList;
import java.util.LinkedList;

/**
toString, hashCode equals
 */

/**
 * @author niharika
 *
 */
public class MathProblems {

	public static void test(){
		
		System.out.println("gcd(3, 6) - "+gcd(3, 6));
	}
	
	public static int gcd(int a, int b) {
		if(a == b) return a;
		
		int divd = 0;
		int div = Math.max(a, b);
		int rem = Math.min(a, b);
		
		while(rem !=0){
			divd = div;
			div = rem;
			rem = divd % div;
		}
		
		return div;
	}

	/**
	 * 1 is not a prime.
	 * @param a
	 * @return 0 if the given number a is not a prime. And return 1 if it is prime.
	 */
	public static int isPrime(int a){
		if(a <= 1) return 0;

		int limit = (int) Math.sqrt(a);

		for (int i = 2; i <= limit; i++) {
			if((a % i) == 0 )return 0;
		}

		return 1;
	}
	
	public static String findDigitsInBinary(int a) {
		StringBuffer sb = new StringBuffer();

		int dividend = a;
		int divisor = 2;
		int rem = 0;

		while(dividend > 0){
			rem = dividend % divisor;
			dividend = dividend / 2;
			sb.append(rem);
		}

		sb.reverse();
		return sb.toString();
	}
	
	/**
	 * Given an even number ( greater than 2 ), return two prime numbers whose sum will be equal to given number.
	 * NOTE: A solution will always exist. read Goldbach’s conjecture.
	 * Input : 4,  Output: 2 + 2 = 4
	 *
	 * @param a
	 * @return
	 */
	public static ArrayList<Integer> primeSum(int a) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		for (int i = 2; i < a; i++) {
			if( MathProblems.isPrime(i)==1 && MathProblems.isPrime(a - i)==1 ){
				ArrayList<Integer> temp = new ArrayList(); 
				temp.add(i); temp.add(a-i);
				return temp;
			}
		}

		return null;
	}
	
	/**
	 * Given a column title as appears in an Excel sheet, return its corresponding column number. 
	 * A  ->  1 
	 * AB -> 28
	 * @param a
	 * @return
	 */
	public static int titleToNumber(String a) {
		int totalNumber = 0, placeValue = 1, digitValue=0;
		
		for (int i = a.length()-1 ; i >= 0  ; i--) {
			digitValue = a.charAt(i) - 'A' +1;
			totalNumber += digitValue*placeValue;
			placeValue *= 26;
		}

		return totalNumber;
	}
	
	
	/*// TODO: Write a mehtod to return all the prime factors of it.
	  public ArrayList<Integer> getPrimeFactor(int a){
		if(a <= 1) return null;
		
		int limit = (int) Math.sqrt(a);
		
		ArrayList<Integer> factors = new ArrayList<>();
		LinkedList<Integer> rest = new LinkedList<>();
		
		for (int i = 1; i <= limit; i++) {
			if( (a % i) == 0 ){
				factors.add(i);
				rest.addFirst(( a / i));
			}
		}
		
		return null;
	}*/
}
