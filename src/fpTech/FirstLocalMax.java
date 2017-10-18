/**
 * 
 */
package fpTech;

/**
toString, hashCode equals
 */

/**
 * @author niharika
 *
 */
public class FirstLocalMax {
	
	public static void test(){
		int[] inp = {9,8,7, 1, 10};
		System.out.println(getFirstLocalMax(inp));
		
		int[] asc = {1, 2, 3};
		System.out.println(getFirstLocalMax(asc));
		
		int[] mid2 = {1, 2, 3, 4, 2 };
		System.out.println(getFirstLocalMax(mid2));
		
	}
	
	/**
	 * Return index of local first Max
	 * @param inp
	 * @return
	 */
	public static int getFirstLocalMax(int[] inp){

		int localMax = -1;
		int l=0, r=inp.length-1, m;
		
		// As long as length is more than 2
		while( r-l > 1){
			m = (l+r)/2;
			
			// Max at mid
			if( inp[m] > inp[m-1] && inp[m] > inp[m+1]){
				return m;
			} else {
				if(inp[m-1] > inp[m+1]){
					r = m-1;
				} else {
					l = m+1;
				}
			}
		}
		
		// Only two elements
		if(inp[l] > inp[r]){
			return l;
		} else {
			return r;
		}
	}
	

}
