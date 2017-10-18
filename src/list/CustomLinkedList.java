package list;


/**
 * How can we create get() and Iterator. Is the get() based on the index?
 * @author niharika
 *
 * @param <T>
 */
public class CustomLinkedList<T> {
	
	public Node<T> head;

	public class Node<T> {
		Node<T> next;
		T val;
		
		public Node(T val){
			super();
			this.val = val;
			this.next = null;
		}
	}
	
	public CustomLinkedList(){
		super();
		this.head = null;
	}
	
	public void addToHead(T data){
		Node<T> newNode = new Node(data); 
		if(head==null){
			head = newNode;
		} else {
			newNode.next = head; 
			head = newNode;
		}
	}
	
	
	public T get(int i){
		int cur=0;
		Node curNode = head; 
		while(curNode != null ){
			if(cur==i){
				return (T) curNode.val;
			}
			curNode = curNode.next;
			cur++;
		}
		
		return null;
	}
	
	public void delete(T data){
		if(head != null ){
			if(head.val.equals(data)){
				head = head.next;
			} else {
				Node<T> cur = head;
				while(cur.next != null){
					if(cur.next.val.equals(data)){
						cur.next = cur.next.next;
//						cur = cur.next;
						return;
					}
				}
			}
		}
	}
	
	
	@Override
	public String toString() {
		
		StringBuffer br = new StringBuffer();
		
		br.append("CustomLinkedList [");

		if(head != null){
			Node<T> next = head;
			
			while(next != null){
				br.append(" "+next.val.toString()+", ");
				next = next.next;				
			}
		}
		
		br.append("]");
		return br.toString();
	}

	public static void test(){
		CustomLinkedList<Integer> intList = new CustomLinkedList<Integer>();
		
		intList.addToHead(5);
		intList.addToHead(6);
		intList.addToHead(7);
		
		System.out.println("Check equals - "+ (intList.head.val.equals(7)));
		
		System.out.println(intList.toString());
		
/*		intList.delete(6);
		System.out.println(intList.toString());
		
		intList.delete(7);
		System.out.println(intList.toString());
		
		intList.delete(5);
		System.out.println(intList.toString());*/
		
		System.out.println("intList.get(0) - "+intList.get(0));
		System.out.println("intList.get(1) - "+intList.get(1));
		
		
	}
	
	
}
