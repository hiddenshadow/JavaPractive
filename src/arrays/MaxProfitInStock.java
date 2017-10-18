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
public class MaxProfitInStock {
	
	public static void makeProfit(int[] arr, int n){
        int first=0;
        int prev=0;
        int next=1;
        boolean shouldPrint=false;
        
        boolean profit=false;
        while(next<n){
        while(next<n && arr[prev]<arr[next]){
            prev++;
            next++;
            shouldPrint=true;
            profit=true;
        }
        if(shouldPrint){
          System.out.print("("+first+" "+prev+")"+" ");  
        }
        first=next;
        prev=first;
        next=first+1;
        shouldPrint=false;
    }
    if(profit){
       System.out.println(); 
    }
    else{
        System.out.println("No Profit"); 
    }
	}

}
