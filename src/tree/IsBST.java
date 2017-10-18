/**
 * 
 */
package tree;

import tree.TreeInterviewBit.TreeNode;

/**
toString, hashCode equals
 */

/**
 * @author niharika
 *
 */
public class IsBST {
	
	public static void test(){
		
		TreeNode root = new TreeNode(20);

		root.l = new TreeNode(8);
		root.r = new TreeNode(22);

		root.l.l = new TreeNode(4);
		root.l.r = new TreeNode(12);

		root.l.r.l = new TreeNode(10);
		root.l.r.r = new TreeNode(14);
		
		System.out.println("" + isBst(root, Integer.MIN_VALUE, Integer.MAX_VALUE ));
	}
	
	/**
	 * Tricky part is, initial call should give min as Intger.MIN_VALUE and max value as Integer.MAX_VALUE
	 * @param root
	 * @param min
	 * @param max
	 * @return
	 */
	public static boolean isBst(TreeNode root, int min, int max){
		if(root == null){
			return true;
		}
		
		boolean isLeftBST = isBst(root.l, min, root.val);
		boolean isRightBST = isBst(root.r, root.val, max);
		
		if(isLeftBST && isRightBST && root.val > min && root.val < max){
			return true;
		}
		
		return false;
	}

}
