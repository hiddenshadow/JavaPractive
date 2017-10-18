/**
 * 
 */
package graph;

import list.CustomLinkedList;

/**
toString, hashCode equals
 */

/**
 * @author niharika
 *
 */
enum State {
	UNVISITED, VISITING, VISITED
}

public class GraphNode<T> {
	T val;
	State state;
	CustomLinkedList<GraphNode<T>> adj;
	
	public GraphNode(T val){
		val = val;
		state = State.UNVISITED;
		adj = new CustomLinkedList<>();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BinTreeNode [val=");
		builder.append(val);
		builder.append(", state=");
		builder.append(state);
		builder.append(", adj=");
		builder.append(adj);
		builder.append("]");
		return builder.toString();
	}
	
	public static void test(){
		
	}
	
}
