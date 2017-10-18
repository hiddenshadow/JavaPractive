/**
 * 
 */
package bitManipulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
toString, hashCode equals
 */

/**
 * @author niharika
 *
 */
public class BitManipulation {

	/*	x & (x-1) will clear the lowest set bit of x
	x & ~(x-1) extracts the lowest set bit of x (all others are clear). Pretty patterns when applied to a linear sequence.
	x & (x + (1 << n)) = x, with the run of set bits (possibly length 0) starting at bit n cleared.
	x & ~(x + (1 << n)) = the run of set bits (possibly length 0) in x, starting at bit n.
	x | (x + 1) = x with the lowest cleared bit set.
	x | ~(x + 1) = extracts the lowest cleared bit of x (all others are set).
	x | (x - (1 << n)) = x, with the run of cleared bits (possibly length 0) starting at bit n set.
	x | ~(x - (1 << n)) = the lowest run of cleared bits (possibly length 0) in x, starting at bit n are the only clear bits.*/


	public static void testMinXor(){

		ArrayList<Integer> ar = new ArrayList<>();
		ar.add(2);
		ar.add(12);
		ar.add(6);
		ar.add(4);
		
		System.out.println(findMinXor(ar));

	}

	public static void testClearLowest(){
		int val = 7;
		System.out.println("Before clearing lowest set bit: "+ Integer.toBinaryString(val));
		int res = clearLowestSetBit(val);
		System.out.println("After clearing lowest set bit: "+ Integer.toBinaryString(res));

		val = 10;
		System.out.println("Before clearing lowest set bit: "+ Integer.toBinaryString(val));
		res = clearLowestSetBit(val);
		System.out.println("After clearing lowest set bit: "+ Integer.toBinaryString(res));
	}

	public static int clearLowestSetBit(int x){		
		return ( x & (x-1) );
	}


	public static class IntComparator implements Comparator<Integer> {

		public int compare(Integer a, Integer b ){
			return a-b;
		}

	} 

	public static int findMinXor(ArrayList<Integer> A) {

		IntComparator inc = new BitManipulation.IntComparator();

		A.sort(inc);
		int min = Integer.MAX_VALUE, cur=0;

		System.out.println("A.size() - "+A.size());
		
		for(int i=0; i < A.size()-1; i++) {

			cur = (A.get(i)) ^ (A.get(i+1));

			if(cur < min){
				min = cur;
			}

		}

		return min;
	}


}
