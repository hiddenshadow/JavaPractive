/**
 * 
 */
package towPointers;

import java.util.ArrayList;

import com.practice.java.Utils;

/**
toString, hashCode equals
 */

/**
 * @author niharika
 *
 */
public class IntArrayTwoPointerIntvBit {
	
	/**
	 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. 
	 * Return the sum of the three integers. Assume that there will only be one solution.
	 * @param A
	 * @param B
	 * @param C
	 * @return
	 */
	public static int solve3Sum(ArrayList<Integer> A, ArrayList<Integer> B, ArrayList<Integer> C) {
		int minAbsDiff = Integer.MAX_VALUE;
		int curAbs = Integer.MAX_VALUE;
		
		int i=0, j=0, k=0;
		int curMin = Integer.MAX_VALUE;
		int curMax = Integer.MIN_VALUE;
		
		while( i < A.size() && j < B.size() && k < C.size()){
			
			curMin = Math.min( Math.min(A.get(i), B.get(j)), C.get(k) );
			curMax = Math.max( Math.max(A.get(i), B.get(j)), C.get(k) );
			
			curAbs = curMax - curMin;
			
			if(minAbsDiff > curAbs){
				minAbsDiff = curAbs;
			}
			
			while(i < A.size() && curMin == A.get(i)){
				i++;
			}
			
			while(j < B.size() && curMin == B.get(j)){
				j++;
			}
			
			while(k < C.size() && curMin == C.get(k)){
				k++;
			}
		}
		
		return minAbsDiff;
    }
	
	/**
	 * Given three sorted arrays A, B and Cof not necessarily same sizes.
	 * Calculate the minimum absolute difference between the maximum and minimum number from the triplet a, b, c such that a, b, c belongs arrays A, B, C respectively.
	 * i.e. minimize | max(a,b,c) - min(a,b,c) |.
	 * @param a
	 * @param b
	 * @return
	 */
	public static int threeSumClosest(ArrayList<Integer> a, int b) {
		Utils.IntComp comp = new Utils.IntComp();
		a.sort(comp);
		
		int minDiff = Integer.MAX_VALUE;
		int minSum = Integer.MAX_VALUE;
		int sum = 0;
		
		for (int i = a.size()-1; i > 1 ; i--) {
			
			for (int j = 0; j < i; j++) {
				
				for (int j2 = i-1; j2 > j; j2--) {
					sum = a.get(i) + a.get(j) +a.get(j2);
					
					if(Math.abs(sum - b) < minDiff ){
						minDiff = Math.abs(sum - b);
						minSum = sum;
					}
				}
			}
		}
			
		return minSum;
	}

}
