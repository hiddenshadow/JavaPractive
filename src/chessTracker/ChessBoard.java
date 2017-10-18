/**
 * 
 */
package chessTracker;

import sun.nio.cs.ext.ISCII91;

/**
toString, hashCode equals
 */

/**
 * @author niharika
 *
 */
public class ChessBoard {

	private static final String EMPTY_VAL = "-";
	private static final int  DEF_HALF_MOVES = 0;
	private static final int  DEF_FULL_MOVES = 1;
	
	private Cell board[][];
	private boolean isWhiteTurn;
	private boolean[] castling;	// KQkq
	private String castlingStr;
	private String enPassantStr;
	private int halfMoveClock ;
	private int fullMoveNumber ;

	
	// Relative positions.
	
	// For king. These arrays are used to get row and column numbers of 8 neighbors of a given cell.
    private static int KING_ROW_NBR[] = {-1, -1, -1,  0, 0,  1, 1, 1};
    private static int KING_COL_NBR[] = {-1,  0,  1, -1, 1, -1, 0, 1};
    
    // For Pawn these arrays are used to get row and column numbers of all neighbors of a given cell.
    private static int PAWN_ROW_NBR[] = {1, 2, 1,  1, 0,  1, 1, 1};
    private static int PAWN_COL_NBR[] = {0, 0, 1, -1, 1, -1, 0, 1};
	
	public ChessBoard(){
		super();

		this.board = new Cell[8][8];
		this.isWhiteTurn = true;
		this.castling = new boolean[4];

		init();
	}

	private void init(){
		boolean curRow = true, curCol;
		Cell curCell;

		// Alternating the cells with black and white color.
		for (int i = 0; i < 8; i++) {
			curCol = curRow;
			for (int j = 0; j < 8; j++) {
				curCell = new Cell(curCol);
				board[i][j] = curCell;
				curCol = !curCol; 
			}
			curRow = !curRow;
		}

		// Filling the cells with units.
		board[7][0].unit = new Unit('r', false);
		board[7][7].unit = new Unit('r', false);

		board[7][1].unit = new Unit('n', false);
		board[7][6].unit = new Unit('n', false);

		board[7][2].unit = new Unit('b', false);
		board[7][5].unit = new Unit('b', false);

		board[7][3].unit = new Unit('q', false);
		board[7][4].unit = new Unit('k', false);


		for (int i = 0; i < 8; i++) {
			board[6][i].unit = new Unit('p', false);
			board[1][i].unit = new Unit('P', true);
		}

		board[0][0].unit = new Unit('R', true);
		board[0][7].unit = new Unit('R', true);

		board[0][1].unit = new Unit('N', true);
		board[0][6].unit = new Unit('N', true);

		board[0][2].unit = new Unit('B', true);
		board[0][5].unit = new Unit('B', true);

		board[0][3].unit = new Unit('Q', true);
		board[0][4].unit = new Unit('K', true);

		for (int i = 0; i < castling.length; i++) {
			castling[i] = true;
		}
		
		updateCastlingString();
		this.enPassantStr = EMPTY_VAL;
		this.halfMoveClock = DEF_HALF_MOVES;
		this.fullMoveNumber = DEF_FULL_MOVES;
	}

	/**
	 * a1, h1 for white. a8, h8 for black.
	 * @param movedCell
	 */
	public void updateCastling(String movedCell){

		switch (movedCell) {
		case "a1":
			// Remove Queen side castling for White.
			castling[1] = false;
			break;
		case "h1":
			// Remove King side castling for White.
			castling[0] = false;
			break;
		case "e1":
			// Remove both side castling for White.
			castling[0] = false;
			castling[1] = false;
			break;
		case "a8":
			// Remove Queen side castling for Black.
			castling[3] = false;
			break;
		case "h8":
			// Remove King side castling for Black.
			castling[2] = false;
			break;
		case "e8":
			// Remove both side castling for Black.
			castling[2] = false;
			castling[3] = false;
			break;
		default:
//			System.out.println("No castling update for input - "+movedCell);
			break;
		}
		
		updateCastlingString();
	}

	private void updateCastlingString(){
		StringBuilder sb = new StringBuilder();
		
		if(castling[0]){
			sb.append("K");
		}
		if(castling[1]){
			sb.append("Q");
		}
		if(castling[2]){
			sb.append("k");
		}
		if(castling[3]){
			sb.append("q");
		}
		if(sb.length() == 0 ){
			sb.append(EMPTY_VAL);
		}

		this.castlingStr = sb.toString();		
	}
	
	private void updateEnPassant(String dest, String source, Unit curUnit){
		
		StringBuilder sb = new StringBuilder();
		
		if(curUnit.type == 'P' && (dest.charAt(1) - source.charAt(1) == 2)){
			sb.append(dest.charAt(0)).append( (dest.charAt(1) - '0' - 1 )); 
		} else if(curUnit.type == 'p' && (dest.charAt(1) - source.charAt(1) == -2)){
			sb.append(dest.charAt(0)).append( dest.charAt(1) - '0' + 1 );
		} else {
			sb.append(EMPTY_VAL);
		}
		
		enPassantStr = sb.toString();
	}
	
	/**
	 * @param c
	 * @param inp
	 */
	private boolean isValidPiece(char c, String inp) {
		Unit cur = board[inp.charAt(0) - 'a'][inp.charAt(1) - '1'].unit;
		if(cur.type == c && cur.isWhite == this.isWhiteTurn){
			return true;
		} else {
			return false;
		}
	}


	/**
	 * Checks if the represented cell is within the limits.
	 * @param cell - Ex: e1
	 * @return
	 */
	private boolean isValidCell(String cell){
		if(isValidFile(cell.charAt(0)) && isValidRank(cell.charAt(1))){
			return true;
		} else {
			System.out.println("Invalid Cell - "+cell);
			return false;
		}
	}

	private boolean isValidFile(char file){
		if( file >= 'a' && file < 'h'){
			return true;
		} else {
			return false;
		}
	}

	private boolean isValidRank(char rank){
		if(rank >= '1' && rank <= '8'){
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Rules applied:
	 * 1. Check if valid unit present.
	 * @param inp
	 */
	public void isValidateInput(String inp){

		int len = inp.length();
		int file, rank;

		switch (len) {
		case 2:
			// Only pawn move
			isValidCell(inp);
			isValidPiece('p', inp);
			break;

		default:
			System.out.println("Invalid input: "+inp);
			break;
		}

	}

	/**
	 * Input the piece type.
	 * @param dest
	 * @param piece - Always take piece in upper case. [Change input also.]
	 * @return
	 */
	public Cell getSourceCellForMove(char piece, String dest, boolean isCapture, boolean isEnPassant){
		
		int verticalDir = 1;

		int destFile = dest.charAt(0) - 'a';
		int destRank = dest.charAt(1) - '1';
		
		
		switch (piece) {
		case 'P':
			
			/*if(!isWhiteTurn){
				verticalDir = -1;
			}*/
			
			if(isCapture){
				if(isWhiteTurn){
					if(board[destRank-1][destFile-1].getUnit().getType() == 'P'){
						return board[destRank-1][destFile-1];
					} else if( board[destRank-1][destFile+1].getUnit().getType() == 'P'){
						return board[destRank-1][destFile+1];
					} else {
						return null;	// Invalid.
					}
				} else {
					if( board[destRank+1][destFile-1].getUnit().getType() == 'P'){
						return board[destRank+1][destFile-1];
					} else if( board[destRank+1][destFile+1].getUnit().getType() == 'P'){
						return board[destRank+1][destFile+1];
					} else {
						return null;	// Invalid.
					}
				}
			} else if(isEnPassant){
				System.out.println("No enpassant yet. ");
				return null;
			} else {
				if(isWhiteTurn){
					if(board[destRank-1][destFile].getUnit().getType() == 'P'){
						return board[destRank-1][destFile];
					} else if( board[destRank-1][destFile].getUnit() == null && board[destRank-2][destFile].getUnit().getType() == 'P' && destRank == 4){
						return board[destRank-2][destFile];
					} else {
						return null;
					}
				} else {
					if(board[destRank+1][destFile].getUnit().getType() == 'p'){
						return board[destRank+1][destFile];
					} else if( board[destRank+1][destFile].getUnit() == null && board[destRank+2][destFile].getUnit().getType() == 'p' && destRank == 5){
						return board[destRank-2][destFile];
					} else {
						return null;
					}
				}
			}
			
		default:
			break;
		}
		
		return null;
	}

	/**
	 * Find valid source cell and input to execute.
	 * @param piece
	 * @param dest
	 * @param source
	 */
	public void executeInput(String dest, String source){

		Cell curCell = board[source.charAt(1) - '1'][source.charAt(0) - 'a']; 
		Cell destCell = board[dest.charAt(1) - '1'][dest.charAt(0) - 'a'];

		destCell.unit = curCell.unit;
		curCell.unit = null;

		updateCastling(source);
		updateEnPassant(dest, source, destCell.unit);
		
		changeTurn();
	}

	private void changeTurn(){
		this.isWhiteTurn = !this.isWhiteTurn;
	}


	public String piecePlacement(){
		StringBuilder sb = new StringBuilder();
		int emptyCelCount=0;

		for (int i = 7; i >=0; i--) {
			emptyCelCount=0;

			for (int j = 0; j < 8; j++) {
				if(board[i][j].unit == null ){
					emptyCelCount++;
				} else {
					if(emptyCelCount > 0){
						sb.append(emptyCelCount).append(board[i][j].unit.type);
						emptyCelCount=0;
					} else {
						sb.append(board[i][j].unit.type);
					}
				}
			}

			if(emptyCelCount > 0){
				sb.append(emptyCelCount);
			}

			if(i < 7){
				sb.append("/");
			}
		}

		return sb.toString();
	}

	public void printFEN(){
		StringBuilder sb = new StringBuilder();

		sb.append(piecePlacement());
		sb.append(" ");
		sb.append(""+ ( isWhiteTurn ? 'w' : 'b') );
		sb.append(" ");
		sb.append(castlingStr);
		sb.append(" ");
		sb.append(enPassantStr);
		sb.append(" ");
		sb.append(halfMoveClock);
		sb.append(" ");
		sb.append(fullMoveNumber);

		System.out.println(sb.toString());
	}

}

/* Test cases:
 * 1. Test initial Positions be giving few cell positions and cross checking if it is expected piece. Ex: d1 should have white queen
 * 2. Range check for the input, if the files and ranks are within the range. 
 * */
