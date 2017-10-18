/**
 * 
 */
package javaDemos;

/**
toString, hashCode equals
 */

/**
 * @author niharika
 *
 */
public class EvenOddThreads {
	
	static final class LastNumber {
        int num;
        final int limit;

        LastNumber(int num, int limit) {
            this.num = num;
            this.limit = limit;
        }
    }
	
	public static void test(){
		Integer cur = new Integer(0);
		Integer max = new Integer(10);

		LastNumber ln = new LastNumber(0, 10);
		
		Printer p1 = new Printer(max, cur, ln);
		Printer p2 = new Printer(max, cur, ln);
		
		Thread t1 = new Thread(p1, "Odd");
		Thread t2 = new Thread(p2, "Even");
		
		t1.start();
		t2.start();
	}
	

}

class Printer implements Runnable {
	
	private final Integer max;
	private Integer cur;
	private final EvenOddThreads.LastNumber ln;
	
	public Printer(Integer max, Integer cur, EvenOddThreads.LastNumber ln){
		super();
		this.max = max;
		this.cur = cur;
		this.ln = ln;
	}
	
	public void run(){
		
		System.out.println("I am "+Thread.currentThread().getName()+", holding cur "+cur.toString()+""+ln);
		
		while(ln.num < ln.limit) {
			synchronized(ln){
				ln.num++;
				System.out.println(Thread.currentThread().getName()+" "+ln.num);
				
				try {
					Thread.sleep(200);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}

				ln.notify();
				
				if( 1 < ln.limit - ln.num ){
					try {
						ln.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
			}
		}
		
	}
	
	public void start(){
		
	}
	
}
