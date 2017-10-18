package hashMap;

import java.util.ArrayList;

import list.CustomLinkedList;
import list.CustomLinkedList.Node;

public class CustomHashMap<Key, Value> {
	
	int count;
	int size;
	float loadFactor;
	ArrayList<HashMapNode> table;
	
	public CustomHashMap(int size, float loadFactor){
		super();
		
		this.size = size;
		this.loadFactor = loadFactor;
		this.count=0;
		
		table = new ArrayList<>();
		for(int i=0; i < size; i++){
			table.add(new HashMapNode());
		}
	}
	
	class ListNode {
		int hash;
		Key key;
		Value val;
		ListNode next;
		
		public ListNode(int hash, Key key, Value val, ListNode next){
			this.hash = hash;
			this.key = key;
			this.val = val;
			this.next = next;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("ListNode [ hash=");
			builder.append(hash);
			builder.append(", key=");
			builder.append(key);
			builder.append(", val=");
			builder.append(val);
/*			builder.append(", next=");
			builder.append(next);*/
			builder.append("]");
			return builder.toString();
		}
		
		
	}
	
	class HashMapNode {
		int count;
		ListNode chainList;
		
		public HashMapNode(){
			super();
			this.chainList = null;
			this.count=0;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("HashMapNode [count=");
			builder.append(count);
			builder.append(", chainList=");
			
			ListNode temp = chainList;
			
			while ( temp != null ) {
				builder.append(temp+", ");
				temp = temp.next;
			}
			
			builder.append("] \n");
			return builder.toString();
		}
		
		
	}
	
	public void resize() {
		System.out.println("Resizing the HashMap: "+this);
		
		int newSize = size*2;
		
		for (int i = 0; i < size; i++) {
			table.add(new HashMapNode());
		}
		
		for (int i = 0; i < size; i++) {
			HashMapNode curHashMapNode = table.get(i);
			
			System.out.println("curHashMapNode - "+curHashMapNode);
			
			ListNode oldChain = curHashMapNode.chainList; 
			curHashMapNode.chainList = null;
			ListNode curNode = null;
			
			System.out.println("After removing chain, curHashMapNode - "+curHashMapNode);
			
			while(oldChain != null){
				System.out.println("oldChain - "+oldChain);
				curNode = oldChain;
				oldChain = oldChain.next;
				
				int hash = curNode.hashCode();
				int ind = hash % newSize;
				HashMapNode node = table.get(ind);
				
				if(ind != i){
					if(node.chainList == null){
						curNode.next = node.chainList; 
						node.chainList = curNode;
						node.count++; curHashMapNode.count--;
					} else {
						ListNode chainlist = node.chainList;
						
						while(chainlist != null){
							System.out.println("chainlist - "+chainlist);
							if(chainlist.key.equals(curNode.key) && chainlist.hash == curNode.hash){
								chainlist.val = curNode.val;
								node.count++; curHashMapNode.count--;
								break;
							}
							chainlist = chainlist.next;
						}
						
						curNode.next = node.chainList; 
						node.chainList = curNode;
						node.count++; curHashMapNode.count--;
					}
				}
				
				System.out.println("oldChain - "+oldChain);
			}
		}
		
		size = newSize;
	}

	/**
	 * What should you if same key exists?
	 * @param key
	 * @param val
	 * @return
	 */
	public boolean put(Key key, Value val){
		
		int hash = key.hashCode();
		int ind = hash % size;
		HashMapNode node = table.get(ind);
		
		ListNode newN = new ListNode(hash, key, val, null);
		
		if(node.chainList == null){
			newN.next = node.chainList; 
			node.chainList = newN;
			node.count++; count++;
			if(getLoadFactor(node.count) > loadFactor) resize();
			return true;
		} else {
			ListNode chainlist = node.chainList;
			
			while(chainlist != null){
				if(chainlist.key.equals(key) && chainlist.hash == hash){
					chainlist.val = val;
					return true;
				}
				chainlist = chainlist.next;
			}
			
			newN.next = node.chainList; 
			node.chainList = newN;
			node.count++; count++;
			if(getLoadFactor(node.count) > loadFactor) resize();
			return true;
		}
	}
	
	public float getLoadFactor(int nodeCount){
		return ((float) nodeCount / size);
	}
	
	public Value get(Key key){
		
		int hash = key.hashCode();
		int ind = hash % size;
		HashMapNode node = table.get(ind);
		
		if(node.chainList == null){
			return null;
		} else {
			ListNode chainlist = node.chainList;
			
			while(chainlist != null){
				if(chainlist.key.equals(key) && chainlist.hash == hash){
					return chainlist.val;
				} else {
					chainlist = chainlist.next;
				}
			}
		}
		
		return null;
	}
	
	public boolean delete(Key key){
		
		int hash = key.hashCode();
		int ind = hash % size;
		HashMapNode node = table.get(ind);
		
		if(node.chainList == null){
			return false;
		} else {
			ListNode chainlist = node.chainList;
			
			if(chainlist.key.equals(key) && chainlist.hash == hash){
				node.chainList = null;
				
				node.count--; count--;
				
				return true;
			}
			
			while(chainlist.next != null){
				if(chainlist.next.key.equals(key) && chainlist.next.hash == hash){
					chainlist.next = chainlist.next.next;
					
					node.count--; count--;
					
					return true;
				} else {
					chainlist = chainlist.next;
				}
			}
		}

		return false;
	}
	
	public static void test(){
		CustomHashMap<Integer, Integer> sample = new CustomHashMap<Integer, Integer>(3, 0.75f);
		
		sample.put(3, 3);
		sample.put(5, 5);
		sample.put(6, 6);
		sample.put(9, 9);
		sample.put(12, 12);
		sample.put(16, 16);
		sample.put(6, 18);
		sample.put(10, 10);
		
		System.out.println("sample - "+sample);
		
//		sample.resize();
		
		sample.delete(12);
		System.out.println("sample - "+sample);
		System.out.println("sample.getLoadFactor(5) - "+sample.getLoadFactor(5));
		
		/*System.out.println("Get for 16 - "+sample.get(16));
		System.out.println("Get for 6 - "+sample.get(6));*/
		
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		sb.append("CustomHashMap [ ");
		sb.append("count=" + count + ", size=" + size + ", loadFactor=" + loadFactor );
		
		
		sb.append(", table - "+table);
		
		sb.append("]");
		
		
		
		return sb.toString();
	}
	
	
}
