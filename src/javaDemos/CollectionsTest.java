/**
 * 
 */
package javaDemos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

import arrays.ArrayProblemsIntvBit;

/**
toString, hashCode equals
 */

/**
 * @author niharika
 *
 */
public class CollectionsTest {




	public static void testMinMax(){

		ArrayList<Integer> ar = new ArrayList<>();
		ar.add(2);
		ar.add(12);
		ar.add(6);
		ar.add(4);

		System.out.println(ar);

		System.out.println("Min - "+Collections.min(ar));
		System.out.println("Min - "+Collections.max(ar));
		Collections.swap(ar, 1, 3);
		System.out.println("After swap, 1 ,3"+ ar);


	}

	public static void testPriorityQueue(){
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();

		minHeap.add(4);
		minHeap.add(3);
		minHeap.add(6);
		minHeap.add(1);

		System.out.println(minHeap);

		System.out.println(minHeap.peek());
		System.out.println(minHeap.poll());

		System.out.println(minHeap.peek());
		System.out.println(minHeap.poll());

		System.out.println(minHeap.peek());
		minHeap.add(0);

		System.out.println(minHeap.peek());
		System.out.println(minHeap);
		System.out.println(minHeap.poll());
		System.out.println(minHeap.poll());
		System.out.println(minHeap.poll());

		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(20, Collections.reverseOrder());

		maxHeap.add(4);
		maxHeap.add(3);
		maxHeap.add(6);
		maxHeap.add(1);

		System.out.println(maxHeap);

		System.out.println(maxHeap.poll());
		System.out.println(maxHeap.poll());
		System.out.println(maxHeap.poll());
	}

	public static void testDoublyLinkedList(){
		
		List<Character> dll = new ArrayList<>();
		
		// Adds at the end of the dll.
		dll.add(new Character('a'));
		dll.add(new Character('l'));
		dll.add(new Character('p'));
		dll.add(new Character('h'));
		dll.add(new Character('m'));
		
		System.out.println(dll);
		
		
		// Removes first occurance from the 
		dll.remove((Character) 'a');
		dll.remove((Character) 'p');
		
		System.out.println("last - "+dll.get(dll.size()-1));
		
		System.out.println(dll);
	}

	public static void testStack(){
		Stack<Character> stack = new Stack<>();
		
	}
	
}
