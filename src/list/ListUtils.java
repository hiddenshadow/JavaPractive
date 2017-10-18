/**
 * 
 */
package list;

/**
toString, hashCode equals
 */

/**
 * @author niharika
 *
 */
public class ListUtils {

	
	public static void test(){
		ListNode l1 = createLL(5, 10);
		printLL(l1);
		printLL(reveseList(l1));
		
		
		System.out.println();
		ListNode l2 = createLL(5, 10);
		printLL(l2);
		printLL(reveseList(l2));
		
	}
	
	public static void printLL(ListNode list){
		if(list == null){
			System.out.println("List is empty");
		}
		
		while(list != null){
			System.out.print(""+list.val+"->");
			list = list.next;
		}
		System.out.print("null");
		System.out.println();
	}
	
	/**
	 * How can we reverse an LL if only head is given? -  
	 * @param head
	 */
	public static ListNode reveseList(ListNode list){

		if(list == null || list.next == null){
			return list;
		}

		ListNode prev=null, cur=list, next=list.next;

		while(cur != null){
			next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
		}

		return prev;
	}


	public static ListNode createLL(int size, int maxRange){
		
		if(size == 0 ){			
			return null;
		}
		
		ListNode list = null, cur = null;
		
		int rand = (int) (Math.random() * maxRange);
		
		list = new ListNode(rand); cur = list;
		
		for (int i = 1; i < size; i++) {
			rand = (int) (Math.random() * maxRange) ;
			cur.next = new ListNode(rand);
			cur = cur.next;
		}
		
		return list;
	}
	
	
}
