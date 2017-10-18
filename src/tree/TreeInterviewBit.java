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
public class TreeInterviewBit {

	public static class TreeNode {
		int val;
		TreeNode l;
		TreeNode r;

		TreeNode(int val){
			super();
			this.val = val;
		}
	}

	public static void test(){

		TreeNode root = new TreeNode(20);

		root.l = new TreeNode(8);
		root.r = new TreeNode(22);

		root.l.l = new TreeNode(4);
		root.l.r = new TreeNode(12);

		root.l.r.l = new TreeNode(10);
		root.l.r.r = new TreeNode(14);


//		printKdistNodes(root, 1);
		getNodesAtKDistance(root, 12, 2);
//		getNodesAtKDistance(root, 8, 1);
	}


	public static int getNodesAtKDistance(TreeNode root, int val, int dis){

		if(dis < 0 || root == null) {
			return -1;
		}
		
		if(root.val == val){
			printKdistNodes(root.l, dis-1);
			printKdistNodes(root.r, dis-1);
			return dis-1;
		} else {
			int lRem = getNodesAtKDistance(root.l, val, dis);

			if(lRem == 0){
				System.out.println(""+root.val);
				return -1;
			} else if(lRem > 0){
				printKdistNodes(root.r, lRem-1);
				return lRem-1;
			}

			int rRem = getNodesAtKDistance(root.r, val, dis);

			if(rRem == 0) {
				System.out.println(""+root.val);
				return -1;
			} else if(rRem > 0){
				printKdistNodes(root.l, rRem-1);
				return rRem-1;
			}

			return -1;
		}

	}

	public static void printKdistNodes(TreeNode root, int dis){
		if(root == null) return;
		
		if(dis == 0){
			System.out.println(""+root.val);
		} else if(dis > 0){
			printKdistNodes(root.l, dis-1);
			printKdistNodes(root.r, dis-1);
		}
	}

}
