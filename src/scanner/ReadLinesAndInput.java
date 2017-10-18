package scanner;

/**
toString, hashCode equals
 */

/**
 * @author niharika
 *
 */
import java.util.*;
import java.lang.*;
import java.io.*;

import arrays.MaxProfitInStock;

public class ReadLinesAndInput {
	public static void test() {
		Scanner reader = new Scanner(System.in);
        int t = reader.nextInt();
        // Read number of cases.
        while(t-- > 0){
        	// In each case, first line has number of points. 
            int n=reader.nextInt();
            int[] arr=new int[n];
            // Reading the number of points in a given case.
            for(int i=0;i<n;i++){
                arr[i]=reader.nextInt();
            }

            MaxProfitInStock.makeProfit(arr, n);
        
        }
	}
	
}
