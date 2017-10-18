/**
 * 
 */
package liftSystem;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
toString, hashCode equals
 */

/**
 * @author niharika
 *
 */
public class LiftSystem {
	
	private int numOfLift;
	private int maxFloor;
	private int minFloor; // Can be -1 or -2.
	
	// Can also avoid this.
	Lift[] allLifts;	// Needed for Demo. To give specific alarms & inputs.
	
	// List of observers. A lift shall be present in one of them.
	HashMap<Integer, Lift> idle;
	HashMap<Integer, Lift> up;
	HashMap<Integer, Lift> down;

	/**
	 * @param numOfLift
	 * @param maxFloor
	 */
	public LiftSystem(int numOfLift, int maxFloor) {
		super();
		
		this.numOfLift = numOfLift;
		this.maxFloor = maxFloor;
		
		this.minFloor = 0;

		this.idle = new HashMap<>();
		this.up = new HashMap<>();
		this.down = new HashMap<>();
		
		this.allLifts = new Lift[numOfLift];
		
		init();
	}
	
	/**
	 * Optimize this to start lifts from diff floors.
	 */
	private void init(){
		Lift cur;
		
		// Adding lifts.
		for (int i = 0; i < this.numOfLift; i++) {
			cur = new Lift(i+1, 0, this);	// Not using 0 for Id. Starts from 1.
			allLifts[i] = cur;
		}
	}
	
	public void subscribeToLiftSystem(Lift l){
		this.idle.put(l.liftId, l);
	}
	
	public void generateGenericAlarm(String msg){
		System.out.println("generateGenericAlarm");
		
		for (int i = 0; i < allLifts.length; i++) {
			generateSpecificAlarm(msg, allLifts[i]);
		}
		
	}
	
	public void generateSpecificAlarm(String msg, Lift lf){
		
	}
	
	public void generateSpecificAlarm(String msg, int liftId){
		generateSpecificAlarm(msg, allLifts[liftId-1]);
	}
	
	public void changeLiftState(Lift lf, LiftState endState){
		// Process the state change, update all resources and finally change the lift state using reference.
		
		if(lf.liftState == LiftState.MOVING_UP){
		
			if(endState == LiftState.IDLE){

				up.remove(lf.liftId);
				idle.put(lf.liftId, lf);
				lf.liftState = LiftState.IDLE;

			} else if(endState == LiftState.MOVING_DOWN){
//				System.out.println("Not possible now.");
			} else {
//				System.out.println("No state change");
			}
			
			
		} else if(lf.liftState == LiftState.MOVING_DOWN){
			
			if(endState == LiftState.IDLE){
				
				down.remove(lf);
				lf.liftState = LiftState.IDLE;
				idle.put(lf.liftId, lf);
				
				
			} else if(endState == LiftState.MOVING_UP){
//				System.out.println("Not possible now.");
			} else {
//				System.out.println("No state change");
			}
			
		} else {
			
			if(endState == LiftState.MOVING_UP){
				
				idle.remove(lf.liftId);
				
				up.put(lf.liftId, lf);
				
			} else if(endState == LiftState.MOVING_DOWN){
				
				idle.remove(lf.liftId);
				
				down.put(lf.liftId, lf);
				
			} else {
				
//				System.out.println("No state change");
			}
		}
		
	}
}
