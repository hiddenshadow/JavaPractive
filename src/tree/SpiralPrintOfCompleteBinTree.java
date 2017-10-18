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
public class SpiralPrintOfCompleteBinTree {
	
	public static void test(){
		
	}
	
	public static void printSpiralForCompleteBinaryTree(int[] tree){
		int h = (int)(Math.log(tree.length));
		
		int top=0, bottom = h-1;
		int cur=0, loop=0, bStart, bEnd;
		
		// Till end of the tree
		while(top < bottom){
			
			
			// Left Side. Spiral print starts with the top=1;
			for(int i=top; i < bottom; i++) {
				cur = getLevelStart(i) + loop;
				System.out.println(tree[i]);
			}
			
			// Print the Bottom left to right.  
			for(int i = cur+1; i <= (getLevelEnd(bottom) - loop) ; i++ ){
				System.out.println(tree[i]);
			}
			
			// Right side.
			for(int i = bottom-1; i >= top ; i--){
				cur = (getLevelEnd(bottom-1) - loop );
				System.out.println(tree[cur]);
			}
			
			// Print top right to left.
			for(int i = (getLevelEnd(bottom) - loop - 1); i > (getLevelStart(top) + loop) ; i--){
				System.out.println(tree[i]);
			}
			
			loop++;
			top++; bottom--;
		}
		
		if(top == bottom){

			// Print left to right single line.
			for(int i = (getLevelStart(top) + loop); i <= (getLevelEnd(bottom) - loop) ; i++ ){
				System.out.println(tree[i]);
			}
			
		}
	}
	
	/**
	 * levels start from 0. Start of level 0 is from 0.
	 * @param lev
	 * @return
	 */
	public static int getLevelStart(int lev) {
		return (2^(lev+1) - 2^(lev) - 2);
	}
	
	/**
	 * Level starts from 0. End of level 0 is 0.
	 * @param lev
	 * @return
	 */
	public static int getLevelEnd(int lev) {
		return (2^(lev+1) - 2);
	}

}
