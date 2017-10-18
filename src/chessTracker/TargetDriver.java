/**
 * 
 */
package chessTracker;

import java.util.Scanner;

/**
toString, hashCode equals
 */

/**
 * @author niharika
 *
 */
public class TargetDriver {
	
	public static void test(){
		ChessBoard b = new ChessBoard();
		
		b.printFEN();
		
/*		Scanner sc = new Scanner(System.in);
		String next = sc.nextLine();
		
		while(true) {
			System.out.println("Input is: "+next);
			
		}*/
		
		testExecute(b);
		
	}
	
	public static void testExecute(ChessBoard b){
		b.executeInput("e4", "e2");
		b.printFEN();
	}
	
	public static void testEnPassant(ChessBoard b){
		b.executeInput("e4", "e2");
		b.printFEN();
	}
	
//	testCastlingUpdate(b);
	public static void testCastlingUpdate(ChessBoard b){
		
		b.updateCastling("a1");
		b.printFEN();
		
		b.updateCastling("h1");
		b.printFEN();
		
		b.updateCastling("e1");
		b.printFEN();
		
		b.updateCastling("a8");
		b.printFEN();
		
		b.updateCastling("h8");
		b.printFEN();
		
		b.updateCastling("e8");
		b.printFEN();
	}

}
