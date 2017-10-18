/**
 * 
 */
package stack;

/**
toString, hashCode equals
 */

/**
 * @author niharika
 *
 */
public class SortStack {

	public static void test(){
		CustomStack<Integer> source = new CustomStack<>();

		source.push(3);
		source.push(4);
		source.push(2);
		source.push(7);
		
		System.out.println("source - "+source);
		
		sort(source);
		
		System.out.println("source - "+source);
	}
	
	public static void sort(CustomStack<Integer> stack){
		if(stack.isEmpty()) return;
		
		int temp;
		CustomStack<Integer> buffer = new CustomStack<Integer>();
		boolean hasSwapped = true;
		
		CustomStack<Integer> swapRef = null;
		
		while(hasSwapped){
			hasSwapped = false;
			
			while(!stack.isEmpty()){
				buffer.push(stack.pop());
				
				if(buffer.isEmpty() || stack.isEmpty() || buffer.peek() <= stack.peek()){
					continue;
				} else {
					hasSwapped = true;
					temp = buffer.pop();
					buffer.push(stack.pop());
					stack.push(temp);
				}
			}
			
			while(!buffer.isEmpty()){
				stack.push(buffer.pop());
			}
			
		}
		
		return;
	}
	
}
