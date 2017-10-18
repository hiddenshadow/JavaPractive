package stack;

import list.CustomLinkedList;

public class CustomStack<T> {
	
	CustomLinkedList<T> list;

	public CustomStack() {
		super();
		this.list = new CustomLinkedList<>();
	}
	
	public boolean isEmpty(){
		return (list.head == null);
	}
	
	public T pop(){
		T toReturn = list.get(0);

		if(toReturn != null){
			list.delete(toReturn);
		}
		
		return toReturn;
	}
	
	public T peek(){
		return list.get(0);
	}
	
	public void push(T val){
		list.addToHead(val);
	}
	
	public String printStack(){
		return list.toString();
	}
	
	
	

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CustomStack [list=");
		builder.append(list);
		builder.append("]");
		return builder.toString();
	}

	public static void test(){ 
		CustomStack<Integer> stack = new CustomStack<>();
		stack.push(1);
		
		System.out.println("stack - "+stack);
		
		stack.push(2);
		stack.push(3);
		
		System.out.println("stack - "+stack);
		
		stack.pop();
		System.out.println("stack - "+stack);
	}
}
