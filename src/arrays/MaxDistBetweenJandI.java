/**
 * 
 */
package arrays;

import com.practice.java.Utils;

/**
toString, hashCode equals
 */

/**
 * @author niharika
 *
 */
public class MaxDistBetweenJandI {

	
	public static void test(){
		int[] inp = {3, 6, 7, 0, 1, 2};
		System.out.println("Maxd = "+getMaxDist(inp));
	}
	/**
	 * http://www.geeksforgeeks.org/given-an-array-arr-find-the-maximum-j-i-such-that-arrj-arri/
	 * @param arr
	 * @return
	 */
	public static int getMaxDist(int[] arr){
	
		int maxd = 0, l;
		
		if(arr == null ) return maxd;
		
		l = arr.length;
		
		if(arr.length == 1) return maxd;
		
		int[] lMin = Utils.getLminAuxArr(arr);
		
		int[] rMax = Utils.getRMaxAuxArr(arr);
		
		int i = 0, j =0;
		
		while(i < arr.length && j < arr.length){
			if(lMin[i] < rMax[j]){
				maxd = Math.max(maxd, j-i);
				j++;
			} else {
				i++;
			}
		}
		
		return maxd;
	}

}
