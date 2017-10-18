/**
 * 
 */
package liftSystem;

import java.util.PriorityQueue;

/**
toString, hashCode equals
 */

/**
 * @author niharika
 *
 */
public class Lift {
	
	int liftId;	// Identifier.
	int curFloor;
	
	LiftState liftState;	// Alarms, limits.
	
	// Should me min or max heap based on the direction of the Lift.
	PriorityQueue<Integer> listOfHalts;	// Shall have input from the ping queue and from user inside the lift.
	
	LiftSystem ls;

	/**
	 * @param liftId
	 * @param curFloor
	 * @param ls
	 */
	public Lift(int liftId, int curFloor, LiftSystem ls) {
		super();

		this.liftId = liftId;
		this.curFloor = curFloor;
		this.ls = ls;
		
		this.ls.subscribeToLiftSystem(this);
	}
	
	/**
	 * @param signal
	 */
	public void takeLiftSystemSignal(int signal){
		// Stop in nearest lower floor.
		if(signal == -1){
			
			
			
			if(LiftState.MOVING_UP == this.liftState){
				
				// No change in floor.
				this.liftState = LiftState.IDLE;
			} else if(LiftState.MOVING_DOWN == this.liftState){
				
				this.curFloor = this.curFloor+1;	 // Stop in next floor.
				this.liftState = LiftState.IDLE;
			}
		}
	}
	
	
	public void takeLiftSystemSignal(int signal, String msg){
		takeLiftSystemSignal(signal);
	}
	
	public void informChangeState(LiftState endState){
//		LiftState cur = this.liftState;
		this.ls.changeLiftState(this, endState);
	}
	

}