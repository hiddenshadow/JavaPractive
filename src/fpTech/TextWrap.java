/**
 * 
 */
package fpTech;

/**
toString, hashCode equals
 */

/**
 * @author niharika
 *
 */
public class TextWrap {
	
	/**
	 * Return true if it is any one of the delimiter like space, newline, tab
	 * @param c
	 * @return
	 */
	public boolean isWordSep(char c){
		
		if(c == ' ' || c == '\n' || c == '\t')
			return true;
		
		return false;
	}
	
	public String wrapText(String inp, int width){
		
		if(inp.length() <= width){
			return inp;
		} else {
			
			StringBuilder sb = new StringBuilder();
			int end = 14;
			int minCost=Integer.MAX_VALUE, minEnd=end;
			
			while( !isWordSep(inp.charAt(end)) ){
				end--;
			}
			
			
			
		}
		
		
		
		return "";
	}
	
	public String wrapTextO(String inp, int width){
	
		int i=0;
		int curWs=0, curWe=0; // Keeps track of cur Word.
		int curLs=0;	// Keeps track of size of curLine.

		StringBuilder sb = new StringBuilder();
		
		// Process each char.
		while(i < inp.length()) {
			
			
			// Track next word.
			if(isWordSep(inp.charAt(i))){
				
				// Can we fit cur word in the line.
				if( (curLs + curWs) < width ){
					
				}
				
				curWs=curWe+1; // Reset.
			} else {
				curWe++;	// Keep tracking the word.
			}
			
			
			
			
		}
		
		return sb.toString();
	}

}
