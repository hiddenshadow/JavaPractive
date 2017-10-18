/**
 * 
 */
package arrays;

/**
toString, hashCode equals
 */

/**
 * @author niharika
 *Optimal Substructure:
Let arr[0..n-1] be the input array and L(i) be the length of the LIS ending at index i such that arr[i] is the last element of the LIS.
Then, L(i) can be recursively written as:
L(i) = 1 + max( L(j) ) where 0 < j < i and arr[j] < arr[i]; or
L(i) = 1, if no such j exists.
To find the LIS for a given array, we need to return max(L(i)) where 0 < i < n.
Thus, we see the LIS problem satisfies the optimal substructure property as the main problem can be solved using solutions to subproblems.
 */
public class LongestIncreasingSubSequence {

	/* Dynamic Programming Java implementation of LIS problem */

	/* lis() returns the length of the longest increasing
	       subsequence in arr[] of size n */
	public static int lis(int arr[],int n)
	{
		int lis[] = new int[n];
		int i,j,max = 0;

		/* Initialize LIS values for all indexes */
		for ( i = 0; i < n; i++ )
			lis[i] = 1;

		/* Compute optimized LIS values in bottom up manner */
		for ( i = 1; i < n; i++ )
			for ( j = 0; j < i; j++ ) 
				if ( arr[i] > arr[j] && lis[i] < lis[j] + 1)
					lis[i] = lis[j] + 1;

		/* Pick maximum of all LIS values */
		for ( i = 0; i < n; i++ )
			if ( max < lis[i] )
				max = lis[i];

		return max;
	}

	public static void main(String args[])
	{
		int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
		int n = arr.length;
		System.out.println("Length of lis is " + lis( arr, n ) + "n" );
	}


}
