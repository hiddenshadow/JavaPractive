/**
 * 
 */
package fpTech;

import java.util.Deque;
import java.util.LinkedList;

/**
toString, hashCode equals
 */

/**
 * @author niharika
 *
 */
public class MaxEachWind {

	public static void test(){

		Deque<Integer> dq = new LinkedList<Integer>();
		
		/*dq.add(1);
		dq.add(2);
		dq.add(3);
		
		System.out.println(dq);
		System.out.println(dq.peek());*/
		
		int[] inp = {1,2,3,1,4,5,2,3,6};
		
//		int[] inp = {9, 8, 7, 6, 5, 4, 3, 2, 1};
		
//		int[] inp = {1,2,3,4,5};
		
		getMaxForEachWindow(inp, 3, dq);
		
	}
	
	/**
	 * Add indexes to dq.
	 * @param inp
	 * @param k
	 * @param dq
	 */
	public static void getMaxForEachWindow(int[] inp, int k, Deque<Integer> dq){
		
		int i=0, curMax = inp[0];
		int temp;
		
		// Add k elements
		while(i < k-1){
			dq.addLast(i);
			i++;
		}
		
		while(i < inp.length){
			dq.addLast(i); // Add kth element.
			
			// Max diff should be k
			while(dq.peek() < i-k+1){
				dq.removeFirst();
			}

			temp = dq.removeFirst();
			
			// Deque all num less than in coming from front.
			while(inp[temp] < inp[i]){
				temp = dq.removeFirst();
			}
			
			dq.addFirst(temp);
			
			System.out.print(" "+inp[dq.peek()]); // Shall print head. While add at tail.
			
			i++;
		}
		
	}
	
	
	
	
}
