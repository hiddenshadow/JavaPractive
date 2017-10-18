/**
 * 
 */
package arrays;

import java.util.ArrayList;

import com.practice.java.Utils;

/**
toString, hashCode equals
 */

/**
 * @author niharika
 *
 */
public class ArrayProblemsIntvBit {
	
	/**
	 * Print concentric rectangular pattern in a 2d matrix.
	 * @param a
	 * @return
	 */
	public  static ArrayList<ArrayList<Integer>> prettyPrint(int a) {
		if(a <1)return null;

		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();

		int numOfColNRows = 2*(a-1)+1;
		ArrayList<Integer> row = null;

		for (int i = 0; i < numOfColNRows; i++) {
			row  = new ArrayList<Integer>();
			for (int j = 0; j < numOfColNRows; j++) {
				row.add(-1);
			}
			res.add(row);
		}

		// Number of outer boxes
		for (int i = 0; i < a; i++) {
			int min = a-1-i, max = a-1+i;

			// Range of row and col is min to max.
			int valToSet = i+1;

			// Top row.
			for (int j = min; j <= max; j++) {
				res.get(min).set(j, valToSet);
			}

			// Right side
			for (int j = min; j <= max; j++) {
				res.get(j).set(max, valToSet);
			}

			// Bottom
			for (int j = min; j <= max; j++) {
				res.get(max).set(j, valToSet);
			}

			// Left side
			for (int j = min; j <= max; j++) {
				res.get(j).set(min, valToSet);
			}			
		}

		return res;
	}
	
	/**
	 * Given an integer array, find if an integer p exists in the array such that the number of integers greater than p in the array equals to p
	 * If such an integer is found return 1 else return -1.
	 * @param A
	 * @return
	 */
	public static int solve(ArrayList<Integer> A) {
		Utils.IntComp comp = new Utils.IntComp();
		A.sort(comp);
		
		int size = A.size();
		
		for (int i = 0; i < A.size(); i++) {
			if(A.get(i) == (size - i -1) ) return 1;
		}
		
		return -1;
    }

	/**
	 * Given an array of integers, sort the array into a wave like array and return it, 
	 * In other words, arrange the elements into a sequence such that a1 >= a2 <= a3 >= a4 <= a5.....
	 * @param a
	 * @return
	 */
	public static ArrayList<Integer> wave(ArrayList<Integer> a) {
		
		if(a == null || a.size()== 0  || a.size() == 1 ) {
			return a;
		}
		
		Utils.IntComp comp = new Utils.IntComp();
		a.sort(comp);
		
		int temp = a.get(0);
		
		for (int i = 0; i < a.size(); i = i+2) {
			Utils.swap(i, i+1, a);
		}
		
		return a;
	}
	
}
