/**
 * 
 */
package tree;

/**
toString, hashCode equals
 */

/**
 * @author niharika
 *
 */
public class BinTreeNode<T> {
	T val;
	BinTreeNode<T> left;
	BinTreeNode<T> right;
	
	public BinTreeNode(T val){
		super();
		this.val = val;
		left = null;
		right = null;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BinTreeNode [val=");
		builder.append(val);
		builder.append(", left=");
		builder.append(left);
		builder.append(", right=");
		builder.append(right);
		builder.append("]");
		return builder.toString();
	}
	
	
}
