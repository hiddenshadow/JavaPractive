/**
 * 
 */
package tree;

import java.util.ArrayList;

import graph.GraphNode;
import list.CustomLinkedList;

/**
toString, hashCode equals
 */

/**
 * @author niharika
 *
 */
public class CustomGraph<T> {

	ArrayList<GraphNode<T>> nodes;
	
	public CustomGraph(){
		
	}
	
	/**
	 * Prevent adding duplicates.
	 * @param node
	 */
	public void addNode(GraphNode<T> node){
		nodes.add(node);
	}
	
	public void addDirectedSide(GraphNode<T> from, GraphNode<T> to){
		int count = nodes.size();
		int i=0;
		GraphNode<T> fromNode = null;
		while(nodes.get(i) != from){
			fromNode = nodes.get(i);
			i++;
		}
	}
}
