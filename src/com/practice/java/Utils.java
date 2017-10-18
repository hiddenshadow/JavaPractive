package com.practice.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import list.JustListNode.Node;

/**
 * TODO: Sample input generations.
 * @author niharika
 *
 */

public class Utils {
	
	public static ArrayList<Integer> getArrayList(int[] arr){
		ArrayList<Integer> cur = new ArrayList<Integer>();
		
		for (int i = 0; i < arr.length; i++) {
			cur.add(arr[i]);
		}
		
		return cur;
	}
	
	public static class IntComp implements Comparator<Integer> {
		@Override
		public int compare(Integer arg0, Integer arg1) {
			return arg0 - arg1;
		}
	}

	public static void printInt2DArray(int[][] mat){
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				System.out.print(mat[i][j]+", ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static void swap(int i, int j, ArrayList<Integer> a){
		int temp = a.get(i);
		a.set(i, a.get(j));
		a.set(j, temp);
	}

	public static int[] getLminAuxArr(int[] arr){
		int[] lMin = new int[arr.length];
		
		lMin[0] = arr[0];
		
		for (int i = 1; i < lMin.length; i++) {
			lMin[i] = Math.min(lMin[i-1], arr[i]);
		}
		
		return lMin;
	}
	

	public static int[] getRMaxAuxArr(int[] arr){
		int[] rMax = new int[arr.length];
		
		rMax[arr.length-1] = arr[arr.length-1];
		
		for (int i = arr.length-2; i > -1; i--) {
			rMax[i] = Math.max(rMax[i+1], arr[i]);
		}
		
		return rMax;
	}
}
