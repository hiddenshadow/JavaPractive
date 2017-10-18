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
public class Cell {

	private boolean isWhite;
	private Unit unit;
	
	public Cell(boolean isWhite){
		this.isWhite = isWhite;
	}

	public boolean isWhite() {
		return isWhite;
	}

	public void setWhite(boolean isWhite) {
		this.isWhite = isWhite;
	}

	public Unit getUnit() {
		return unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}

	
	
}
