package arrays;

import com.practice.java.Utils;

public class ZeroTheRowNColumn {
	
	
	public static void test(){
		int[][] mat = { {1,2,3,4}, {1,1,3,0}, {1,2,3,0}  };
		
		Utils.printInt2DArray(mat);
		
		zeroCorrespondingRowAndColumn(mat);
		
		Utils.printInt2DArray(mat);
	}
	
	
	public static void zeroCorrespondingRowAndColumn(int[][] mat){
		
		int i = -1,  r = -1;
		boolean found = false;
		int row = mat.length;
		int col = mat[0].length;
		
		for (int j = 0; j < row; j++) {
			for (int k = 0; k < col; k++) {
				
				if(mat[j][k] == 0){
					if(found){
						mat[i][k] = 0;
						mat[j][r] = 0;
					} else {
						i = j; 
						r = k;
						found = true;
					}
				}
				
			}
		}
		
		
		if(found){
			// Check all col of ith row.
			for (int j = 0; j < col; j++) {
				if(mat[i][j] == 0 && j != r){
					
					// Except ith row make all rows and jth col to zeroes.
					for (int j2 = 0; j2 < row ; j2++) {
						mat[j2][j] = 0;
					}
				}
			}
			
			// Check all rows of the rth col for zeroes.
			for (int j = 0; j < row ; j++) {
				if(mat[j][r] == 0 &&  j != i){
					
					// Make all col of jth row to zeroes
					for (int j2 = 0; j2 < col ; j2++) {
						mat[j][j2] = 0;
					}					
				}
			}
			
			for (int j = 0; j < row; j++) {
				mat[j][r] = 0;
			}
			
			for (int j = 0; j < col; j++) {
				mat[i][j] = 0;
			}			
		}
	}
}
