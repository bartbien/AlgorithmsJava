package com.phoenixjcam.recursion;

/**
 * F0 	F1 	F2 	F3 	F4 	F5 	F6 	F7 	F8 	F9 	F10 F11 	F12 	F13 	F14 	F15 	F16 	F17 	F18 	F19
 *	0 	1 	1 	2 	3 	5 	8 	13 	21 	34 	55 	89 		144 	233 	377 	610 	987 	1597 	2584 	4181
 * @author Bart88
 *
 */
public class Fibonacci
{
	public static long fib(int numb)
	{
		long result;

		if (numb <= 1)
			return numb;
		else
			result = fib(numb - 1) + fib(numb - 2);

		return result;
	}

	public static void main(String[] args)
	{
		 int numb = 35;
		
		 for (int i = 1; i <= numb; i++)
		 System.out.println(i + ": " + fib(i));


	}

}
