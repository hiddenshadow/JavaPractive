/**
 * 
 */
package arrays;

/**
toString, hashCode equals
 */

/**
 * @author niharika
 *
 */
public class MaxPossibleProductOfIntegers {
	
	public static void test(){
		int[] ar1 = {1, 2, 3};
		System.out.println(maxProdOfInts(ar1));
		
		int[] ar2 = {1, 9, 5, 0, 3, 5};
		System.out.println(maxProdOfInts(ar2));
		
		int[] ar3 = {1, 9, 5, 0, 3, 16};
		System.out.println(maxProdOfInts(ar3));
		
		int[] ar4 = {1, 9, 5, -3, 15};
		System.out.println(maxProdOfInts(ar4));
		
		int[] ar5 = {1, 9, 5, -3, 15, -1};
		System.out.println(maxProdOfInts(ar5));		
	}
	
	public static int maxProdOfInts(int[] arr){
		int cProd, mProd, nProd;
		
		if(arr == null) return 0;
		
		cProd = nProd = mProd = arr[0];
		
		for (int i = 0; i < arr.length; i++) {
			
			mProd = Math.max(mProd, Math.max(cProd, nProd));
			
			if(cProd == 0){
				cProd = nProd = arr[i];
			} else if(cProd < 0 ){
				cProd = arr[i];
				nProd *= arr[i];
			} else {
				cProd *= arr[i];
				nProd *= arr[i];
			}
		}
		
		mProd = Math.max(mProd, Math.max(cProd, nProd));
		
		return mProd;
	}

}
