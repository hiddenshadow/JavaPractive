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
public class TreeWithMinHeight {
	
	public static void test(){		
		int[] ary = {1, 2, 3, 8 , 9};
		
		System.out.println("makeTree - "+makeTree(ary, 0, ary.length-1));
	}
	
	public static BinTreeNode makeTree(int[] inputArray, int startInd, int endInd){
		BinTreeNode tree = null;
		
		if(startInd - endInd > 0 ){
			 return tree;
		} 
		/*else if(startInd - endInd == 0){
			tree = new BinTreeNode(inputArray[startInd]);
		} else if(startInd - endInd == 1) {
			tree = new BinTreeNode(inputArray[startInd]);
			tree.left = new BinTreeNode(inputArray[endInd]);
		} */
		else {
			int mid = (startInd + endInd) /2;
			tree = new BinTreeNode(inputArray[mid]);
			tree.left = makeTree(inputArray, startInd, mid-1);
			tree.right = makeTree(inputArray, mid+1, endInd);
		}
		
		return tree;
	}
	
}
