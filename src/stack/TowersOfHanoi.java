/**
 * 
 */
package stack;

/**
toString, hashCode equals
 */

/**
 * @author niharika
 *
 */
public class TowersOfHanoi {

	public static void test(){
		
		CustomStack<Integer> source = new CustomStack<>();
		CustomStack<Integer> dest = new CustomStack<>();
		CustomStack<Integer> buffer = new CustomStack<>();
		
		source.push(3);
		source.push(2);
		source.push(1);
		
		System.out.println("source - "+source);
		System.out.println("dest - "+dest);
		System.out.println("buffer - "+buffer);
		
		shiftDisks(1, dest, source, buffer);
		System.out.println("");
		
		System.out.println("source - "+source);
		System.out.println("dest - "+dest);
		System.out.println("buffer - "+buffer);
		
	}
	
	public static void shiftDisks(int count, CustomStack<Integer> dest, CustomStack<Integer> source, CustomStack<Integer> buffer){
		
		if(count < 1 ) return;
		
		if(count == 1){
			Integer curDist = source.pop();
			dest.push(curDist);
			return;
		} else {
			shiftDisks(count-1, buffer, source, dest);
			shiftDisks(1, dest, source, buffer);
			shiftDisks(count-1, dest, buffer, source);
			return;
		}
	}
	
}
