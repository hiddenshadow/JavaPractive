package list;


import java.util.LinkedList;

import list.CustomLinkedList.Node;

public class JustListNode<T> {
	
	public class Node<T> {
		Node<T> next;
		T val;

		public Node(T val){
			super();
			this.val = val;
			this.next = null;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Node [ ");
//			builder.append("next=");
//			builder.append(next);
			builder.append(", val=");
			builder.append(val);
			builder.append("]");
			return builder.toString();
		}

	}
	
	public void removeDuplicates(Node list){
		
		Node<T> cur = list;
		Node<T> previous, run; 
		
		if(cur == null){
			return;
		}
				
		while(cur != null){
			previous = cur; run = cur.next;	

			while(run != null){
				if(run.val == cur.val){
					previous.next = run.next;
					run = run.next;
				} else {
					previous = previous.next;
					run = previous.next;
				}
			}
			
			cur = cur.next;
		}
		
		return;
	}
	

	public String printString(Node list) {
		StringBuilder builder = new StringBuilder();
		builder.append("Node [");
		
		Node temp = list;
		
		while ( temp != null ) {
			builder.append(temp+", \n");
			temp = temp.next;
		}
		
		builder.append("]");
		return builder.toString();
	}
	
	public void testRemoveDuplicates(){
		Node<Integer> list = new Node(6);
		Node<Integer> second = new Node(7);
		Node<Integer> third = new Node(6);
		
		list.next = null;
		
		second.next = list;
		list = second;
		
		third.next = list;
		list = third;
		
		System.out.println("List - "+printString(list));
		
		removeDuplicates(list);
		
		System.out.println("List - "+printString(list));
	}
	
	public void testGetNthFromLast(){
		Node<Integer> list = null;
		Node<Integer> cur;
		
		for (int i = 0; i < 12; i++) {
			int random = (int) (Math.random()*12);
			cur = new Node<Integer>(random);
			cur.next = list;
			list = cur;
		}
		
		System.out.println("list - "+printString(list));

		System.out.println(" - "+getNthFromLast(list, 2));
		System.out.println(" - "+getNthFromLast(list, 10));
	}
	
	public Node getNthFromLast(Node list, int n){
		int count=0;
		Node curNode = list;
		Node nthNode = null;
		
		while(count<n-1 && curNode != null){
			curNode = curNode.next;
			count++;
		}
		
		if(count == n-1 && curNode!=null){
			nthNode = list;
			while(curNode.next != null){
				curNode = curNode.next;
				nthNode = nthNode.next;
			}
			return nthNode;
		} else {
			return null;
		}
	}

}
