package arrays;

import com.practice.java.Utils;

public class RotateMatrixImage {
	
	public static void test() {
		int[][] mat = {  {1, 2, 3, 4}, {5, 6, 7, 8}, {1, 2, 3, 4}, {5, 6, 7, 8} };
		
		Utils.printInt2DArray(mat);
		
		rotateImageMatrix(mat, 0, mat.length-1);
		
		Utils.printInt2DArray(mat);
		
	}
	
	public static void rotateImageMatrix(int[][] image, int startInd, int endInd) {

		if(startInd == endInd || startInd>endInd) return;
		
		for (int i = startInd; i < endInd; i++) {
			int temp = image[startInd][i]; // Save Top row.
			
			image[startInd][i] = image[endInd-i][startInd]; // Filling Top row element.
			image[endInd-i][startInd] = image[endInd][endInd-i]; // Left col
			image[endInd][endInd-i] = image[i][endInd]; // Bottom row
			image[i][endInd] = temp;			
		}
		
		rotateImageMatrix(image, startInd+1, endInd-1);
	}
	
	

}
