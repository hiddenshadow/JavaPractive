package com.practice.java;

import fpTech.FirstLocalMax;
import fpTech.MaxEachWind;
import hackerEarthPrac.OlaOnlineTest;
import hashMap.CustomHashMap;
import heap.CustomHeap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

import javaDemos.CollectionsTest;
import javaDemos.EvenOddThreads;
import javaDemos.ParallelFileReadWrite;

import stack.CustomStack;
import stack.SortStack;
import stack.TowersOfHanoi;
import strings.StringIntBit;
import towPointers.IntArrayTwoPointerIntvBit;
import tree.IsBST;
import tree.PrintTreeInLevelOrder;
import tree.TreeInterviewBit;
import tree.TreeWithMinHeight;

import arrays.Factors;
import arrays.MaxDistBetweenJandI;
import arrays.MaxGameOutcome;
import arrays.MaxPossibleProductOfIntegers;
import binarySearch.BinarySearchIntBit;
import bitManipulation.BitManipulation;

import chessTracker.TargetDriver;

import com.sun.org.apache.xalan.internal.xsltc.runtime.Node;

import liftSystem.Driver;
import list.CheckIfCircularList;
import list.CustomLinkedList;
import list.JustListNode;
import list.ListUtils;
import list.SumOfNumbersInListForm;
import math.MathProblems;
import scanner.*;
import dynamicProgramming.CoinChange;;

public class Main {

	public static void main(String[] args){
		
//		BinarySearchIntBit.test();
		
//		testPower();
//		BitManipulation.testMinXor();
//		CollectionsTest.test();
		
//		CollectionsTest.testPriorityQueue();
		
//		BinarySearchIntBit.testSearchMatrix();
		
//		EvenOddThreads.test();
		
//		CollectionsTest.testDoublyLinkedList();
		
//		MaxGameOutcome.test();
		
//		CustomHeap.test();		
//		LinkedList<Integer>[] adjListArray = new LinkedList[5];
		
//		FirstLocalMax.test();
//		MaxEachWind.test();
		
//		TargetDriver.test();
		
		String[] arr = { "123", "395", "111" };
		int[][] arri = {{ 1, 1 }, { 1, 1 }};
		
//		OlaOnlineTest.cavityMap(arr);
		System.out.println(OlaOnlineTest.numberOfPaths(arri));
		
		
	}

	public static void testPower(){
		int a=3, b=2;
		System.out.println("Xor = "+(a^b));
		System.out.println("Power = "+(Math.pow(3, 2)));
	}

	public static ArrayList<ArrayList<Integer>> squareSum(int A) {
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();

		for (int a = 0; a * a < A; a++) {
			for (int b = 0; (a <= b) && (b * b < A) ; b++) {
				if ((a * a) + (b * b) == A) {
					ArrayList<Integer> newEntry = new ArrayList<Integer>();
					newEntry.add(a);
					newEntry.add(b);
					ans.add(newEntry);
				}
			}
		}
		return ans;
	}


	public static void testModAnd(){
		System.out.println("% - "+ (1 % 11)+", & - "+ (1 & 11));
		System.out.println("% - "+ (0 % 11)+", & - "+ (0 & 11));
		System.out.println("% - "+ (118 % 15)+", & - "+ (118 & 15));

		for(int i=0; i< 24; i++){
			System.out.println("For "+i+", % - "+ (i % 11)+", & - "+ (i & 11));
		}
	}


	public static void testBinaryAnd(){
		int h1 = 0106204401;
		int h2 = -017671573377;	

		int h3 = (1 << -65);
		int res = (h1 | h3);

		System.out.println("h1 - "+h1+ ", h3 - "+h3+", res - "+res);

	}

	public static void testScanner(String[] args) {
		System.out.print("input: ");
		System.out.flush();
		try {
			Scanner s = new Scanner(System.in);
			String token;
			do {
				System.out.println("This is the input: "+args[0]);
				token = s.findInLine(args[0]);
				System.out.println("found " + token);
			} while (token != null);

			s.close();
		} catch (Exception e) { System.out.println("scan exc"); }
	}

}
