/**
 * 
 */
package liftSystem;

import java.util.Scanner;

/**
toString, hashCode equals
 */

/**
 * @author niharika
 *
 */
public class Driver {

	/**
	 * 
	 */
	public static void start(){

		int maxFloor, numOfLifts, nextNum;
		String next, alarmMessage;
		LiftSystem ls;


		// Inputs: [Floor, pingDir]

		Scanner sc = new Scanner(System.in);

		System.out.println("Give input  to start the Lift system.");

		System.out.println("Input Max floor:");
		maxFloor = sc.nextInt(); //

		System.out.println("Number of lifts:");
		numOfLifts = sc.nextInt(); //

		ls = new LiftSystem(numOfLifts, maxFloor);

		System.out.println("Start giving input to the Lift System: ");
		next = sc.nextLine();	// Start taking input.

		// Serve each request.
		while(!next.equalsIgnoreCase("END")){

			System.out.println("input: " + next);

			switch(next.toLowerCase()){
			case "in" : {
				nextNum = sc.nextInt();
				
				break;
			}

			case "out" : {
				break;
			}

			case "alarm":{
				
				System.out.println("Is it Generic or Specific ? [0 for Generic, lift id for Specific Alarm.] ");
				nextNum = sc.nextInt();
				
				if(nextNum == 0){
					System.out.println("Give alarmMessage: ");
					alarmMessage = sc.nextLine();
					
					ls.generateGenericAlarm(alarmMessage);
					
				} else if(nextNum > 0 && nextNum <= numOfLifts) {
					
					System.out.println("Give alarmMessage: ");
					alarmMessage = sc.nextLine();
					
					
				} 
				
				
				
				break;
			}

			default: 
				System.out.println("Wrong input");
			}

			next = sc.nextLine();	// Next input.
		}

		System.out.println("Recieved end signal.");
	}

}
