/**
 * 
 */
package javaDemos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
toString, hashCode equals
 */

/**
 * @author niharika
 *
 */
public class ParallelFileReadWrite {
	
	public static void test(){
		
		BlockingQueue<String> que = new ArrayBlockingQueue<>(10);
		
		Reader r = new Reader(que, "inputFile.txt");
		Processor p = new Processor(que);
		
		Thread t1 = new Thread(r);
		Thread t2 = new Thread(p);
		
		t1.start();
		t2.start();
	}
	

}

class Processor implements Runnable {
	
	BlockingQueue<String> queue;
	
	public Processor(BlockingQueue<String> queue){
		this.queue = queue;
	}
	
	public void run(){
		String curString;
		
		try{
			
			while(true){
				curString = queue.take();
				
				if(curString.equals("EOF")){
					break;
				}
				
				System.out.println(curString);
			}
			
		} catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	
}


class Reader implements Runnable {
	private String file;
	
	BlockingQueue<String> queue; 
	
	public Reader(BlockingQueue<String> que, String file){
		this.queue = que;
		this.file = file;
	}
	
	public void run(){
		
		try {

			BufferedReader br = new BufferedReader(new FileReader(new File(file)));
			
			String nextLine = br.readLine();
			
			while(nextLine != null){
				queue.put(nextLine);
				nextLine = br.readLine();
			}
			
			queue.put("EOF");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException ie){
			ie.printStackTrace();
		}
	}
	
}