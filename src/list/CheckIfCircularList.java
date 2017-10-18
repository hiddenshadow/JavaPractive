package list;

public class CheckIfCircularList {

	public static void test(){
		
		ListNodeInt cirList = new ListNodeInt(1);
		ListNodeInt two = new ListNodeInt(2);
		ListNodeInt three = new ListNodeInt(3);
		ListNodeInt four = new ListNodeInt(4);
		
		cirList.next = two;
		two.next = three;
		three.next = four;
		four.next = two;
		
		System.out.println("Start - "+getStartOfCircularList(cirList));
		
		
		
	}
	
	public static ListNodeInt getStartOfCircularList(ListNodeInt list){
		
		if(list == null || list.next == null) return null;
		
		ListNodeInt slow = list;
		ListNodeInt fast = list.next.next;
		
		while(slow != fast ){
			if(slow != null){
				slow = slow.next;
			} else {
				return null;
			}
			
			if(fast != null && fast.next != null){
				fast = fast.next.next;
			} else {
				return null;
			}
		}
		
		if(slow != null && fast != null){
			return slow;
		}
		
		return null;
	}
	
}
