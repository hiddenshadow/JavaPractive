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
public class MinMoneyForTour {


	    public static void driver(String args[] ) throws Exception {
	        
			Scanner reader = new Scanner(System.in);
	        int t = reader.nextInt(); // Read number of cases.
	        
	        int[] arr, arr2;
	        
	        while(t-- > 0){
	        	
	        	// In each case, first line has number of points. 
	            int n=reader.nextInt();
	            
	            arr=new int[n];
	            arr2=new int[n];

	            // Reading the number of points in a given case. Cost.
	            for(int i=0;i<n;i++){
	                arr[i]=reader.nextInt();
	            }
	            
	            // Reading the second set of points in a given case. Litres.
	            for(int i=0;i<n;i++){
	                arr2[i]=reader.nextInt();
	            }

	            System.out.println(getMinMoneyRequired(arr, arr2));
	        }

	    }
	    
	    public static int getMinMoneyRequired(int[] c, int[] l){
	        
	        int minSoFar = c[0];
	        int minCost = minSoFar*l[0];
	        
	        for(int i=1; i < c.length; i++){
	            minSoFar = Math.min(minSoFar, c[i]);
	            minCost += minSoFar*l[i];
	        }
	        
	        return minCost;
	    }

	
}
