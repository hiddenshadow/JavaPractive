/**
 * 
 */
package binarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import com.practice.java.Utils;



/**
toString, hashCode equals
 */

/**
 * @author niharika
 *
 */
public class BinarySearchIntBit {

	public static void test(){
		testSqrt();
	}

	public static void testSqrt(){
		//30506
		//		System.out.println(getSqrt(930675566));
		System.out.println(getSqrt(9));
	}

	public static void testMedianMat(){
		//		int[][] mat = {  {1, 2, 3, 4, 9}, {5, 6, 7, 8, 9}, {1, 2, 3, 4, 9} };

		ArrayList<ArrayList<Integer>> mat = new ArrayList<>();

		int[] arr = {1, 2, 3, 4, 9};
		ArrayList<Integer> cur = Utils.getArrayList(arr); 
		mat.add(cur);

		int[] arr2 = {5, 6, 7, 8, 9};
		cur = Utils.getArrayList(arr2);
		mat.add(cur);

		int[] arr3 = {1, 2, 3, 4, 9};
		cur = Utils.getArrayList(arr3);
		mat.add(cur);		

		System.out.println("mat "+mat);
		System.out.println("mat "+mat.get(0));
		System.out.println("mat "+mat.get(0).get(0));

		System.out.println("findMedian - "+findMedian(mat));

	}

	public static void testSearchMatrix(){

		ArrayList<ArrayList<Integer>> a = new ArrayList<>();

		int[]  r1 = {2, 3, 4, 6};

		a.add(Utils.getArrayList(r1));

		int[]  r2 = {16, 19, 33, 36};
		a.add(Utils.getArrayList(r2));

		int[] r3 = {37, 38, 38, 41};
		a.add(Utils.getArrayList(r3));

		int[] r4= {47, 47, 50, 51};
		a.add(Utils.getArrayList(r4));

		int[] r5 = {55, 57, 58, 62};
		a.add(Utils.getArrayList(r5));

		int[] r6 = {63, 65, 66, 66};
		a.add(Utils.getArrayList(r6));

		int[] r7 = {68, 70, 75, 77};
		a.add(Utils.getArrayList(r7));

		int[] r8 = {78, 84, 84, 86};
		a.add(Utils.getArrayList(r8));

		int[] r9 = {86, 87, 88, 92};
		a.add(Utils.getArrayList(r9));

		int[] r10 = {94, 95, 96, 97};
		a.add(Utils.getArrayList(r10));

		//		System.out.println(searchMatrix(a, 81));
		System.out.println(searchMatrix(a, 94));

	}

	public static int searchMatrix(ArrayList<ArrayList<Integer>> a, int b) {

		int l,r,mid, top, bot, mRow, row = 0;

		if(a == null) return 0;

		int m = a.size(), n = a.get(0).size();

		// Within Matrix.
		if( b >= a.get(0).get(0) && b <= a.get(m-1).get(n-1) ){

			top=0; bot=m-1; 

			while(top <= bot){
				mRow=(top+bot)/2;

				if(a.get(mRow).get(0) <= b){
					row = mRow;
					top = mRow+1;
				} else {
					bot = mRow-1;
				}
			}

			l=0; r=n-1; 

			while(l <= r){
				mid=(l+r)/2;

				if(a.get(row).get(mid) == b){
					return 1;
				} else if(a.get(row).get(mid) > b) {
					r = mid-1;
				} else {
					l = mid+1;
				}
			}

		} else {
			return 0;
		}

		return 0; 
	}

	public static int getSqrt(int a){
		int curPF=4;

		if(a <= 0 )
			return 0;

		if(a < 4) return 1;
		if(a < 9) return 2;

		int l=0, r= (int) Math.sqrt(Integer.MAX_VALUE), m = a/4;

		while(l <= r){
			System.out.println("l = "+l+", r="+r+", curPF="+curPF);

			m = (l+r)/2;
			curPF = m*m;

			if(curPF == a){
				return m;
			} else if(curPF > a) {
				r = m-1;
			} else {
				l = m+1;
			}
		}


		return r-1;
	}

	public static int findMedianBySorting(ArrayList<ArrayList<Integer>> A) {

		int rows = A.size(), columnns = A.get(0).size();
		int nextRow;

		int r1, r2, temp, r3;
		Integer val1 = null, val2 = null;

		boolean hasSwap = true;
		while(hasSwap){
			hasSwap = false;

			for (int i = 0; i < rows-1; i++) {
				r1=0; r2=0;

				while(r1 < columnns && r2 < columnns){	
					val1 = A.get(i).get(r1); 
					val2 = A.get(i+1).get(r2);

					if( val1 > val2 ) {

						hasSwap = true;

						temp = A.get(i).get(r1);
						A.get(i).set(r1, A.get(i+1).get(r2));
						A.get(i+1).set(r2, temp);

						r3=r2;
						while(r3 < columnns-1){
							val1 = A.get(i+1).get(r3); 
							val2 = A.get(i+1).get(r3+1); 

							if( val1 > val2 ){

								Utils.swap(r3, r3+1, A.get(i+1));

								/*							temp = A.get(i+1).get(r3);
								A.get(i+1).set(r3, A.get(i).get(r3+1));
								A.get(i+1).set(r3+1, temp);*/
								r3++;
							} else {
								break;
							}

						}
					}

					r1++;
				}

			}

		}



		System.out.println("After sorting - "+A);

		return A.get(rows/2).get(columnns/2);
	}

	public static int findMedian(ArrayList<ArrayList<Integer>> A) {
		int high=Integer.MAX_VALUE;
		int low=0;
		int x=1;

		while(low <= high){
			int mid = (low+high)/2;
			if(function(A,mid)){
				low=mid+1;
			} else {
				x=mid;
				high=mid-1;
			}
		}

		return x;
	}


	public static boolean function(ArrayList<ArrayList<Integer>> A,int num){
		int n=A.size(), m=A.get(0).size(), c=0;

		for(int i=0;i<n;i++){
			c += count(A.get(i),num);
		}
		return c<(n*m)/2 +1;
	}

	/**
	 * Counts number of ints smaller than the given number num, the sorted array.
	 * @param A
	 * @param num
	 * @return
	 */
	public static int count(ArrayList<Integer> A,int num){
		int low=0, high=A.size()-1;

		while(low <= high){
			int mid=(low+high)/2;

			if(A.get(mid)>num){
				high=mid-1;
			} else {
				low=mid+1;
			}
		}

		return low;                
	}

}