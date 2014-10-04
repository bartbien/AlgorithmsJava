package com.phoenixjcam.stairs;

/**
 * F0 F1 F2 F3 F4 F5 F6 F7 F8 F9 F10 F11 F12 F13 F14 F15 F16 F17 F18 F19 
 * 0 1 1 2 3 5 8 13 21 34 55 89 144 233 377 610 987 1597 2584 4181
 *
 * Great quesion: You are climbing a stair case. Each time you can either make 1 step or 2 steps. The staircase has n
 * steps. In how many distinct ways can you climb the staircase ?
 *
 * @author Bart88
 *
 */
public class ClimbingStairs
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

	public static long fib2(int numb)
	{
		long result1;
		long result2;

		long sum;

		if (numb <= 1)
			return numb;
		else
		{
			result1 = fib2(numb - 1);
			result2 = fib2(numb - 2);

			sum = result1 + result2;
		}

		return sum;
	}

	public static void main(String[] args)
	{
		int numb = 5;

		for (int i = 1; i <= numb; i++)
			System.out.println(i + ": " + fib2(i));

	}

}
