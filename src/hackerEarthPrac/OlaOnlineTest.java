/**
 * 
 */
package hackerEarthPrac;

import java.util.Scanner;

/**
toString, hashCode equals
 */

/**
 * @author niharika
 *
 */
public class OlaOnlineTest {
//	public static void test(){
//		
//		Scanner reader = new Scanner(System.in);
//        int t = reader.nextInt(); // Read number of cases.
//        
//        int[] arr, arr2;
//        
//        while(t-- > 0){
//        	
//        	// In each case, first line has number of points. 
//            int n=reader.nextInt();
//            
//            arr=new int[n];
//            arr2=new int[n];
//
//            // Reading the number of points in a given case. Cost.
//            for(int i=0;i<n;i++){
//                arr[i]=reader.nextInt();
//            }
//            
//            // Reading the second set of points in a given case. Litres.
//            for(int i=0;i<n;i++){
//                arr2[i]=reader.nextInt();
//            }
//
//            System.out.println(util(arr, arr2));
//        }
//		
//		
//	}
	
	public static String[] cavityMap(String[] arr) {
			
		int r=arr.length;
		int c=arr[0].length();
		
		int[] adjr = { 0, 0,-1, 1};
		int[] adjc = {-1, 1, 0, 0};
		char[] cur;
		
		for (int i = 1; i < r-1; i++) {
			cur = arr[i].toCharArray();
			for (int j = 1; j < c-1; j++) {
				char curCh = arr[i].charAt(j); 
				boolean flag = true;
				for (int j2 = 0; j2 < adjc.length; j2++) {
					char temp = arr[i + adjr[j2] ].charAt(j+adjc[j2]);
					if( curCh >  temp ){
						continue;
					} else {
						flag = false;
					}
				}
				
				if(flag){
					cur[j] = 'X';
				}
				
				
			}
			arr[i] = new String(cur);			
		}
		
		return arr;
	}
	
	
	public static int numberOfPaths(int[][] a) {
		
		if(a == null) return 0;
		
		int m = a.length;
		int n = a[0].length;
		
		return numberOfPathsRec(a, 0, 0, m-1, n-1);
    }
	
	public static int numberOfPathsRec(int[][] a, int r, int c, int re, int ce) {
		
		int right= 0, down=0;
		
		if(r==re && c==ce) return 1;
		
		if(r < re && c == ce) {
			
			if(a[r+1][c] == 1){
				right = numberOfPathsRec(a, r+1, c, re, ce);
			}
			
			return right;
		}
		
		if(r == re && c < ce) {
			
			if( a[r][c+1] == 1 ){
				down = numberOfPathsRec(a, r, c+1, re, ce);
			}
			
			return down;
		}
		
		// right
		if( a[r][c+1] == 1 ){
			down = numberOfPathsRec(a, r, c+1, re, ce);
		}
		
		if(a[r+1][c] == 1){
			right = numberOfPathsRec(a, r+1, c, re, ce);
		}
		
		return right+down;
    }
	
	
}
