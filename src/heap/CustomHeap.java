/**
 * 
 */
package heap;

import java.util.Comparator;

/**
toString, hashCode equals
 */

/**
 * @author niharika
 *
 */
public class CustomHeap<T> {

	Comparator<T> comparator;
	int count;
	int size;
	T[] heap ;

	public CustomHeap(int size, Comparator<T> comp){
		this.comparator = comp;
		this.size = size;
		this.count = 0;
		this.heap = (T[]) new Object[size];
	}

	public void print(){
		System.out.println("Whole of heap:");
		for (int i = 0; i < heap.length && heap[i] != null; i++) {
			System.out.println(heap[i]);
		}
	}
	
	public T peek(){
		if(count == 0 ){
			return null;
		}
		
		return heap[0];
	}
	
	public boolean add(T obj){
		if(this.size == this.count)
			return false;

		this.heap[count] = obj;

		count++;
		heapify(count-1);
		

		return true;
	}

	public boolean delete(){

		if(this.count == 0){
			return false;
		}
		
		this.heap[0] = this.heap[count-1];
		this.heap[count-1] = null;
		
		this.count--;
		heapify(0);
		
		
		return true;
	}

	/**
	 * Compare with parent and compare with both children together.
	 * @param index
	 */
	private void heapify(int index){
		int cur = index, p, l, r;
		boolean doHeapify = true;

		while(doHeapify){

			if(cur % 2 == 0){
				p = (cur-2) / 2;
			} else {
				p = (cur-1) / 2;
			}

			// Check with parent.
			if(p >= 0 && comparator.compare(heap[p], heap[cur]) > 0  ){
				swap(p, cur);
				cur = p;
				continue;
			}

			l = (2*cur +1);  r = (2*cur +  2); 

			// check if both of the siblings positions are valid.
			if(r < count){
				
				// If right child is min, swap with right child. Else swap with left child.
				if(comparator.compare(heap[l], heap[r]) > 0){
					if(comparator.compare(heap[r], heap[cur]) < 0 ){
						swap(r, cur);
						cur = r;
						continue;
					}
				} else {
					if(comparator.compare(heap[l], heap[cur]) < 0){
						swap(l, cur);
						cur = l;
						continue;
					}
				}
				
			} else if(l < count){
			
				if(l < count && comparator.compare(heap[l], heap[cur]) < 0){
					swap(l, cur);
					cur = l;
					continue;
				}
			}
			
			doHeapify = false;
		}
	}

	private void swap(int ind1, int ind2){
		T temp = heap[ind1];
		heap[ind1] = heap[ind2];
		heap[ind2] = temp;
	}


	public static void test(){ 
		
		Comparator<Integer> comp = new Comparator<Integer>() {
			
			@Override
			public int compare(Integer arg0, Integer arg1) {
				return -(arg0-arg1);
			}
		};
		
		int[] arr = {5, 4, 3, 9 , 1, 0, 12, 7};
		
		CustomHeap<Integer> minHeap = new CustomHeap<>(arr.length, comp);
		
		for (int i = 0; i < arr.length; i++) {
			minHeap.add(arr[i]);
			System.out.println(minHeap.peek());
		}
		
		minHeap.print();
		
		while(minHeap.peek() != null){
			minHeap.delete();
			minHeap.print();
		}
	}
}
