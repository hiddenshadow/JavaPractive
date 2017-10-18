package list;

import list.JustListNode.Node;


public class ListNodeInt {

	ListNodeInt next;
	Integer val;

	public ListNodeInt(Integer val){
		super();
		this.val = val;
		this.next = null;
	}

	public static String printString(ListNodeInt list) {
		StringBuilder builder = new StringBuilder();
		builder.append("Node [");
		
		ListNodeInt temp = list;
		
		while ( temp != null ) {
			builder.append(temp+", \n");
			temp = temp.next;
		}
		
		builder.append("]");
		return builder.toString();
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ListNodeInt [ ");
//		builder.append("next=");
//		builder.append(next);
		builder.append(", val=");
		builder.append(val);
		builder.append("]");
		return builder.toString();
	}

	
	public static ListNodeInt getRandomListNode(int size){
		
		ListNodeInt list = null;
		ListNodeInt cur = null;
		
		for (int i = 0; i < size; i++) {
			int random = (int) (Math.random()*9);
			cur = new ListNodeInt(random);
			cur.next = list;
			list = cur;
		}
		
		return list;
	}

}
