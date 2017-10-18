/**
 * 
 */
package chessTracker;

/**
toString, hashCode equals
 */

/**
 * @author niharika
 *
 */
public class Unit {
	char type;
	boolean isWhite;

	/**
	 * @param type
	 * @param isWhite
	 */
	public Unit(char type, boolean isWhite) {
		super();
		this.type = type;
		this.isWhite = isWhite;
	}

	public char getType() {
		return type;
	}

	public void setType(char type) {
		this.type = type;
	}

	public boolean isWhite() {
		return isWhite;
	}

	public void setWhite(boolean isWhite) {
		this.isWhite = isWhite;
	}
	
	
}
