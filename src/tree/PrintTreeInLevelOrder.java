/**
 * 
 */
package tree;

import java.util.LinkedList;

import tree.TreeInterviewBit.TreeNode;

/**
toString, hashCode equals
 */

/**
 * @author niharika
 *
 */
public class PrintTreeInLevelOrder {
	
	public static void test(){
		TreeNode root = new TreeNode(20);

		root.l = new TreeNode(8);
		root.r = new TreeNode(22);

		root.l.l = new TreeNode(4);
		root.l.r = new TreeNode(12);

		root.l.r.l = new TreeNode(10);
		root.l.r.r = new TreeNode(14);
		
		
//		printInLevelOrder(root);
		printInZigZagWay(root);
	}
	
	public static void printInLevelOrder(TreeNode root){
		System.out.println("printInLevelOrder");
		TreeNode cur=null;
		
		if(root == null) return;
		
		LinkedList<TreeNode> que = new LinkedList<>();
		
		que.add(root);
		
		while( !que.isEmpty() ){
			cur = que.poll();
			
			System.out.println(""+cur.val); // Visit
			
			if(cur.l != null){
				que.add(cur.l);
			}
			
			if(cur.r != null){
				que.add(cur.r);
			}
		}
	}
	
	public static void printInZigZagWay(TreeNode root){
		System.out.println("printInZigZagWay");
		if(root == null) return;
		
		TreeNode cur = null;
		boolean isLToR = true;
		LinkedList<TreeNode> s1 = new LinkedList<>(), s2 = new LinkedList<>();
		
		s1.push(root);
		
		while(!s1.isEmpty() || !s2.isEmpty()) {
			
			if(isLToR){
				
				while(!s1.isEmpty()){
					cur = s1.pop();
					
					System.out.print(cur.val+" ");
					
					if(cur.l != null){
						s2.push(cur.l);
					}
					
					if(cur.r != null){
						s2.push(cur.r);
					}
				}
				
				isLToR = false;
				System.out.println();
			} else {
				
				while(!s2.isEmpty()){
					cur = s2.pop();
					
					System.out.print(cur.val+" ");
					
					if(cur.r != null){
						s1.push(cur.r);
					}
					
					if(cur.l != null){
						s1.push(cur.l);
					}
				}
				
				isLToR = true;
				System.out.println();
			}
		}
	}

}
