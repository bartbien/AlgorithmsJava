package com.phoenixjcam.searching.binary;

import java.util.Scanner;

/**
 * Recursion(function calls itself) + binary search(divide and concur) 
 * 
 *  This code uses binary search to play the game of twenty questions.
 *  It takes a command-line argument n, asks you to think of a number
 *  between 0 and N-1, where N = 2^n, and always guesses the answer
 *  with n questions.
 *
 *  %  java TwentyQuestions 7
 *  Think of an integer between 0 and 127
 *  Is it less than 64?  false
 *  Is it less than 96?  true
 *  Is it less than 80?  true
 *  Is it less than 72?  false
 *  Is it less than 76?  false
 *  Is it less than 78?  true
 *  Is it less than 77?  false
 *  Your number is 77
 *  
 * 	based on http://introcs.cs.princeton.edu/java/42sort/TwentyQuestions.java.html
 * 
 * @author Bart88
 *
 */
public class TwentyQuestions
{
	// recursion problem
	public static int search(int min, int max)
	{
		Scanner scanner = new Scanner(System.in);
		
		if ((max - min) == 1)
			return min;
		
		int middle = min + (max - min) / 2;
		
		System.out.println("Is it less than " + middle + "   (1 - yes or 0 - no)");
		
		if(scanner.nextInt() == 1)
			return search(min, middle);
		else
			return search(middle, max);

	}

	public static void main(String[] args)
	{
		int size = 100;
		System.out.println("Think of an integer between " + 0 + " and " + size);
		
		int answer = search(0, size);
		System.out.printf("Your number is %d\n", answer);
	}
}